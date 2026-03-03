public class GeneralFeedbackHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("General feedback from " + message.getSenderEmail() + ": " + message.getContent());
            System.out.println("Action: Analyzed and responded.");
        } else {
            super.handle(message);
        }
    }
}