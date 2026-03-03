public class Main {
    public static void main(String[] args) {

        Handler compensationHandler = new CompensationClaimHandler();
        Handler contactHandler = new ContactRequestHandler();
        Handler suggestionHandler = new DevelopmentSuggestionHandler();
        Handler feedbackHandler = new GeneralFeedbackHandler();


        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(feedbackHandler);


        Message message1 = new Message(MessageType.COMPENSATION_CLAIM, "Requesting refund for damaged product.", "customer1@example.com");
        Message message2 = new Message(MessageType.CONTACT_REQUEST, "Please call me regarding my order.", "customer2@example.com");
        Message message3 = new Message(MessageType.DEVELOPMENT_SUGGESTION, "Add a dark mode feature to the app.", "customer3@example.com");
        Message message4 = new Message(MessageType.GENERAL_FEEDBACK, "Great service, keep it up!", "customer4@example.com");


        compensationHandler.handle(message1);
        compensationHandler.handle(message2);
        compensationHandler.handle(message3);
        compensationHandler.handle(message4);
    }
}