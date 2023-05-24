/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(40, 40, 40, 40));
        grid.setVgap(20);
        grid.setHgap(20);

        Label usernameLabel = new Label("Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);
        TextField usernameInput = new TextField();
        GridPane.setConstraints(usernameInput, 1, 0);

        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);
        PasswordField passwordInput = new PasswordField();
        GridPane.setConstraints(passwordInput, 1, 1);

        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);
        loginButton.setOnAction(e -> {
            String username = usernameInput.getText();
            String password = passwordInput.getText();
            // Perform login validation here (e.g., check against a database)
            if (isValidLogin(username, password)) {
                // Successful login
                showAlert("Login Successful!", "Welcome, " + username + "!");
            } else {
                System.out.println("Invalid username or password.");
                // Invalid login
                showAlert("Login Failed", "Invalid username or password.");
            }
        });
        Button registerButton = new Button("Register");
        GridPane.setConstraints(registerButton, 2, 2);
        registerButton.setOnAction(e -> {
            String username = usernameInput.getText();
            String password = passwordInput.getText();
            // Perform login validation here (e.g., check against a database)
            if (isValidLogin(username, password)) {
                // Successful login
                showAlert("Login Successful!", "Welcome, " + username + "!");
            } else {
                System.out.println("Invalid username or password.");
                // Invalid login
                showAlert("Login Failed", "Invalid username or password.");
            }
        });

        grid.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, loginButton);

        Scene scene = new Scene(grid, 450, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean isValidLogin(String username, String password) {
        // Replace this with your login validation logic
        return username.equals("admin") && password.equals("password");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
