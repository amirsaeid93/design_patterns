public class CompensationClaimHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.COMPENSATION_CLAIM) {
            System.out.println("Compensation claim from " + message.getSenderEmail() + ": " + message.getContent());
            System.out.println("Action: Reviewed and approved/rejected.");
        } else {
            super.handle(message);
        }
    }
}