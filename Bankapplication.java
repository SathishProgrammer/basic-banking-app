package projects;

import java.util.Scanner;

public class Bankapplication {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double accountBalance = 0;
        while(true){
            System.out.println("Welcome to Banking Application");
            System.out.println("Choose the option you want to perform");
            System.out.println("1. Cash Deposit");
            System.out.println("2. Cash Withdrawal");
            System.out.println("3. Check Bank Balance");
            System.out.println("4. Exit");
            int choice = scan.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter the amount to deposit: ");
                    double depositAmount = scan.nextDouble();
                    accountBalance = cashDeposit(depositAmount,accountBalance);
                    System.out.println("Rs:" + depositAmount + " is deposited successfully");
                    break;

                case 2:
                    System.out.println("Enter the amount to be withdrawal: ");
                    double withdrawAmount = scan.nextDouble();
                    if (withdrawAmount<accountBalance){
                    accountBalance = cashWithdrawal(withdrawAmount,accountBalance);
                    System.out.println("Rs:" + withdrawAmount + " is withdraw successfully");
                    }
                    else{
                        System.out.println("Insuffiecient account balance");
                    }
                    break;

                case 3:
                    System.out.println("Your current balance is Rs: "+accountBalance);
                    break;

                default:
                    if(choice != 4){
                        System.out.println("Enter a valid input");
                    }
                    break;
            }
            if (choice == 4){
                System.out.println("Thank you for Banking with us.");
                break;
            }
            scan.close();
        }
        
    }
    public static double cashDeposit(double depositAmount,double accountBalance){
        if (depositAmount>0){
            accountBalance+=depositAmount;
        }
        return accountBalance;
    }

    public static double cashWithdrawal(double withdrawAmount,double accountBalance){
        if (withdrawAmount<accountBalance){
            accountBalance-=withdrawAmount;
        }
        return accountBalance;
    }
}
