public class User {
    private ChatMediator mediator;
    private String name;
    private ChatController controller;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        mediator.addUser(this);
    }

    public void send(String msg, String recipient) {
        System.out.println(this.name + ": Sending Message=" + msg + " to " + recipient);
        mediator.sendMessage(msg, this, recipient);
    }

    public void receive(String msg, String sender) {
        System.out.println(this.name + ": Received Message:" + msg + " from " + sender);
        if (controller != null) {
            controller.receiveMessage(msg, sender);
        }
    }

    public String getName() {
        return name;
    }

    public void setController(ChatController controller) {
        this.controller = controller;
    }
}
