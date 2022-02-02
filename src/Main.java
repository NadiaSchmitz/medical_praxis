import Prog1Tools.IOTools;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		int i, age = 0, house = 0, plz = 0, topic, subtopic, subtopic_1, subtopic_2;
		String name = "", surname = "", age_group = "", sex = "", bloodgroup = "", diagnose = "", city = "", street = "";
		LocalDate birthday = null;		
		Patient[] patients = new Patient [20];
		
		// Patients created
		for (i = 0; i < patients.length; i++) {
			patients[i] = new Patient();
			patients[i].setName(name);
			patients[i].setSurname(surname);
			patients[i].setBirthday(birthday);
			patients[i].setAge(age);
			patients[i].setAgeGroup(age_group);
			patients[i].setSex(sex);
			patients[i].setBloodgroup(bloodgroup);
			patients[i].setDiagnose(diagnose);
			patients[i].setCity(city);
			patients[i].setStreet(street);
			patients[i].setHouse(house);
			patients[i].setPLZ(plz);
		}
		
		// Doctors created
		Doctor sai = new Doctor("Mir", "Sai", "Magischer Arzt", "Gedankenanalyse");
		Doctor loi = new Doctor("Gal", "Loi", "Supermagischer Arzt", "Traumanalyse");
		Doctor zed = new Doctor("Lim", "Zed", "Auszubildender");
		
		// User interface, Topic,  Report		
		System.out.println("Wilkommen zur magischen Praxis. Wir stellen Ihnen alle Informationen zur Verfügung. Lassen uns anfangen!");
		System.out.println("Themen:");
		System.out.println("1 - Liste der Patienten");
		System.out.println("2 - Liste der Ärzte");
		System.out.println("3 - Liste der Patienten, die alter, als _ sind.");
		System.out.println("4 - Liste der Patienten, die junge, als _ sind.");
		System.out.println("5 - Liste der Patienten, die zwischen Jahr _ und Jahr _ geboren wurden.");
		System.out.println("6 - Liste der Patienten von Geschlecht _.");
		System.out.println("7 - Liste der Patienten aus Altersgruppe _.");
		System.out.println("8 - Liste der Patienten mit Blutgruppe _.");
		System.out.println("9 - Liste der Patienten mit Diagnose _.");
		System.out.println("10 - Liste der Patienten, die vom Arzt _ betreut werden.");
		System.out.println();
		topic = IOTools.readInteger("Wahlen Sie bitte, wofür Sie sich interesieren? ");
		subtopic = 0;
		subtopic_1 = 0;
		subtopic_2 = 0;
 
		// Topic
		if (topic == 3) {
			subtopic = IOTools.readInteger("Geben Sie der Alter ein: ");
		} else if (topic == 4) {
			subtopic = IOTools.readInteger("Geben Sie der Alter ein: ");
		} else if (topic == 5) {
			subtopic_1 = IOTools.readInteger("Geben Sie das erste Jahr im Format JJJJ ein: ");
			subtopic_2 = IOTools.readInteger("Geben Sie das letzte Jahr im Format JJJJ ein: ");
		} else if (topic == 6) {
			System.out.println("1 - Weiblich");
			System.out.println("2 - Männlich");
			System.out.println("3 - Divers");
			subtopic = IOTools.readInteger("Geben Sie das Geschlecht ein: ");
		} else if (topic == 7) {
			System.out.println("1 - Kinder");
			System.out.println("2 - Jugendliche");
			System.out.println("3 - Erwachsene");
			subtopic = IOTools.readInteger("Geben Sie die Altersgruppe ein: ");
		} else if (topic == 8) {
			System.out.println("1 - A");
			System.out.println("2 - B");
			System.out.println("3 - AB");
			System.out.println("4 - O");
			subtopic = IOTools.readInteger("Geben Sie die Blutgruppe ein: ");
		} else if (topic == 9) {
			System.out.println("1 - Kann durch Wände sehen");
			System.out.println("2 - Kann unsichtbar werden");
			System.out.println("3 - Überträgt Gedanken");
			System.out.println("4 - Fliegt im Schlaf");
			subtopic = IOTools.readInteger("Geben Sie die Diagnose ein: ");
		} else if (topic == 10) {
			System.out.println("1 - Mir Sai");
			System.out.println("2 - Gal Loi");
			System.out.println("3 - Lim Zed");
			subtopic = IOTools.readInteger("Geben Sie der Nade des Artztes ein: ");
		} else {
			System.out.println("Falsche Eingabe.");
		}
		
		// Report
		if (topic == 1) {
			Patient_list_full_report(patients);
		} else if (topic == 2) {
			Doctor_list_full_report(sai, loi, zed);
		} else if (topic == 3) {
			Report_age_old(patients, subtopic);
		} else if (topic == 4) {
			Report_age_young(patients, subtopic);
		} else if (topic == 5) {
			Report_year(patients, subtopic_1, subtopic_2);
		} else if (topic == 6) {
			Report_sex(patients, subtopic);
		} else if (topic == 7) {
			Report_age_group(patients, subtopic);
		} else if (topic == 8) {
			Report_Bloodgroup(patients, subtopic);
		} else if (topic == 9) {
			Report_Diagnose(patients, subtopic);
		} else if (topic == 10) {
			Report_Doctors(patients, subtopic, sai, loi, zed);
		}
		
		// Report print
		Patient_list_full_report(patients);
		
	}
	
	// Patients full Report
	public static void Patient_list_full_report(Patient[] patients) {
				
		int i;
		LocalDate today;
		today = LocalDate.now();
		
		System.out.println();
		System.out.println("***Liste der Patienten ");
		System.out.println();
		System.out.printf("Datum: %1$td.%1$tm.%1$ty      ", today);
		System.out.printf("Anzahl der Patienten: " + patients.length);
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf(String.format("| %-10s| %-10s| %-14s| %-7s| %-8s | %-10s | %-10s | %-23s | %-11s | %-14s | %-10s | %-6s |", "Vorname", "Nachname", "Geburtsdatum", "Alter", "Altersgruppe", "Geschlecht", "Blutgruppe", "Diagnose", "Stadt", "Straße", "Hausnummer", "PLZ"));
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		for (i = 0; i < patients.length; i++) {
			System.out.printf(String.format("| %-10s", patients[i].getName()));
			System.out.printf(String.format("| %-10s", patients[i].getSurname()));
			System.out.printf(String.format("|   %1$td.%1$tm.%1$ty    ", patients[i].getBirthday()));
			System.out.printf(String.format("| %-7s", patients[i].getAge()));
			System.out.printf(String.format("| %-13s", patients[i].getAgeGroup()));
			System.out.printf(String.format("| %-11s", patients[i].getSex()));
			System.out.printf(String.format("| %-11s", patients[i].getBloodgroup()));
			System.out.printf(String.format("| %-24s", patients[i].getDiagnose()));
			System.out.printf(String.format("| %-12s", patients[i].getCity()));
			System.out.printf(String.format("| %-15s", patients[i].getStreet()));
			System.out.printf(String.format("| %-11s", patients[i].getHouse()));
			System.out.printf(String.format("| %-6s |", patients[i].getPLZ()));
			System.out.println();
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	// Doctors full report
	public static void Doctor_list_full_report(Doctor doctor_1, Doctor doctor_2, Doctor doctor_3) {
		
		LocalDate today;
		today = LocalDate.now();
		
		System.out.println();
		System.out.println("***Liste der Ärzte.");
		System.out.println();
		System.out.printf("Datum: %1$td.%1$tm.%1$ty      ", today);
		System.out.println();
		System.out.println("--------------------------------------------------------------");
		System.out.printf(String.format("| %-8s| %-9s| %-20s| %-16s|", "Vorname", "Nachname", "Titel", "Fachgebiet"));
		System.out.println();
		System.out.println("--------------------------------------------------------------");
		
		System.out.printf(String.format("| %-8s", doctor_1.getName()));
		System.out.printf(String.format("| %-9s", doctor_1.getSurname()));
		System.out.printf(String.format("| %-20s", doctor_1.getTitle()));
		System.out.printf(String.format("| %-16s|", doctor_1.getArea()));
		System.out.println();
		System.out.printf(String.format("| %-8s", doctor_2.getName()));
		System.out.printf(String.format("| %-9s", doctor_2.getSurname()));
		System.out.printf(String.format("| %-20s", doctor_2.getTitle()));
		System.out.printf(String.format("| %-16s|", doctor_2.getArea()));
		System.out.println();
		System.out.printf(String.format("| %-8s", doctor_3.getName()));
		System.out.printf(String.format("| %-9s", doctor_3.getSurname()));
		System.out.printf(String.format("| %-20s", doctor_3.getTitle()));
		System.out.printf(String.format("| %-16s|", doctor_3.getArea()));
		
		System.out.println();
		System.out.println("--------------------------------------------------------------");
	}
	
	// Age report
	public static void Report_age_old(Patient[] patients, int a) {
		
		int i;
		LocalDate today;
		today = LocalDate.now();
		
		System.out.println();
		System.out.println("***Liste der Patienten, die älter als " + a + " Jahre alt sind.");
		System.out.println();
		System.out.printf("Datum: %1$td.%1$tm.%1$ty      ", today);
		System.out.println();
		System.out.println("---------------------------------");
		System.out.printf(String.format("| %-10s| %-10s| %-6s|", "Vorname", "Nachname", "Alter"));
		System.out.println();
		System.out.println("---------------------------------");
		
		for (i = 0; i < patients.length; i++) {
			if (patients[i].getAge() > a) {
				System.out.printf(String.format("| %-10s", patients[i].getName()));
				System.out.printf(String.format("| %-10s", patients[i].getSurname()));
				System.out.printf(String.format("| %-5s |", patients[i].getAge()));
				System.out.println();
			}
		}
		System.out.println("---------------------------------");
		
	}
	
	// Age report
	public static void Report_age_young(Patient[] patients, int a) {
			
		int i;
		LocalDate today;
		today = LocalDate.now();
		
		System.out.println();
		System.out.println("***Liste der Patienten, die junger als " + a + " Jahre alt sind.");
		System.out.println();
		System.out.printf("Datum: %1$td.%1$tm.%1$ty      ", today);
		System.out.println();
		System.out.println("---------------------------------");
		System.out.printf(String.format("| %-10s| %-10s| %-6s|", "Vorname", "Nachname", "Alter"));
		System.out.println();
		System.out.println("---------------------------------");
		
		for (i = 0; i < patients.length; i++) {
			if (patients[i].getAge() < a) {
				System.out.printf(String.format("| %-10s", patients[i].getName()));
				System.out.printf(String.format("| %-10s", patients[i].getSurname()));
				System.out.printf(String.format("| %-5s |", patients[i].getAge()));
				System.out.println();
			}
		}
		System.out.println("---------------------------------");
		
	}
	
	// Year report
	public static void Report_year(Patient[] patients, int y_1, int y_2) {
		
		int i, year;
		LocalDate today;
		today = LocalDate.now();
		
		System.out.println();
		System.out.println("***Liste der Patienten, die zwischen " + y_1 + " und " + y_2 + " geboren wurden.");
		System.out.println();
		System.out.printf("Datum: %1$td.%1$tm.%1$ty      ", today);
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.printf(String.format("| %-10s| %-10s| %-13s|", "Vorname", "Nachname", "Geburtsdatum"));
		System.out.println();
		System.out.println("----------------------------------------");
		
		for (i = 0; i < patients.length; i++) {
		year = patients[i].getBirthday().getYear();
			if (year >= y_1 & year <= y_2) {
				System.out.printf(String.format("| %-10s", patients[i].getName()));
				System.out.printf(String.format("| %-10s", patients[i].getSurname()));
				System.out.printf(String.format("|   %1$td.%1$tm.%1$ty   |", patients[i].getBirthday()));
				System.out.println();
			}
		}
		System.out.println("----------------------------------------");
	}
		
	// Sex report
	public static void Report_sex(Patient[] patients, int s) {
		
		int i;
		LocalDate today;
		today = LocalDate.now();
		
		System.out.println();
		System.out.println("***Liste der Patienten nach dem Geschlecht.");
		System.out.println();
		System.out.printf("Datum: %1$td.%1$tm.%1$ty      ", today);
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.printf(String.format("| %-10s| %-10s| %-13s|", "Vorname", "Nachname", "Geschlecht"));
		System.out.println();
		System.out.println("----------------------------------------");
		
		for (i = 0; i < patients.length; i++) {
			if (s == 1) {
				if (patients[i].getSex().equals("Weiblich")) {
					System.out.printf(String.format("| %-10s", patients[i].getName()));
					System.out.printf(String.format("| %-10s", patients[i].getSurname()));
					System.out.printf(String.format("| %-13s|", patients[i].getSex()));
					System.out.println();
				}
			} else if (s == 2) {
				if (patients[i].getSex().equals("Männlich")) {
					System.out.printf(String.format("| %-10s", patients[i].getName()));
					System.out.printf(String.format("| %-10s", patients[i].getSurname()));
					System.out.printf(String.format("| %-13s|", patients[i].getSex()));
					System.out.println();
				}
			} else if (s == 3 ) {
				if (patients[i].getSex().equals("Divers")) {
					System.out.printf(String.format("| %-10s", patients[i].getName()));
					System.out.printf(String.format("| %-10s", patients[i].getSurname()));
					System.out.printf(String.format("| %-13s|", patients[i].getSex()));
					System.out.println();
				}
			}
		}
		System.out.println("----------------------------------------");
	}
		
	//Age group report
	public static void Report_age_group(Patient[] patients, int g) {
		
		int i;
		LocalDate today;
		today = LocalDate.now();
		
		System.out.println();
		System.out.println("***Liste der Patienten nach der Altersgruppe.");
		System.out.println();
		System.out.printf("Datum: %1$td.%1$tm.%1$ty      ", today);
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.printf(String.format("| %-10s| %-10s| %-7s| %-12s |", "Vorname", "Nachname", "Alter", "Altersgruppe"));
		System.out.println();
		System.out.println("-------------------------------------------------");
		
		for (i = 0; i < patients.length; i++) {
			if (g == 1) {
				if (patients[i].getAgeGroup().equals("Kind")) {
					System.out.printf(String.format("| %-10s", patients[i].getName()));
					System.out.printf(String.format("| %-10s", patients[i].getSurname()));
					System.out.printf(String.format("| %-7s", patients[i].getAge()));
					System.out.printf(String.format("| %-12s |", patients[i].getAgeGroup()));
					System.out.println();
				}
			} else if (g == 2) {
				if (patients[i].getAgeGroup().equals("Jugendliche")) {
					System.out.printf(String.format("| %-10s", patients[i].getName()));
					System.out.printf(String.format("| %-10s", patients[i].getSurname()));
					System.out.printf(String.format("| %-7s", patients[i].getAge()));
					System.out.printf(String.format("| %-12s |", patients[i].getAgeGroup()));
					System.out.println();
				}
			} else if (g == 3 ) {
				if (patients[i].getAgeGroup().equals("Erwachsene")) {
					System.out.printf(String.format("| %-10s", patients[i].getName()));
					System.out.printf(String.format("| %-10s", patients[i].getSurname()));
					System.out.printf(String.format("| %-7s", patients[i].getAge()));
					System.out.printf(String.format("| %-12s |", patients[i].getAgeGroup()));
					System.out.println();
				}
			}
		}
		System.out.println("-------------------------------------------------");
	}
		
	//Blood group report
	public static void Report_Bloodgroup(Patient[] patients, int b) {
		
		int i;
		LocalDate today;
		today = LocalDate.now();
		
		System.out.println();
		System.out.println("***Liste der Patienten nach der Blutgruppe.");
		System.out.println();
		System.out.printf("Datum: %1$td.%1$tm.%1$ty      ", today);
		System.out.println();
		System.out.println("-------------------------------------");
		System.out.printf(String.format("| %-10s| %-10s| %-9s |", "Vorname", "Nachname", "Blutruppe"));
		System.out.println();
		System.out.println("-------------------------------------");
		
		for (i = 0; i < patients.length; i++) {
			if (b == 1) {
				if (patients[i].getBloodgroup().equals("A")) {
					System.out.printf(String.format("| %-10s", patients[i].getName()));
					System.out.printf(String.format("| %-10s", patients[i].getSurname()));
					System.out.printf(String.format("| %-9s |", patients[i].getBloodgroup()));
					System.out.println();
				}
			} else if (b == 2) {
				if (patients[i].getBloodgroup().equals("B")) {
					System.out.printf(String.format("| %-10s", patients[i].getName()));
					System.out.printf(String.format("| %-10s", patients[i].getSurname()));
					System.out.printf(String.format("| %-9s |", patients[i].getBloodgroup()));
					System.out.println();
				}
			} else if (b == 3 ) {
				if (patients[i].getBloodgroup().equals("AB")) {
					System.out.printf(String.format("| %-10s", patients[i].getName()));
					System.out.printf(String.format("| %-10s", patients[i].getSurname()));
					System.out.printf(String.format("| %-9s |", patients[i].getBloodgroup()));
					System.out.println();
				}
			} else if (b == 4) {
				if (patients[i].getBloodgroup().equals("O")) {
					System.out.printf(String.format("| %-10s", patients[i].getName()));
					System.out.printf(String.format("| %-10s", patients[i].getSurname()));
					System.out.printf(String.format("| %-9s |", patients[i].getBloodgroup()));
					System.out.println();
				}
			}
		}
		System.out.println("-------------------------------------");
	}
		
	//Diagnose report
	public static void Report_Diagnose(Patient[] patients, int d) {
		
		int i;
		LocalDate today;
		today = LocalDate.now();
		
		System.out.println();
		System.out.println("***Liste der Patienten nach der Diagnose.");
		System.out.println();
		System.out.printf("Datum: %1$td.%1$tm.%1$ty      ", today);
		System.out.println();
		System.out.println("---------------------------------------------------");
		System.out.printf(String.format("| %-10s| %-10s| %-23s |", "Vorname", "Nachname", "Diagnose"));
		System.out.println();
		System.out.println("---------------------------------------------------");
		
		for (i = 0; i < patients.length; i++) {
			if (d == 1) {
				if (patients[i].getDiagnose().equals("Kann durch Wände sehen")) {
					System.out.printf(String.format("| %-10s", patients[i].getName()));
					System.out.printf(String.format("| %-10s", patients[i].getSurname()));
					System.out.printf(String.format("| %-23s |", patients[i].getDiagnose()));
					System.out.println();
				}
			} else if (d == 2) {
				if (patients[i].getDiagnose().equals("Kann unsichtbar werden")) {
					System.out.printf(String.format("| %-10s", patients[i].getName()));
					System.out.printf(String.format("| %-10s", patients[i].getSurname()));
					System.out.printf(String.format("| %-23s |", patients[i].getDiagnose()));
					System.out.println();
				}
			} else if (d == 3 ) {
				if (patients[i].getDiagnose().equals("Überträgt Gedanken")) {
					System.out.printf(String.format("| %-10s", patients[i].getName()));
					System.out.printf(String.format("| %-10s", patients[i].getSurname()));
					System.out.printf(String.format("| %-23s |", patients[i].getDiagnose()));
					System.out.println();
				}
			} else if (d == 4) {
				if (patients[i].getDiagnose().equals("Fliegt im Schlaf")) {
					System.out.printf(String.format("| %-10s", patients[i].getName()));
					System.out.printf(String.format("| %-10s", patients[i].getSurname()));
					System.out.printf(String.format("| %-23s |", patients[i].getDiagnose()));
					System.out.println();
				}
			}
		}
		System.out.println("---------------------------------------------------");
	}
		
	//Doctors report
	public static void Report_Doctors(Patient[] patients, int d, Doctor doctor_1, Doctor doctor_2, Doctor doctor_3) {
		
		int i;
		LocalDate today;
		today = LocalDate.now();
		
		System.out.println();
		System.out.println("***Liste der Patienten nach der Artz. ");
		System.out.println("Die Patienten werden von den Ärzten mit einem passenden Fachgebiet betreut. ");
		System.out.println("Sollte es keinen solchen Arzt geben, werden Patienten vorübergehend von Auszubildender betreut.");
		System.out.println();
		System.out.printf("Datum: %1$td.%1$tm.%1$ty      ", today);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.printf(String.format("| %-10s| %-10s| %-23s| %-10s| %-14s| %-16s|", "Vorname", "Nachname", "Diagnose", "Artzname", "Artznachname", "Fachgebiet"));
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------");
		
		for (i = 0; i < patients.length; i++) {
			if (d == 1) {
				if (patients[i].getDiagnose().equals("Überträgt Gedanken")) {
					System.out.printf(String.format("| %-10s", patients[i].getName()));
					System.out.printf(String.format("| %-10s", patients[i].getSurname()));
					System.out.printf(String.format("| %-23s", patients[i].getDiagnose()));
					System.out.printf(String.format("| %-10s", doctor_1.getName()));
					System.out.printf(String.format("| %-14s", doctor_1.getSurname()));
					System.out.printf(String.format("| %-15s |", doctor_1.getArea()));
					System.out.println();
				}
			} else if (d == 2) {
				if (patients[i].getDiagnose().equals("Fliegt im Schlaf")) {
					System.out.printf(String.format("| %-10s", patients[i].getName()));
					System.out.printf(String.format("| %-10s", patients[i].getSurname()));
					System.out.printf(String.format("| %-23s", patients[i].getDiagnose()));
					System.out.printf(String.format("| %-10s", doctor_2.getName()));
					System.out.printf(String.format("| %-14s", doctor_2.getSurname()));
					System.out.printf(String.format("| %-15s |", doctor_2.getArea()));
					System.out.println();
				}
			} else if (d == 3 ) {
				if (patients[i].getDiagnose().equals("Kann durch Wände sehen") || patients[i].getDiagnose().equals("Kann unsichtbar werden")) {
					System.out.printf(String.format("| %-10s", patients[i].getName()));
					System.out.printf(String.format("| %-10s", patients[i].getSurname()));
					System.out.printf(String.format("| %-23s", patients[i].getDiagnose()));
					System.out.printf(String.format("| %-10s", doctor_3.getName()));
					System.out.printf(String.format("| %-14s", doctor_3.getSurname()));
					System.out.printf(String.format("| %-15s |", doctor_3.getArea()));
					System.out.println();
				}
			} 
		}
		System.out.println("------------------------------------------------------------------------------------------------");
	}
	
}
