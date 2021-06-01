import java.util.Random;

public class randomtry {

    public static void main(String[] args) {
        
        Random rnd = new Random();
        int[] number = new int[10];

        for (int i = 0; i < 10; i++) {
            number[i] = rnd.nextInt(10);
                
            System.out.println("Number is " + number[i]);
        }
    }
}