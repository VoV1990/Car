import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Car skoda = new Car("Skoda", "Rapid");
        skoda.move();
        skoda.fillUpCar();
        skoda.replacingSpecificTires();
        skoda.printCarBrand();
        System.out.println(skoda);
    }
}
