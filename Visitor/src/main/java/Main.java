public class Main {

    public static void main(String[] args) {

        Directory root = new Directory("root");
        Directory docs = new Directory("documents");
        Directory images = new Directory("images");

        File file1 = new File("resume.docx", 2);
        File file2 = new File("budget.xlsx", 5);
        File file3 = new File("holiday.jpg", 10);
        File file4 = new File("notes.txt", 1);

        docs.addElement(file1);
        docs.addElement(file2);
        images.addElement(file3);
        root.addElement(docs);
        root.addElement(images);
        root.addElement(file4);


        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Tiedostojen yhteen laskettu koko megabitteinä on: " + sizeVisitor.getTotalSize() + " MB.");


        SearchVisitor searchVisitor = new SearchVisitor(".docx");
        root.accept(searchVisitor);

        System.out.println("Hakutulokset haulla '.docx':");
        for (File f : searchVisitor.getMatchingFiles()) {
            System.out.println(" - " + f.getName() + " (" + f.getSize() + " MB)");


        }
    }
}
