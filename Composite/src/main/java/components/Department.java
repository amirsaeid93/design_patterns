package components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Department implements OrgComponent {
    private final String name;
    private final List<OrgComponent> children = new ArrayList<>();

    public Department(String name) { this.name = Objects.requireNonNull(name); }

    @Override
    public String getName() { return name; }

    @Override
    public double getTotalSalary() {
        return children.stream().mapToDouble(OrgComponent::getTotalSalary).sum();
    }

    @Override
    public void add(OrgComponent c) { children.add(Objects.requireNonNull(c)); }

    @Override
    public void remove(OrgComponent c) { children.remove(c); }

    public List<OrgComponent> getChildren() { return Collections.unmodifiableList(children); }

    @Override
    public String toXml(int indent) {
        String spaces = " ".repeat(indent);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s<department name=\"%s\">\n", spaces, escape(name)));
        for (OrgComponent c : children) {
            sb.append(c.toXml(indent + 2));
        }
        sb.append(String.format("%s</department>\n", spaces));
        return sb.toString();
    }

    private static String escape(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&apos;");
    }
}