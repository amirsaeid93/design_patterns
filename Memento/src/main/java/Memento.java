import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public final class Memento implements MementoMetadata {

    private final double color1;
    private final double color2;
    private final double color3;
    private final boolean isChecked;


    private final LocalDateTime timestamp;
    private final String changeDescription;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Memento(double c1, double c2, double c3, boolean checked, String description) {
        this.color1 = c1;
        this.color2 = c2;
        this.color3 = c3;
        this.isChecked = checked;
        this.changeDescription = description;
        this.timestamp = LocalDateTime.now();
    }


    public double getColor1() { return color1; }
    public double getColor2() { return color2; }
    public double getColor3() { return color3; }
    public boolean isChecked() { return isChecked; }


    @Override
    public String getChangeDescription() { return changeDescription; }
    @Override
    public LocalDateTime getTimestamp() { return timestamp; }


    @Override
    public String toString() {
        return String.format("[%s] %s", timestamp.format(FORMATTER), changeDescription);
    }
}