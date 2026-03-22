import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {

    private final String keyword;
    private final List<File> matchingFiles = new ArrayList<>();

    public SearchVisitor(String keyword) {
        this.keyword = keyword.toLowerCase();
    }

    @Override
    public void visit(File file) {
        if (file.getName().toLowerCase().contains(keyword)) {
            matchingFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement child : directory.getChildren()) {
            child.accept(this);
        }
    }

    public List<File> getMatchingFiles() {
        return matchingFiles;
    }
}