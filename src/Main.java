import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = calc(input);
        System.out.println(result);
    }

    public static String calc(String input) {
        String result;
        if (new Scanner(input).hasNextInt()){
            result = calcArab(input);
        }else {
            result = calcRome(input);
            if (result == null) throw new ArithmeticException();
        }
        return result;
    }

    public static String calcArab(String input){
        String[] numbers = input.split(" ");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[2]);
        int result = 0;
        for (String word : numbers) {
                if (Objects.equals(word, "+")) {
                    result = a + b;
                } else if (Objects.equals(word, "*")) {
                    result = a * b;
                } else if (Objects.equals(word, "-")) {
                    result = a - b;
                } else if (Objects.equals(word, "/")) {
                    result = a / b;
                }
                if (numbers.length > 3){
                    throw new ArithmeticException();
                }
        }
        return String.valueOf(result);
    }

    public static String calcRome(String input){
        String[] numbers = input.split(" ");
        int a = Integer.parseInt(convert(numbers[0]));
        int b = Integer.parseInt(convert(numbers[2]));
        int result = 0;
        for (String word : numbers) {
            if (Objects.equals(word, "+")) {
                result = a + b;
            } else if (Objects.equals(word, "*")) {
                result = a * b;
            } else if (Objects.equals(word, "-")) {
                    result = a - b;
               if (result == 0){
                   throw new ArithmeticException();
               }
            } else if (Objects.equals(word, "/")) {
                result = a / b;
            }
            if (numbers.length > 3){
                throw new ArithmeticException();
            }
        }
        return convert(result);
    }

    public static String convert(int num) {
        CalcData calcData = new CalcData();
        Map<Integer, String> convertToArab = new HashMap<>();
        String result;
        for (int i = 0; i < calcData.roman.length; i++) {
            convertToArab.put(calcData.arab[i], calcData.roman[i]);
        }
        result = convertToArab.get(num);
        
        return result;
    }


    public static String convert(String num) {
        CalcData calcData = new CalcData();
        Map<String, Integer> convertToRom = new HashMap<>();
        int result;
        for (int i = 0; i < calcData.roman.length; i++) {
            convertToRom.put(calcData.roman[i], calcData.arab[i]);
        }
        result = convertToRom.get(num);

        return String.valueOf(result);
    }

}