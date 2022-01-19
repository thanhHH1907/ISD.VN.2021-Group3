package presentation.screen.payment;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import common.utils.Utils;
import domain.entity.order.Order;
import domain.entity.transaction.TransactionInfo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.controller.BaseController;
import presentation.controller.ReturnBikeController;
import presentation.screen.BaseScreenHandler;

/**
 * This class is to display the transaction result screen
 * @author DungNM
 * @version 1.0
 */

public class ResultScreenHandler extends BaseScreenHandler implements Initializable {

    @FXML
    private Label owner;

    @FXML
    private Label content;

    @FXML
    private Label amount;

    @FXML
    private Label id;

    @FXML
    private Button backToHomeBtn;

    private Order order;

    /**
     * This constructor use when returning bike sucessful
     *
     * @param stage
     * @param screenPath
     * @param bController
     * @param trans
     * @throws IOException
     * @author DungNM
     */
    public ResultScreenHandler(Stage stage, String screenPath, BaseController bController, TransactionInfo trans) throws IOException {
        super(stage, screenPath);
        setBController(bController);
        setTransactionInfo(trans);
    }
    
    /**
     * set the info of the transaction in the screen
     * @param trans
     */
    public void setTransactionInfo(TransactionInfo trans) {
        this.id.setText("#" + trans.getId());
        this.owner.setText(trans.getCard().getOwner());
        this.content.setText(trans.getTransactionContent());
        this.amount.setText(Utils.getCurrencyFormat(trans.getAmount()));
    }

    /**
     * This constructor use when rent bike sucessful
     *
     * @param stage
     * @param screenPath
     * @param bController
     * @param trans
     * @param order
     * @throws IOException
     * @author DungNM
     */
    public ResultScreenHandler(Stage stage, String screenPath, BaseController bController, TransactionInfo trans, Order order) throws IOException {
        this(stage, screenPath, bController, trans);
        this.order = order;
    }
    
    /**
     * get the controller of this screen
     */
    public ReturnBikeController getBController() {
        return (ReturnBikeController) super.getBController();
    }


    @Override
    /**
     * initialize the screen
     */
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backToHomeBtn.setOnMouseClicked(event -> {
            try {
                backToHomeAfterRent(order);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
