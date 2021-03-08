public class Welcome {
    public static void main(String[] args) {
        //println has a portable newline character from OS to OS
        System.out.println("Welcome! (Printed from println)");
        //printf with the %n specifier is portable, however the \n character is NOT
        System.out.printf("%s%n%s%n",
                "Welcome to", "Java! (Printed from printf)");
    }
}