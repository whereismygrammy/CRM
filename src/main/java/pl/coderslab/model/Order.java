package pl.coderslab.model;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.VehicleDao;

import java.time.LocalDate;


//Data przyjęcia do naprawy
//Planowana data rozpoczęcia naprawy
//Data rozpoczęcia do naprawy

//Przypisany do naprawy pracownik
//Opis problemu
//Opis naprawy

//Status
//Pojazd którego dotyczy naprawa
//Koszt naprawy dla klienta
//Koszt wykorzystanych części
//Koszt roboczogodziny (informacja przepisywana z kosztu roboczogodziny pracownika wykonującego naprawę)
//Ilość roboczogodzin


public class Order {

    private int id;
    private LocalDate dateOfAcceptance;
    private LocalDate dateOfPlanedStart;
    private LocalDate dateOfStart;
    private Employee employee;
    private String problemDescription;
    private String repairDescription;
    private Status status;
    private Vehicle vehicle;
    private double costForClient;
    private double partsCost;
    private double workCost;
    private int numberOfHours;

    public Order() {
    }

    public Order(String dateOfAcceptance, String dateOfPlanedStart, String dateOfStart, int employeeId, String problemDescription, String repairDescription, String status, int vehicleId, double costForClient, double partsCost, int numberOfHours) {
        setDateOfAcceptance(dateOfAcceptance);
        setDateOfPlanedStart(dateOfPlanedStart);
        setDateOfStart(dateOfStart);
        setEmployee(employeeId);
        this.problemDescription = problemDescription;
        this.repairDescription = repairDescription;
        setStatus(status);
        setVehicle(vehicleId);
        this.costForClient = costForClient;
        this.partsCost = partsCost;
        setNumberOfHours(numberOfHours);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateOfAcceptance() {
        return dateOfAcceptance;
    }

    public void setDateOfAcceptance(String dateOfAcceptance) {
        this.dateOfAcceptance = LocalDate.parse(dateOfAcceptance);
    }

    public LocalDate getDateOfPlanedStart() {
        return dateOfPlanedStart;
    }

    public void setDateOfPlanedStart(String dateOfPlanedStart) {
        this.dateOfPlanedStart = LocalDate.parse(dateOfPlanedStart);
    }

    public LocalDate getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(String dateOfStart) {
        this.dateOfStart = LocalDate.parse(dateOfStart);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(int employeeId) {
        this.employee = EmployeeDao.getEmployeeById(employeeId);
        if (numberOfHours != 0) {
            setWorkCost(numberOfHours * employee.getCostPerHour());
        }
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = Status.valueOf(status);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(int vehicleId) {
        this.vehicle = VehicleDao.getVehicleById(vehicleId);
    }

    public double getCostForClient() {
        return costForClient;
    }

    public void setCostForClient(double costForClient) {
        this.costForClient = costForClient;
    }

    public double getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(double partsCost) {
        this.partsCost = partsCost;
    }

    public double getWorkCost() {
        return workCost;
    }

    public void setWorkCost(double workCost) {
        this.workCost = workCost;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
        if (employee != null) {
            setWorkCost(numberOfHours * employee.getCostPerHour());
        }

    }

    @Override
    public String toString() {
        return "Order{" +
                "dateOfAcceptance=" + dateOfAcceptance +
                ", dateOfPlanedStart=" + dateOfPlanedStart +
                ", dateOfStart=" + dateOfStart +
                ", employee=" + employee +
                ", problemDescription='" + problemDescription + '\'' +
                ", repairDescription='" + repairDescription + '\'' +
                ", status=" + status +
                ", vehicle=" + vehicle +
                ", costForClient=" + costForClient +
                ", partsCost=" + partsCost +
                ", workCost=" + workCost +
                ", numberOfHours=" + numberOfHours +
                '}';
    }
}
