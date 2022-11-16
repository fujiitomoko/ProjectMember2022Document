package lecture02;

class Exercise2_3 {
    public static void main(String[] args) {
        Tire[] tires = new Tire[4];

        for (int i = 0; i < tires.length; i++) {
            tires[i]=new Tire(65);
        }

//      拡張for文を使った例
//      ただ拡張for文で取得した変数に代入するのは非推奨
//      この場合は上記の添字を使ったほうが適切
//        for (Tire tire : tires) {
//            tire = new Tire(65);
//        }

        Engine engine = new Engine(400);

        Car03 car = new Car03(tires, engine);
        GasStation03.refuel(car);
        car.startEngine();
        car.run();
    }
}
