package lecture06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise6_1 {
    public static void main(String[] args) {
        System.out.println("小数点を入力して下さい。");
        try {
            Scanner scanner = new Scanner(System.in);
            double input = scanner.nextDouble();
            System.out.println("入力した値: " + input);
        }catch (InputMismatchException e) {
            System.out.println("エラー.");
        }
    }
}
