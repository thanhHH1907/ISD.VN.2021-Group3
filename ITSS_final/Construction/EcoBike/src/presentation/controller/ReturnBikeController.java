package presentation.controller;

import updateDB.ReturnBike;
import javafx.stage.Stage;
import presentation.screen.BaseScreenHandler;
import presentation.screen.home.HomeScreenHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;

import data.repository.CardRepositoryImpl;
import domain.entity.bike.Bike;
import domain.entity.invoice.Invoice;
import domain.entity.order.Order;
import domain.entity.station.Station;
import domain.entity.transaction.Card;
import domain.entity.transaction.TransactionInfo;
import domain.repository.CardRepositoryInterface;

/**
 * This class controls the flow of events in result screen
 * @author BachDV
 * @version 1.0
 *
 */
public class ReturnBikeController extends TransactionController {
    private CardRepositoryInterface cardRepository = new CardRepositoryImpl();
	/**
	 * Get card information for DB
	 * @return Card
	 */
    public Card getCard() {
        return cardRepository.getCardFromDB();
    }


    /**
     * check station have empty dock point to return bike
     * @param station
     */
    public boolean checkStationReturnBike(Station station) {
        try {
            if (station.getNumEmptyDockPoint() > 0)
                return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * calculate the amount of money customer has to pay when using bike
     * @param coefficient
     * @param start
     * @return
     */
    public int calculateAmount(double coefficient, LocalDateTime start) {
        Duration dur = Duration.between(start, LocalDateTime.now());
        long minutes = dur.toMinutes();
        if (minutes <= 10) return 0;
        if (minutes <= 30) return (int) (10000 * coefficient);
        return (int) (10000 + (Math.ceil((minutes - 30) / 15) * 3000) * coefficient);
    }


    /**
     * get bike deposit
     *
     * @param bike
     * @return deposit
     */
    public int getBikeDeposit(Bike bike) {
        return (int) (bike.getValue() * 0.4);
    }

    /**
     * set the cvv code to the card entity
     * @param cvv
     * @param card
     */
    public void setCvvCode(String cvv, Card card) {
        card.setCvvCode(cvv);
    }

    /**
     * Control the process when returning bike
     * @param card
     * @param totalAmount
     * @param order
     * @param invoiceContents
     * @param stage
     * @param homeScreenHandler
     * @param prev
     * @throws IOException
     * @throws SQLException
     */
    public void processReturnBike(Card card, int totalAmount, Order order, String invoiceContents, Stage stage, HomeScreenHandler homeScreenHandler, BaseScreenHandler prev) throws IOException, SQLException {
        // pay more if rentingFee > deposit, else refund to account
        Invoice invoice = createInvoice(order, totalAmount, invoiceContents);
        TransactionInfo transactionResult = submitToPay(invoice, card);
        if (!transactionResult.getErrorCode().equals("00")) {
            displayTransactionError(transactionResult.getErrorCode(), stage, homeScreenHandler, prev);
        } else {
            moveToTransactionResult(invoice, transactionResult, card, stage, new ReturnBike());
        }
    }


}

