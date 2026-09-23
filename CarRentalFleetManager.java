import java.util.Scanner;

public class CarRentalFleetManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] carNumber = {"KA01AB1234", "KA02CD5678", "KA03EF9012"};
        String[] carModel = {"Swift", "Creta", "BMW"};
        int[] rentPerDay = {1500, 2500, 5000};
        boolean[] available = {true, true, true};

        System.out.println("================================");
        System.out.println("     CAR RENTAL FLEET MANAGER");
        System.out.println("================================");

        System.out.println("\nAvailable Cars:");

        for (int i = 0; i < carNumber.length; i++) {
            if (available[i]) {
                System.out.println((i + 1) + ". " +
                        carModel[i] + " - " +
                        carNumber[i] +
                        " - Rs." + rentPerDay[i] + "/day");
            }
        }

        System.out.print("\nEnter car number (1-3): ");
        int choice = sc.nextInt();

        if (choice < 1 || choice > 3) {
            System.out.println("Invalid car choice.");
            return;
        }

        int index = choice - 1;

        if (!available[index]) {
            System.out.println("Car is not available.");
            return;
        }

        System.out.print("Enter number of rental days: ");
        int days = sc.nextInt();

        System.out.print("Enter kilometres travelled: ");
        double km = sc.nextDouble();

        System.out.print("Enter fuel charge: Rs.");
        double fuelCharge = sc.nextDouble();

        double kmCharge = km * 5;
        double total = (rentPerDay[index] * days)
                     + kmCharge
                     + fuelCharge;

        available[index] = false;

        System.out.println("\n========== RENTAL BILL ==========");
        System.out.println("Car Model      : " + carModel[index]);
        System.out.println("Car Number     : " + carNumber[index]);
        System.out.println("Rental Days    : " + days);
        System.out.println("Distance       : " + km + " km");
        System.out.println("Rental Charge  : Rs." +
                (rentPerDay[index] * days));
        System.out.println("Distance Charge: Rs." + kmCharge);
        System.out.println("Fuel Charge    : Rs." + fuelCharge);
        System.out.println("---------------------------------");
        System.out.println("Total Amount   : Rs." + total);
        System.out.println("=================================");

        sc.close();
    }
}