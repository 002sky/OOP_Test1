import java.util.ArrayList;

public class ElectricCar {
    private String ElectricCarID;
    private String Model;
    private CarManufacturer Manufacturer;

    private ChargingStation  currentChargingStation;

    private int BatteryCapacity;


    public ElectricCar() {
        this("EC0001", "Tesla",new CarManufacturer("CM0001", "Tesla"),10000);
    }

    public ElectricCar(String electricCarID, String model, CarManufacturer manufacturer, ChargingStation currentChargingStation, int batteryCapacity) {
        ElectricCarID = electricCarID;
        Model = model;
        Manufacturer = manufacturer;
        this.currentChargingStation = currentChargingStation;
        BatteryCapacity = batteryCapacity;
    }

    public ElectricCar(String electricCarID, String model, CarManufacturer manufacturer, int batteryCapacity) {
        ElectricCarID = electricCarID;
        Model = model;
        Manufacturer = manufacturer;
        BatteryCapacity = batteryCapacity;
    }

    public String getElectricCarID() {
        return ElectricCarID;
    }

    public void setElectricCarID(String electricCarID) {
        ElectricCarID = electricCarID;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public ChargingStation getCurrentChargingStation() {
        return currentChargingStation;
    }

    public void setCurrentChargingStation(ChargingStation currentChargingStation) {
        this.currentChargingStation = currentChargingStation;
    }

    public CarManufacturer getManufacturer() {
        return Manufacturer;
    }

    public int getBatteryCapacity() {
        return BatteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        BatteryCapacity = batteryCapacity;
    }

    public String displayChargingStation(){
       return   getCurrentChargingStation() != null ?  "\nCharging Station: " + getCurrentChargingStation().toString() + "with capacity: " + getCurrentChargingStation().getChargingCapacity() + " kWh: " : "";
    }


    @Override
    public String toString() {
        return "\nElectricCar ID: " + getElectricCarID() +
                "\n" + "Model: " + getModel() +
                "\n" + "Manufacturer: " + getManufacturer().getManufacturerName() +
                "\n" + "Battery Capacity: " + getBatteryCapacity() +"kWh"
                + displayChargingStation() ;
    }

    public int selectElectricCar(String ID, ArrayList<ElectricCar> electricCars){
        int[] ec = new int[1];
        for (ElectricCar ec1 : electricCars) {
            if (ec1.getElectricCarID().equals(ID)) {
                ec[0] = electricCars.indexOf(ec1);
                return ec[0];
            }
        }
        return -1;
    }


}
