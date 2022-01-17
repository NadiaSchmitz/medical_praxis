import Prog1Tools.IOTools;

public class Patient {

	private String name;
	private String surname;
	private int day_birthday;
	private int month_birthday;
	private int year_birthday;
	private String city;
	private int plz;
	private String street;
	private int house;
	private String age_group;
	private String sex;
	private String[] diagnose;
	private int[] bloodgroup;
	
	private boolean is_parent;
	
	String[] name_constructor = {"ma", "ser", "nok", "sa", "mi", "dol", "lur", "jen", "fer", "mo", "pas", "kru", "sel", "vat", "mar"};
	String birthday;
	String[] sex_constructor = {"Männlich", "Weiblich", "Divers"};
	int i, index, day_today, month_today, year_today, age;
	
	public Patient() {
		
	}
	
	public Patient(String name, String surname, int birthday, int birthmonth, 
			int birthyear, String city, int plz, String street, int house, String age_group, 
			String sex, String[] diagnose) {
		
		System.out.println("Full object is created!");
		this.name = name;
		this.surname = surname;
		this.day_birthday = birthday;
		this.month_birthday = birthmonth;
		this.month_birthday = birthyear;
		this.city = city;
		this.plz = plz;
		this.street = street;
		this.house = house;
		this.age_group = age_group;
		this.sex = sex;
		this.diagnose = diagnose;	
	}
	
	public Patient(String name, String surname, String sex) {
		
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		System.out.println(name + " " + surname + " " + sex);
		
	}
	
	public Patient(String name, String surname, int birthday, int birthmonth, int birthyear) {
		
		this.name = name;
		this.surname = surname;
		this.day_birthday = birthday;
		this.month_birthday = birthmonth;
		this.month_birthday = birthyear;
		
	}
	
	
	public Patient (String name, String surname, boolean rezept) {
		
		this.name = name;
		this.surname = surname;
		
	}
	
	public void Start() {
		day_today = IOTools.readInteger("Geben Sie den Tag: ");
		month_today = IOTools.readInteger("Geben Sie das Monat: ");
		year_today = IOTools.readInteger("Geben Sie das Jahr: ");
	}
	
	public void Name_value() {
		// Name
		for (i = 0; i < 3; i++) {
			index = (int)(Math.round(Math.random() * 14));
			name = name + name_constructor[index];
		}
		name = name.substring(0,1).toUpperCase() + name.substring(1);
		System.out.println(name);
	}
	
	public void Surname_value() {
		// Surname
		for (i = 0; i < 3; i++) {
			index = (int)(Math.round(Math.random() * 14));
			surname = surname + name_constructor[index];
		}
		surname = surname.substring(0,1).toUpperCase() + surname.substring(1);
		System.out.println(surname);
	}
	
	public void Date_birthday_value() {
		// Date - birthday
		day_birthday = (int)(Math.round(Math.random() * 28));
		month_birthday = (int)(Math.round(Math.random() * 12));
		year_birthday = (int)(Math.round(Math.random() * 90 + 1930));
		birthday = day_birthday + "." + month_birthday + "." + year_birthday;
		System.out.println(birthday);
	}
	
	public void City_value() {
		// City
		for (i = 0; i < 2; i++) {
			index = (int)(Math.round(Math.random() * 14));
			city = city + name_constructor[index];
		}
		city = city.substring(0,1).toUpperCase() + city.substring(1) + "stadt";
		System.out.println(city);
	}
	
	public void Street_value() {
		// Street
		for (i = 0; i < 2; i++) {
			index = (int)(Math.round(Math.random() * 14));
			street = street + name_constructor[index];
		}
		street = street.substring(0,1).toUpperCase() + street.substring(1) + "straße";
		System.out.println(street);
	}
	
	public void House_value() {
		// House
		house = (int)(Math.round(Math.random() * 100));
		System.out.println(house);
	}
	
	public void PLZ_value() {
		// PLZ
		plz = (int)(Math.round(Math.random() * 100 + 59000));
		System.out.println(plz);
	}
	
	public void Age_value() {
		// Age
		if ((day_today - day_birthday) >= 0 & (month_today - month_birthday) >= 0) {
			age = year_today - year_birthday;
		} else {
			age = year_today - year_birthday - 1;
		}
	}
	
	public void Age_group() {
		// Age Group
		if (age < 13) {
			age_group = "Kind";
		} else if (age < 18){
			age_group = "Jugendliche";
		} else {
			age_group = "Erwachsene";
		}
	}
	
	public void Sex_value() {
		// Sex
		index = (int)(Math.round(Math.random() * 2));
		sex = sex + sex_constructor[index];
	}
	
	
	
	
}
