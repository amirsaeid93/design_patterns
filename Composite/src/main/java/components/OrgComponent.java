package components;

public interface OrgComponent {
    String getName();
    double getTotalSalary();

    default void add(OrgComponent c) { throw new UnsupportedOperationException("Cannot add to leaf"); }
    default void remove(OrgComponent c) { throw new UnsupportedOperationException("Cannot remove from leaf"); }

    String toXml(int indent);
}