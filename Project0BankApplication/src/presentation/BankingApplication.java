package presentation;


import java.util.List;
import java.util.Scanner;
import exception.EmptyAccountException;
import model.AccountPojo;
import model.UserPojo;
import service.AccountService;
import service.AccountServiceImpl;
import service.UserService;
import service.UserServiceImpl;


public class BankingApplication {

	public static void main(String[] args) {
		
		UserService userService = new UserServiceImpl();
		AccountService accountService = new AccountServiceImpl();
		int accntUserid = 0;
		Scanner scan = new Scanner(System.in);
	
		int option = 0;
		boolean mark = true;
		
		while(mark) {
			System.out.println("**********************************");
			System.out.println("BANK ACCOUNT LOGIN");
			System.out.println("**********************************");
			System.out.println("1. LOGIN TO EXISTING ACCOUNT");
			System.out.println("2. REGISTER NEW ACCOUNT");
			System.out.println("3. Exit.");
			System.out.println("**********************************");
			System.out.println("Enter your option:");
			option = Integer.parseInt(scan.nextLine());
			System.out.println("**********************************");
		
			switch(option) {
			case 1:
				UserPojo userLoginPojo = new UserPojo();
				System.out.println("Enter user id:");
				userLoginPojo.setUserId(Integer.parseInt(scan.nextLine()));
				System.out.println("Enter user password:");
				userLoginPojo.setPassword(scan.nextLine());
			
				
				AccountService bankInfoService = new AccountServiceImpl();
				
				char proceed = 'y';
				while(proceed == 'y') {
					System.out.println("1. View bank balance");
					System.out.println("2. Withdraw");
					System.out.println("3. Deposit");
					System.out.println("4. Log out");
					System.out.println("*****************************");
					System.out.println("Please enter an option:");
					int option2 = scan.nextInt();
					System.out.println("*****************************");
					switch(option2) {
						case 1:
							List<AccountPojo> everyAccount;
							try {
								everyAccount = accountService.getAllAccount();
							} catch (EmptyAccountException e) {
								System.out.println(e.getMessage());
								break;
							}
							System.out.println("***************************************************************************************");
							System.out.println("Accnt #\ttbalance");
							System.out.println("***************************************************************************************");
							everyAccount.forEach((item) -> System.out.println(item.getAccntId() + "\t" + item.getBalance()));
							System.out.println("***************************************************************************************");
							System.out.println("Do you want to continue?(y/n)");
							proceed = scan.next().charAt(0);
							break;
							
						case 2:
							System.out.println("Please enter account number to make withdrawl :");
							int updateAccntId = scan.nextInt(); 
							AccountPojo withdrawlAccountPojo = accountService.getAAccount(updateAccntId);
							if(withdrawlAccountPojo == null) {
								System.out.println("*****************************");
								System.out.println("Account number does not exist. \nPlease enter a valid account number!");
								System.out.println("*****************************");
								break;
							}else {
								System.out.println("*****************************");
								System.out.println("Current balance...");
								System.out.println("*****************************");
								System.out.println("Account number : " + withdrawlAccountPojo.getAccntId());
								System.out.println("Account balance: " + withdrawlAccountPojo.getBalance());
								System.out.println("*****************************");
								System.out.println("Please enter new balance :");
								withdrawlAccountPojo.setBalance(scan.nextDouble());
								accountService.updateAccount(withdrawlAccountPojo);
								System.out.println("*****************************");
								System.out.println("Balance updated successfully...");
								System.out.println("*****************************");
							}
						
						case 3:
							System.out.println(accntUserid);
							//System.out.println("Please enter account number to make updates :");
							//int updateAccntNo1 = scan.nextInt();
							
							List<AccountPojo> allAccount;
						try {
							allAccount = bankInfoService.getAllAccount();
						} catch (EmptyAccountException e) {
							System.out.println(e.getMessage());
							break;
						}
							System.out.println("***************************************************************************************");
							System.out.println("ID\tBalance");
							System.out.println("***************************************************************************************");
							allAccount.forEach((item) -> System.out.println(item.getAccntId() + "\t" + item.getBalance()));
							
							System.out.println("Please enter account number to make deposit :");
							int updateAccntId1 = scan.nextInt(); 
							AccountPojo depositAccountPojo1 = accountService.getAAccount(updateAccntId1);
							if(depositAccountPojo1 == null) {
								System.out.println("*****************************");
								System.out.println("Account number does not exist. \nPlease enter a valid account number!");
								System.out.println("*****************************");
								break;
							}else {
								System.out.println("*****************************");
								System.out.println("Current balance...");
								System.out.println("*****************************");
								System.out.println("Account number : " + depositAccountPojo1.getAccntId());
								System.out.println("Account balance: " + depositAccountPojo1.getBalance());
								System.out.println("*****************************");
								System.out.println("Please enter new balance :");
								depositAccountPojo1.setBalance(scan.nextDouble());
								accountService.updateAccount(depositAccountPojo1);
								System.out.println("*****************************");
								System.out.println("Balance updated successfully...");
								System.out.println("*****************************");
							}
							break;
						case 4:
							System.out.println("*******************************************************************");
							System.out.println("Thank you for using Banking Application!!");
							System.out.println("*******************************************************************");
							System.exit(0);
						default:		
						}
				
					}
				
			case 2:
				UserPojo newUserPojo = new UserPojo();
				System.out.println("Enter new user password:");
				newUserPojo.setPassword(scan.nextLine());
				UserPojo userPojo = userService.register(newUserPojo);
				System.out.println("**********************************");
				System.out.println("User registered successfully!!");
				System.out.println("**********************************");
				System.out.println("Your User ID is : " + userPojo.getUserId());
				accntUserid = newUserPojo.getUserId();
				break;
				
			case 3:
				System.out.println("*******************************************************************");
				System.out.println("Thank you for using BANKING APPLICATION!!");
				System.out.println("*******************************************************************");
				System.exit(0);
				
			}
			

			}
		}
	}
