import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, DocumentInterface> documents = new HashMap<>();


    public void addDocument(String id, String content) {
        documents.put(id, new Document(id, content));
    }


    public void addProtectedDocument(String id, String content, String... allowedUsers) {
        Document realDoc = new Document(id, content);
        DocumentProxy proxy = new DocumentProxy(realDoc);


        AccessControlService acs = AccessControlService.getInstance();
        for (String user : allowedUsers) {
            acs.grantAccess(user, id);
        }

        documents.put(id, proxy);
    }

    public DocumentInterface getDocument(String id) {
        return documents.get(id);
    }
}
