import java.util.Scanner;

public class Calculate {
    public static String calc(String input) {
        String result;
        if (new Scanner(input).hasNextInt()) {
            result = calcArab(input);
        }
        else if(input.length() == 2 && input.contains("!")){ // Пробовал сделать калькулятор факториала, если что, он работает))
            result = String.valueOf(calcF(input));           // Не мешает общему функционалу, просто интерес
        }                                                    // Формат ввода "число+знак" без пробела
        else {
            result = calcRome(input);
            if (result == null) throw new ArithmeticException();
        }

        return result;
    }

    public static String calcArab(String input) {
        String[] numbers = input.split(" ");
        int result = 0;
        if (numbers.length == 3) {
            int a = Integer.parseInt(numbers[0]);
            int b = Integer.parseInt(numbers[2]);
            switch (numbers[1]) {
                case "+" -> result = a + b;
                case "*" -> result = a * b;
                case "-" -> result = a - b;
                case "/" -> result = a / b;
                default -> throw new ArithmeticException();
            }
        }else {
            throw new ArithmeticException();
        }
        return String.valueOf(result);
    }

    public static String calcRome(String input) {
        String[] numbers = input.split(" ");
        int result = 0;
        if (numbers.length == 3) {
            int a = Integer.parseInt(convert(numbers[0]));
            int b = Integer.parseInt(convert(numbers[2]));
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
        }else {
            throw new ArithmeticException();
        }

        return convert(result);
    }

    public static String convert(int num) {
        CalcData calcData = new CalcData();
        String result = null;
        for(int i: calcData.arab){
            if (num == calcData.arab[i]) {
                result = calcData.roman[i];
            }
        }

        return result;
    }


    public static String convert(String num) {
        CalcData calcData = new CalcData();
        int result = 0;
        for (int i: calcData.arab) {
            if (num.equals(calcData.roman[i])) {
                result = calcData.arab[i];
            }
        }

        return String.valueOf(result);
    }

    public static int calcF(String input){
        String[] res = input.split("");
        int a = Integer.parseInt(res[0]);
        var sum = 1;
        for (int i = 1; i < a + 1; i++){
            sum = sum * i;
        }
        return sum;
    }

}
