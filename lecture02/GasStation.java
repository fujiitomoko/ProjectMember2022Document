package lecture02;

public class GasStation {
    public static void refuel(Car car) {
        int fuel = 20;
        car.fuel += fuel;
        System.out.println("給油したことにより、fuelが " + fuel + " 増えました。");
    }
}
