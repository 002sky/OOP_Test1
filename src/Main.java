import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CarManufacturer CMTesla = new CarManufacturer("CM0001", "Tesla");
        CarManufacturer CMBMW = new CarManufacturer("CM0002", "BMW");
        ArrayList<CarManufacturer> ManufacturersList = new ArrayList<>();
        ManufacturersList.add(CMTesla);
        ManufacturersList.add(CMBMW);

        ElectricCar Model_S = new Tesla("ECT0001", "Model S", CMTesla, 10000, true, false, true);
        ElectricCar Model_Y = new Tesla("ECT0002", "Model Y", CMTesla, 20000, true, true, true);

        CMTesla.addModel(Model_S);
        CMTesla.addModel(Model_Y);

        ElectricCar BMW_M = new Ora("ECB001", "BMW M5", CMBMW, 10000, true, true);
        ElectricCar BMW_K = new Ora("ECB002", "BMW K5", CMBMW, 20000, true, true);
        CMBMW.addModel(BMW_M);
        CMBMW.addModel(BMW_K);


        ChargingStation CS1 = new ChargingStation("CS0001", "Aeon Tebrau",100);
        ChargingStation CS2 = new ChargingStation("CS0002","Sutera Mall", 200);
        ChargingStation CS3 = new ChargingStation("CS0003", "Aeon Dato Onn",300);

        ArrayList<ChargingStation> ChargingStationsList = new ArrayList<>();
        ChargingStationsList.add(CS1);
        ChargingStationsList.add(CS2);
        ChargingStationsList.add(CS3);

        Scanner scanner = new Scanner(System.in);

        Customer customer = new Customer("C0001", "Kang Sheng");
        Customer customer2 = new Customer("C0002", "Lily Anderson");

        ArrayList<Customer> CustomersList = new ArrayList<>();
        CustomersList.add(customer);
        CustomersList.add(customer2);


        while (true) {
            int[] index = new int[1];
            String ID;
            CustomersList.forEach(C -> {
                System.out.println(C.displayCustomer());

            });
            System.out.println("Enter your customer ID : (Enter EXIT to close system) ");
            ID = scanner.nextLine();

            if(ID.equalsIgnoreCase("EXIT")) {
                break;
            }

            while (customer2.getIndex(ID, CustomersList) == -1) {
                System.out.println("Customer ID not found");
                System.out.println("Enter your customer ID : ");
                ID = scanner.nextLine();
            }

            index[0] = customer2.getIndex(ID, CustomersList);

            boolean innerLoop = true;
            while (innerLoop) {

                System.out.println("Choose an option: ");
                System.out.println("1 - View Manufacturers and available models");
                System.out.println("2 - Purchase a car");
                System.out.println("3 - View and Update your cars charging Status");
                System.out.println("4 - view your Owned Cars");
                System.out.println("5 - Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        ManufacturersList.forEach(M -> {
                            System.out.println(M.toString());
                        });
                        break;
                    case 2:
                        ManufacturersList.forEach(M -> {
                            System.out.println(M.toString());
                        });

                        System.out.println("Choose a model you want to purchase: ");
                        String model = scanner.nextLine();

                        ManufacturersList.forEach(M -> {
                            M.getModelsList().forEach(E -> {
                                if (E.getModel().equalsIgnoreCase(model)) {
                                    CustomersList.get(index[0]).addOwnedCars(E);
                                }
                            });
                        });

                        break;

                    case 3:
                        if (CustomersList.get(index[0]).getOwnedCars().isEmpty()) {
                            System.out.println("You have no cars");
                        } else {
                            CustomersList.get(index[0]).getOwnedCars().forEach(E -> {
                                if (E.getCurrentChargingStation() == null) {
                                    System.out.println(E.getElectricCarID() + " " + E.getModel() + " is not charging");
                                } else {
                                    System.out.println(E.getElectricCarID() + " " + E.getModel() + " is charging at " + E.getCurrentChargingStation().getStationID() + " With a capacity of " + E.getCurrentChargingStation().getChargingCapacity() + "KWH");
                                }
                            });

                            System.out.println("Available Charging Stations: ");
                            ChargingStationsList.forEach(CS -> {
                                System.out.println(CS.toString());
                            });

                            System.out.println("Choose the Car you want to update by enter the Car ID: ");
                            String carID = scanner.nextLine();

                            if (carID.equalsIgnoreCase("Exit")) {
                                break;
                            }

                            System.out.println("Choose the Charging Station by enter the Station ID: ");
                            String stationID = scanner.nextLine();

                            while (CustomersList.get(index[0]).getOwnedCars().get(0).selectElectricCar(carID, CustomersList.get(index[0]).getOwnedCars()) == -1 || ChargingStationsList.get(0).selectSection(stationID, ChargingStationsList) == null) {
                                if (CustomersList.get(index[0]).getOwnedCars().get(0).selectElectricCar(carID, CustomersList.get(index[0]).getOwnedCars()) == -1) {
                                    System.out.println("Car ID not found");
                                    System.out.println("Choose the Car you want to update: ");
                                    carID = scanner.nextLine();
                                }
                                if (ChargingStationsList.get(0).selectSection(stationID, ChargingStationsList) == null) {
                                    System.out.println("Station ID not found");
                                    System.out.println("Choose the Charging Station: ");
                                    stationID = scanner.nextLine();
                                }
                            }

                            int carIndex = CustomersList.get(index[0]).getOwnedCars().get(0).selectElectricCar(carID, CustomersList.get(index[0]).getOwnedCars());
                            ChargingStation stationIndex = ChargingStationsList.get(0).selectSection(stationID, ChargingStationsList);
                            CustomersList.get(index[0]).getOwnedCars().get(carIndex).setCurrentChargingStation(stationIndex);

                            break;

                        }
                        break;

                    case 4:
                        System.out.println(CustomersList.get(index[0]).toString());
                        break;
                    case 5:
                        innerLoop = false;
                        break;
                }
            }
        }



    }

}