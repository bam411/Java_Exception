// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
// каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
// Если длины массивов не равны, необходимо как-то оповестить пользователя.

package Homework_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise_1 {
    public static void main(String[] args) {
        int[] firstArray = { 1, 2, 3, 7, 8, 9 };
        int[] secondArray = { 0, 1, 2, 1, 2, 3 };
        System.out.println(Arrays.toString(firstArray));
        System.out.println(Arrays.toString(secondArray));
        System.out.println("Разница двух  массивов " + differenceArray(firstArray, secondArray));
    }

    public static ArrayList<Integer> differenceArray(int[] firstArray, int[] secondArray) {
        ArrayList<Integer> result = new ArrayList<>();
        int min = Math.min(firstArray.length, secondArray.length);
        int max = Math.max(firstArray.length, secondArray.length);

        if (min < max) {
            throw new RuntimeException("Длинны массивов не равны");
        }
        for (int i = 0; i < min; i++) {
            result.add(firstArray[i] - secondArray[i]);
        }
        return result;
    }
}