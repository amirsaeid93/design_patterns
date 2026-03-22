public class Main {
    public static void main(String[] args) {
        Library library = new Library();


        User alice = new User("alice");
        User bob = new User("bob");


        library.addDocument("doc1", "Tämä on suojaamaton julkinen asiakirja.");


        library.addProtectedDocument("doc2",
                "Tämä on suojattu asiakirja ja vain Alice:llä on pääsy tähän dokumenttiin.", "alice");

        try {
            System.out.println("Alice lukee doc1: " + library.getDocument("doc1").getContent(alice));
            System.out.println("Bob lukee doc1: " + library.getDocument("doc1").getContent(bob));


            System.out.println("Alice lukee doc2: " + library.getDocument("doc2").getContent(alice));


            System.out.println("Bob lukee doc2: " + library.getDocument("doc2").getContent(bob));

        } catch (AccessDeniedException e) {
            System.err.println(e.getMessage());
        }
    }
}
