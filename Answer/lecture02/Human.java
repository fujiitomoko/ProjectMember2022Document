package lecture02;

public class Human {
    String name;
    int age;

    Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void print() {
        if(age <=18) {
            System.out.println("生徒:" + this.name + " " + this.age + "歳です。");
        }else if(age <= 22) {
            System.out.println("学生:"+ this.name + " " + this.age + "歳です。");
        }
    }
}
