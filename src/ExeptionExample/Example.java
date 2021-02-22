package ExeptionExample;

import java.util.Arrays;
import java.util.Collections;

/**
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
 * при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
 * должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
 * 3. В методе main() вызвать полученный метод,
 * обработать возможные исключения MySizeArrayException и MyArrayDataException,
 * и вывести результат расчета.
 */

public class Example {

    public static void main(String[] args) {
        String[][] s = {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        String[][] s2 = {{"1", "1", "1", "1"}, {"1"}};
        String[][] s3 = {{"1", "1", "1", "1"}, {"one", "1", "1", "1"}};

        try {
            System.out.println("Test 1, array - s");
            someTest(s);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }finally {
            System.out.println("End of Test 1 \n" );
//            System.out.println();
        }

        try {
            System.out.println("Test 2, array - s2");
            someTest(s2);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }finally {
            System.out.println("End of Test 2");
            System.out.println();
        }

        try {
            System.out.println("Test 3, array - s3");
            someTest(s3);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }finally {
            System.out.println("End of Test 3");
            System.out.println();
        }
    }

    static void someTest(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (arr.length != 2 || arr[0].length !=4 || arr[1].length != 4){
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                try {
                    int temp = Integer.parseInt(arr[i][j]);
                    sum += temp;

                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка по адресу ячейки: ряд - " + i + " столбец - " + j);
                    throw new MyArrayDataException();
                }
            }
        }
        System.out.println("Сумма всех элементов массива равна " + sum);
    }
}
