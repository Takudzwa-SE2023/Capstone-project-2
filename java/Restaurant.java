package Customer.java;

public class Restaurant {
	private String name;
	private String location;
	private String contactNumber;
	
	//constructor
	public Restaurant(String name, String location, String contactNumber) {
		this.name = name;
		this.location = location;
		this.contactNumber = contactNumber;
	}
	
	// Getters and Setters

    // Getter for the restaurant name
    public String getName() {
        return name;
    }

    // Setter for the restaurant name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the restaurant location
    public String getLocation() {
        return location;
    }

    // Setter for the restaurant location
    public void setLocation(String location) {
        this.location = location;
    }

    // Getter for the restaurant contact number
    public String getContactNumber() {
        return contactNumber;
    }

    // Setter for the restaurant contact number
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
}
