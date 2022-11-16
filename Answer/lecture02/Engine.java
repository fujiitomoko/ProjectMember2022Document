package lecture02;

public class Engine {
    int rpm;

    public Engine(int rpm) {
        this.rpm = rpm;
    }

    void start() {
        System.out.println("rpm = " + rpm + "でエンジンを始動させました。");
    }
}
