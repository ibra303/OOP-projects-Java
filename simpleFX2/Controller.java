package simpleFX2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller implements Initializable
{
    public Button ofraHazaButton;
    public Button yardenaAraziButton;
    private IntegerProperty votes = new SimpleIntegerProperty(0);
    public Label voteCounterLabel;

    public void ofraHazaButtonController()
    {//add 1 vote 
        votes.setValue(votes.getValue() + 1);
    }

    public void yardenaAraziButtonController() 
    {//delete 1 vote
    	votes.setValue(votes.getValue() - 1);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        voteCounterLabel.textProperty().bind(votes.asString());
    }
}
