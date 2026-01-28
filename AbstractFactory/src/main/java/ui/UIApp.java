package ui;

import ui.abstracts.Button;
import ui.abstracts.Checkbox;
import ui.abstracts.TextField;
import ui.abstracts.UIFactory;
import ui.styleA.StyleAFactory;
import ui.styleB.StyleBFactory;

public class UIApp {
    public static void main(String[] args) {

        UIFactory factory = new StyleAFactory();
        System.out.println("=== Style A ===");
        Button btnA = factory.createButton("OK");
        TextField tfA = factory.createTextField("Enter name");
        Checkbox cbA = factory.createCheckbox("Accept terms");

        btnA.display();
        tfA.display();
        cbA.display();


        tfA.setText("Changed!");
        tfA.display();


        factory = new StyleBFactory();
        System.out.println("\n=== Style B ===");
        Button btnB = factory.createButton("Submit");
        TextField tfB = factory.createTextField("Password");
        Checkbox cbB = factory.createCheckbox("Remember me");

        btnB.display();
        tfB.display();
        cbB.display();


        btnB.setText("Login");
        btnB.display();
    }
}