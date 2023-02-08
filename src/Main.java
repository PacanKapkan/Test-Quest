import java.util.*;

public class Main extends Calculate{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = calc(input.toUpperCase());
        System.out.println(result);
    }
}