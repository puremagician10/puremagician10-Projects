import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MainMenu extends VBox {

    private Stage stage;

    public MainMenu(Stage stage) {
        this.stage = stage;
        setUpMainMenu();
    }

    private void setUpMainMenu() {
        setAlignment(Pos.CENTER);
        setSpacing(10);

        Button accountOverviewButton = new Button("View Account Overview");
        accountOverviewButton.setOnAction(e -> openAccountOverview());

        Button depositButton = new Button("Deposit Funds");
        depositButton.setOnAction(e -> openDepositScreen());

        Button withdrawButton = new Button("Withdraw Funds");
        withdrawButton.setOnAction(e -> openWithdrawScreen());

        Button transferButton = new Button("Transfer Funds");
        transferButton.setOnAction(e -> openTransferScreen());

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> logout());

        getChildren().addAll(
            accountOverviewButton,
            depositButton,
            withdrawButton,
            transferButton,
            logoutButton
        );
    }

    private void openAccountOverview() {
        // Placeholder for now, will implement AccountOverview later
        System.out.println("Opening Account Overview...");
    }

    private void openDepositScreen() {
        // Placeholder for now, will implement Deposit Screen later
        System.out.println("Opening Deposit Screen...");
    }

    private void openWithdrawScreen() {
        // Placeholder for now, will implement Withdraw Screen later
        System.out.println("Opening Withdraw Screen...");
    }

    private void openTransferScreen() {
        // Placeholder for now, will implement Transfer Screen later
        System.out.println("Opening Transfer Screen...");
    }

    private void logout() {
        LoginScreen loginScreen = new LoginScreen(stage);
        Scene scene = new Scene(loginScreen, 300, 250);
        stage.setScene(scene);
    }
}
