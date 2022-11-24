package lecture03;

import java.util.ArrayList;

public class Exercise3_4 {
    public static void main(String[] args) {
        ArrayList<Vegetable> price = new ArrayList<>();

        price.add(new Vegetable("にんじん", 117));
        price.add(new Vegetable("たまねぎ", 120));
        price.add(new Vegetable("じゃがいも", 154));

        for (int i = 0;i < price.size(); i++) {
            price.get(i).print();
        }
    }
}
