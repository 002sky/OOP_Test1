import java.util.ArrayList;

public class Customer {
    private String CustomerID;
    private String Name;
    private ArrayList<ElectricCar> OwnedCars = new ArrayList<>();

    public Customer() {
        this("C0001", "KS");
    }

    public Customer(String customerID, String name, ArrayList<ElectricCar> ownedCars) {
        CustomerID = customerID;
        Name = name;
        OwnedCars = ownedCars;
    }

    public Customer(String customerID, String name) {
        CustomerID = customerID;
        Name = name;
    }


    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<ElectricCar> getOwnedCars() {
        return OwnedCars;
    }

    public void addOwnedCars(ElectricCar ownedCars) {
        OwnedCars.add(ownedCars);
    }

    @Override
    public String toString() {
        return "Customer ID: " + getCustomerID() + "\n" + "Customer Name: " + getName() + "\n" + "Owned Cars: " + displayOwnedCars();
    }

    public String displayOwnedCars() {
        ArrayList<String> OCString = new ArrayList<>();

        this.getOwnedCars().forEach(OC -> {
            if (OC instanceof Tesla) {
                OCString.add(OC.toString());
            } else if (OC instanceof Ora) {
                OCString.add(OC.toString());
            }
        });

        return OCString.toString();
    }

    public String displayCustomer() {
        return "Customer ID: " + getCustomerID() + "\n" + "Customer Name: " + getName();
    }

    public int getIndex(String ID, ArrayList<Customer> CustomersList) {
        int[] index = new int[1];
        for (Customer C : CustomersList) {
            if (C.getCustomerID().equalsIgnoreCase(ID)) {
                index[0] = CustomersList.indexOf(C);
                return index[0];
            }
        }
        return -1;
    }
}


