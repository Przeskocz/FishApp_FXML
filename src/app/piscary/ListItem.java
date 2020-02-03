package app.piscary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ListItem extends AnchorPane {

    @FXML
    Label labelItemPiscaryInfo;

    @FXML
    Button buttonPiscaryItem;

    private String info;
    private long id;

    public ListItem(String info, long id) {
        this.info = info;
        this.id = id;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/app/piscary/listItem.fxml"));
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
        labelItemPiscaryInfo.setText(info);
    }
}


