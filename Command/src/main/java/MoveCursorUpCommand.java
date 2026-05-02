public class MoveCursorUpCommand implements Command {
    private final PixelArtModel model;
    public MoveCursorUpCommand(PixelArtModel model) { this.model = model; }
    @Override public void execute() { model.moveCursor(-1, 0); }
}
