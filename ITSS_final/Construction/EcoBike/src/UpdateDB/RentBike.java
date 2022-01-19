package updatedb;

import domain.entity.bike.Bike;
import domain.entity.invoice.Invoice;
import domain.entity.transaction.TransactionInfo;
import domain.repository.BikeRepositoryInterface;
import domain.repository.InvoiceRepositoryInterface;
import domain.repository.OrderRepositoryInterface;
import javafx.stage.Stage;
import presentation.controller.ResultScreenController;
import presentation.screen.payment.ResultScreenHandler;

import java.io.IOException;
import java.sql.SQLException;

import common.utils.Configs;
import data.repository.BikeRepositoryImpl;
import data.repository.InvoiceRepositoryImpl;
import data.repository.OrderRepositoryImpl;
/**
 * This class is used when rent bike successfully
 * @author BachDV
 * @version 1.0
 */
public class RentBike implements UpdateDBTransaction {
    private BikeRepositoryInterface bikeRepository = new BikeRepositoryImpl();
    private OrderRepositoryInterface orderRepository = new OrderRepositoryImpl();
    private InvoiceRepositoryInterface invoiceRepository = new InvoiceRepositoryImpl();
    @Override
    /**
	 * insert invoice, insert order of the invoice, update bike of the order, update station of the bike to db
	 * @param invoice
	 * @throws SQLException
	 */
    public void updateDB(Invoice invoice) throws SQLException {
        bikeRepository.updateQtyDB(1, invoice.getOrder().getRentedBike());
        orderRepository.newOrderDB(invoice.getOrder());
        invoiceRepository.creatNewInvoiceDB(invoice);
    }

    /**
     * Move to result screen
     * @param stage
     * @param invoice
     * @param transactionResult
     * @throws IOException
     */
    public void moveToResultScreenHandler(Stage stage, Invoice invoice, TransactionInfo transactionResult) throws IOException {

        ResultScreenHandler resultScreenHandler = new ResultScreenHandler(stage, Configs.RESULT_SCREEN_PATH, new ResultScreenController(), transactionResult, invoice.getOrder());
        resultScreenHandler.show();
    }
}
