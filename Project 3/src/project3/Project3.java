package project3;

import java.util.Scanner;

class InvalidValue extends Exception {
	private static final long serialVersionUID = 1L;	
}

abstract class Account {
	double interestRate;
	double amount;
	
	abstract double calculateInterest(double amount) throws InvalidValue;
}

class FDAccount extends Account {
	double FDinterestRate;
	double FDamount;
	int noOfDays, ageOfACHolder;
	double General, SeniorCitizen;
	Scanner FDs = new Scanner(System.in);
	
	@Override
	double calculateInterest(double amount) throws InvalidValue {
		this.FDamount = amount;
		if(FDamount < 0) {
			throw new InvalidValue();
		}
		
		System.out.print("Enter FD days: ");
		noOfDays = FDs.nextInt();
		System.out.print("Enter FD account holder age: ");
		ageOfACHolder = FDs.nextInt();
		
		if(noOfDays < 0 || ageOfACHolder < 0) {
			throw new InvalidValue();
		}
		 
		if(amount < 10000000) {
			if(noOfDays >= 7 && noOfDays <= 14) {
				General = 0.045;
				SeniorCitizen = 0.05;
			} else if(noOfDays >= 15 && noOfDays <= 29) {
				General = 0.047;
				SeniorCitizen = 0.0525;
			} else if(noOfDays >= 30 && noOfDays <= 45) {
				General = 0.0550;
				SeniorCitizen = 0.06;
			} else if(noOfDays >= 45 && noOfDays <= 60) {
				General = 0.07;
				SeniorCitizen = 0.0750;
			} else if(noOfDays >= 61 && noOfDays <= 184) {
				General = 0.0750;
				SeniorCitizen = 0.08;
			} else if(noOfDays >= 185 && noOfDays <= 365) {
				General = 0.08;
				SeniorCitizen = 0.0850;
			}
			FDinterestRate = (ageOfACHolder < 50) ? General : SeniorCitizen;
		} else {
			if(noOfDays >= 7 && noOfDays <= 14) {
				interestRate = 0.065;
			} else if(noOfDays >= 15 && noOfDays <= 29) {
				interestRate = 0.0675;
			} else if(noOfDays >= 30 && noOfDays <= 45) {
				interestRate = 0.0675;
			} else if(noOfDays >= 45 && noOfDays <= 60) {
				interestRate = 0.080;
			} else if(noOfDays >= 61 && noOfDays <= 184) {
				interestRate = 0.0850;
			} else if(noOfDays >= 185 && noOfDays <= 365) {
				interestRate = 0.10;
			}
		}
		return FDamount * interestRate;
	}
	
}

class SBAccount extends Account {
	double SBinterestRate;
	double SBamount;
	Scanner SBs = new Scanner(System.in);
	
	@Override
	double calculateInterest(double amount) throws InvalidValue {
		this.SBamount = amount;
		if(SBamount < 0) {
			throw new InvalidValue();
		}
		System.out.println("Select account type:\n[1] NRI\n[2] Normal ");
		int choice = SBs.nextInt();
		switch(choice) {
		case 1:
			SBinterestRate = 0.06;
			break;
		case 2:
			SBinterestRate = 0.04;
			break;
		default:
			System.out.println("Invalid choice.");
		}
		return amount*SBinterestRate;
	}
}

class RDAccount extends Account {
	double RDinterestRate;
	double RDamount;
	int noOfMonths;
	double monthlyAmount;
	double General, SeniorCitizen;
	Scanner RDs = new Scanner(System.in);
	
	@Override
	double calculateInterest(double amount) throws InvalidValue {
		this.RDamount = amount;
		if(RDamount < 0) {
			throw new InvalidValue();
		}
		System.out.print("Enter RD months: ");
		noOfMonths = RDs.nextInt();
		System.out.print("Enter RD holder age: ");
		int age = RDs.nextInt();
		
		if(noOfMonths < 0 || age < 0) {
			throw new InvalidValue();
		}
		
		if (noOfMonths >= 0 && noOfMonths <= 6) {
            General = 0.0750;
            SeniorCitizen = 0.080;
        } else if (noOfMonths >= 7 && noOfMonths <= 9) {
            General = .0775;
            SeniorCitizen = 0.0825;
        } else if (noOfMonths >= 10 && noOfMonths <= 12) {
            General = .0800;
            SeniorCitizen = 0.0850;
        } else if (noOfMonths >= 13 && noOfMonths <= 15) {
            General = .0825;
            SeniorCitizen = 0.0875;
        } else if (noOfMonths >= 16 && noOfMonths <= 18) {
            General = .0850;
            SeniorCitizen = 0.0900;
        } else if (noOfMonths >= 22) {
            General = .0875;
            SeniorCitizen = 0.0925;
        }
        RDinterestRate = (age < 50) ? General : SeniorCitizen;
        return RDamount * RDinterestRate;
	}	
}

public class Project3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Select the option:\n\t1. Interest Calculator - SB\n\t2. Interest Calculator - FD\n\t3. Interest Calculator - RD\n\t4. Exit");
		int choice = in.nextInt();
		
		switch(choice) {
		case 1:
			SBAccount sb = new SBAccount();
			System.out.println("Enter the Average SB amount ");
            double amount = in.nextDouble();
            try {
				System.out.println("Interest gained is : $ " + sb.calculateInterest(amount));
			} catch (InvalidValue e1) {
				System.err.println("Error: Please enter positive number");
			}
            break;
           
		case 2:
			FDAccount fd = new FDAccount();
            System.out.println("Enter the FD Amount");
            double fAmount = in.nextDouble();
            try {
				System.out.println("Interest gained is: $ " + fd.calculateInterest(fAmount));
			} catch (InvalidValue e) {
				System.err.println("Error: Please enter positive number");
			}
            break;
		case 3:
			RDAccount rd = new RDAccount();
            System.out.println("Enter the RD amount");
            double Ramount = in.nextDouble();
            try {
				System.out.println("Interest gained is: $ " + rd.calculateInterest(Ramount));
			} catch (InvalidValue e) {
				System.err.println("Error: Please enter positive number");
			}
            break;
		case 4:
			System.out.println("Thank you for using the program");
			System.exit(1);
		default:
			System.out.println("Invalid choice");
		}		
		in.close();
	}

}
