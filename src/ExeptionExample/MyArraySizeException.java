package ExeptionExample;

public class MyArraySizeException extends Exception{
    @Override
    public void printStackTrace() {
        System.out.println("проверьте размер массива, должен быть 4 на 4");
    }
}
