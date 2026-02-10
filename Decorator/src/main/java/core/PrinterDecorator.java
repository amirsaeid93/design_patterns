package core;

public abstract class PrinterDecorator implements Printer {
    protected Printer wrappedPrinter;

    public PrinterDecorator(Printer wrappedPrinter) {
        this.wrappedPrinter = wrappedPrinter;
    }

    @Override
    public void print(String message) {
        wrappedPrinter.print(message);
    }
}