package Customer.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickFood {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Creating a new Restaurant object(user input)
            System.out.println("Enter restaurant name:");
            String restaurantName = scanner.nextLine();

            System.out.println("Enter restaurant location:");
            String restaurantLocation = scanner.nextLine();

            System.out.println("Enter restaurant contact number:");
            String restaurantContactNumber = scanner.nextLine();

            Restaurant restaurant = new Restaurant(restaurantName, restaurantLocation, restaurantContactNumber);

            // Creating a new Customer object (user input)
            System.out.println("Enter order number:");
            int orderNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter customer name:");
            String customerName = scanner.nextLine();

            System.out.println("Enter customer contact number:");
            String customerContactNumber = scanner.nextLine();

            System.out.println("Enter customer address:");
            String customerAddress = scanner.nextLine();

            System.out.println("Enter customer location:");
            String customerLocation = scanner.nextLine();

            System.out.println("Enter customer email address:");
            String customerEmailAddress = scanner.nextLine();

            System.out.println("Enter number of meals:");
            int numberOfMeals = scanner.nextInt();
            scanner.nextLine(); 
            // Initializing two ArrayLists to store meal names and their corresponding prices
            List<String> meals = new ArrayList<>();
            List<Double> mealPrices = new ArrayList<>();
            // Prompting the user to enter the meal name and price for each meal
            // The loop will run 'numberOfMeals' times
            for (int i = 1; i <= numberOfMeals; i++) {
                System.out.println("Enter meal " + i + " name:");
                String mealName = scanner.nextLine();
                meals.add(mealName);
                System.out.println("Enter meal " + i + " price:");
                double mealPrice = scanner.nextDouble();
                // consume the remaining newline character(insures next call to 'scanner.nextLine()' reads user input correctly)
                scanner.nextLine(); 
                mealPrices.add(mealPrice);
            }

            System.out.println("Enter special instructions:");
            String specialInstructions = scanner.nextLine();

            System.out.println("Enter total amount:");
            double totalAmount = scanner.nextDouble();

            Customer customer = new Customer(orderNumber, customerName, customerContactNumber, customerAddress, customerLocation,
                    customerEmailAddress, numberOfMeals, meals, mealPrices, specialInstructions, totalAmount);

            // Read drivers.txt file and find the driver in the correct area with the smallest load (includes where to find the driver.txt)
            try {
                File file = new File("C:\\Users\\takud\\Dropbox\\tk22010002795\\2. Advanced Programming Concepts\\L2T07\\Comp Task2\\src\\Customer\\java\\drivers.txt");
                Scanner fileScanner = new Scanner(file);
                String driverName = "";
                String driverArea = "";
                int driverLoad = Integer.MAX_VALUE;

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] fields = line.split(", ");

                    if (fields.length == 3) {
                        String name = fields[0];
                        String area = fields[1];
                        int load = Integer.parseInt(fields[2]);

                        if (area.equalsIgnoreCase(customer.getLocation()) && load < driverLoad) {
                            driverName = name;
                            driverArea = area;
                            driverLoad = load;
                        }
                    }
                }

                fileScanner.close();

                //if statement for if the driver is found if driver is found, then carry on printing invoice, if not print invoice with message saying no driver available.
                if (!driverName.isEmpty()) {
                    System.out.println("Driver found:");
                    System.out.println("Name: " + driverName);
                    System.out.println("Area: " + driverArea);
                    System.out.println("Load: " + driverLoad);
                    // printing out the invoice
                    try (PrintWriter writer = new PrintWriter("invoice.txt")) {

                        // Print the customer details
                    	writer.println("Order Number: " + customer.getOrderNumber());
                        writer.println("Customer: " + customer.getName());
                        writer.println("Email Address: " + customer.getEmailAddress());
                        writer.println("Contact Number: " + customer.getContactNumber());
                        writer.println("Location: " + customer.getLocation() + "\n");

                        // Print the meal details(prices included)
                        writer.println("You have ordered the following from " + restaurant.getName() + " in " + restaurant.getLocation());
                        for (int i = 0; i < customer.getNumberOfMeals(); i++) {
                            String mealName = customer.getMeals().get(i);
                            double mealPrice = customer.getMealPrices().get(i);
                            writer.println(mealName + ":R" + mealPrice +"\n");
                        }

                        writer.println("Special Instructions: " + customer.getSpecialInstructions()+ "\n");
                        
                        writer.println("Total Amount: " + customer.getTotalAmount() +"\n");

                        // Print the driver details
                        writer.println(driverName + " is the nearest to the restaurant and so he/she will be delivering your order at: \n"  
                        + customer.getAddress() + "\n" );

                        writer.println("If you need to contact the restaurant, their number is " + restaurant.getContactNumber());

                        System.out.println("Invoice saved to invoice.txt");

                    } 
                    
                    catch (FileNotFoundException e) {
                        System.out.println("Failed to save invoice: " + e.getMessage());
                    }
                } else {
                	System.out.println("Sorry no driver is available");
                	try (PrintWriter writer = new PrintWriter("invoice.txt")) {
                        writer.println("Sorry! Our drivers are too far away from you to be able to deliver to your location.");
                    }
                 }
            } catch (FileNotFoundException e) {
                System.out.println("Failed to read drivers file: " + e.getMessage());
              }
        }
    }
}