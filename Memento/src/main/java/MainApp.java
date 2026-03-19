import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainApp extends Application {

    private final Model model = new Model();
    private final History history = new History();
    private boolean isInternalChange = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        history.save(model.save("Initial State"));


        VBox root = new VBox(10);
        root.setPadding(new Insets(10));


        HBox rectangles = new HBox(10);
        Slider slider1 = createColorSlider(rectangles, model.color1Property());
        Slider slider2 = createColorSlider(rectangles, model.color2Property());
        Slider slider3 = createColorSlider(rectangles, model.color3Property());


        CheckBox checkBox = new CheckBox("Is Checked?");
        checkBox.selectedProperty().bindBidirectional(model.isCheckedProperty());


        Button historyButton = new Button("Show History");
        historyButton.setOnAction(e -> createHistoryWindow());

        root.getChildren().addAll(rectangles, slider1, slider2, slider3, checkBox, historyButton);


        ChangeListener<Object> changeListener = (obs, oldVal, newVal) -> {
            if (!isInternalChange) {
                String description = "State changed";
                if (obs == model.color1Property()) description = "Changed Color 1";
                if (obs == model.color2Property()) description = "Changed Color 2";
                if (obs == model.color3Property()) description = "Changed Color 3";
                if (obs == model.isCheckedProperty()) description = "Toggled Checkbox";
                history.save(model.save(description));
            }
        };

        model.color1Property().addListener(changeListener);
        model.color2Property().addListener(changeListener);
        model.color3Property().addListener(changeListener);
        model.isCheckedProperty().addListener(changeListener);


        Scene scene = new Scene(root, 400, 300);
        setupShortcuts(scene);

        primaryStage.setTitle("Memento Pattern Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void setupShortcuts(Scene scene) {

        scene.getAccelerators().put(new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN), () -> {
            System.out.println("Undo triggered");
            isInternalChange = true;
            Memento mementoToRestore = history.undo(model.save("Undo Action"));
            model.restore(mementoToRestore);
            isInternalChange = false;
        });


        scene.getAccelerators().put(new KeyCodeCombination(KeyCode.Y, KeyCombination.CONTROL_DOWN), () -> {
            System.out.println("Redo triggered");
            isInternalChange = true;
            Memento mementoToRestore = history.redo(model.save("Redo Action"));
            model.restore(mementoToRestore);
            isInternalChange = false;
        });
    }


    private void createHistoryWindow() {
        Stage historyStage = new Stage();
        historyStage.setTitle("History");

        ListView<Memento> listView = new ListView<>(history.getUndoList());


        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                System.out.println("Restoring from history: " + newSelection);
                isInternalChange = true;
                model.restore(newSelection);
                isInternalChange = false;
            }
        });

        Scene scene = new Scene(listView, 300, 400);
        historyStage.setScene(scene);
        historyStage.show();
    }


    private Slider createColorSlider(HBox parent, DoubleProperty colorProperty) {
        Rectangle rect = new Rectangle(50, 50);

        rect.fillProperty().bind(Bindings.createObjectBinding(() -> Color.gray(colorProperty.get()), colorProperty));
        parent.getChildren().add(rect);

        Slider slider = new Slider(0, 1, 0.5);
        slider.valueProperty().bindBidirectional(colorProperty);
        return slider;
    }
}