package app.piscary;

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
import javafx.stage.Stage;
import app.model.Fish;
import app.model.Piscary;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("ALL")
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
    @FXML
    ListView<String> listViewEffectiveBait;
    @FXML
    Button buttonBack;

    private List<Piscary> listOfPiscary;
    private int indexOfPiscary = -1;


    public PiscaryPanelController() {
        listOfPiscary = PiscaryRepository.getAllPiscary();
    }

    @FXML
    private void initialize() {
        displayNextPiscaryOnGUI();
    }

    public void buttonBack_Clicked(MouseEvent e) {

        String patch = "/app/mainMenuPanel.fxml";

        try {
            // Tworzony jest Loader dla podanego panelu w zmiennej patch
            FXMLLoader loader = new FXMLLoader(getClass().getResource(patch));

            // Tworzona nowa "estrada"
            Stage stage = new Stage();

            // Na estradę jest tworzona nowa scena na którą załadowywany jest panel z loader'a
            stage.setScene(new Scene(loader.load()));

            // Ustawia tytuł okna (napis na pasku u góry)
            stage.setTitle("Menu główne");

            // Prezentuj/pokaż na ekranie
            stage.show();

            // Ukryj bieżące okno
            ((Node) (e.getSource())).getScene().getWindow().hide();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
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





