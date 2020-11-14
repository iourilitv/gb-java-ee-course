package gb.lesson4;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        int quantity = 5;
        for (int i = 0; i < 1000; i++) {
            int n = random.nextInt(quantity) + 1;
            if(n < 1 || n > 5) {
                System.out.println(n);
            }
        }

    }
}
