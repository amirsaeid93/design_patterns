import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        ChatMediatorImpl mediator = new ChatMediatorImpl();

        User user1 = new User(mediator, "Alice");
        User user2 = new User(mediator, "Bob");
        User user3 = new User(mediator, "Mike");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        try {
            createChatWindow(user1, users);
            createChatWindow(user2, users);
            createChatWindow(user3, users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createChatWindow(User user, List<User> allUsers) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ChatView.fxml"));
        Parent root = loader.load();

        ChatController controller = loader.getController();
        controller.setUser(user);
        controller.initialize(allUsers);

        Stage stage = new Stage();
        stage.setTitle("Chat - " + user.getName());
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
