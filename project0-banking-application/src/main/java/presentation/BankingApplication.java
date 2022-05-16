package presentation;

import java.util.Scanner;
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

			switch (option) {
			case 1:
				UserPojo userLoginPojo = new UserPojo();
				System.out.println("Enter user id:");
				userLoginPojo.setUserId(Integer.parseInt(scan.nextLine()));
				System.out.println("Enter user password:");
				userLoginPojo.setPassword(scan.nextLine());

				UserPojo returnedLoginUserPojo = null;

				returnedLoginUserPojo = userService.validateUser(userLoginPojo);

				// not sure if this is necessary
				if (returnedLoginUserPojo != null) {
					System.out.println("**********************************");
					System.out.println("Customer Login successfull!!");
					System.out.println("Display Customer Menu.");
					System.out.println("**********************************");
				} else {
					System.out.println("**********************************");
					System.out.println("Login failed!!");
					System.out.println("**********************************");
					break;
				}

				char proceed = 'y';
				while (proceed == 'y') {
					System.out.println("1. View bank balance");
					System.out.println("2. Withdraw");
					System.out.println("3. Deposit");
					System.out.println("4. Log out");
					System.out.println("*****************************");
					System.out.println("Please enter an option:");
					int option2 = scan.nextInt();
					System.out.println("*****************************");

					int loginUserId = userLoginPojo.getUserId();

					switch (option2) {
					case 1:
						System.out.println("your current balance is: ");
						System.out.println("$" + accountService.viewBalance(loginUserId));
						System.out.println("*****************************");
						break;

					case 2: // withdraw
						System.out.println("*****************************");
						System.out.println("Please enter withdraw amount :");
						Double withdrawAmount = scan.nextDouble();
						accountService.withdrawFunds(loginUserId, withdrawAmount);
						System.out.println("*****************************");
						System.out.println("withdraw made successfully...");
						System.out.println("*****************************");
						break;

					case 3: // deposit
						System.out.println("*****************************");
						System.out.println("Please enter deposit amount :");
						Double depositAmount = scan.nextDouble();
						accountService.depositFunds(loginUserId, depositAmount);
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
				UserPojo userPojo = userService.register(newUserPojo);
				System.out.println("**********************************");
				System.out.println("User registered successfully!!");
				System.out.println("user id: " + accountService.getDbUserId(newUserPojo.getPassword()));
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
