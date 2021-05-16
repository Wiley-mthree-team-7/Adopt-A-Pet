
/**
 * @author HP
 *
 */
public class User {
	protected String name;
    protected String location;
    protected int age;
    protected long phNo;
    protected double salary;
	/**
	 * @param name
	 * @param location
	 * @param age
	 * @param phNo
	 * @param salary
	 */
	public User(String name, String location, int age, long phNo, double salary) {
		this.name = name;
		this.location = location;
		this.age = age;
		this.phNo = phNo;
		this.salary = salary;
	}
	
	
    /**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}


	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}


	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}


	/**
	 * @return the phNo
	 */
	public long getPhNo() {
		return phNo;
	}


	/**
	 * @param phNo the phNo to set
	 */
	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}


	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}


	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}


	public void viewProfile() {
		System.out.println("---USER PROFILE DETAILS---");
    	System.out.printf("Name : %s\nAge : %d\nLocation : %s\nPhone Number : %d\nSalary : %.2f\n", getName(),getAge(),getLocation(),getPhNo(),getSalary());
    }
    
	/*public void transactionDetails() {
		
	}
	
	public void showCart() {
		
	}*/
	
}
