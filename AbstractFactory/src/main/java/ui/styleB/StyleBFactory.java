package ui.styleB;

import ui.abstracts.Button;
import ui.abstracts.Checkbox;
import ui.abstracts.TextField;
import ui.abstracts.UIFactory;

public class StyleBFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        return new ButtonB(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldB(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxB(text);
    }
}