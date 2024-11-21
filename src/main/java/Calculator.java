import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        System.out.println(calc(input));
    }

    public static boolean checkArabian(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String calc(String input) {
        int num1;
        int num2;
        int result;
        char oper;

        String[] parts = input.split(" ");
        if (parts.length != 3) {
            return "Вы ввели не правильное количество символов";
        }
        try {
            boolean isArabic1 = checkArabian(parts[0]);
            boolean isArabic2 = checkArabian(parts[2]);
            if (isArabic1 && isArabic2) {
                num1 = Integer.parseInt(parts[0]);
                num2 = Integer.parseInt(parts[2]);
                if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                    return "Введите числа от 1 до 10";
                }
            } else if (!isArabic1 && !isArabic2) {
                num1 = RomanToArabic(parts[0]);
                num2 = RomanToArabic(parts[2]);
                if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                    return "Введите числа от 1 до 10";
                }
            } else {
                return "Нельзя вводить арабское и римское числа";
            }
            oper = parts[1].charAt(0);
        } catch (NumberFormatException e) {
            return "Введён некорректный символ";
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
                return "Неправильный знак";
        }
        if (checkArabian(parts[0]) && checkArabian(parts[2])) {
            return num1 + " " + oper + " " + num2 + " = " + result;
        } else {
            return ArabicToRoman(result);
        }
    }

    public static String ArabicToRoman(int arabNum) {
        switch (arabNum) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
            default:
                throw new IllegalArgumentException("Римское число должно быть от 1 до 10");

        }
    }

    public static int RomanToArabic(String roman) {
        switch (roman) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                throw new IllegalArgumentException("Некорректное римское число");
        }
    }
}





