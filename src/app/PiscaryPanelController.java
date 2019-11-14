package app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Fish;
import model.Piscary;

import java.util.HashSet;

public class PiscaryPanelController {
    @FXML
    Label labelArea;
    @FXML
    Label labelName;
    @FXML
    Label labelAddress;
    @FXML
    Label labelContact;
    @FXML
    Label labelHourFrom;
    @FXML
    Label labelHourTo;
    @FXML
    Label labelPriceDay;
    @FXML
    Label labelPriceNight;
    @FXML
    Label labelCountRod;
    @FXML
    Label labelIsBookingSlot;

    private Piscary onePiscary;

    public PiscaryPanelController() {
        String[] baits = {"kulki proteinowe słodkie", "kulki proteinowe śmierdzące", "robaczek", "kukurydza"};
        onePiscary = new Piscary(5.0, "Nad Stawami", "Siedliska 10", "+48 754 220 272",
                new HashSet<Fish>(), 7, 19, 30, 30, 3, true, baits);

        //TODO: please implemet list of 'availableFish' and array of 'effectiveBait' in GUI Piscary
    }

    @FXML
    private void initialize() {
        labelArea.setText(String.valueOf(onePiscary.getArea()) + " ha");
        labelName.setText(onePiscary.getName());
        labelAddress.setText(onePiscary.getAddress());
        labelContact.setText(onePiscary.getContact());
        labelHourFrom.setText(String.valueOf(onePiscary.getHourFrom()));
        labelHourTo.setText(String.valueOf(onePiscary.getHourTo()));
        labelPriceDay.setText(String.valueOf(onePiscary.getPriceDay())+" zł");
        labelPriceNight.setText(String.valueOf(onePiscary.getPriceNight())+ " zł");
        labelCountRod.setText(String.valueOf(onePiscary.getCountRod())+ " szt.");
        labelIsBookingSlot.setText(onePiscary.isBookingSlot() ? "Tak" : "Nie"); //wyciagam boolean
    }
}
