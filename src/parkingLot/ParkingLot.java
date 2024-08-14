package parkingLot;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingLot {

	private List<Vehicle> vehicles = new ArrayList<>();
	private List<Ledger> ledger = new ArrayList<>();
	private List<Ledger> transaction = new ArrayList<>();

	private char[][] parkingLotLayout;
	int emptyLots, occupiedLots, total;
	private int currentRow; // Current row position of the vehicle
	private int currentCol; // Current column position of the vehicle
	char symbolToHit = ' ';
	boolean bool = false;

	private int width, length;

	public ParkingLot(int length, int width) {
		// Initialize the parking lot layout based on the provided length and width
		initializeLayout(length, width);
		this.setEmptyLots(width);
		this.length = length;
		this.width = width;
	}

	public List<Ledger> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Ledger> transaction) {
		this.transaction = transaction;
	}

	public List<Ledger> getLedger() {
		return ledger;
	}

	public void setLedger(List<Ledger> ledger) {
		this.ledger = ledger;
	}

	public List<Vehicle> getParkedVehicles() {
		return vehicles;
	}

	public void setParkedVehicles(List<Vehicle> parkedVehicles) {
		this.vehicles = parkedVehicles;
	}

	public char[][] getParkingLotLayout() {
		return parkingLotLayout;
	}

	public void setParkingLotLayout(char[][] parkingLotLayout) {
		this.parkingLotLayout = parkingLotLayout;
	}

	public int getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}

	public int getCurrentCol() {
		return currentCol;
	}

	public void setCurrentCol(int currentCol) {
		this.currentCol = currentCol;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getEmptyLots() {
		return emptyLots;
	}

	public void setEmptyLots(int emptyLots) {
		this.emptyLots = emptyLots;
	}

	public int getOccupiedLots() {
		return occupiedLots;
	}

	public void setOccupiedLots(int occupiedLots) {
		this.occupiedLots = occupiedLots;
	}

	private void initializeLayout(int length, int width) {
		// Create and populate the parking lot layout based on your specified rules
		parkingLotLayout = new char[length][width];

		// Set the boundaries ('|' and '-') for the parking lot layout
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				if (i == 0 || i == length - 1 || j == 0 || j == width - 1) {
					parkingLotLayout[i][j] = '|'; // Boundary
				} else if (i % 2 == 0 && j % 2 == 0) {
					parkingLotLayout[i][j] = 'P'; // Parking spot
				} else if (i % 2 == 1 && j % 2 == 1) {
					parkingLotLayout[i][j] = '~'; // Driveway
				} else {
					parkingLotLayout[i][j] = '.'; // Empty space
				}
			}
		}

		// 3rd row

		//
		for (int i = 0; i < length; i++) {
			if (i == 0 || i == (width - 1)) {
				continue;
			} else if (i == 1 || i == (width - 2)) {

				//
				for (int j = 1; j < width - 1; j++) {
					if (j % 2 == 0) {
						parkingLotLayout[i][j] = '~';
					} else {
						parkingLotLayout[i][j] = '~';

					}
				}

			} else if (i == 2 || i == (width - 3)) {
				//
				for (int j = 1; j < width - 1; j++) {
					if (j % 2 == 0) {
						parkingLotLayout[i][j] = '~';
					} else {
						parkingLotLayout[i][j] = 'P';

					}
				}
			} else {
				//
				for (int j = 1; j < width - 1; j++) {
					if (j % 2 == 0) {
						parkingLotLayout[i][j] = '~';
					} else {
						parkingLotLayout[i][j] = '.';

					}
				}
			}
		}

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				if (j == 0 || j == (width - 1)) {
					parkingLotLayout[i][j] = '|';
				}
			}
		}


	

//	    length = row
		// first row
		for (int i = 0; i < width; i++) {
			if (i == 0 || i == (width - 1)) {
				continue;
			} else {
				parkingLotLayout[0][i] = '-';
			}
		}
		// last row
		for (int i = 0; i < width; i++) {
			if (i == 0 || i == (width - 1)) {
				continue;
			} else {
				parkingLotLayout[length - 1][i] = '-';
			}
		}

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				if (!(j == 0 || j == (width - 1)) && (i == length - 2)) {
					parkingLotLayout[i][j] = '~';
				}
			}
		}

		if ((width != length) && (length % 2 != 0)) {
			for (int i = 0; i < length; i++) {
				for (int j = 1; j < width - 1; j++) {

				if (i == length - 3) {
//					for (int j = 1; j < width - 1; j++) {
						if (j % 2 == 0) {
							parkingLotLayout[i][j] = '~';
						} else {
							parkingLotLayout[i][j] = '.';

						}
					}
				}
			}
		}
		
		
		for(int i=0; i<length; i++)
		{
			if((i>=2) && (i<=length-3)) 
			{
				for (int j = 1; j < width - 1; j++) {
					if (j % 2 == 0) {
						parkingLotLayout[i][j] = '~';
					} else {
						parkingLotLayout[i][j] = '.';

					}
				}
			}
		}
		
		for(int i=0; i<length; i++)
		{
			for(int j=0; j<width; j++) 
			{
				if(i == 2 || i == (length - 3))
			    {
					if((j!=0) || (j!=width-1)) 
					{
						if (j % 2 == 0) {
							parkingLotLayout[i][j] = '~';
						} else {
							parkingLotLayout[i][j] = 'P';

						}
					}
			    }
			}
		}
		
		

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				if (j == 0 || j == (width - 1)) {
					parkingLotLayout[i][j] = '|';
				}
			}
		}
		
		for (int i = 0; i < width; i++) {
			if (i == 0 || i == (width - 1)) {
				continue;
			} else {
				parkingLotLayout[length - 1][i] = '-';
			}
		}
		
		int firstDoorX = 1;
		int firstDoorY = 0;
		int secondDoorX = length - 2;
		int secondDoorY = width - 1;

		parkingLotLayout[firstDoorX][firstDoorY] = 'D';
		parkingLotLayout[secondDoorX][secondDoorY] = 'D';

	}

	public void displayLayout() {
		if (parkingLotLayout == null) {
			System.out.println("Parking Lot layout is not available.");
			return;
		}

		for (int row = 0; row < parkingLotLayout.length; row++) {
			for (int col = 0; col < parkingLotLayout[row].length; col++) {
				System.out.print(parkingLotLayout[row][col]);
			}
			System.out.println(); // Move to the next row
		}
	}

	@SuppressWarnings("resource")
	public boolean checkIn() {
		Scanner scanner = new Scanner(System.in);

		if (total > occupiedLots) {
			System.out.print("Vehicle Type (car   |    bike   |    motorbike   |    truck): ");
			String vehicleType = scanner.nextLine().trim().toLowerCase();

			if (!vehicleType.equals("car") && !vehicleType.equals("bike") && !vehicleType.equals("truck")
					&& !vehicleType.equals("motorbike")) {
				System.out.println(
						"Invalid vehicle type.\n" + "Vehicle Type should be 'car', 'bike', 'motorbike' or 'truck'.\n"
								+ "Press any key to return to the parking lot menu\r\n" + "> ");
				return false; // Error occurred, return false
			}

			System.out.print("> Regn Id:        ");
			String regId = scanner.nextLine();
			if (regId.length() != 6) {
				System.out.println("Invalid Registration Id. Registration Id should be of length 6.\n"
						+ "Press any key to return to the parking lot menu\r\n" + "> ");
				return false; // Error occurred, return false
			}
			System.out.print("> Vehicle Model:  ");
			String model = scanner.nextLine();
			System.out.print("> Vehicle Color:  ");
			String color = scanner.nextLine();

			System.out.print("> Time of entry: (HH:mm format)");
			String time = scanner.nextLine();
			if (!isValidTimeFormat(time)) {
				System.out.println(
						"Invalid Time of Entry format. Time should be in HH:MM format and within valid ranges.\n"
								+ "Press any key to return to the parking lot menu\r\n" + "> ");
				return false; // Error occurred, return false
			}

			// Get and validate date of entry
			System.out.print("> Date of entry: (yyyy-MM-dd format) ");
			String date = scanner.nextLine();
			if (!isValidDateFormat(date)) {
				System.out.println(
						"Invalid Date of Entry format. Date should be in yyyy-MM-dd format and within valid ranges.");
				return false; // Error occurred, exit
			}

			LocalDate dateLocal;
			try {
				dateLocal = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			} catch (Exception e) {
				System.out.println("Invalid Date of Entry format. Date should be in yyyy-MM-dd format.");
				return false; // Error occurred, exit
			}

			System.out.println("> Vehicle Type:   " + vehicleType + "\n> Regn Id:        " + regId
					+ "\n> Vehicle Model:  " + model + "\n> Vehicle Colour: " + color
					+ "\n> Time of entry: (HH:mm format)" + time + "\n> Date of entry: (yyyy-MM-dd format)" + date);

			Vehicle v = null;

			if (vehicleType.matches("car")) {
				v = new Car(vehicleType, regId, model, color, time, 1, 1, dateLocal);
			} else if (vehicleType.matches("bike")) {
				v = new Bike(vehicleType, regId, model, color, time, 1, 1, dateLocal);
			} else if (vehicleType.matches("motorbike")) {
				v = new Motorbike(vehicleType, regId, model, color, time, 1, 1, dateLocal);
			} else if (vehicleType.matches("truck")) {
				v = new Truck(vehicleType, regId, model, color, time, 1, 1, dateLocal);
			}

			ledger.add(new Ledger(v, 0, 0.0, "", dateLocal));

			updateSlotCounts();

			return true; // Check-in successful
		} else {
			System.out.println("The parking is full. Please come back later. Taking you back to main menu.\n");
			return false; // Check-in unsuccessful
		}
	}

	public void park() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("To park a vehicle, provide the details.");
		if (ledger.isEmpty()) {
			System.out.println("No vehicle checked in the parking lot. Returning to the main menu.");
			return;
		}

		System.out.print("Vehicle Type (car   |    bike   |    motorbike   |    truck): ");
		String vehicleType = scanner.nextLine().trim().toLowerCase();

		if (!vehicleType.equals("car") && !vehicleType.equals("bike") && !vehicleType.equals("truck")
				&& !vehicleType.equals("motorbike")) {
			System.out.println(
					"Invalid vehicle type. \n" + "Vehicle Type should be 'Car' , 'Bike', 'Motorbike' or 'Bike'.");
			return;
		}
		System.out.print("> Regn Id:        ");
		String regId = scanner.nextLine();
		if (regId.length() != 6) {
			System.out.println("Invalid Registration Id. \n" + "Registration Id should be of length 6.\n"
					+ "Press any key to return to the parking lot menu\r\n" + "> ");
			return; // Error occurred, return false
		}

		System.out.println("\nHere is the parking lot layout:");
		// Display the parking lot layout
		displayLayout();

		int index = -1;
		boolean check = false;

		for (int i = 0; i < ledger.size(); i++) {
			if (ledger.get(i).getV().getType().matches(vehicleType) && ledger.get(i).getV().getRegID().matches(regId)) {
				index = i;
				check = true;
			}
		}

		// true
		if (check == true) {
			System.out.println("Type w/s/a/d to move the vehicle up/down/left/right or 'q' to exit park mode.");

			Ledger currentVehicle = ledger.get(index);

			while (true) {
				String move = scanner.nextLine().trim().toLowerCase();

				if (move.equals("q")) {
					System.out.println("Exiting park mode and returning to the main menu to checkout.");
					break;
				}

				// Handle vehicle movement
				if (move.equals("w") || move.equals("a") || move.equals("s") || move.equals("d")) {
					moveVehicle(currentVehicle, move);
					displayLayout();
				} else {
					System.out.println("Invalid command. Use w/s/a/d/q.");
				}
			}
		} else {
			System.out.println("Your Reg. ID and/or Type didn't match.\n");
		}
	}

	public void checkout() {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		// Check if the parking lot is empty
		if (ledger.isEmpty()) {
			System.out.println("Invalid command! The parking is empty. Taking you back to the main menu.");
			return;
		}

		System.out.println("Please enter your vehicle details");
		System.out.print("> Vehicle Type (car   |    bike   |    motorbike   |    truck): ");
		String vehicleType = scanner.nextLine().trim().toLowerCase();

		// Validate the vehicle type
		if (!vehicleType.equals("car") && !vehicleType.equals("bike") && !vehicleType.equals("truck")
				&& !vehicleType.equals("motorbike")) {
			System.out.println("The selected vehicle type is not present in the parking lot.");
			return;
		}

		System.out.print("> Regn Id:        ");
		String regId = scanner.nextLine();
		if (regId.length() != 6) {
			System.out.println("Invalid Registration Id. \n" + "Registration Id should be of length 6.\n"
					+ "Press any key to return to the parking lot menu\r\n" + "> ");
			return; // Error occurred, return false
		}

		System.out.print("> Time of exit (HH:mm format): ");
		String exitTimeStr = scanner.nextLine().trim();

		// Parse the exit time as LocalDateTime
		LocalDateTime exitTime;
		try {
			exitTime = LocalDateTime.now().withHour(Integer.parseInt(exitTimeStr.split(":")[0]))
					.withMinute(Integer.parseInt(exitTimeStr.split(":")[1])).withSecond(0);
		} catch (Exception e) {
			System.out.println("Invalid time format. Time should be in HH:mm format.");
			return;
		}

		// Get and validate date of entry
		System.out.print("> Date of exit: (yyyy-MM-dd format) ");
		String date = scanner.nextLine();
		if (!isValidDateFormat(date)) {
			System.out.println(
					"Invalid Date of exit format. Date should be in yyyy-MM-dd format and within valid ranges.");
			return; // Error occurred, exit
		}

		LocalDate dateLocal;
		try {
			dateLocal = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		} catch (Exception e) {
			System.out.println("Invalid Date of Exit format. Date should be in yyyy-MM-dd format.");
			return; // Error occurred, exit
		}

		// Check if the vehicle is parked
		Ledger vehicleToCheckout = null;
		for (Ledger vehicle : ledger) {
			if (vehicle.getV().getRegID().equals(regId) && vehicle.getV().getType().equals(vehicleType)) {
				vehicleToCheckout = vehicle;
				break;
			}
		}

		if (vehicleToCheckout == null) {
			System.out.println("The selected vehicle is not present in the parking lot.");
			return;
		}

		// Calculate the total parking fee and fine
		double parkingFee = calculateParkingFee(vehicleType, vehicleToCheckout.getV().getTimeOfEntry(), exitTime);
		int totalHits = vehicleToCheckout.getHitCount();
		double fine = calculateFine(vehicleType, totalHits);

		// Display the checkout details
		System.out.println("Please verify your details.");
		System.out.println(
				"Total number of hours: " + calculateHours(vehicleToCheckout.getV().getTimeOfEntry(), exitTime));
		System.out.println("Total number of hits: " + totalHits);
		System.out.println("Vehicle Type: " + vehicleType.toUpperCase());
		System.out.println("Regn Id: " + regId);
		System.out.println("Total Parking Fee: $" + (parkingFee + fine));
		vehicleToCheckout.setAmount(parkingFee + fine);

		Ledger l = new Ledger(vehicleToCheckout.getV(), totalHits, (parkingFee + fine), exitTimeStr, dateLocal);

		// Ask the user to accept the fee
		System.out.print("Type 'Y' to accept the fee or 'menu' to return to the main menu\n> ");
		String confirmation = scanner.nextLine().trim().toLowerCase();

		if (confirmation.equals("y")) {
			// Vehicle checkout successful

			parkingLotLayout[vehicleToCheckout.getV().getRow()][vehicleToCheckout.getV().getCol()] = '.';

			transaction.add(l);
			ledger.remove(l);
			updateSlotCounts();
			System.out.println("Thank you for visiting Java Parking Lot. See you next time!");
		} else if (confirmation.equals("menu")) {
			// Return to the main menu
			return;
		} else {
			System.out.println(
					"You cannot checkout your vehicle. Please accept the fee by pressing 'Y' or type 'menu' to return to the main menu and park your vehicle.");
		}

	}

	private boolean isValidTimeFormat(String time) {
		// Split the time on ":" and check if it's in HH:MM format
		String[] parts = time.split(":");
		if (parts.length != 2) {
			return false;
		}

		try {
			int hours = Integer.parseInt(parts[0]);
			int minutes = Integer.parseInt(parts[1]);

			// Check if hours and minutes are within valid ranges
			return (hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59);
		} catch (NumberFormatException e) {
			return false; // Parsing error
		}
	}

	private static boolean isValidDateFormat(String date) {
		try {
			LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			LocalDate minDate = LocalDate.of(1970, 1, 1);
			LocalDate maxDate = LocalDate.of(2099, 12, 31);
			return !parsedDate.isBefore(minDate) && !parsedDate.isAfter(maxDate);
		} catch (Exception e) {
			return false;
		}
	}

	public void updateSlotCounts() {

		occupiedLots = ledger.size();
		emptyLots = (length - 2 - (length - 2) / 2) * (width - 4) - (length - 2 - (length - 2) / 2) * 2;
		if (bool == false) {
			total = emptyLots;
			bool = true;
		}
		System.out.println("Empty Lots: " + (emptyLots - occupiedLots) + " | Occupied: " + occupiedLots);
	}

	/*
	 * 
	 * 
	 */

	private void moveVehicle(Ledger vehicle, String move) {

		int newRow = vehicle.getV().getRow();
		int newCol = vehicle.getV().getCol();

		switch (move) {
		case "w":
			newRow--;
			break;
		case "a":
			newCol--;
			break;
		case "s":
			newRow++;
			break;
		case "d":
			newCol++;
			break;
		}

		if (isValidMove(newRow, newCol)) {
			char targetSymbol = parkingLotLayout[newRow][newCol];

			if (targetSymbol == 'D') {
				System.out.println("You cannot exit the parking lot without checkout.");
				checkout(); // calling checkout method, bcz without parking, we are unable to checkout
			} else if (targetSymbol == 'P') {
				System.out.println("You hit the pillar. There will be a damage fee!");
				vehicle.setHitCount(vehicle.getHitCount() + 1);
			} else {
				if (move.matches("a") || move.matches("d")) {

					//
					if (targetSymbol == '.') {

						parkingLotLayout[vehicle.getV().getRow()][vehicle.getV().getCol()] = '~';
						vehicle.getV().setRow(newRow);
						vehicle.getV().setCol(newCol);
						parkingLotLayout[newRow][newCol] = vehicle.getV().getType().charAt(0);
					}

					// done
					else if (targetSymbol == '~') {
						if (vehicle.getV().getRow() == 1 || vehicle.getV().getRow() == 2
								|| vehicle.getV().getRow() == (length - 2) || vehicle.getV().getRow() == (length - 3)) {
							parkingLotLayout[vehicle.getV().getRow()][vehicle.getV().getCol()] = '~';
							vehicle.getV().setRow(newRow);
							vehicle.getV().setCol(newCol);
							parkingLotLayout[newRow][newCol] = vehicle.getV().getType().charAt(0);
						} else {
							parkingLotLayout[vehicle.getV().getRow()][vehicle.getV().getCol()] = '.';
							vehicle.getV().setRow(newRow);
							vehicle.getV().setCol(newCol);
							parkingLotLayout[newRow][newCol] = vehicle.getV().getType().charAt(0);
						}
					}
				} else if (move.matches("w") || move.matches("s")) {

					if (targetSymbol == '.') {

						if (vehicle.getV().getCol() % 2 != 0) {
							parkingLotLayout[vehicle.getV().getRow()][vehicle.getV().getCol()] = '.';
							vehicle.getV().setRow(newRow);
							vehicle.getV().setCol(newCol);
							parkingLotLayout[newRow][newCol] = vehicle.getV().getType().charAt(0);
						} else {
							parkingLotLayout[vehicle.getV().getRow()][vehicle.getV().getCol()] = '~';
							vehicle.getV().setRow(newRow);
							vehicle.getV().setCol(newCol);
							parkingLotLayout[newRow][newCol] = vehicle.getV().getType().charAt(0);
						}

					}

					//
					else if (targetSymbol == '~') {
						if (vehicle.getV().getCol() % 2 != 0) {
							parkingLotLayout[vehicle.getV().getRow()][vehicle.getV().getCol()] = '.';
							vehicle.getV().setRow(newRow);
							vehicle.getV().setCol(newCol);
							parkingLotLayout[newRow][newCol] = vehicle.getV().getType().charAt(0);
						} else {
							parkingLotLayout[vehicle.getV().getRow()][vehicle.getV().getCol()] = '~';
							vehicle.getV().setRow(newRow);
							vehicle.getV().setCol(newCol);
							parkingLotLayout[newRow][newCol] = vehicle.getV().getType().charAt(0);
						}
					}
				}
			}
		} else {

			if ((symbolToHit == '|') || (symbolToHit == '-')) {
				System.out.println("You have hit the wall. There will be a damage fee!");
				vehicle.setHitCount(vehicle.getHitCount() + 1);
			} else if ((symbolToHit == 'm') || (symbolToHit == 'b') || (symbolToHit == 't') || (symbolToHit == 'c')) {
				System.out.println("You hit the vehicle. There will be a damage fee!");
				vehicle.setHitCount(vehicle.getHitCount() + 1);
			}
		}
	}

	private boolean isValidMove(int newRow, int newCol) {
		// Check if the new position is within the parking lot boundaries
		if (newRow >= 0 && newRow < parkingLotLayout.length && newCol >= 0 && newCol < parkingLotLayout[0].length) {
			// Check if the new position is not a wall ('|' or '-')
			if (parkingLotLayout[newRow][newCol] != '|' && parkingLotLayout[newRow][newCol] != '-') {
				return true;
			}
		}
		symbolToHit = parkingLotLayout[newRow][newCol];
		return false;
	}

	private double calculateParkingFee(String vehicleType, String entryTimeStr, LocalDateTime exitTime) {
		// Parse entryTimeStr to LocalTime
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime entryTime = LocalTime.parse(entryTimeStr, formatter);

		// Calculate the duration in hours
		LocalDateTime entryDateTime = LocalDateTime.of(LocalDate.now(), entryTime);

		// Check if exitTime is before entryTime on the next day (crosses midnight)
		if (exitTime.isBefore(entryDateTime)) {
			exitTime = exitTime.plusDays(1); // Add one day to exitTime
		}

		Duration duration = Duration.between(entryDateTime, exitTime);
		long hours = duration.toHours();

		double hourlyRate = 0.0;

		// Define the hourly rates based on vehicle type
		switch (vehicleType) {
		case "bike":
			hourlyRate = 2.0;
			break;
		case "motor bike":
			hourlyRate = 3.0;
			break;
		case "motorbike":
			hourlyRate = 3.0;
			break;
		case "car":
			hourlyRate = 4.0;
			break;
		case "truck":
			hourlyRate = 10.0;
			break;
		default:
			// Handle invalid vehicle type
			break;
		}

		return hours * hourlyRate;
	}

	private double calculateFine(String vehicleType, int totalHits) {

		double hitFee = 0.0;

		// Define hit fees based on vehicle type
		switch (vehicleType) {
		case "bike":
			hitFee = 0.01;
			break;
		case "motor bike":
			hitFee = 0.02;
			break;
		case "car":
			hitFee = 0.1;
			break;
		case "truck":
			hitFee = 0.2;
			break;
		default:
			// Handle invalid vehicle type
			break;
		}
		return totalHits * hitFee;
	}

	private String calculateHours(String entryTime, LocalDateTime exitTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime parsedEntryTime = LocalTime.parse(entryTime, formatter);

		LocalDateTime entryDateTime = LocalDateTime.of(LocalDate.now(), parsedEntryTime);

		// Check if exitTime is before entryTime on the next day (crosses midnight)
		if (exitTime.isBefore(entryDateTime)) {
			exitTime = exitTime.plusDays(1); // Add one day to exitTime
		}

		Duration duration = Duration.between(entryDateTime, exitTime);
		long hours = duration.toHours();
		long minutes = duration.toMinutesPart();

		// Format the hours and minutes as HH:mm
		String formattedHours = String.format("%02d", hours);
		String formattedMinutes = String.format("%02d", minutes);

		return formattedHours + ":" + formattedMinutes;
	}

	public void parkingfeelog() {

		System.out.println("============ Here are the Transaction logs for the Java Parking Lot =============");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("| Vehicle Type | Registration Id |  Entry DateTime  | Exit DateTime | Parking Fee |");
		System.out.println("-----------------------------------------------------------------------------------");

		if (transaction.isEmpty()) {
			System.out.println("\n**************************************");
			System.out.println("|    No Transaction Record Found.    |");
			System.out.println("**************************************\n");
			return;
		}

		for (int i = 0; i < transaction.size(); i++) {
			System.out.println(transaction.get(i).getV().getType() + "             "
					+ transaction.get(i).getV().getRegID() + "            " + transaction.get(i).getV().getTimeOfEntry()
					+ " " + transaction.get(i).getV().getDate() + "   " + transaction.get(i).getExitTime() + " "
					+ transaction.get(i).getDate() + "      " + transaction.get(i).getAmount());
		}

	}

}
