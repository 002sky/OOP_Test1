public class Ora extends ElectricCar {

    private boolean hasPanaromicSunroof;
    private boolean hasWirelessCharging;


    public Ora() {
        this("ECO0002", "Ora Car", new CarManufacturer("CMO0001", "Ora"),10000, false, false);
    }


    public Ora(String electricCarID, String model, CarManufacturer manufacturer, ChargingStation currentChargingStation, int batteryCapacity, boolean hasPanaromicSunroof, boolean hasWirelessCharging) {
        super(electricCarID, model, manufacturer, currentChargingStation, batteryCapacity);
        this.hasPanaromicSunroof = hasPanaromicSunroof;
        this.hasWirelessCharging = hasWirelessCharging;
    }

    public Ora(String electricCarID, String model, CarManufacturer manufacturer, int batteryCapacity, boolean hasPanaromicSunroof, boolean hasWirelessCharging) {
        super(electricCarID, model, manufacturer, batteryCapacity);
        this.hasPanaromicSunroof = hasPanaromicSunroof;
        this.hasWirelessCharging = hasWirelessCharging;
    }

    public boolean isHasPanaromicSunroof() {
        return hasPanaromicSunroof;
    }

    public void setHasPanaromicSunroof(boolean hasPanaromicSunroof) {
        this.hasPanaromicSunroof = hasPanaromicSunroof;
    }

    public boolean isHasWirelessCharging() {
        return hasWirelessCharging;
    }

    public void setHasWirelessCharging(boolean hasWirelessCharging) {
        this.hasWirelessCharging = hasWirelessCharging;
    }

    @Override
    public String toString() {
        return super.toString() + "\nhasPanaromicSunroof: " + hasPanaromicSunroof + "\nhasWirelessCharging: " + hasWirelessCharging + "\n";
    }
}
