package app.piscary;

import app.model.Piscary;
import app.repository.PiscaryRepository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;


public class ListOfPiscary extends VBox {

    private List <Piscary> listOfPiscary;

    @FXML
    VBox vBoxListOfPiscary;

    public ListOfPiscary(){
        listOfPiscary = PiscaryRepository.getAllPiscary();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/app/piscary/listOfPiscary.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    @FXML // Konstruktor dla kontrolek z GUI
    public void initialize() {

        for (Piscary item : listOfPiscary){
            String info = item.getName();
            long id = item.getPiscaryId();
            this.getChildren().add(new ListItem(info, id));
        }
    }
}


