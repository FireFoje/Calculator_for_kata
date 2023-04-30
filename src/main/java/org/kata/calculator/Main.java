package org.kata.calculator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        calc(Arrays.toString(args));
    }

    public static String calc(String input) throws Exception {
        int result;
        String romResult = "";
        String[] romNum = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        System.out.println("Enter your expression(Arab or Rom): ");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine().toUpperCase();
        String[] operands = input.replaceAll(" ", "").split("[*/+-]");
        String[] operators = input.replaceAll(" ", "").split("[0-9, I, II, III, IV, V, VI, VII, VIII, IX, X]+");
        if (input.length() <= 2){
            throw new Exception();
        }
        for (int i = 0; i < operands.length; i++) {
            switch (operands[i]) {
                case "I":
                    operands[i] = String.valueOf(1);
                    break;
                case "II":
                    operands[i] = String.valueOf(2);
                    break;
                case "III":
                    operands[i] = String.valueOf(3);
                    break;
                case "IV":
                    operands[i] = String.valueOf(4);
                    break;
                case "V":
                    operands[i] = String.valueOf(5);
                    break;
                case "VI":
                    operands[i] = String.valueOf(6);
                    break;
                case "VII":
                    operands[i] = String.valueOf(7);
                    break;
                case "VIII":
                    operands[i] = String.valueOf(8);
                    break;
                case "IX":
                    operands[i] = String.valueOf(9);
                    break;
                case "X":
                    operands[i] = String.valueOf(10);
                    break;
            }
        }
        for (int i = 0; i < input.length() + 1; i++) {
            boolean isInteger = isInteger(String.valueOf(input.charAt(0)));
            String inputMax = String.valueOf(input.charAt(operands.length));
            if (isInteger && input.charAt(2) == 'I'
                    || isInteger && input.charAt(2) == 'V'
                    || isInteger && input.charAt(2) == 'X'
                    || isInteger && isInteger(String.valueOf(input.charAt(1))) && input.charAt(operands.length + 1) == 'I'
                    || isInteger && isInteger(String.valueOf(input.charAt(1))) && input.charAt(operands.length + 1) == 'V'
                    || isInteger && isInteger(String.valueOf(input.charAt(1))) && input.charAt(operands.length + 1) == 'X'
                    || input.charAt(0) == 'I' && isInteger(inputMax)
                    || input.charAt(0) == 'V' && isInteger(inputMax)
                    || input.charAt(0) == 'X' && isInteger(inputMax)
                    || operators.length > 2
                    || Integer.parseInt(operands[0]) > 10
                    || Integer.parseInt(operands[1]) > 10
                    || Integer.parseInt(operands[0]) == 0
                    || Integer.parseInt(operands[1]) == 0
                    || operands.length < 2) {
                throw new Exception();
            }
        }

        result = Integer.parseInt(operands[0]);
        for (int i = 1; i < operands.length; i++) {
            switch (operators[i]) {
                case "+":
                    result = Integer.parseInt(operands[0]) + Integer.parseInt(operands[1]);
                    break;
                case "-":
                    result = Integer.parseInt(operands[0]) - Integer.parseInt(operands[1]);
                    break;
                case "*":
                    result = Integer.parseInt(operands[0]) * Integer.parseInt(operands[1]);
                    break;
                case "/":
                    result = Integer.parseInt(operands[0]) / Integer.parseInt(operands[1]);
                    break;
            }


            if (input.charAt(0) == 'I') {
                if (result==0) {
                    throw new Exception();
                } else {
                    System.out.println(romNum[result]);
                }
            } else if (input.charAt(0) == 'I' && input.charAt(1) == 'I') {
                if (result==0) {
                    throw new Exception();
                } else {
                    System.out.println(romNum[result]);
                }
            } else if (result==0) {
                if (Integer.parseInt(operands[0]) <= Integer.parseInt(operands[1])) {
                    throw new Exception();
                } else {
                    System.out.println(romNum[result]);
                }
            } else if (input.charAt(0) == 'I' && input.charAt(1) == 'V') {
                if (result==0) {
                    throw new Exception();
                } else {
                    System.out.println(romNum[result]);
                }
            } else if (input.charAt(0) == 'V') {
                if (result==0) {
                    throw new Exception();
                } else {
                    System.out.println(romNum[result]);
                }
            } else if (input.charAt(0) == 'V' && input.charAt(1) == 'I') {
                if (result==0) {
                    throw new Exception();
                } else {
                    System.out.println(romNum[result]);
                }
            } else if (input.charAt(0) == 'V' && input.charAt(1) == 'I' && input.charAt(2) == 'I') {
                if (result==0) {
                    throw new Exception();
                } else {
                    System.out.println(romNum[result]);
                }
            } else if (input.charAt(0) == 'V' && input.charAt(1) == 'I' && input.charAt(2) == 'I' && input.charAt(3) == 'I') {
                if (result==0) {
                    throw new Exception();
                } else {
                    System.out.println(romNum[result]);
                }
            } else if (input.charAt(0) == 'I' && input.charAt(1) == 'X') {
                if (result==0) {
                    throw new Exception();
                } else {
                    System.out.println(romNum[result]);
                }
            } else if (input.charAt(0) == 'X') {
                if (result==0) {
                    throw new Exception();
                } else {
                    System.out.println(romNum[result]);
                }
            } else {
                System.out.println(result);
            }
        }
        return String.valueOf(result);
    }

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}