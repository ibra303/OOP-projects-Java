package mines;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MinesFX extends Application implements EventHandler<MouseEvent>
{
    Scene scene;
    Stage stage;

    Mines minesGame;
    GridPane aGridPane;
    
    int height = 10, width = 10, minesNum = 10;

    TextField widthTextField = new TextField(String.valueOf(width));
    TextField heightTextField = new TextField(String.valueOf(height));
    TextField minesTextField = new TextField(String.valueOf(minesNum));

    Button resetButton = new Button("Reset"); 

    VBox vBox = new VBox(10);
    HBox root = new HBox(10);

    @Override
    public void start(Stage stage) throws Exception 
    {
        this.stage = stage;

        Label widthLabel = new Label("width ");
        widthLabel.setMaxWidth(40);
        widthLabel.setAlignment(Pos.CENTER_LEFT);
        widthTextField.setMaxWidth(60);
        widthTextField.setAlignment(Pos.CENTER);

        Label heightLabel = new Label("height ");
        heightLabel.setMaxWidth(40);
        heightLabel.setAlignment(Pos.CENTER_LEFT);
        heightTextField.setMaxWidth(60);
        heightTextField.setAlignment(Pos.CENTER);

        Label minesLabel = new Label("mines ");
        minesLabel.setMaxWidth(40);
        minesLabel.setAlignment(Pos.CENTER_LEFT);
        minesTextField.setMaxWidth(60);
        minesTextField.setAlignment(Pos.CENTER);

        HBox labelAndText1 = new HBox();
        labelAndText1.getChildren().addAll(widthLabel, widthTextField);
        labelAndText1.setAlignment(Pos.CENTER);
        HBox labelAndText2 = new HBox();
        labelAndText2.getChildren().addAll(heightLabel, heightTextField);
        labelAndText2.setAlignment(Pos.CENTER);
        HBox labelAndText3 = new HBox();
        labelAndText3.getChildren().addAll(minesLabel, minesTextField);
        labelAndText3.setAlignment(Pos.CENTER);

        resetButton.setOnMouseClicked(this);
        resetButton.setAlignment(Pos.CENTER);
        resetButton.setMaxWidth(100);

        minesGame = new Mines(height, width, minesNum);

        vBox.getChildren().addAll(resetButton, labelAndText1, labelAndText2, labelAndText3);
        vBox.setAlignment(Pos.CENTER);

        this.stage.setTitle("The Amazing Mines Sweeper");
        SetRoot();
        this.stage.show();
    }

    private GridPane initiateGrid(int width, int height) 
    {
        GridPane aGridPane = new GridPane();
        for (int i = 0; i < height; i++) 
        {
            for (int j = 0; j < width; j++) 
            {
                Button b = new MyButton(minesGame.get(i, j), i, j);
                b.setOnMouseClicked(this);
                b.setPrefSize(40, 40);
                b.setAlignment(Pos.CENTER);
                if (minesGame.get(i, j) == "X") {
                	b.setText("X");
                } else if (minesGame.get(i, j) == "F") {
                	b.setText("F");
                } else if (minesGame.get(i, j) == ".")
                {
                    b.setText(".");
                } else
                    b.setFont(new Font("Arial", 17));
                aGridPane.add(b, i, j);
            }
        }
        return aGridPane;
    }

    private void SetRoot() 
    {
        aGridPane = initiateGrid(width, height);
        aGridPane.setAlignment(Pos.CENTER);
        root = new HBox(10);
        root.getChildren().addAll(vBox, aGridPane);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
        this.stage.setScene(new Scene(root));
    }

    @Override
    public void handle(MouseEvent event) 
    {
        if (event.getSource() instanceof MyButton) 
        {
            MyButton b = (MyButton) event.getSource();
            if (event.getButton() == MouseButton.PRIMARY) 
            {
            	if(minesGame.get(b.getX(), b.getY())=="F") 
            		return;    	            
                if (!minesGame.open(b.getX(), b.getY())) 
                {
                    minesGame.setShowAll(true);
                    WinOrLose("You lost bro!");                   
                } else if (minesGame.isDone()) 
                {
                    minesGame.setShowAll(true);
                    WinOrLose("You won bro!");                 
                }
            } 
            else if (event.getButton() == MouseButton.SECONDARY) {            
                minesGame.toggleFlag(b.getX(), b.getY());
            }
            SetRoot();
        } else {
            ResetGame();
        }
    }
    
    private void WinOrLose(String msg) 
    {
    	Stage newStage = new Stage();    	
    	Label txt =new Label(msg);
    	HBox comp = new HBox();
    	comp.setPadding(new Insets(20));
    	comp.getChildren().add(txt);
    	
    	Scene stageScene = new Scene(comp, 150, 100);
    	newStage.setScene(stageScene);
    	newStage.show();
    }

    private void ResetGame() 
    {//restart the game
        try {
            width = Integer.parseInt(widthTextField.getText());
            height = Integer.parseInt(heightTextField.getText());
            minesNum = Integer.parseInt(minesTextField.getText());

            if (minesNum < (width * height) / 4) {
                minesGame = new Mines(height, width, minesNum);
                SetRoot();
            } else {
               WinOrLose("Cannot fit all mines");
            }
        } catch (NumberFormatException e) {}
    }

    public static void main(String[] args) 
    {
        launch(args);
    }

}
