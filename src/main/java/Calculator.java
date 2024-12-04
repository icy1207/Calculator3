import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) {
        int num1;
        int num2;
        int result;
        char oper;
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Вы ввели неправильное количество символов. Используйте формат: 'a + b'");
        }
        try {
            num1 = Integer.parseInt(parts[0]);
            num2 = Integer.parseInt(parts[2]);
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new IllegalArgumentException("Введите числа от 1 до 10.");
            }
            oper = parts[1].charAt(0);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Введены некорректные символы вместо чисел.");
        }
        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Неправильный знак операции. Допустимые операции: +, -, *, /.");
        }
        return num1 + " " + oper + " " + num2 + " = " + result;
    }
}

