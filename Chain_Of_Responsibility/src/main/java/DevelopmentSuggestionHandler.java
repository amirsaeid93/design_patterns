public class DevelopmentSuggestionHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("Development suggestion from " + message.getSenderEmail() + ": " + message.getContent());
            System.out.println("Action: Logged and prioritized.");
        } else {
            super.handle(message);
        }
    }
}