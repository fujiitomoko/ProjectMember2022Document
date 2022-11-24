package lecture03;

public class Vegetable {
    String name;
    int value;

    Vegetable(String name, int value) {
        this.name = name;
        this.value = value;
    }

    void print() {
        System.out.println(this.name + "は" + this.value + "円");
    }
}