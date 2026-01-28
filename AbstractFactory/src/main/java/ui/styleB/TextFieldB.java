package ui.styleB;

import ui.abstracts.TextField;

public class TextFieldB extends TextField {
    public TextFieldB(String text) {
        super(text);
    }

    @Override
    public void display() {
        String border = buildBorder(text.length() + 2);
        System.out.println("/" + border + "\\");
        System.out.println("| " + text + " |");
        System.out.println("\\" + border + "/");
    }

    private String buildBorder(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
