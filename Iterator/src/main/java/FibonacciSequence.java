public class FibonacciSequence implements Sequence {
    @Override
    public java.util.Iterator<Integer> iterator() {
        return new FibonacciIterator();
    }
}
