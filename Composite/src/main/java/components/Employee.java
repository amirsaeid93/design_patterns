package components;

import java.util.Objects;

public class Employee implements OrgComponent {
    private final String name;
    private final double salary;

    public Employee(String name, double salary) {
        this.name = Objects.requireNonNull(name);
        this.salary = salary;
    }

    @Override
    public String getName() { return name; }

    public double getSalary() { return salary; }

    @Override
    public double getTotalSalary() { return salary; }

    @Override
    public String toXml(int indent) {
        String spaces = " ".repeat(indent);
        return String.format("%s<employee name=\"%s\" salary=\"%.2f\"/>\n", spaces, escape(name), salary);
    }

    private static String escape(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&apos;");
    }
}