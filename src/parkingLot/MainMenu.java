package parkingLot;

import java.util.Scanner;

public class MainMenu {

	private static ParkingLot parkingLot;
	private Scanner scanner;

	public MainMenu() {
		parkingLot = null; // Initialize parkingLot as null
		this.scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {

		// welcome text
		displayWelcomeText();

	}

	public static void displayWelcomeText() {

		MainMenu m = new MainMenu();

		System.out.println("****************************************************\n"
				+ "|                    Welcome to                    |\n"
				+ "|                   Java Parking                   |\n"
				+ "****************************************************");

		System.out.println("Empty Lots: [" + 0 + "] | Occupied: [" + 0 + "]\r\n"
				+ "Please enter a 'commands' to continue.\r\n" + "Type 'help' to learn how to get started.\r\n" + ">");

		Scanner scanner = new Scanner(System.in);

		while (true)

		{
			String command = scanner.nextLine().trim().toLowerCase();

			switch (command) {
			case "help":
				m.displayHelpMenu();
				break;
			case "commands":
				m.displayCommands();
				break;
			case "menu":
				m.displayMainMenu();
				break;
			case "parkinglot":
				m.handleParkingLotSubMenu();
				break;
			case "checkin":
				// Handle adding car details while entering the parking lot
				m.checkIn();
				break;
			case "park":
				m.park();
				break;
			case "parkingfeelog":
				m.parkingfeelog();
				break;
			case "exit":
				System.out.println("Good bye from the Java Parking Lot! See you next time!\r\n");
				scanner.close();
				return;
			default:
				System.out.println("Command not found!");
				break;
			}
		}
	}

	public void displayHelpMenu() {
		System.out.println("Type 'commands' to list all the available commands\r\n"
				+ "Type 'menu' to return to the main menu" + "\n" + "> ");
	}

	public void displayCommands() {

		System.out.println("help: shows you list of commands that you can use.\r\n"
				+ "parkinglot: initialise the space for parking lot or view the layout of parking lot.\n"
				+ "checkin: add your car details while entering the parking lot.\n"
				+ "park: park your car to one of the empty spot.\n"
				+ "parkingfeelog: view the transaction log for parking lot.\n" + "exit: To exit the program.\n"
				+ "Type 'commands' to list all the available commands\n" + "Type 'menu' to return to the main menu\n"
				+ ">");
	}

	public void displayMainMenu() {
		if (parkingLot == null) {
			System.out.println("Please enter 'commands' to continue.\r\n" + "Type 'help' to learn how to get started."
					+ "\n" + "> ");
		} else
			parkingLot.updateSlotCounts();
		System.out.println(
				"Please enter 'commands' to continue.\r\n" + "Type 'help' to learn how to get started." + "\n" + "> ");
	}

	public void parkingLot() {
		System.out.println("Type 'init' to initialize the parking space\n"
				+ "Type 'view' to view the layout of the parking space\n" + "Type 'menu' to return to the main menu\r\n"
				+ "> ");
	}

	private void handleParkingLotSubMenu() {
		if (parkingLot == null) {
			parkingLot();
		} else {
			System.out.println(
					"There are vehicles in the Parking Lot, you cannot change the space of the parking lot at the moment.\n"
							+ "Type 'menu' to return to the main menu\r\n" + "> ");
		}

		while (true) {
			String subCommand = scanner.nextLine().trim().toLowerCase();

			if (subCommand.equals("init")) {
				if (parkingLot == null) {
					// Initialize the parking lot here
					System.out.println("Please enter the length of the parking lot:");
					int length = Integer.parseInt(scanner.nextLine().trim());
					System.out.println("Please enter the width of the parking lot:");
					int width = Integer.parseInt(scanner.nextLine().trim());

					if (length < 5 || width < 5) {
						System.out.println("Parking Lot size cannot be less than 5. Goodbye!");
						System.exit(0);
					}

					// Create and initialize the parking lot
					parkingLot = new ParkingLot(length, width);
					System.out.println("Parking Lot Space is setup. Here is the layout -");
					parkingLot.displayLayout();
					System.out.println("Press any key to return to parkinglot menu\r\n");
					parkingLot();
				} else {
					System.out.println(
							"There are vehicles in the Parking Lot, you cannot change the space of the parking lot at the moment.\n"
									+ "Type 'menu' to return to the main menu\r\n" + "> ");
				}
			} else if (subCommand.equals("view")) {
				if (parkingLot != null) {
					// Display the parking lot layout
					parkingLot.displayLayout();
					System.out.println("Press any key to return to parkinglot menu\r\n");
					parkingLot();
				} else {
					System.out.println("The parking lot is not initialized. Please run 'init'.\n"
							+ "Type 'menu' to return to the main menu\r\n" + "> ");
				}
			} else if (subCommand.equals("menu")) {
				displayMainMenu();
				return; // Return to the main menu
			} else {
				System.out.println("Command not found!\n");
				parkingLot();
			}
		}
	}

	public void checkIn() {
		if (parkingLot == null) {
			System.out.println("The parking lot is not initialized. Please run 'init'.\n"
					+ "Type 'menu' to return to the main menu\r\n" + "> ");
		} else {
			parkingLot.checkIn();

			displayMainMenu();
		}
	}

	public void park() {
		if (parkingLot == null) {
			System.out.println("The parking lot is not initialized. Please run 'init'.\n"
					+ "Type 'menu' to return to the main menu\r\n" + "> ");
		} else {
			parkingLot.park();

			displayMainMenu();
		}
	}
	
	public void parkingfeelog() {
		if (parkingLot == null) {
			System.out.println("The parking lot is not initialized. Please run 'init'.\n"
					+ "Type 'menu' to return to the main menu\r\n" + "> ");
		} else {
			parkingLot.updateSlotCounts();

			parkingLot.parkingfeelog();

			displayMainMenu();
		}
	}
}