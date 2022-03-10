package simpleFX;

//voing ofra vs yardena who has more votes for ofra the counter increases by 1 but for yardena decreases by 1 

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

public class Simplefx extends Application
{
	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage Stage)
	{
		Scene scene = new Scene(creatRoot());
		Stage.setTitle("Voting");
		Stage.setScene(scene);
		Stage.show();
	}

	private int count = 0;

	private VBox creatRoot() 
	{
		VBox root = new VBox(); 
		HBox butt = new HBox(); 
		Label label = new Label();
		label.setText("" + 0); 
		Color p;
		p = Color.RED;
		label.setMaxWidth(Double.MAX_VALUE);
		label.setAlignment(Pos.CENTER);
		label.setMinHeight(30);
		BackgroundFill b = new BackgroundFill(p, null, null);
		label.setBackground(new Background(b)); 
		root.getChildren().addAll(butt, label); 
		root.setPadding(new Insets(20));
		Button ofra = new Button("Ofra Haza");
		Button yardena = new Button("Yardena Arazi");
		butt.getChildren().addAll(ofra, yardena); 
		root.setAlignment(Pos.CENTER);
		root.setSpacing(25); 
		butt.setSpacing(15); 

		class ofracount implements EventHandler<ActionEvent> 
		{ 
			@Override
			public void handle(ActionEvent arg0) 
			{
				count++;
				label.setText(count + "");
				label.setTextFill(Color.BLACK);
			}
		}
		
		class yardencounter implements EventHandler<ActionEvent>
		{ 
			@Override
			public void handle(ActionEvent arg0) 
			{
				count--;
				label.setText(count + "");
				label.setTextFill(Color.BLACK);
			}
		}

		ofra.setOnAction(new ofracount());
		yardena.setOnAction(new yardencounter());

		return root;
	}
}