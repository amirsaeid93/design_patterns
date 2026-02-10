package decorators;

import core.Printer;
import core.PrinterDecorator;

import java.util.Base64;

public class EncryptedPrinter extends PrinterDecorator {

    public EncryptedPrinter(Printer wrappedPrinter) {
        super(wrappedPrinter);
    }

    @Override
    public void print(String message) {
        String encryptedMessage = encrypt(message);
        super.print(encryptedMessage);
    }

    private String encrypt(String message) {

        return Base64.getEncoder().encodeToString(message.getBytes());
    }

    public String decrypt(String encryptedMessage) {
        return new String(Base64.getDecoder().decode(encryptedMessage));
    }
}