import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = calcArab(input.toUpperCase());
        System.out.println(result);

    }
    public static String calcArab(String input) {
        String[] numbers = input.split(" ");
        int result;
        if (numbers.length == 3){
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[2]);
        if ((a > 1 && b > 1) && (a <= 10 && b <= 10)) {
            switch (numbers[1]) {
                case "+" -> result = a + b;
                case "*" -> result = a * b;
                case "-" -> result = a - b;
                case "/" -> result = a / b;
                default -> throw new ArithmeticException();
            }
        }else {
            throw new ArithmeticException();}
        }else {
            throw new IndexOutOfBoundsException();}
        return String.valueOf(result);
    }
}