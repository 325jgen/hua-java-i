package it22105;

public class Author extends Person {
    
    public Author(String email) {
        super(email);
    }

    public Author(String name, String surname, String title, String email, String institution) {
        super(name, surname, title, email, institution);
    }
}
