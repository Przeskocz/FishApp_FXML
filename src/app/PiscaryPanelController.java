package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    @FXML
    ListView<String> listViewAvailableFish;

    private Piscary onePiscary;

    public PiscaryPanelController() {
        String[] baits = {"kulki proteinowe słodkie", "kulki proteinowe śmierdzące", "robaczek", "kukurydza"};
        onePiscary = new Piscary(5.0, "Nad Stawami", "Siedliska 10", "+48 754 220 272",
                new HashSet<Fish>(), 7, 19, 30, 30, 3, true, baits);

        //dodawanie fiszków do stawu
        onePiscary.addNewFish(new Fish("Karp", Fish.TypeOfFish.HERBIVORE, 1, 25));
        onePiscary.addNewFish(new Fish("Amur", Fish.TypeOfFish.HERBIVORE, 1, 15));
        onePiscary.addNewFish(new Fish("Jesiotr", Fish.TypeOfFish.HERBIVORE, 2, 15));
        onePiscary.addNewFish(new Fish("Szczupak", Fish.TypeOfFish.MEAT_EATER, 1, 10));
        onePiscary.addNewFish(new Fish("Karaś", Fish.TypeOfFish.HERBIVORE, 1, 3));
        onePiscary.addNewFish(new Fish("Płoć", Fish.TypeOfFish.HERBIVORE, 1, 2));
        onePiscary.addNewFish(new Fish("Okoń", Fish.TypeOfFish.MEAT_EATER, 0, 1));
        onePiscary.addNewFish(new Fish("Sum", Fish.TypeOfFish.SCAVENGER, 5, 40));


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

        ObservableList<String> speciesOfFish = FXCollections.observableArrayList();

        for (Fish item : onePiscary.getAvailableFish()) {
            String speciesFish = item.getSpecies();
            speciesOfFish.add(speciesFish); //dodanie gatunki fiszki do obserwowalnej listy
        }

        listViewAvailableFish.setItems(speciesOfFish);// wstawienie obserwowalnej listy do kontrolki listView

    }
}
