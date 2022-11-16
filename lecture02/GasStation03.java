package lecture02;

public class GasStation03 {

    public static void refuel(Car03 car) {
        int fuel = 20;
        car.fuel += fuel;
        System.out.println("給油したことにより、fuelが " + fuel + " 増えました。");
    }
}
