public class SortContext {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] array) {
        if (strategy == null) {
            throw new IllegalStateException("Sort strategy not set!");
        }
        strategy.sort(array);
    }
}