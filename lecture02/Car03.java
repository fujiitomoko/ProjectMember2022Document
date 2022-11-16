package lecture02;

public class Car03 {
    int fuel;
    Tire[] tires;
    Engine engine;

    Car03(Tire[] tires, Engine engine) {
        this.fuel = 0;
        this.tires = tires;
        this.engine = engine;
    }

    void run() {
        if(fuel <= 0) {
            System.out.println("燃料が足りないため走れませんでした。");
        }else {
            System.out.println("燃料を1消費して走りました。");
        }
    }

    void startEngine() {
        engine.start();
    }
}
