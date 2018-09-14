package math.problems;

public class Fibonacci {
    public static void main(String[] args) {
         /*
          Write 40 Fibonacci numbers with java.
         */


        int prev = 0;
        int next = 1;
        for (int i = 0; i < 40; i++) {
            System.out.print(next + "\t");
            prev = next - prev;
            next = next + prev;

        }
    }
}
