import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class AccountLookup {

    public static void main(String[] args) throws Exception {
        // Sample data (replace with actual data)
        Map<String, AccountDetails> accountData = new HashMap<>();

        try (// Get user input
		Scanner scanner = new Scanner(System.in)) {
        	
        	System.out.println("Hello! Welcome to Bank Of Texas.");
        	System.out.println();
			System.out.print("Enter your name: ");
			
			String userName = scanner.nextLine().toLowerCase(); // Convert to lowercase
			 Thread.sleep(1000);
			 System.out.println();
			 System.out.println("Loading...........");
			 Thread.sleep(1000);
			System.out.println(); 
			// Check if the entered name (in lowercase) exists in the data
			if (accountData.containsKey(userName)) {
			    AccountDetails userAccount = accountData.get(userName);
			    System.out.println("Account Number: " + userAccount.getAccountNumber());
			    System.out.println("Account Balance: $" + userAccount.getAccountBalance());
			} else {
			    System.out.println("User not found in the system.");

			    // Ask if the user wants to create an account
			    Thread.sleep(1000);
			    System.out.println();
			    System.out.print("Do you want to create an account? (yes/no): ");
			    String createAccountChoice = scanner.nextLine().toLowerCase();

			    if (createAccountChoice.equals("yes")) {
			        // Generate a random account number
			        String accountNumber = generateRandomAccountNumber();

			        // Ask the user for an initial deposit
			        System.out.print("Enter the initial deposit amount: $");
			        double initialDeposit = scanner.nextDouble();
			        scanner.nextLine(); // Consume the newline character

			        // Create a new account
			        AccountDetails newAccount = new AccountDetails(accountNumber, initialDeposit);
			        accountData.put(userName, newAccount);

			        // Display the account details
			        Thread.sleep(1000);
			        System.out.println();
			        System.out.println("Account created successfully!");
			        System.out.println();
			        Thread.sleep(1000);
			        System.out.println("Account Number: " + newAccount.getAccountNumber());
			        System.out.println("Account Balance: $" + newAccount.getAccountBalance());
			        System.out.println();
			    
			    while(true)  
		        {  
			    	
		            System.out.println("Automated Teller Machine");  
		            System.out.println("Choose 1 for Withdraw");  
		            System.out.println("Choose 2 for Deposit");  
		            System.out.println("Choose 3 for Check Balance");  
		            System.out.println("Choose 4 for EXIT");  
		            System.out.print("Choose the operation you want to perform:");  
		              
		            //get choice from user  
		            int choice = scanner.nextInt();  
		            switch(choice)  
		            {  
		                case 1:  
		        System.out.print("Enter money to be withdrawn:");  
		                      
		        //get the withdrawl money from user  
		      double withdraw = scanner.nextInt();  
		                      
		        //check whether the balance is greater than or equal to the withdrawal amount  
		      
		      ;
		        if(newAccount.accountBalance >= withdraw)  
		        {  
		            //remove the withdrawl amount from the total balance  
		             newAccount.accountBalance = newAccount.accountBalance - withdraw;  
		            System.out.println("Please collect your money");  
		        }  
		        else  
		        {  
		            //show custom error message   
		            System.out.println("Insufficient Balance");  
		        }  
		        System.out.println("");  
		        break;  
		            
		                case 2:  
		                      
		        System.out.print("Enter money to be deposited:");  
		                      
		        //get deposite amount from te user  
		       double deposit = scanner.nextInt();  
		                      
		        //add the deposit amount to the total balanace  
		       newAccount.accountBalance = newAccount.accountBalance + deposit;  
		        System.out.println("Your Money has been successfully depsited");  
		        System.out.println("");  
		        break;  
		   
		                case 3:  
		        //displaying the total balance of the user  
		        System.out.println("Balance : "+  newAccount.accountBalance);  
		        System.out.println("");  
		        break;  
		   
		                case 4:  
		        //exit from the menu  
		        System.exit(0);  
		              
		          
			     
		            }
		        }
			    }
			    else {
			        System.out.println("Thank you for using our system.");
			    }
			}
		}
    }

    // Generate a random account number
    private static String generateRandomAccountNumber() {
        Random random = new Random();
        int accountNumber = 100000 + random.nextInt(900000);
        return String.valueOf(accountNumber);
        
    }

    // Class to store account details
    static class AccountDetails {
        private String accountNumber;
        private double accountBalance;

        public AccountDetails(String accountNumber, double accountBalance) {
            this.accountNumber = accountNumber;
            this.accountBalance = accountBalance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public double getAccountBalance() {
            return accountBalance;
        }
    }
}