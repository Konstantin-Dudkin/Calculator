import java.util.HashMap;
import java.util.Map;

public class Processing {

    private Map<String, Integer> romanNumerals = new HashMap<String, Integer>() {{
        put("0", 0);
        put("I", 1);
        put("II", 2);
        put("III", 3);
        put("IV", 4);
        put("V", 5);
        put("VI", 6);
        put("VII", 7);
        put("VIII", 8);
        put("IX", 9);
        put("X", 10);
    }};

    private Map<Integer, String> romanNumeralsResult = new HashMap<Integer, String>() {{
        put(0, "0");
        put(1, "I");
        put(2, "II");
        put(3, "III");
        put(4, "IV");
        put(5, "V");
        put(6, "VI");
        put(7, "VII");
        put(8, "VIII");
        put(9, "IX");
        put(10, "X");
        put(11, "XI");
        put(12, "XII");
        put(13, "XIII");
        put(14, "XIV");
        put(15, "XV");
        put(16, "XVI");
        put(17, "XVII");
        put(18, "XVIII");
        put(19, "XIX");
        put(20, "XX");
        put(21, "XXI");
        put(22, "XXII");
        put(23, "XXIII");
        put(24, "XXIV");
        put(25, "XXV");
        put(26, "XXVI");
        put(27, "XXVII");
        put(28, "XXVIII");
        put(29, "XXIX");
        put(30, "XXX");
        put(31, "XXXI");
        put(32, "XXXII");
        put(33, "XXXIII");
        put(34, "XXXIV");
        put(35, "XXXV");
        put(36, "XXXVI");
        put(37, "XXXVII");
        put(38, "XXXVIII");
        put(39, "XXXIX");
        put(40, "XL");
        put(41, "XLI");
        put(42, "XLII");
        put(43, "XLIII");
        put(44, "XLIV");
        put(45, "XLV");
        put(46, "XLVI");
        put(47, "XLVII");
        put(48, "XLVIII");
        put(49, "XLIX");
        put(50, "L");
        put(51, "LI");
        put(52, "LII");
        put(53, "LIII");
        put(54, "LIV");
        put(55, "LV");
        put(56, "LVI");
        put(57, "LVII");
        put(58, "LVIII");
        put(59, "LIX");
        put(60, "LX");
        put(61, "LXI");
        put(62, "LXII");
        put(63, "LXIII");
        put(64, "LXIV");
        put(65, "LXV");
        put(66, "LXVI");
        put(67, "LXVII");
        put(68, "LXVIII");
        put(69, "LXIX");
        put(70, "LXX");
        put(71, "LXXI");
        put(72, "LXXII");
        put(73, "LXXIII");
        put(74, "LXXIV");
        put(75, "LXXV");
        put(76, "LXXVI");
        put(77, "LXXVII");
        put(78, "LXXVIII");
        put(79, "LXXIX");
        put(80, "LXXX");
        put(81, "LXXXI");
        put(82, "LXXXII");
        put(83, "LXXXIII");
        put(84, "LXXXIV");
        put(85, "LXXXV");
        put(86, "LXXXVI");
        put(87, "LXXXVII");
        put(88, "LXXXVIII");
        put(89, "LXXXIX");
        put(90, "XC");
        put(91, "XCI");
        put(92, "XCII");
        put(93, "XCIII");
        put(94, "XCIV");
        put(95, "XCV");
        put(96, "XCVI");
        put(97, "XCVII");
        put(98, "XCVIII");
        put(99, "XCIX");
        put(100, "C");
    }};

    // Метод распределяет какой модуль будет обрабатывать выражение: римский или арабский
    public String inputProcessing(String input) {
        // проверяем, начинается ли с цифры, если да, то направляем в stringArabProcessing
        boolean arabInput = false;

        for (int i = 1; i < 11; i++) {
            String j = Integer.toString(i);
            if (input.startsWith(j)) {
                arabInput = true;
                break;
            }
        }
        if (arabInput) {
            return stringArabProcessing(input);
        } else {
            return stringRomeProcessing(input);
        }
    }


    // Обработка арабских цифр
    private String stringArabProcessing(String input) {
        int result = 0;
        String arabResult;
        String inputArabArray[];

        // Обработка Сложения

        if (input.indexOf('+') > 0) {
            inputArabArray = input.split("\\+");
            // если величин в выражении не 2, то выбрасываем исключение
            if (inputArabArray.length != 2) {
                throw new IllegalArgumentException("Некорректно введенны данные");
            }
            int a = Integer.parseInt(inputArabArray[0]);
            int b = Integer.parseInt(inputArabArray[1]);

            // Числа должны быть положительными и меньше 10; если все совпадает, то находим результат
            if (a > 0 && b > 0 && a <= 10 && b <= 10) {
                Values values = new Values(a, b);
                result = MathOperations.add(values);
            } else {
                throw new IllegalArgumentException("Некорректно введенны данные");
            }


            // Обработка операции вычитания

        } else if (input.indexOf('-') > 0) {
            inputArabArray = input.split("-");
            // если величин в выражении не 2, то выбрасываем исключение
            if (inputArabArray.length != 2) {
                throw new IllegalArgumentException("Некорректно введенны данные");
            }
            int a = Integer.parseInt(inputArabArray[0]);
            int b = Integer.parseInt(inputArabArray[1]);

            // Числа должны быть положительными и меньше 10; если все совпадает, то находим результат
            if (a > 0 && b > 0 && a <= 10 && b <= 10) {
                Values values = new Values(a, b);
                result = MathOperations.sub(values);
            } else {
                throw new IllegalArgumentException("Некорректно введенны данные");
            }


            // Обработка операции умножения

        } else if (input.indexOf('*') > 0) {
            inputArabArray = input.split("\\*");
            // если величин в выражении не 2, то выбрасываем исключение
            if (inputArabArray.length != 2) {
                throw new IllegalArgumentException("Некорректно введенны данные");
            }
            int a = Integer.parseInt(inputArabArray[0]);
            int b = Integer.parseInt(inputArabArray[1]);

            // Числа должны быть положительными и меньше 10; если все совпадает, то находим результат
            if (a > 0 && b > 0 && a <= 10 && b <= 10) {
                Values values = new Values(a, b);
                result = MathOperations.mult(values);
            } else {
                throw new IllegalArgumentException("Некорректно введенны данные");
            }


            // Обработка операции деления

        } else if (input.indexOf('/') > 0) {
            inputArabArray = input.split("/");
            // если величин в выражении не 2, то выбрасываем исключение
            if (inputArabArray.length != 2) {
                throw new IllegalArgumentException("Некорректно введенны данные");
            }
            int a = Integer.parseInt(inputArabArray[0]);
            int b = Integer.parseInt(inputArabArray[1]);

            // Числа должны быть положительными и меньше 10; если все совпадает, то находим результат
            if (a > 0 && b > 0 && a <= 10 && b <= 10) {
                Values values = new Values(a, b);
                result = MathOperations.div(values);
            } else {
                throw new IllegalArgumentException("Некорректно введенны данные");
            }

        } else {
            throw new IllegalArgumentException("Некорректно введенны данные");
        }
        return Integer.toString(result);
    }


    // Обработка римских цифр
    private String stringRomeProcessing(String input) {

        String[] inputArray;
        int result;
        String romeResult;


        // Оработка операции сложения

        if (input.indexOf('+') > 0) {
            inputArray = input.split("\\+");
            // если величин в выражении не 2, то выбрасываем исключение
            if (inputArray.length != 2) {
                throw new IllegalArgumentException("Некорректно введенны данные");
            }
            // если в HashMap есть такие величины, то производим операцию
            if (romanNumerals.containsKey(inputArray[0]) &&
                    romanNumerals.containsKey(inputArray[1])) {
                Values values = new Values(romanNumerals.get(inputArray[0]),
                        romanNumerals.get(inputArray[1]));
                result = MathOperations.add(values);
            }
            // если в HashMap таких величин нет, то выбрасываем исключение
            else {
                throw new IllegalArgumentException("Некорректно введенны данные");
            }
        }


        // Обработка операции вычитания

        else if (input.indexOf('-') > 0) {
            inputArray = input.split("-");
            if (inputArray.length != 2) {
                throw new IllegalArgumentException("Некорректно введенны данные");
            }
            // если в HashMap есть такие величины, то производим операцию
            if (romanNumerals.containsKey(inputArray[0]) &&
                    romanNumerals.containsKey(inputArray[1])) {
                Values values = new Values(romanNumerals.get(inputArray[0]),
                        romanNumerals.get(inputArray[1]));
                result = MathOperations.sub(values);
            }
            // если в HashMap таких величин нет, то выбрасываем исключение
            else {
                throw new IllegalArgumentException("Некорректно введенны данные");
            }


            // Обработка операции деления

        } else if (input.indexOf('/') > 0) {
            inputArray = input.split("/");
            if (inputArray.length != 2) {
                throw new IllegalArgumentException("Некорректно введенны данные");
            }
            // если в HashMap есть такие величины, то производим операцию
            if (romanNumerals.containsKey(inputArray[0]) &&
                    romanNumerals.containsKey(inputArray[1])) {
                Values values = new Values(romanNumerals.get(inputArray[0]),
                        romanNumerals.get(inputArray[1]));
                result = MathOperations.div(values);
            }
            // если в HashMap таких величин нет, то выбрасываем исключение
            else {
                throw new IllegalArgumentException("Некорректно введенны данные");
            }


            // Обработка операции умножения

        } else if (input.indexOf('*') > 0) {
            inputArray = input.split("\\*");
            if (inputArray.length != 2) {
                throw new IllegalArgumentException("Некорректно введенны данные");
            }
            // если в HashMap есть такие величины, то производим операцию
            if (romanNumerals.containsKey(inputArray[0]) &&
                    romanNumerals.containsKey(inputArray[1])) {
                Values values = new Values(romanNumerals.get(inputArray[0]),
                        romanNumerals.get(inputArray[1]));
                result = MathOperations.mult(values);
            }
            // если в HashMap таких величин нет, то выбрасываем исключение
            else {
                throw new IllegalArgumentException("Некорректно введенны данные");
            }


            // если нет арифметических символов, то выбрасываем ошибку
        } else {
            throw new IllegalArgumentException("Некорректно введенны данные");
        }


        // Берём полученную переменную int и переводим ее в римские цифры
        romeResult = romanNumeralsResult.get(result);
        if (romeResult == null) {
            throw new IllegalArgumentException("Тут похоже получилось отрицательное число.Но мы его не покажем.");
        }
        return romeResult;
    }

}
