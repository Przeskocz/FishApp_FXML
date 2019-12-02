package app.fish;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Fish;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class FishPanelController {
    @FXML
    Label labelSpecies;
    @FXML
    Label labelType;
    @FXML
    Label labelFrom;
    @FXML
    Label labelTo;

    @FXML
    Button buttonClickMe;

    @FXML
    Button buttonBack;

    private List<Fish> listOfFish;
    private int indexOfFish = -1;

    public FishPanelController() {
        this.listOfFish = new ArrayList<>();
        listOfFish.add(new Fish("Karp", Fish.TypeOfFish.HERBIVORE, 1, 25));
        listOfFish.add(new Fish("Amur", Fish.TypeOfFish.HERBIVORE, 1, 15));
        listOfFish.add(new Fish("Jesiotr", Fish.TypeOfFish.HERBIVORE, 2, 15));
        listOfFish.add(new Fish("Szczupak", Fish.TypeOfFish.MEAT_EATER, 1, 10));
        listOfFish.add(new Fish("Karaś", Fish.TypeOfFish.HERBIVORE, 1, 3));
        listOfFish.add(new Fish("Płoć", Fish.TypeOfFish.HERBIVORE, 1, 2));
        listOfFish.add(new Fish("Okoń", Fish.TypeOfFish.MEAT_EATER,  0, 1));
        listOfFish.add(new Fish("Sum", Fish.TypeOfFish.SCAVENGER, 5, 40));
    }

    @FXML
    public void buttonBack_Clicked(MouseEvent e){

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
        if (indexOfFish + 1 == listOfFish.size())
            indexOfFish = -1;

        //Wybór ryby z listy
        Fish selectedFish = listOfFish.get(++indexOfFish);

        //Przypisywanie do label wybranych wartości
        labelSpecies.setText(selectedFish.getSpecies());
        labelFrom.setText(String.valueOf(selectedFish.getWeightFrom()));
        labelTo.setText(String.valueOf(selectedFish.getWeightTo()));

        if (Fish.TypeOfFish.HERBIVORE.equals(selectedFish.getType())){
            labelType.setText("roślinożerna");
        }
        if (Fish.TypeOfFish.MEAT_EATER.equals(selectedFish.getType())){
            labelType.setText("mięsożerna");
        }
        if (Fish.TypeOfFish.SCAVENGER.equals(selectedFish.getType())){
            labelType.setText("padlinożerna");
        }
    }
}
