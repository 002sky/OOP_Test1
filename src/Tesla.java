public class Tesla extends ElectricCar {

    private boolean isAutoPilotEnabled;
    private boolean isFullSelfDrivingEnabled;
    private boolean isTeslaTheatreEnabled;


    public Tesla() {
        this("ECT0001", "Tesla",new CarManufacturer("CM0001", "Tesla") , 10000, false, false, false);
    }

    public Tesla(String electricCarID, String model, CarManufacturer manufacturer, ChargingStation currentChargingStation, int batteryCapacity, boolean isAutoPilotEnabled, boolean isFullSelfDrivingEnabled, boolean isTeslaTheatreEnabled) {
        super(electricCarID, model, manufacturer, currentChargingStation, batteryCapacity);
        this.isAutoPilotEnabled = isAutoPilotEnabled;
        this.isFullSelfDrivingEnabled = isFullSelfDrivingEnabled;
        this.isTeslaTheatreEnabled = isTeslaTheatreEnabled;
    }

    public Tesla(String electricCarID, String model, CarManufacturer manufacturer, int batteryCapacity, boolean isAutoPilotEnabled, boolean isFullSelfDrivingEnabled, boolean isTeslaTheatreEnabled) {
        super(electricCarID, model, manufacturer, batteryCapacity);
        this.isAutoPilotEnabled = isAutoPilotEnabled;
        this.isFullSelfDrivingEnabled = isFullSelfDrivingEnabled;
        this.isTeslaTheatreEnabled = isTeslaTheatreEnabled;
    }

    public boolean isAutoPilotEnabled() {
        return isAutoPilotEnabled;
    }

    public void setAutoPilotEnabled(boolean autoPilotEnabled) {
        isAutoPilotEnabled = autoPilotEnabled;
    }

    public boolean isFullSelfDrivingEnabled() {
        return isFullSelfDrivingEnabled;
    }

    public void setFullSelfDrivingEnabled(boolean fullSelfDrivingEnabled) {
        isFullSelfDrivingEnabled = fullSelfDrivingEnabled;
    }

    public boolean isTeslaTheatreEnabled() {
        return isTeslaTheatreEnabled;
    }

    public void setTeslaTheatreEnabled(boolean teslaTheatreEnabled) {
        isTeslaTheatreEnabled = teslaTheatreEnabled;
    }

    @Override
    public String toString() {
        return super.toString() + "\nisAutoPilotEnabled: " + isAutoPilotEnabled + " \nisFullSelfDrivingEnabled: " + isFullSelfDrivingEnabled + " \nisTeslaTheatreEnabled: " + isTeslaTheatreEnabled + "\n";
    }
}
