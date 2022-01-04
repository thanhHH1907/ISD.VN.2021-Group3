package updateDB;

import controller.ResultScreenController;
import entity.bike.Bike;
import entity.invoice.Invoice;
import entity.transaction.TransactionInfo;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.payment.ResultScreenHandler;

import java.io.IOException;
import java.sql.SQLException;
/**
 * This class is used when rent bike successfully
 * @author BachDV
 * @version 1.0
 */
public class RentBike implements UpdateDBTransaction {
    @Override
    /**
	 * insert invoice, insert order of the invoice, update bike of the order, update station of the bike to db
	 * @param invoice
	 * @throws SQLException
	 */
    public void updateDB(Invoice invoice) throws SQLException {
        new Bike().updateQtyDB(1, invoice.getOrder().getRentedBike());
        invoice.getOrder().newOrderDB();
        invoice.creatNewInvoiceDB();
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
