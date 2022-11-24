package lecture03;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise3_2 {
    public static void main(String[] args) {
        System.out.println("何行分入力しますか？");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt(); scanner.nextLine();

        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < number + 1; i++) {
            System.out.println(i + "行目:");
            String input = scanner.nextLine();
            list.add(input);
        }

        System.out.println("入力した文字列");
        for (String string : list) {
            System.out.println("[" + list.indexOf(string) + "] " + string);
        }
    }

}
