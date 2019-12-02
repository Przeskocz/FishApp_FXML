package app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


@SuppressWarnings("ALL")
public class MainMenuController {
    @FXML
    private Button buttonFish;
    @FXML
    private Button buttonPiscary;

    // Wspólna akcja dla obydwóch przycisków zadeklarowana jako pole klasy.
    // Zaletą tego rozwiązania jest możliwość użycia tego pola w obrębie całej klasy (w kazdym jej miescju)
    private EventHandler<ActionEvent> clickButtonsEvent;

    // Konstruktor klasy MainMenuController
    public MainMenuController() {
       initEvents();
    }

    @FXML // Konstruktor dla kontrolek z GUI
    public void initialize() {
        buttonFish.setOnAction(clickButtonsEvent);
        buttonPiscary.setOnAction(clickButtonsEvent);
    }



    private void initEvents() {
        // definicja akcji w polu clickButtonsEvent
        this.clickButtonsEvent = new EventHandler<ActionEvent>(){
            @Override
            public void handle(final ActionEvent event) {
                String patch = null;
                String title = null;

                if (event.getSource().equals(buttonFish)) {
                    patch = "/app/fish/fishPanel.fxml";
                    title = "Rybki :)";
                } else if(event.getSource().equals(buttonPiscary)) {
                    patch = "/app/piscary/piscaryPanel.fxml";
                    title = "Łowiska :)";
                }

                if (patch != null) {
                    try {
                        // Tworzony jest Loader dla podanego panelu w zmiennej patch
                        FXMLLoader loader = new FXMLLoader(getClass().getResource(patch));

                        // Tworzona nowa "estrada"
                        Stage stage = new Stage();

                        // Na estradę jest tworzona nowa scena na którą załadowywany jest panel z loader'a
                        stage.setScene(new Scene(loader.load()));

                        // Ustawia tytuł okna (napis na pasku u góry)
                        stage.setTitle(title);

                        // Prezentuj/pokaż na ekranie
                        stage.show();

                        // Ukryj bieżące okno
                        ((Node) (event.getSource())).getScene().getWindow().hide();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }; // end of new EventHandler<ActionEvent>()
    }
}
