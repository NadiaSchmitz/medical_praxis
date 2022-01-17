import Prog1Tools.IOTools;

public class Main {

	public static void main(String[] args) {

		//String name = "", surname = "", city = "", street = "", age_group = "", sex = "";
		//int i, index, day_today, day_birthday, month_today, month_birthday, year_today, year_birthday, house, plz, age;
		
		//Patient patient = new Patient();
		//patient.Name_value();
		//patient.Surname_value();
		//patient.Date_birthday_value();
		//System.out.println();
		
		Patient_list();
		
	}
	
	public static void Patient_list() {
		
		Patient patient = new Patient();
		System.out.println(patient.Name_value());
		
		
	}

}
