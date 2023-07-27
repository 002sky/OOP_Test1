import java.util.ArrayList;

public class CarManufacturer {

    private String ManufacturerID;
    private String ManufacturerName;
    private ArrayList<ElectricCar> ModelsList = new ArrayList<>();

    public CarManufacturer() {
        this("CM0001", "Tesla");
    }

    public CarManufacturer(String manufacturerID, String manufacturerName, ArrayList<ElectricCar> modelsList) {
        ManufacturerID = manufacturerID;
        ManufacturerName = manufacturerName;
        ModelsList = modelsList;
    }

    public CarManufacturer(String manufacturerID, String manufacturerName) {
        ManufacturerID = manufacturerID;
        ManufacturerName = manufacturerName;
    }

    public String getManufacturerID() {
        return ManufacturerID;
    }

    public void setManufacturerID(String manufacturerID) {
        ManufacturerID = manufacturerID;
    }

    public String getManufacturerName() {
        return ManufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        ManufacturerName = manufacturerName;
    }

    public ArrayList<ElectricCar> getModelsList() {
        return ModelsList;
    }

    public void setModelsList(ArrayList<ElectricCar> modelsList) {
        ModelsList = modelsList;
    }

    public void addModel(ElectricCar model) {
        ModelsList.add(model);
    }

    public String displayModels() {
        return "Car Models: " + ModelsList.toString().replaceAll("[\\[\\]]","");
    }

    @Override
    public String toString() {
        return "Manufacturer ID: " + getManufacturerID() + "\nManufacturer Name: " + getManufacturerName() + "\n" + displayModels();
    }
}
