public class PerformanceTester {
    public static void main(String[] args) {
        int[] smallDataSet = DataGenerator.generateRandomArray(30, 100);
        int[] largeDataSet = DataGenerator.generateRandomArray(100000, 100000);

        SortContext context = new SortContext();


        context.setStrategy(new BubbleSort());
        testPerformance(context, smallDataSet, "Bubble Sort");
        testPerformance(context, largeDataSet, "Bubble Sort");


        context.setStrategy(new QuickSort());
        testPerformance(context, smallDataSet, "Quick Sort");
        testPerformance(context, largeDataSet, "Quick Sort");


        context.setStrategy(new MergeSort());
        testPerformance(context, smallDataSet, "Merge Sort");
        testPerformance(context, largeDataSet, "Merge Sort");
    }

    private static void testPerformance(SortContext context, int[] dataSet, String algorithmName) {
        int[] dataCopy = dataSet.clone();
        long startTime = System.nanoTime();
        context.executeStrategy(dataCopy);
        long endTime = System.nanoTime();
        System.out.println(algorithmName + " took " + (endTime - startTime) / 1_000_000.0 + " ms.");
    }
}