package lecture03;

import java.util.Scanner;

class Exercise3_3_1 {
    public static void main(String[] args) {
        System.out.println("1つ目の整数を入力してください:");
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        //改行文字など数字に変換できなかった部分が残っているのでもう一度読み取り
        scanner.next();

        System.out.println("2つ目の整数を入力してください:");
        int number2 = scanner.nextInt();
        scanner.next();

        int sum = number1 + number2;

        System.out.println(number1 + " + " + number2 + " = " + sum);
    }
}
