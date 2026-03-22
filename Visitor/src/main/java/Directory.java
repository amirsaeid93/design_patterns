import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement {


    private final String name;
    private final List<FileSystemElement> children = new ArrayList<>();


    public Directory(String name) {
        this.name = name;
    }


    public void addElement(FileSystemElement element) {
        children.add(element);
    }


    public List<FileSystemElement> getChildren() {
        return children;
    }


    @Override
    public String getName() {
        return name;
    }


    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}