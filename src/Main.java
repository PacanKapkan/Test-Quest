import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("Введите пример формата :число + число:");
            System.out.println();
            input = scanner.nextLine();
            String result = calc(input);
            System.out.println(result);
            // Для выхода можно просто указать любое число
        }
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
        int a = Integer.parseInt(convertToArab(numbers[0]));
        int b = Integer.parseInt(convertToArab(numbers[2]));
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
        return convertToRom(result);
    }

    public static String convertToRom(int num) {
        Map<Integer, String> convertToArab = new HashMap<>();

        int[] arab = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
                27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52,
                53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78,
                79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100,};


        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII",
                "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV",
                "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII",
                "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI",
                "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII",
                "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV",
                "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI",
                "XCVII", "XCVIII", "XCIX", "C",};
        String result = null;
        for (int i = 0; i < roman.length; i++) {
            convertToArab.put(arab[i], roman[i]);
        }
        result = convertToArab.get(num);
        
        return result;
    }


    public static String convertToArab(String num) {
        Map<String, Integer> convertToRom = new HashMap<>();

        int[] arab = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
                27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52,
                53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78,
                79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100,};


        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII",
                "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV",
                "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII",
                "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI",
                "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII",
                "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV",
                "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI",
                "XCVII", "XCVIII", "XCIX", "C",};
        int result;
        for (int i = 0; i < roman.length; i++) {
            convertToRom.put(roman[i], arab[i]);
        }
        result = convertToRom.get(num);

        return String.valueOf(result);
    }
}