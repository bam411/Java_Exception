// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),и возвращает введенное значение.
// Ввод текста вместо числа не должно приводить к падению приложения,
// вместо этого, необходимо повторно запросить у пользователя ввод данных.

package Homework_2;

import java.util.Scanner;

public class Exercise_1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean valid;
            Float number = null;
            String inputData;
            do {
                System.out.print("Введите число: ");
                try {
                    inputData = scanner.nextLine();
                    if (Float.parseFloat(inputData) > 0) {
                        number = Float.parseFloat(inputData);
                        valid = true;
                    } else {
                        System.out.println("Неверный ввод");
                        valid = false;
                    }
                } catch (Exception ex) {
                    valid = false;
                }
            } while (!valid);
            System.out.println("Вы ввели: " + number);
        }
    }
}
