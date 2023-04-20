// Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
// Фамилия Имя Отчество датарождения номертелефона пол
// Форматы данных: 
// фамилия, имя, отчество - строки
// дата_рождения - строка формата dd.mm.yyyy
// номер_телефона - целое беззнаковое число без форматирования
// пол - символ латиницей f или m.

// Приложение должно проверить введенные данные по количеству.
// Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

// Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
// Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
// Можно использовать встроенные типы java и создать свои.
// Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
// Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
// <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
// Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
// Не забудьте закрыть соединение с файлом.
// При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.

package Homework_3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise_1 {

    public class Main {
        public static void main(String[] args) throws InvalidDataFormatException {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Введите данные (Фамилия Имя Отчество, Дата рождения, Номер телефона, Пол): ");
                String input = scanner.nextLine();

                String[] data = input.split(" ");
                if (data.length != 6) {
                    throw new InvalidDataFormatException("Ошибка: некорректное количество данных.");
                }

                String lastName = data[0];
                String firstName = data[1];
                String middleName = data[2];
                String birthDateStr = data[3];
                String phoneNumberStr = data[4];
                String genderStr = data[5];

                try {
                    String[] birthDateParts = birthDateStr.split("\\.");
                    if (birthDateParts.length != 3) {
                        throw new InvalidDataFormatException("Некорректный формат даты рождения.");
                    }
                    int day = Integer.parseInt(birthDateParts[0]);
                    int month = Integer.parseInt(birthDateParts[1]);
                    int year = Integer.parseInt(birthDateParts[2]);
                    if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900 || year > 2023) {
                        throw new InvalidDataFormatException("Некорректная дата рождения.");
                    }
                    String birthDate = String.format("%02d.%02d.%04d", day, month, year);

                    long phoneNumber = Long.parseLong(phoneNumberStr);
                    if (phoneNumber < 11 || phoneNumber > 11) {
                        throw new InvalidDataFormatException("Некорректный номер телефона.");
                    }

                    char gender = genderStr.charAt(0);
                    if (gender != 'm' && gender != 'f') {
                        throw new InvalidDataFormatException("Некорректный пол.");
                    }

                    FileWriter writer = new FileWriter(
                            "/Volumes/bam/Обучение/Java_Exception/Homework_3/" + lastName + ".txt", true);
                    writer.write(
                            lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " "
                                    + gender + "\n");
                    writer.close();

                    System.out.println("Данные успешно записаны в файл.");
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: некорректный формат номера телефона.");
                } catch (InvalidDataFormatException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                } catch (IOException e) {
                    System.out.println("Ошибка записи в файл: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }

        private static class InvalidDataFormatException extends Exception {
            public InvalidDataFormatException(String message) {
                super(message);
            }
        }
    }
}
