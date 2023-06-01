package Customer.java;
//importing the List class used in the code below
import java.util.List;
public class Customer {
//instances variables	
    private int orderNumber;
    private String Name;
    private String contactNumber;
    private String address;
    private String location;
    private String emailAddress;
    private int numberOfMeals;
    private List<String> meals;
    private List<Double> mealPrices;
    private String specialInstructions;
    private double totalAmount;
     // Constructor
    public Customer(int orderNumber, String name, String contactNumber, String address, String location,
            String emailAddress, int numberOfMeals, List<String> meals, List<Double> mealPrices, 
    		String specialInstructions, double totalAmount) {
        // initializing instance variables with values passed to constructor(methods)
        this.orderNumber = orderNumber;
        this.Name = name;
        this.contactNumber = contactNumber;
        this.address = address;
        this.location = location;
        this.emailAddress = emailAddress;
        this.numberOfMeals = numberOfMeals;
        this.meals = meals;
        this.mealPrices = mealPrices;
        this.specialInstructions = specialInstructions;
        this.totalAmount = totalAmount;
    }


	// Getters and Setters/methods
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public int getNumberOfMeals() {
        return numberOfMeals;
    }

    public void setNumberOfMeals(int numberOfMeals) {
        this.numberOfMeals = numberOfMeals;
    }

    public List<String> getMeals() {
        return meals;
    }

    public void setMeals(List<String> meals) {
        this.meals = meals;
    }

    public List<Double> getMealPrices() {
        return mealPrices;
    }

    public void setMealPrices(List<Double> mealPrices) {
        this.mealPrices = mealPrices;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    
    
}

