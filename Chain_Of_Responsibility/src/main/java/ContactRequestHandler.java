public class ContactRequestHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("Contact request from " + message.getSenderEmail() + ": " + message.getContent());
            System.out.println("Action: Forwarded to appropriate department.");
        } else {
            super.handle(message);
        }
    }
}