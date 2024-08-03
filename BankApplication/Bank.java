package projects.BankApplication;
import java.util.List;
import java.util.ArrayList;
public class Bank {
 // private String name;
  private List<Account>customers;

  public Bank() {
   // this.name = name;
    this.customers = new ArrayList<>();
  }

  public void addCustomer(Account customer){
    customers.add(customer);
  }

  public String removeCustomer(String customer){
    for (Account account : customers) {
      if (account.getCustomerId().equals(customer)){
        customers.remove(account);
        return "Your account is closed.";
      }
    }
    return "Your account is not present.Please enter a valid customerID.";
  }

  public void cashDeposit(String accNo, double amount){
    Account acc = null;
    if (amount>0 && amount!=0){
      for (Account account : customers) {
        if (account.getAccountNumber().equals(accNo)){
          acc = account;
        }
      }
      System.out.println(acc.deposit(amount)+"\n");
    }
    else{
      System.out.println("Invalid Amount"+"\n");
    }
  }
  
  public void cashWithdraw(String accNo, double amount){
    Account acc = null;
    int money = (int)(amount);
    if (money > 0 && money!=0){
      for (Account account : customers) {
      if (account.getAccountNumber().equals(accNo)){
        acc = account;
      }
    }
    if (amount>acc.getInitialBalance()){
      System.out.println("Insuffiecient Balance"+"\n");
    }
    else{
      System.out.println(acc.withdraw(amount)+"\n");
    }
  }
  else {
    System.out.println("Enter a valid input.");
  }
  }

  public void getBalance(String accNo){
    Account acc = null;
    for (Account account : customers) {
      if (account.getAccountNumber().equals(accNo)){
        acc = account;
      }
    }
    System.out.println(acc.getInitialBalance()+"\n");
  }

  public Account findCustomer(String customerId) throws CustomerNotFoundException{
    for (Account customer : customers) {
      if (customer.getCustomerId().equals(customerId)) {
        return customer;
      }
    }
    throw new CustomerNotFoundException("Customer with ID " + customerId + " not found.");
    }

  public void displayAllCustomers(){
    for (Account customer : customers) {
      System.out.println(customer);
    }
  }
}