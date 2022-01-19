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
import java.time.LocalDateTime;

import common.utils.Configs;
import data.repository.BikeRepositoryImpl;
import data.repository.InvoiceRepositoryImpl;
import data.repository.OrderRepositoryImpl;

public class ReturnBike implements UpdateDBTransaction {
    private BikeRepositoryInterface bikeRepository = new BikeRepositoryImpl();
    private OrderRepositoryInterface orderRepository = new OrderRepositoryImpl();
    private InvoiceRepositoryInterface invoiceRepository = new InvoiceRepositoryImpl();
    @Override
    /**
	 * insert invoice, update order of the invoice, update bike of the order, update station of the bike to db
	 * @param invoice
	 * @throws SQLException
	 */
    public void updateDB(Invoice invoice) throws SQLException {
        invoice.getOrder().setEnd(LocalDateTime.now());
        bikeRepository.updateQtyDB(0, invoice.getOrder().getRentedBike());
        orderRepository.updateOrderDB(invoice.getOrder());
        invoiceRepository.creatNewInvoiceDB(invoice);
        // set new station for bike
        bikeRepository.updateBikeDB(invoice.getOrder().getRentedBike().getId(),
                invoice.getOrder().getRentedBike().getStation().getId());
    }

    
    /**
     * Move to result screen
     * @param stage
     * @param invoice
     * @param transactionResult
     * @throws IOException
     */
    public void moveToResultScreenHandler(Stage stage, Invoice invoice, TransactionInfo transactionResult) throws IOException {

        ResultScreenHandler resultScreenHandler = new ResultScreenHandler(stage, Configs.RESULT_SCREEN_PATH, new ResultScreenController(), transactionResult);
        resultScreenHandler.show();
    }
}
