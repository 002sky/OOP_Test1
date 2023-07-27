import java.util.ArrayList;

public class ChargingStation {
    private String StationID;
    private int ChargingCapacity;


    public ChargingStation() {
        this("CS0001", 0);
    }

    public ChargingStation(String stationID, int chargingCapacity) {
        StationID = stationID;
        ChargingCapacity = chargingCapacity;
    }

    public String getStationID() {
        return StationID;
    }

    public void setStationID(String stationID) {
        StationID = stationID;
    }

    public int getChargingCapacity() {
        return ChargingCapacity;
    }

    public void setChargingCapacity(int chargingCapacity) {
        ChargingCapacity = chargingCapacity;
    }

    @Override
    public String toString() {
        return "Station ID: " + getStationID() + "\nCharging Capacity: " + getChargingCapacity();
    }

    public ChargingStation selectSection(String ID, ArrayList<ChargingStation> chargingStations){
        ChargingStation[] cs = new ChargingStation[1];
        for (ChargingStation cs1 : chargingStations) {
            if (cs1.getStationID().equals(ID)) {
                cs[0] = cs1;
                return cs[0];
            }
        }
        return null;
    }


}
