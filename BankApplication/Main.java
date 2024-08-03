package projects.BankApplication;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Bank bank = new Bank();
    Account account = null;
    Scanner scan = new Scanner(System.in);
    while(true){
      System.out.println("Welcome to Indian Bank");
      System.out.println(" ");
      System.out.println("Select the option to perform: ");
      System.out.println(" ");
      System.out.println("1: Open Account");
      System.out.println("2: View Account");
      System.out.println("3: Close Account");
      System.out.println("4: Deposit Amount");
      System.out.println("5: Withdraw Amount");
      System.out.println("6: Check Balance");
      System.out.println("7: Exit"+"\n");

      int choice = scan.nextInt();
      scan.nextLine();
      switch (choice) {
        case 1:
          account = new Account();
          account.openAccount();
          bank.addCustomer(account);
          break;

        case 2:
          System.out.print("Enter the CustomerId: ");
          String customerId = scan.nextLine();
          try {
            bank = bank.findCustomer(customerId);
            System.out.println(bank);
          } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
          }
          break;
          
        case 3:
          System.out.print("Enter the CustomerId: ");
          String customerId1 = scan.nextLine();
          System.out.println(bank.removeCustomer(customerId1));
          break;

        case 4:
          System.out.print("Enter Account Number: ");
          String acc = scan.nextLine();
          System.out.print("Enter the amount: ");
          double amount = scan.nextDouble();
          bank.cashDeposit(acc, amount);
          break;

        case 5:
          System.out.print("Enter Account Number: ");
          String acc1 = scan.nextLine();
          System.out.print("Enter the amount: ");
          double amount1 = scan.nextDouble();
          bank.cashWithdraw(acc1, amount1);
          break;
          
        case 6:
          System.out.print("Enter Account Number: ");
          String acc2 = scan.nextLine();
          bank.getBalance(acc2);
          break;

        default:
          if(choice != 7){
            System.out.println("Enter a valid input: ");
      }
          break;
    }
    if (choice==7){
      System.out.println("Thank you for banking with us!!");
      break;
    }
  }
  }
}
