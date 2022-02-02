import Prog1Tools.IOTools;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Patient {

	private String name = "";
	private String surname = "";
	private String city = "";
	private int plz;
	private String street = "";
	private int house;
	private String age_group;
	private String sex;
	private String diagnose;
	private String bloodgroup;
	
	String[] name_constructor = {"ma", "ser", "nok", "sa", "mi", "dol", "lur", "jen", "fer", "mo", "pas", "kru", "sel", "vat", "mar"};
	String[] sex_constructor = {"Männlich", "Weiblich", "Divers"};
	String[] diagnose_constructor = {"Kann durch Wände sehen", "Kann unsichtbar werden", "Überträgt Gedanken", "Fliegt im Schlaf"};
	String[] bloodgroup_constructor = {"A", "B", "AB", "O"};
	int age, i, index;
	LocalDate birthday, today;
	
	public Patient() {
		
	}
	
	public Patient(String name, String surname, LocalDate birthday, LocalDate today, 
			int age, String age_group, String sex, String diagnose, String city, 
			int plz, String street, int house) {
		
		System.out.println("Full object is created!");
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
		this.today = today;
		this.age_group = age_group;
		this.sex = sex;
		this.diagnose = diagnose;
		this.city = city;
		this.plz = plz;
		this.street = street;
		this.house = house;	
	}
	
	// Name created
	public String Name_value() {
		for (i = 0; i < 3; i++) {
			index = (int)(Math.round(Math.random() * 14));
			name = name + name_constructor[index];
		}
		name = name.substring(0,1).toUpperCase() + name.substring(1);
		return name;
	}
	
	public String getName() {
        return name;
	}
	
	public void setName(String name) {
        this.name = Name_value();
    }
	
	// Surname created
	public String Surname_value() {
		for (i = 0; i < 3; i++) {
			index = (int)(Math.round(Math.random() * 14));
			surname = surname + name_constructor[index];
		}
		surname = surname.substring(0,1).toUpperCase() + surname.substring(1);
		return surname;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = Surname_value();
	}
	
	// Birthday created
	public LocalDate Date_birthday_value() {
	    birthday =  LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 90))));
	    return birthday;
	}
	
	public LocalDate getBirthday() {
		return birthday;
	}
	
	public void setBirthday(LocalDate birthday) {
		this.birthday = Date_birthday_value();
	}
	
	// Age created
	public int Age_value() {
		today = LocalDate.now();
		age = today.getYear() - birthday.getYear();		
		return age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = Age_value();
	}
	
	// Age Group
	public String Age_group_value() {
		if (age < 13) {
			age_group = "Kind";
		} else if (age < 18) {
			age_group = "Jugendliche";
		} else {
			age_group = "Erwachsene";
		}
		return age_group;
	}
	
	public String getAgeGroup() {
		return age_group;
	}
	
	public void setAgeGroup(String age_group) {
		this.age_group = Age_group_value();
	}
	
	// Sex created
	public String Sex_value() {
		index = (int)(Math.round(Math.random() * 2));
		sex = sex_constructor[index];
		return sex;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = Sex_value();
	}
	
	// Bloodgroup created
	public String Bloodgroup_value() {
		index = (int)(Math.round(Math.random() * 3));
		bloodgroup = bloodgroup_constructor[index];
		return bloodgroup;
	}
	
	public String getBloodgroup() {
		return bloodgroup;
	}
	
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = Bloodgroup_value();
	}
	
	// Diagnose created
	public String Diagnose_value() {
		index = (int)(Math.round(Math.random() * 3));
		diagnose = diagnose_constructor[index];
		return diagnose;
	}
	
	public String getDiagnose() {
		return diagnose;
	}	
	
	public void setDiagnose(String diagnose) {
		this.diagnose = Diagnose_value();
	}
	
	// City created
	public String City_value() {
		for (i = 0; i < 2; i++) {
			index = (int)(Math.round(Math.random() * 14));
			city = city + name_constructor[index];
		}
		city = city.substring(0,1).toUpperCase() + city.substring(1) + "stadt";
		return city;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = City_value();
	}
	
	// Street created
	public String Street_value() {
		for (i = 0; i < 2; i++) {
			index = (int)(Math.round(Math.random() * 14));
			street = street + name_constructor[index];
		}
		street = street.substring(0,1).toUpperCase() + street.substring(1) + "straße";
		return street;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = Street_value();
	}
	
	// House created
	public int House_value() {
		house = (int)(Math.round(Math.random() * 100));
		return house;
	}
	
	public int getHouse() {
		return house;
	}
	
	public void setHouse(int house) {
		this.house = House_value();
	}
	
	// PLZ created
	public int PLZ_value() {
		plz = (int)(Math.round(Math.random() * 100 + 59000));
		return plz;
	}
	
	public int getPLZ() {
		return plz;
	}
	
	public void setPLZ(int plz) {
		this.plz = PLZ_value();
	}

}
