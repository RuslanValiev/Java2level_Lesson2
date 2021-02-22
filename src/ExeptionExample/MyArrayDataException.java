package ExeptionExample;

public class MyArrayDataException extends Exception{
    @Override
    public void printStackTrace() {
        System.out.println("Не удалось преобразовать строку в число");
    }
}
