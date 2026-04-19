public interface ChatMediator {
    void sendMessage(String msg, User user, String recipient);
    void addUser(User user);
}
