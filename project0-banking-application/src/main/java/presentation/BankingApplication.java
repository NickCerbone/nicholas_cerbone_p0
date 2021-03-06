package presentation;

import java.util.Scanner;

import exceptions.FundsException;
import exceptions.SystemException;
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

		Scanner scan = new Scanner(System.in);

		int option = 0;

		while (true) {
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
			AccountPojo accountPojo = new AccountPojo();
			switch (option) {
			case 1:
				UserPojo userLoginPojo = new UserPojo();

				System.out.println("Enter user id:");
				userLoginPojo.setUserId(Integer.parseInt(scan.nextLine()));

				System.out.println("Enter user password:");
				userLoginPojo.setPassword(scan.nextLine());

				try {
					if (userService.validateUser(userLoginPojo) == null) {
						System.out.println("login failed");
						break;
					}
				} catch (SystemException e) {
					System.out.println(e.getMessage());
					break;
				}

				while (true) {
					System.out.println("**********************************");
					System.out.println("CUSTOMER MENU:");
					System.out.println("**********************************");
					System.out.println("1. View bank balance");
					System.out.println("2. Withdraw");
					System.out.println("3. Deposit");
					System.out.println("4. Log out");
					System.out.println("*****************************");
					System.out.println("Please enter an option:");
					int option2 = scan.nextInt();

					switch (option2) {
					case 1:
						System.out.println("your current balance is: ");
						try {
							System.out.println("$" + accountService.viewBalance(userLoginPojo.getUserId()));
						} catch (SystemException e1) {
							System.out.println(e1.getMessage());
							break;
						}
						System.out.println("*****************************");
						break;
					case 2:
						System.out.println("*****************************");
						System.out.println("Please enter withdraw amount :");
						accountPojo.setWithdrawAmount(scan.nextDouble());
						try {
							accountService.withdrawFunds(accountPojo, userLoginPojo.getUserId());
						} catch (FundsException fe) {
							System.out.println(fe.getMessage());
							break;
						} catch (SystemException e) {
							System.out.println(e.getMessage());
							break;
						}
						System.out.println("*****************************");
						System.out.println("withdraw made successfully...");
						System.out.println("*****************************");
						break;
					case 3:
						System.out.println("*****************************");
						System.out.println("Please enter deposit amount :");
						accountPojo.setDepositAmount(scan.nextDouble());
						try {
							accountService.depositFunds(accountPojo, userLoginPojo.getUserId());
						} catch (SystemException e) {
							System.out.println(e.getMessage());
							break;
						}
						System.out.println("*****************************");
						System.out.println("deposit made successfully...");
						System.out.println("*****************************");
						break;
					case 4:
						System.out.println("*******************************************************************");
						System.out.println("Thank you for using Banking Application!!");
						System.out.println("*******************************************************************");
						System.exit(0);
						break;
					default:
					}
				}
			case 2:
				UserPojo newUserPojo = new UserPojo();
				System.out.println("Enter new user password:");
				newUserPojo.setPassword(scan.nextLine());
				try {
					userService.register(newUserPojo);
				} catch (SystemException e) {
					System.out.println(e.getMessage());
					break;
				}
				System.out.println("**********************************");
				System.out.println("User registered successfully!!");
				try {
					System.out.println("user id: " + userService.getDbUserId(newUserPojo.getPassword()));
					accountPojo.setUserId(userService.getDbUserId(newUserPojo.getPassword()));
				} catch (SystemException e) {
					System.out.println(e.getMessage());
					break;
				}

				System.out.println("**********************************");
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
