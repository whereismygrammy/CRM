package pl.coderslab.model;


public class Vehicle {
    private int id;
    private int customer_id;
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

    public Vehicle(int customer_id, String model, String brand, String productionYear, String licensePlate, String nextTechnicalInspection) {
        this.customer_id = customer_id;
        this.model = model;
        this.brand = brand;
        this.productionYear = productionYear;
        this.licensePlate = licensePlate;
        this.nextTechnicalInspection = nextTechnicalInspection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
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
