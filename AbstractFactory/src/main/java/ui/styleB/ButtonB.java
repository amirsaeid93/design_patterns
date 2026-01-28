package ui.styleB;

import ui.abstracts.Button;

public class ButtonB extends Button {
    public ButtonB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("+---- " + text + " ----+");
    }
}