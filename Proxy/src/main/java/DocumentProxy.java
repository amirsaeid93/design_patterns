public class DocumentProxy implements DocumentInterface {
    private final Document realDocument;
    private final AccessControlService accessControlService = AccessControlService.getInstance();

    public DocumentProxy(Document realDocument) {
        this.realDocument = realDocument;
    }

    @Override
    public String getId() {
        return realDocument.getId();
    }

    @Override
    public String getCreationDate() {
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (accessControlService.isAllowed(realDocument.getId(), user.getUsername())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException("Dokumenttiin pääsy estetty käyttäjältä: " + user.getUsername() + ".");
        }
    }
}
