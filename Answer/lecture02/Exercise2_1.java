package lecture02;

public class Exercise2_1 {
    public static void main(String[] args) {
        Human human = new Human("たかし", 18);
        human.print();

        Human human1 = new Human("ひろし", 20);
        human1.print();

        print(human);
    }

    static void print(Human human){
        System.out.println(human.name);
    }
}
