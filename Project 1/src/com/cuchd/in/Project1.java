package com.cuchd.in;

import java.util.Scanner;

public class Project1 {
	static String deptCode(char c)
	{
		switch(c) 
		{
		case 'e' : return "Engineer";
		case 'c' : return "Consultant";
		case 'k' : return "Clerk";
		case 'r' : return "Receptionist";
		case 'm' : return "Manager";
		}
		return "Invalid";
	}
	
	static int da(char c) 
	{
		switch(c)
		{
		case 'e' : return 20000;
		case 'c' : return 32000;
		case 'k' : return 12000;
		case 'r' : return 15000;
		case 'm' : return 40000;
		}
		return 0;
	}

	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		int[] empNo = {1001, 1002, 1003, 1004, 1005, 1006, 1007};
		String[] empName = {"Ashish", "Sushma", "Rahul", "Chahat", "Ranjan", "Suman", "Tanmay"};
		char[] designationCode = {'e', 'c', 'k', 'r', 'm', 'e', 'c'};
		String[] department = {"R&D", "PM", "Acct", "Front Desk", "Engg", "Manufacturing", "PM"};
		int[] basic = {8000, 12000, 8000, 6000, 20000, 9000, 12000};
		int[] it = {3000, 9000, 1000, 2000, 20000, 4400, 10000};
		
		boolean check = false;
		int t = 0;
		
		System.out.print("Enter Employee ID: ");
		int e = sc.nextInt();
		
		for(int i = 0; i < 7; i++) 
		{
			if(empNo[i] == e)
			{
				check = true;
				t = i;
				break;
			}
		}
		
		if(check == false)
		{
			System.out.println("There is no employee with empid: " + e);
		}
		else
		{
			System.out.println("Emp No.\tEmp Name\tDepartment\tDesignation\tSalary");
			System.out.print(empNo[t] + "\t" + empName[t] + "\t\t" + department[t] + "\t\t" + deptCode(designationCode[t]) + "\t");
			
			int salary = basic[t] + it[t] + da(designationCode[t]) - it[t];
			System.out.print(salary);
		}
		
		sc.close();

	}

}
