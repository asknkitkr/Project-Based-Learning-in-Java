package project7;

import java.io.*;
import java.util.*;

class EMS implements Serializable {
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	double salary;
	int age;
	
	public EMS(int id, String name, int age, double salary) {
		this.id = id;		
		this.name = name;		
		this.salary = salary;		
		this.age = age;
	}
	@Override public String toString() {
		return (this.id + this.name + this.age + this.salary);
	}
}

public class Project7 {
	
	private static final Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int choice = 0;		
		do {
			System.out.println("\nMain Menu");
			System.out.println("1. Add an Employee");
			System.out.println("2. Display All");
			System.out.println("3. Exit");
			choice = in.nextInt();
			
			try {
				switch(choice) {
				case 1:
					addEmployee();
					break;
				case 2:
					displayAll();
;					break;
				case 3:
					System.out.println("EXITING FROM PROGRAM");
					System.exit(0);
					break;
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		} while(choice != 3);
	}
	private static EMS displayAll() {
		
		
		try {
			FileInputStream fis = new FileInputStream("ems.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			EMS ems = (EMS) ois.readObject();
			
			return ems;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	private static void addEmployee() throws IOException {
		System.out.print("Enter Employee ID :");
		int id = in.nextInt();
		System.out.print("Enter Employee Name :");
		String name = in.next();
		System.out.print("Enter Employee Age :");
		int age = in.nextInt();
		System.out.print("Enter Employee Salary :");
		double salary = in.nextDouble();
		
		EMS ems = new EMS(id, name, age, salary);
		//String eDetails = ems.id + " " + ems.name + " " + ems.age + ems.salary;

		ArrayList<EMS> list = new ArrayList<EMS>();
		list.add(ems);
		
		try {
			FileOutputStream fos = new FileOutputStream("ems.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			try {
				oos.writeObject(list);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
//public class EMS implements Serializable {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private int id;
//	private String name;
//	private double salary;
//	private int age;
//	
//	public EMS() {}
//	public EMS(int id, String name, int age, double salary) {
//		super();
//		this.id = id;
//		setId(id);
//		
//		this.name = name;
//		setName(name);
//		
//		this.salary = salary;
//		setSalary(salary);
//		
//		this.age = age;
//		setAge(age);
//	}
//	
//	private static final Scanner in = new Scanner(System.in);
//	public static void main(String[] args) {
//		int choice = 0;		
//		String filename = "emslist.text";
//		do {
//			System.out.println("\nMain Menu");
//			System.out.println("1. Add an Employee");
//			System.out.println("2. Display All");
//			System.out.println("3. Exit");
//			choice = in.nextInt();
//			
//			try {
//				switch(choice) {
//				case 1:
//					System.out.print("Enter Employee ID :");
//					int id = in.nextInt();
//					System.out.print("Enter Employee Name :");
//					String name = in.next();
//					System.out.print("Enter Employee Age :");
//					int age = in.nextInt();
//					System.out.print("Enter Employee Salary :");
//					double salary = in.nextDouble();
//					
//					EMS emsList = new EMS(id, name, age, salary);
//					String E = emsList.id + " " + emsList.name + " " + emsList.age + " " + emsList.salary;
//					try {
//						FileWriter fw = new FileWriter(filename, true);
//						BufferedWriter bw = new BufferedWriter(fw);
//						
//						bw.append(E);
//						bw.close();
//						fw.close();
//					}
//					catch(IOException e) {
//						System.out.println("Error: " + e);
//					}
//					break;
//				case 2:
//					try {
//						FileReader fr = new FileReader(filename);
//						BufferedReader br = new BufferedReader(fr);
//						
//						ArrayList<EMS> emsL = new ArrayList<>();
//						String line;
//						
//						while((line = br.readLine())!= null) {
//							String data[] = line.split(" ");
//							EMS EM = new EMS(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[3]), Double.parseDouble(data[2]));
//							emsL.add(EM);
//						}
//						
//						br.close();
//						fr.close();
//						
//						for(EMS em: emsL) {
//							System.out.print(em.id + " " + em.name + " " + em.age + " " + em.salary);
//						}
//					} catch(Exception ex) {
//						ex.printStackTrace();
//					}
//					break;
//				case 3:
//					System.out.println("Exiting the System");
//					System.exit(0);
//					break;
//				default:
//					break;
//				}
//			} catch(InputMismatchException e) {
//				System.err.println("Error: " + e);
//			}
//		} while(choice != 3);
//		
//
//	}
//
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public double getSalary() {
//		return salary;
//	}
//	public void setSalary(double salary) {
//		this.salary = salary;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//}
