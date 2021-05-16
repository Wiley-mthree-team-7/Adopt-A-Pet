

/**
 * @author AnannaBhattacharya
 *
 */
public class User {
    protected String name;
    protected String location;
    protected int age;
    protected long phNo;
    protected double salary;
    protected String username;
    protected String password;

    //parameterized constructor for setting up of user fields
    public User(String name, String location, int age, long phNo, double salary, String username, String password) {
        this.name = name;
        this.location = location;
        this.age = age;
        this.phNo = phNo;
        this.salary = salary;
        this.username = username;
        this.password = password;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhNo() {
        return phNo;
    }

    public void setPhNo(long phNo) {
        this.phNo = phNo;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	
        

    //method which displays user's profile
    public void viewProfile() {
	System.out.println("---USER PROFILE DETAILS---");
    	System.out.printf("Name : %s\nAge : %d\nLocation : %s\nPhone Number : %d\nSalary : %.2f\n", getName(),getAge(),getLocation(),getPhNo(),getSalary());
    }
    
	/*public void transactionDetails() {
		
	}
	
	public void showCart() {
		
	}*/
	
}
