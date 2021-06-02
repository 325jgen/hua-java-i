package it22105.Articles;

public class paperInProgress extends article {
    private String property; // Regular or Case Study
    private String propertyOrg; // TODO Maybe I can change this with interfaces, will check

    public paperInProgress(int ID, String title, String[] keywords, String[] authors, int[] score, String property, String propertyOrg) {
        super(ID, title, keywords, authors, score);
        this.property = property;
        this.propertyOrg = propertyOrg;
    }

    public paperInProgress() {
        super();
        System.out.println("Δώσε 1 αν το άρθρο είναι κανονικό και 2 αν το άρθρο είναι μελέτη περίπτωσης (case study)");
        this.property = input.next();

        // Checking input
        while (!(property.equals("1")) && !(property.equals("2"))) {
            System.out.println("Δώσατε αριθμό διαφορετικό του 1 ή του 2\nΠαρακαλώ προσπαθήστε ξανά");
            this.property = input.next();
        }

        if (property.equals("2")) {
            this.property = "Case Study";
            System.out.println("Ποιό είναι το περιβάλλον της μελέτης στο οποίο βασίζεται το άρθρο;");
            this.propertyOrg = input.next();
        } else {
            this.property = "Regular";
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nΤύπος άρθρου: Full Paper, " + property +
                "\nΠεριβάλλον μελέτης περίπτωσης: " + propertyOrg;
    }
}
