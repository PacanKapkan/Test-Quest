import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = calc(input.toUpperCase());
        System.out.println(result);
    }

    public static String calc(String input) {
        String result;
        if (new Scanner(input).hasNextInt()) {
            result = calcArab(input);
        } else {
            result = calcRome(input);
            if (result == null) throw new ArithmeticException();
        }
        return result;
    }

    public static String calcArab(String input) {
        String[] numbers = input.split(" ");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[2]);
        int result = switch (numbers[1]) {
            case "+" -> a + b;
            case "*" -> a * b;
            case "-" -> a - b;
            case "/" -> a / b;
            default -> throw new ArithmeticException();
        };
        if (numbers.length > 3) {
            throw new ArithmeticException();
        }
        return String.valueOf(result);
    }

    public static String calcRome(String input) {
        String[] numbers = input.split(" ");
        int a = Integer.parseInt(convert(numbers[0]));
        int b = Integer.parseInt(convert(numbers[2]));
        int result = 0;
        switch (numbers[1]) {
            case "+" -> result = a + b;
            case "*" -> result = a * b;
            case "-" -> {
                result = a - b;
                if (result == 0) {
                    throw new ArithmeticException();
                }
            }
            case "/" -> result = a / b;
            default -> throw new ArithmeticException();
        }
        if (numbers.length > 3) {
            throw new ArithmeticException();
        }

        return convert(result);
    }

    public static String convert(int num) {
        CalcData calcData = new CalcData();
        String result = null;
        for (int i = 0; i < calcData.roman.length; i++) {
            if (num == calcData.arab[i]) {
                result = calcData.roman[i];
            }
        }

        return result;
    }


    public static String convert(String num) {
        CalcData calcData = new CalcData();
        int result = 0;
        for (int i = 0; i < calcData.roman.length; i++) {
            if (num.equals(calcData.roman[i])) {
                result = calcData.arab[i];
            }
        }

        return String.valueOf(result);
    }

}