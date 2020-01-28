package app;

import app.fish.FishDataPanel;
import app.piscary.PiscaryDataPanel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

@SuppressWarnings("ALL")
public class MainMenuController {

    @FXML
    private HBox contentHBox;
    @FXML
    private MenuButton mButtonChooseRegion;


    private PiscaryDataPanel piscaryDataPanel;
    private FishDataPanel fishDataPanel;

    private ObservableList<MenuItem> menuItemsObservable;

    // Konstruktor klasy MainMenuController
    public MainMenuController() {

    }

    @FXML // Konstruktor dla kontrolek z GUI
    public void initialize() {
        // Zwraca obserwowalną listę wszystkich elementów tego Menu Button'a
        menuItemsObservable = mButtonChooseRegion.getItems();

        // Każdemu elementowi MenuItem z tej listy ustawia metodę chooseRegion_Clicked
        // jako zdażenie/reakcja na jakąkolwiek akcję (np. kliknięcia)
        menuItemsObservable.stream().forEach(menuItem -> menuItem.setOnAction(this::chooseRegion_Clicked));
    }

    /**
     * Ta metoda jest używana do wczytywania fragmentów GUI do pudełka contentHBox
     * @param event zawieraja szczegółowe informacje o zdarzeniu (np. jaka kontrolka wywołał akcję)
     * */
    public void chooseRegion_Clicked(ActionEvent event) {
        MenuItem buttonClicked = null;
        Object sender = event.getSource(); // Zwraca kontrolkę która wywołała akcję (źródło)

        if (sender instanceof MenuItem) { // Oczekujemy że jest nim jakaś kontrolka typu MenuItem
            buttonClicked = (MenuItem) sender; // Jeśli tak, jest ona rzutowana do odpowiedniej zmiennej
        }

        // Jeśli wszystko wyżej będzie ok to buttonClicked nie będzie null i będzie można
        // wczytywać odpowiedni fragment GUI do contentHBox
        if (buttonClicked != null) {
            if (buttonClicked.getText().equalsIgnoreCase("Podkarpackie")) {
                piscaryDataPanel = new PiscaryDataPanel();
                contentHBox.getChildren().setAll(piscaryDataPanel);
            } else if (buttonClicked.getText().equalsIgnoreCase("Małopolskie")) {
                fishDataPanel = new FishDataPanel();
                contentHBox.getChildren().setAll(fishDataPanel);
            }
        }
    }
}
