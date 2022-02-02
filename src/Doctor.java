import Prog1Tools.IOTools;

public class Doctor {
	
	private String name;
	private String surname;
	private String title;
	private String area;
	
	public Doctor() {
		
	}
	
	public Doctor(String name, String surname, String title, String area) {
		this.name = name;
		this.surname = surname;
		this.title = title;
		this.area = area;
	}
	
	public Doctor(String name, String surname, String title) {
		this.name = name;
		this.surname = surname;
		this.title = title;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
}
