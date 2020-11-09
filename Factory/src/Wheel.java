public class Wheel {
    private double diameter;
    private double heightOfTireProfile;
    private double treadwear = 400.0;
    private double coefficient_of_wear_of_tires = 4.0;
    double max_mileage_of_tires = (treadwear * 483) / coefficient_of_wear_of_tires;

    public Wheel() {
        this.diameter = 1.5;
        this.heightOfTireProfile = 0.5;
    }

    public Wheel(double diameter, double heightOfTireProfile) {
        this.diameter = diameter;
        this.heightOfTireProfile = heightOfTireProfile;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getHeightOfTireProfile() {
        return heightOfTireProfile;
    }

    public double getMax_mileage_of_tires() {
        return max_mileage_of_tires;
    }

    public void setHeightOfTireProfile(double heightOfTireProfile) {
        this.heightOfTireProfile = heightOfTireProfile;
    }

    public double getTreadwear() {
        return treadwear;
    }

    public void setTreadwear(double treadwear) {
        this.treadwear = treadwear;
    }

    public double getCoefficient_of_wear_of_tires() {
        return coefficient_of_wear_of_tires;
    }

    public void setCoefficient_of_wear_of_tires(double coefficient_of_wear_of_tires) {
        this.coefficient_of_wear_of_tires = coefficient_of_wear_of_tires;
    }
}
