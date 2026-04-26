import java.util.Iterator;

/*
   Rationale for state maintenance:
   I have decided to maintain the state of the Fibonacci sequence calculation within the
   FibonacciIterator class rather than the FibonacciSequence class.
   This choice ensures that each iterator is independent. If we create two separate
   iterators from the same FibonacciSequence object, they will each start the
   sequence from the beginning and maintain their own counters. If the state were
   stored in the FibonacciSequence class, creating a second iterator would either
   reset the first one or continue from where the first one left off, which
   violates the principles of independent iteration.
*/
public class FibonacciIterator implements Iterator<Integer> {
    private int a = 0;
    private int b = 1;

    @Override
    public boolean hasNext() {
        // The Fibonacci sequence is conceptually infinite
        return true;
    }

    @Override
    public Integer next() {
        int res = b;
        int nextValue = a + b;
        a = b;
        b = nextValue;
        return res;
    }
}
