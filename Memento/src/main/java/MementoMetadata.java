import java.time.LocalDateTime;

public interface MementoMetadata {
    String getChangeDescription();
    LocalDateTime getTimestamp();
}