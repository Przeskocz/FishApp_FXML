package app.fish;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.Fish;

import java.util.ArrayList;
import java.util.List;

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
