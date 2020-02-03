package app.piscary;

import app.model.Fish;
import app.model.Piscary;
import app.repository.PiscaryRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.util.List;

@SuppressWarnings("Duplicates")
public class PiscaryDataPanel extends AnchorPane {
    @FXML
    TextField textArea;
    @FXML
    Label labelName;
    @FXML
    TextField textAddress;
    @FXML
    TextField textContact;
    @FXML
    TextField textHourFrom;
    @FXML
    TextField textHourTo;
    @FXML
    TextField textPriceDay;
    @FXML
    TextField textPriceNight;
    @FXML
    TextField textCountRod;
    @FXML
    TextField textIsBookingSlot;
    @FXML
    ListView<String> listViewAvailableFish;
    @FXML
    ListView<String> listViewEffectiveBait;
   

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

        //Przypisywanie do text wybranych wartości
        textArea.setText(String.valueOf(selectedPiscary.getArea()) + " ha");
        labelName.setText(selectedPiscary.getName());
        textAddress.setText(selectedPiscary.getAddress());
        textContact.setText(selectedPiscary.getContact());
        textHourFrom.setText(String.valueOf(selectedPiscary.getHourFrom()));
        textHourTo.setText(String.valueOf(selectedPiscary.getHourTo()));
        textPriceDay.setText(String.valueOf(selectedPiscary.getPriceDay()) + " zł");
        textPriceNight.setText(String.valueOf(selectedPiscary.getPriceNight()) + " zł");
        textCountRod.setText(String.valueOf(selectedPiscary.getCountRod()) + " szt.");
        textIsBookingSlot.setText(selectedPiscary.isBookingSlot() ? "Tak" : "Nie"); //wyciagam boolean

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
