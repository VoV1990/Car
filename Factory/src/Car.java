import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
//Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.

public class Car {
    private String brand;
    private String model;
    private Engine engine;
    private Wheel[]wheels;
    private double fuelConsumption;
    private double carMileage;
    private static double maxFuel_level = 56;
    private double current_fuel_level;
    private double tiresMileage = 0.0;

    public Car(String brand, String model) {
        engine = new Engine();
        wheels = new Wheel[]{new Wheel(), new Wheel(), new Wheel(), new Wheel()};
        this.brand = brand;
        this.model = model;
        this.fuelConsumption = 8.0;
        this.carMileage = 0;
        this.current_fuel_level = maxFuel_level;
    }

    public void move() throws InterruptedException {
        engine.start();
        System.out.println("The car started moving...");
        calculationOfMileage();
        stop();
    }

    private void calculationOfMileage() throws InterruptedException {
        Thread.sleep(1000);
        for (double i = 0.0; i < 700; i+= 0.1) {
            carMileage += 0.1;
            calculationOfFuelConsumption();
            calculatingTireWear();
        }
    }

    private void calculationOfFuelConsumption() {
        current_fuel_level -= (fuelConsumption * 0.1) / 100;
        if(current_fuel_level <= 7) {
            System.out.println("Low fuel level.");
            System.out.println("Going to the gas station...");
            fillUpCar();
        }
    }

    private void calculatingTireWear() {
        tiresMileage += 0.1;
        if (tiresMileage >= wheels[0].getMax_mileage_of_tires()) {
            System.out.println("Tires must be replaced.");
            replacingAllTires();
            tiresMileage = 0.0;
        }
    }

    private void replacingAllTires() {
        wheels = new Wheel[] {new Wheel(), new Wheel(), new Wheel(), new Wheel()};
        System.out.println("All tires replaced.");
    }

    public void replacingSpecificTires() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter the number of the tire you want to replace" +
                "(front left - 1; front right - 2; rear left - 3; rear right - 4)");
        int number_of_tire = Integer.parseInt(reader.readLine()) - 1;
        reader.close();
        wheels[number_of_tire] = new Wheel();
        System.out.println("Tire replaced.");
    }

    public void fillUpCar() {
        if(current_fuel_level < maxFuel_level)
            current_fuel_level = maxFuel_level;
        System.out.println("The car is refueled.");
    }

    public void stop() {
        engine.stop();
        System.out.println("The car stopped.");
    }

    public void printCarBrand() {
        System.out.println("Car brand is: " + brand);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getCarMileage() {
        return carMileage;
    }

    public double getCurrent_fuel_level() {
        return current_fuel_level;
    }

    public static double getMaxFuel_level() {
        return maxFuel_level;
    }

    public static void setMaxFuel_level(double maxFuel_level) {
        Car.maxFuel_level = maxFuel_level;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setCarMileage(double carMileage) {
        this.carMileage = carMileage;
    }

    public void setCurrent_fuel_level(double fuel_level) {
        this.current_fuel_level = fuel_level;
    }

    @Override
    public String toString() {
        return "Car brand: " + brand +
                ", model: " + model +
                ", engine volume: " + engine.getEngine_volume() +
                ", diameter of wheels: " + wheels[0].getDiameter() +
                ", fuelConsumption: " + fuelConsumption +
                ", carMileage: " + carMileage +
                ", current_fuel_level: " + current_fuel_level;
    }
}
