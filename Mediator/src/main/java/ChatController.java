import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;

public class ChatController {

    @FXML
    private TextArea chatArea;

    @FXML
    private TextField messageField;

    @FXML
    private ChoiceBox<String> recipientChoiceBox;

    @FXML
    private Button sendButton;

    private User user;

    public void setUser(User user) {
        this.user = user;
        this.user.setController(this);
    }

    public void initialize(List<User> users) {
        // All option for sending a message to everyone
        recipientChoiceBox.getItems().add("All");
        for (User u : users) {
            if (!u.getName().equals(this.user.getName())) {
                recipientChoiceBox.getItems().add(u.getName());
            }
        }
        if (!recipientChoiceBox.getItems().isEmpty()) {
            recipientChoiceBox.setValue("All");
        }
    }

    @FXML
    void sendMessage() {
        String message = messageField.getText();
        String recipient = recipientChoiceBox.getValue();
        if (message != null && !message.isEmpty() && recipient != null) {
            user.send(message, recipient);
            chatArea.appendText("You to " + recipient + ": " + message + "\n");
            messageField.clear();
        }
    }

    public void receiveMessage(String message, String sender) {
        chatArea.appendText(sender + ": " + message + "\n");
    }
}
