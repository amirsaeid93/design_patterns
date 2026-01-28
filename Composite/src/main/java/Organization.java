import components.Department;
import components.Employee;
import components.OrgComponent;

public class Organization {
    private final Department root;

    public Organization(String name) { this.root = new Department(name); }

    public Department getRoot() { return root; }

    public Department addDepartment(Department parent, String name) {
        Department d = new Department(name);
        parent.add(d);
        return d;
    }

    public Employee addEmployee(Department parent, String name, double salary) {
        Employee e = new Employee(name, salary);
        parent.add(e);
        return e;
    }

    public void remove(Department parent, OrgComponent child) { parent.remove(child); }

    public double totalSalary() { return root.getTotalSalary(); }

    public String toXml() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("<organization name=\"%s\">\n", escape(root.getName())));
        for (OrgComponent c : root.getChildren()) {
            sb.append(c.toXml(2));
        }
        sb.append("</organization>\n");
        return sb.toString();
    }

    public void printTotalSalary() { System.out.printf("Total salary: %.2f\n", totalSalary()); }
    public void printXml() { System.out.print(toXml()); }

    private static String escape(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&apos;");
    }
}