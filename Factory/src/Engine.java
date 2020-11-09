public class Engine {
    private double engine_volume = 1.6;
    public void start() {
        System.out.println("The engine started.");
    }
    public void stop() {
        System.out.println("The engine stopped.");
    }

    public double getEngine_volume() {
        return engine_volume;
    }

    public void setEngine_volume(double engine_volume) {
        this.engine_volume = engine_volume;
    }
}
