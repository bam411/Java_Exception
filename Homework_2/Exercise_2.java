// Если необходимо, исправьте данный код
// try {
//     int d = 0;
//     double catchedRes1 = intArray[8] / d;
//     System.out.println("catchedRes1 = " + catchedRes1);
//  } catch (ArithmeticException e) {
//     System.out.println("Catching exception: " + e);
//  }

package Homework_2;

public class Exercise_2 {
    public static void main() {
        try {
            int d = 0;
            int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
