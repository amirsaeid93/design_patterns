public class Main {
    public static void main(String[] args) {
        NewDateInterface date = new CalendarToNewDateAdapter();

        date.setYear(2025);
        date.setMonth(9);
        date.setDay(25);


        System.out.println("Initial Date is: " + date);


        date.advanceDays(10);
        System.out.println("After 10 days the date is: " + date);


        date.advanceDays(40);
        System.out.println("And after another 40 days the date is: " + date);
    }
}
