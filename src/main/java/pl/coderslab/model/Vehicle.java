package pl.coderslab.model;


public class Vehicle {
    private String model;
    private String brand;
    private String productionYear;
    private String licensePlate;
    private String nextTechnicalInspection;

    public Vehicle() {
    }

    public Vehicle(String model, String brand, String productionYear, String licensePlate, String nextTechnicalInspection) {
        this.model = model;
        this.brand = brand;
        this.productionYear = productionYear;
        this.licensePlate = licensePlate;
        this.nextTechnicalInspection = nextTechnicalInspection;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getNextTechnicalInspection() {
        return nextTechnicalInspection;
    }

    public void setNextTechnicalInspection(String nextTechnicalInspection) {
        this.nextTechnicalInspection = nextTechnicalInspection;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", productionYear=" + productionYear +
                ", licensePlate='" + licensePlate + '\'' +
                ", nextTechnicalInspection=" + nextTechnicalInspection +
                '}';
    }
}
