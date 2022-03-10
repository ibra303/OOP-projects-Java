package simpleFX2;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VotingMachine2 extends Application 
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception 
	{
		Parent P = FXMLLoader.load(getClass().getResource("FXML.fxml"));
		stage.setTitle("Voting Machine");
		Scene scene = new Scene(P);
		stage.setScene(scene);
		stage.show();
	}
}
