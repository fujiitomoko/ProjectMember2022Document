package lecture03;

import java.util.Scanner;

class Exercise3_3_2 {
    public static void main(String[] args) {
        System.out.println("1つ目の整数を入力してください:");
        Scanner scanner = new Scanner(System.in);
        //一行読み取ってから、文字列を整数型に変換
        String num1 = scanner.nextLine();
        int number1 = Integer.parseInt(num1);

        System.out.println("2つ目の整数を入力してください:");
        String num2 = scanner.nextLine();
        int number2 = Integer.parseInt(num2);

        int sum = number1 + number2;

        System.out.println(number1 + " + " + number2 + " = " + sum);
    }
}