package it22105.Users;

public class Author extends Person {
    public Author(String name) {
        super(name);
    }

    public Author(String name, String surname, String title, String email, String institution) {
        super(name, surname, title, email, institution);
    }
}
