import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;


public class Model {
    private final DoubleProperty color1 = new SimpleDoubleProperty();
    private final DoubleProperty color2 = new SimpleDoubleProperty();
    private final DoubleProperty color3 = new SimpleDoubleProperty();
    private final BooleanProperty isChecked = new SimpleBooleanProperty();


    public DoubleProperty color1Property() { return color1; }
    public DoubleProperty color2Property() { return color2; }
    public DoubleProperty color3Property() { return color3; }
    public BooleanProperty isCheckedProperty() { return isChecked; }


    public Memento save(String changeDescription) {
        return new Memento(color1.get(), color2.get(), color3.get(), isChecked.get(), changeDescription);
    }


    public void restore(Memento memento) {
        if (memento != null) {
            color1.set(memento.getColor1());
            color2.set(memento.getColor2());
            color3.set(memento.getColor3());
            isChecked.set(memento.isChecked());
        }
    }
}