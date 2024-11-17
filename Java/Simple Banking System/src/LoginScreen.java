import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginScreen extends VBox {

    private Stage stage;

    public LoginScreen(Stage stage) {
        this.stage = stage;
        setUpLoginScreen();
    }

    private void setUpLoginScreen() {
        Label label = new Label("Login to Banking System");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> login(usernameField.getText(), passwordField.getText()));

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, usernameField, passwordField, loginButton);
        layout.setAlignment(Pos.CENTER);

        Scene loginScene = new Scene(layout, 300, 250);
        stage.setScene(loginScene);
    }

    private void login(String username, String password) {
        // Logic for validating user credentials
        // For now, we assume a simple check
        if (username.equals("admin") && password.equals("password")) {
            openMainMenu();
        } else {
            showError("Invalid credentials. Please try again.");
        }
    }

    private void openMainMenu() {
        MainMenu mainMenu = new MainMenu(stage);
        Scene scene = new Scene(mainMenu, 400, 400);
        stage.setScene(scene);
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
