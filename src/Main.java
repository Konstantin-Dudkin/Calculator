

public class Main {
    public static void main(String[] args) {
        Processing processing = new Processing();

        System.out.println("Введите выражение из двух чисел от 1 до 10. " +
                "Цифры могут быть римскими.");


        for (int i = 0; i < 100; i++) {
            System.out.println(processing.inputProcessing(Input.inp()));
        }

    }
}
