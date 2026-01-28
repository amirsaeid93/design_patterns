package ui.styleA;

import ui.abstracts.Button;
import ui.abstracts.Checkbox;
import ui.abstracts.TextField;
import ui.abstracts.UIFactory;

public class StyleAFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        return new ButtonA(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldA(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxA(text);
    }
}