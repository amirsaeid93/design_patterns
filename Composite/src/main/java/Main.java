import components.Department;
import components.Employee;

public class Main {
    public static void main(String[] args) {
        Organization org = new Organization("Acme Corp");
        Department root = org.getRoot();

        Department engineering = org.addDepartment(root, "Engineering");
        Department hr = org.addDepartment(root, "Human Resources");
        Department platform = org.addDepartment(engineering, "Platform");
        Department apps = org.addDepartment(engineering, "Applications");

        org.addEmployee(hr, "Alice HR", 52000);
        org.addEmployee(hr, "Bob HR", 56000);

        org.addEmployee(platform, "Charlie DevOps", 88000);
        org.addEmployee(platform, "Diana SRE", 94000);

        org.addEmployee(apps, "Eve Android", 90000);
        org.addEmployee(apps, "Frank iOS", 91000);

        org.printTotalSalary();
        org.printXml();

        Employee contractor = org.addEmployee(platform, "Grace Contractor", 40000);
        org.printTotalSalary();

        org.remove(platform, contractor);
        org.printTotalSalary();
        org.printXml();
    }
}