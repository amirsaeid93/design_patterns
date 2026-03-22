import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;
    private final Set<String> allowedPairs;

    private AccessControlService() {
        this.allowedPairs = new HashSet<>();
    }

    public static synchronized AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void grantAccess(String username, String documentId) {
        allowedPairs.add(username + ":" + documentId);
    }

    public boolean isAllowed(String documentId, String username) {
        return allowedPairs.contains(username + ":" + documentId);
    }
}
