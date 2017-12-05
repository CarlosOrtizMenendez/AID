package application;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class OneController {

	// not using yet
	@FXML
	private ImageView cc;

	private Ellipse ceiling;

	// private Stage sendStage;

	private void initializeCeiling(AnchorPane root) {
		ceiling = new Ellipse();
		ceiling.centerXProperty().bind(root.widthProperty().multiply(0.5));
		ceiling.centerYProperty().setValue(0);
		ceiling.radiusXProperty().bind(root.widthProperty().multiply(0.8));
		ceiling.radiusYProperty().bind(root.heightProperty().multiply(0.6));
	}

	/**
	 * Opens an stage to send the profile
	 */

	public void showSendProfile() {
		try {
			// Load the fxml file and create a new stage for the popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("View/Superheader.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage sendStage = new Stage();
			sendStage.setTitle("Superheader");

			// clips

			cc = new ImageView();

			cc.setEffect(new GaussianBlur(5));

			Scene scene = new Scene(page);
			sendStage.setScene(scene);

			sendStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void handleSend() {
		showSendProfile();
		// sendStage.close();
	}

	/**
	 * Closes the application when clicked on Exit in the secondary stage
	 */
	@FXML
	private void handleClose() {

		System.exit(0);
	}
}