package app.piscary;

import app.model.Fish;
import app.model.Piscary;
import app.repository.PiscaryRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("Duplicates")
public class PiscaryDataPanel extends AnchorPane {
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
    @FXML
    ListView<String> listViewEffectiveBait;
    @FXML
    Button buttonBack;

    private List<Piscary> listOfPiscary;
    private int indexOfPiscary = -1;


    public PiscaryDataPanel(){
        listOfPiscary = PiscaryRepository.getAllPiscary();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/app/piscary/piscaryPanel.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


    @FXML
    private void initialize() {
        displayNextPiscaryOnGUI();
    }

    public void buttonBack_Clicked(MouseEvent e) {
    }

    @FXML
    public void buttonClickMe_Clicked(MouseEvent e) {
        displayNextPiscaryOnGUI();
    }

    private void displayNextPiscaryOnGUI(){

        if (indexOfPiscary + 1 == listOfPiscary.size())
            indexOfPiscary = -1;

        //Wybór łowiska z listy
        Piscary selectedPiscary = listOfPiscary.get(++indexOfPiscary);

        //Przypisywanie do label wybranych wartości
        labelArea.setText(String.valueOf(selectedPiscary.getArea()) + " ha");
        labelName.setText(selectedPiscary.getName());
        labelAddress.setText(selectedPiscary.getAddress());
        labelContact.setText(selectedPiscary.getContact());
        labelHourFrom.setText(String.valueOf(selectedPiscary.getHourFrom()));
        labelHourTo.setText(String.valueOf(selectedPiscary.getHourTo()));
        labelPriceDay.setText(String.valueOf(selectedPiscary.getPriceDay()) + " zł");
        labelPriceNight.setText(String.valueOf(selectedPiscary.getPriceNight()) + " zł");
        labelCountRod.setText(String.valueOf(selectedPiscary.getCountRod()) + " szt.");
        labelIsBookingSlot.setText(selectedPiscary.isBookingSlot() ? "Tak" : "Nie"); //wyciagam boolean

        ObservableList<String> speciesOfFish = FXCollections.observableArrayList();

        for (Fish item : selectedPiscary.getAvailableFish()) {
            String speciesFish = item.getSpecies();
            speciesOfFish.add(speciesFish); //dodanie gatunki fiszki do obserwowalnej listy
        }

        listViewAvailableFish.setItems(speciesOfFish);// wstawienie obserwowalnej listy do kontrolki listView

        ObservableList<String> baits = FXCollections.observableArrayList(selectedPiscary.getEffectiveBait());
        listViewEffectiveBait.setItems(baits); //wstawienie obserwowalnej listy do kontrolki listView Baits
    }
}
