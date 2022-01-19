package presentation.screen;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import domain.entity.bike.Bike;
import domain.entity.bike.StandardBike;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import presentation.controller.ReturnBikeController;


/**
 * This class is the splash screen view handler
 * @author ThanhNG
 * @version 1.0
 */

public class SplashScreenHandler implements Initializable {

    @FXML
    ImageView logo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}