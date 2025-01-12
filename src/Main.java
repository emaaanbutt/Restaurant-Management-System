import vendor.Vendor;
import customerpackage.Customer;
import reservationsystem.Reservation;
import reservationsystem.ReservationSystem;
import restaurant.Table;
import inventory.Inventory;
import employee.Employee;
import employee.Manager;
import employee.ManagerService;
import employee.Waiter;
import employee.WaiterFileHandler;
import employee.Receptionist;
import employee.ReceptionistBusinessLogic;
import employee.Chef;
import employee.ChefBusinessLogic;
import menu.Menu;
import billing.Bill;
import cart.Cart;
import branch.Branch;
import branch.Restaurant;
import authentication.Login;
import vendor.VendorBusinessLogic;


import java.io.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    static ArrayList<Manager> managers = new ArrayList<>();
    static ArrayList<Waiter> waiters = new ArrayList<>();
    static ArrayList<Receptionist> receptionists = new ArrayList<>();
    static ArrayList<Chef> chefs = new ArrayList<>();
    static ArrayList<Branch> branches = new ArrayList<>();




    private static ReservationSystem reservationSystem = new ReservationSystem();

    private static String reservationDateString;


    public static <PaymentDetails> void main(String[] args) throws IOException, ClassNotFoundException {


//        Branch branch1 = new Branch("Delight", "Lahore");
//        Branch branch2 = new Branch("Delight", "Islamabad");
//        Branch branch3 = new Branch("Delight", "Rawalpindi");
//        Branch branch4 = new Branch("Delight", "Faisalabad");
//        Branch branch5 = new Branch("Delight", "Gujranwala");
//
//        branches.add(branch1);
//        branches.add(branch2);
//        branches.add(branch3);
//        branches.add(branch4);
//        branches.add(branch5);
//
//        Restaurant restaurant1 = new Restaurant("Delight", branches);
//
//        displayLoginMenu();
//        displayNotification();
//        displayMenu();
//        displayEmployees();
//        displayEmployeeMenu();
//        reservationSystem();
//
//
//        displayLoginMenu();
addManager();
displayManagers();
    }

    private static void displayNotification() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Inventory> inventoryArrayList = new ArrayList<>();
        ListIterator<Inventory> li;
        File file = new File("Inventory.txt");
        boolean notification = false;

        try {
            if (file.isFile()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                inventoryArrayList = (ArrayList<Inventory>) ois.readObject();
                ois.close();

                li = inventoryArrayList.listIterator();
                System.out.println("Notifications");
                System.out.println("_____________________________________________________________________________________________________________________");

                while (li.hasNext()) {
                    inventory.Inventory line = li.next();
                    if (line.getFoodItemQuantity() <= 10) {
                        notification = true;
                        System.out.println("* " + line.getFoodItemName() + " is short in Inventory. Please restock. Available Stock ( " + line.getFoodItemQuantity() + " )");
                    }
                }

                if (!notification) {
                    System.out.println("No notification from Inventory. All items are stocked.");
                }
                System.out.println("_____________________________________________________________________________________________________________________");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static <IOException> void displayMenu() throws java.io.IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Menu Operations");
            System.out.println("2. Inventory Operations");
            System.out.println("3. Place Order");
            System.out.println("4. Display Employee Menu ");
            System.out.println("5. Vendor Operations ");
            System.out.println("6. Reservation Operations");
            System.out.println("7. Exit");
            System.out.print("Enter your choice:");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    displayMenuOperations();
                    break;
                case 2:
                    displayInventoryOperations();
                    break;
                case 3:
                    placeOrder();
                    break;
                case 4:
                    displayEmployeeMenu();
                    break;
                case 5:
                    VenderOperation();
                    break;
                case 6:
                    reservationSystem();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }} while (choice != 6);
    }


    // Displaying menu options
    private static void displayEmployeeMenu() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEmployee Menu:");
            System.out.println("1. Manager Operations");
            System.out.println("2. Waiter Operations");
            System.out.println("3. Receptionist Operations");
            System.out.println("4. Chef Operations");
            System.out.println("5. Display Employees ");
            System.out.println("6. Back to Menu");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    managerOperations();
                    break;
                case 2:
                    waiterOperations();
                    break;
                case 3:
                    receptionistOperations();
                    break;
                case 4:
                    chefOperations();
                    break;
                case 5:
                    displayEmployees();
                    break;
                case 6:
                    displayMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);
    }

    private static void addAuthentication(String employeeType)
    {
        Scanner sc=new Scanner(System.in);
        Login login=new Login();
        String newUsername;
        String newPassword;
        System.out.println("\nAuthenticate new employee...");
        System.out.print("Enter new username: ");
        newUsername=sc.next();
        System.out.print("Enter new password: ");
        newPassword=sc.next();
        login.addAuthenticationData(employeeType,newUsername,newPassword);
    }



    private static void displayEmployees() {

        displayManagers();
        displayWaiters();
        displayReceptionists();
        displayChefs();
    }



    private static void managerOperations() {
        Scanner sc = new Scanner(System.in);
        int managerChoice;

        do {
            System.out.println("\nManager Operations:");
            System.out.println("1. Add Manager");
            System.out.println("2. Update Manager");
            System.out.println("3. Remove Manager");
            System.out.println("4. Display Managers");
            System.out.println("5. Check Salary");
            System.out.println("6. Back to Employee Menu");
            System.out.print("Enter your choice: ");
            managerChoice = sc.nextInt();

            switch (managerChoice) {
                case 1:
                    addManager();
                    break;
                case 2:
                    updateManager();
                    break;
                case 3:
                    removeManager();
                    break;
                case 4:
                    displayManagers();
                    break;
                case 5:
                    checkSalary();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (managerChoice != 6);
    }

    private static Manager findManagerByName(ArrayList<Manager> managers, String name) {
        for (Manager manager : managers) {
            if (manager.getName().equalsIgnoreCase(name)) {
                return manager;
            }
        }
        return null;
    }

    private static void checkSalary() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Manager name to check the salary: ");
        String name = sc.nextLine();

        Manager manager = findManagerByName(managers, name);
        if (manager != null) {
            double salary = manager.calculateSalary();
            System.out.println("Salary of Manager " + manager.getName() + ": " + salary);
        } else {
            System.out.println("Manager not found.");
        }
    }

    private static void addManager() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nAdding Manager....");

        String name;
        do {
            System.out.print("Enter Manager Name: ");
            name = sc.nextLine();
            if (employeeExists(name, managers)) {
                System.out.println("Username already exists. Please choose a different one.");
            }
        } while (employeeExists(name, managers));

        // Get and validate Manager Password
        System.out.print("Enter Manager Age: ");
        int age = sc.nextInt();

        // Get and validate Manager Department
        System.out.print("Enter Manager Department: ");
        String department = sc.next();

        Manager newManager = new Manager(name,age ,department);
        managers.add(newManager);
        ManagerService.writeManagersToFile(managers);
        System.out.println("Manager added successfully.");
        addAuthentication("Manager");
    }

    private static boolean employeeExists(String name, ArrayList<? extends Employee> employees) {
        for ( Employee employee: employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    private static void updateManager() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Manager name to Update: ");
        String name = sc.nextLine();

        Manager existingManager = findManagerByName(managers, name);
        if (existingManager != null) {
            if (employeeExists(name, managers)) {
                System.out.print("Enter New Salary: ");
                double newSal = sc.nextDouble();
                existingManager.setBaseSalary(newSal);

                ManagerService.writeManagersToFile(managers);
                System.out.println("Manager information updated successfully.");
            } else {
                System.out.println("Manager not found.");
            }
        } else {
            System.out.println("Manager not found.");
        }
    }

    private static void removeManager() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Manager name to Remove: ");
        String name = sc.nextLine();

        Manager existingManager = findManagerByName(managers, name);
        if (existingManager != null) {
            if (employeeExists(name, managers)) {
                managers.remove(existingManager);
                ManagerService.writeManagersToFile(managers);
                System.out.println("Manager removed successfully.");
            } else {
                System.out.println("Manager not found.");
            }
        } else {
            System.out.println("Manager not found.");
        }
    }

    private static void displayManagers() {
        managers = ManagerService.readManagersFile();
        System.out.println("\nManagers");
        System.out.println("_____________________________________________________________________________________________________________________");
        for (Manager manager : managers) {
            System.out.println(manager.toString());
        }
        System.out.println("_____________________________________________________________________________________________________________________\n");
    }



    private static void waiterOperations() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        int waiterChoice;

        do {
            System.out.println("\nWaiter Operations:");
            System.out.println("1. Add Waiter");
            System.out.println("2. Update Waiter");
            System.out.println("3. Remove Waiter");
            System.out.println("4. Display Waiters");
            System.out.println("5. Check Waiter salary");
            System.out.println("6. Back to Employee Menu");
            System.out.print("Enter your choice: ");
            waiterChoice = sc.nextInt();

            switch (waiterChoice) {
                case 1:
                    addWaiter();
                    break;
                case 2:
                    updateWaiter();
                    break;
                case 3:
                    removeWaiter();
                    break;
                case 4:
                    displayWaiters();
                    break;
                case 5:
                    checkWaiterSalary();
                    break;
                case 6:
                    displayEmployeeMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (waiterChoice != 6);
    }

    private static void checkWaiterSalary() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Waiter name to check the salary: ");
        String name = sc.nextLine();

        Waiter waiter = findWaiterByName( waiters,name);
        if (waiter != null) {
            double salary = waiter.calculateSalary();
            System.out.println("Salary of Waiter " + waiter.getName() + ": " + salary);
        } else {
            System.out.println("Waiter not found.");
        }
    }
    private static Waiter findWaiterByName(ArrayList<Waiter> waiters,String name) {
        for (Waiter waiter : waiters) {
            if (waiter.getName().equalsIgnoreCase(name)) {
                return waiter;
            }
        }
        return null;
    }



    private static void addWaiter() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nAdding Waiter..");

        String name;
        do {
            System.out.print("Enter Waiter name : ");
            name = sc.nextLine();
            if (employeeExists(name, waiters)) {
                System.out.println("Name already exists. Please choose a different one.");
            }
        } while (employeeExists(name, waiters));


        System.out.print("Enter Age : ");
        int age = sc.nextInt();

        System.out.print("Enter Waiter working hours : ");
        int hoursWorked = sc.nextInt();

        Waiter newWaiter = new Waiter(name,age,hoursWorked);
        waiters.add(newWaiter);
        WaiterFileHandler.writeWaitersToFile(waiters);
        System.out.println("Waiter added successfully.");
        addAuthentication("Waiter");
    }

    private static void updateWaiter() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Update Waiter:");

        String name;
        do {
            System.out.print("Enter Waiter name to Update: ");
            name = sc.nextLine();
            if (!employeeExists(name, waiters)) {
                System.out.println("Waiter not found. Please enter a valid username.");
            }
        } while (!employeeExists(name, waiters));

        // Proceed with updating Waiter
        Waiter existingWaiter = findWaiterByName(waiters,name);

        System.out.print("Enter new working hours : ");
        int newHoursWorked = sc.nextInt();
        existingWaiter.setHoursWorked(newHoursWorked);
        existingWaiter.setSalary(existingWaiter.calculateSalary());
        WaiterFileHandler.writeWaitersToFile(waiters);

        System.out.println("Waiter information updated successfully.");
    }

    private static void removeWaiter() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Waiter name to Remove: ");
        String name = sc.nextLine();

        Waiter existingWaiter = findWaiterByName(waiters,name);
        if (existingWaiter != null) {
            if (employeeExists(name, waiters)) {
                waiters.remove(existingWaiter);
                WaiterFileHandler.writeWaitersToFile(waiters);
                System.out.println("Waiter removed successfully.");
            } else {
                System.out.println("Waiter not found.");
            }
        } else {
            System.out.println("Waiter not found.");
        }
    }

    private static void displayWaiters() {
        waiters = WaiterFileHandler.readWaitersFile();
        System.out.println("\nWaiters");
        System.out.println("_____________________________________________________________________________________________________________________");
        for (Waiter waiter : waiters) {
            System.out.println(waiter.toString());
        }
        System.out.println("_____________________________________________________________________________________________________________________\n");
    }

    private static void receptionistOperations() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        int receptionistChoice;

        do {
            System.out.println("\nReceptionist Operations:");
            System.out.println("1. Add Receptionist");
            System.out.println("2. Update Receptionist");
            System.out.println("3. Remove Receptionist");
            System.out.println("4. Check Salary");
            System.out.println("5. Display Receptionists");
            System.out.println("6. Back to Employee Menu");
            System.out.print("Enter your choice: ");
            receptionistChoice = sc.nextInt();

            switch (receptionistChoice) {
                case 1:
                    addReceptionist();
                    break;
                case 2:
                    updateReceptionist();
                    break;
                case 3:
                    removeReceptionist();
                    break;
                case 4:
                    checkSalaryforReceptionist();
                    break;
                case 5:
                    displayReceptionists();
                    break;
                case 6:
                    displayEmployeeMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (receptionistChoice != 6);
    }

    private static void checkSalaryforReceptionist() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Receptionist name to check the salary: ");
        String name = sc.nextLine();

        Receptionist receptionist = findReceptionistByName(receptionists,name);
        if (receptionist != null) {
            double salary = receptionist.calculateSalary();
            System.out.println("Salary of Receptionist " + receptionist.getName() + ": " + salary);
        } else {
            System.out.println("Receptionist not found.");
        }
    }

    private static void addReceptionist() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nAdding Receptionist...");

        String name;
        do {
            System.out.print("Enter Receptionist name : ");
            name = sc.nextLine();
            if (employeeExists(name, receptionists)) {
                System.out.println("Name already exists. Please choose a different one.");
            }
        } while (employeeExists(name, receptionists));


        System.out.print("Enter Age : ");
        int age = sc.nextInt();

        System.out.print("Enter shift (Morning/Evening/Night) : ");
        String shift = sc.next();

        System.out.print("Enter  working hours : ");
        int hoursWorked = sc.nextInt();

        Receptionist newReceptionist = new Receptionist(name,age,shift,hoursWorked);
        receptionists.add(newReceptionist);
        ReceptionistBusinessLogic.writeReceptionistsToFile(receptionists);
        System.out.println("Receptionist added successfully.");
        addAuthentication("Receptionist");
    }


    private static void updateReceptionist() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Receptionist name to Update: ");
        String name = sc.nextLine();

        Receptionist existingReceptionist = findReceptionistByName(receptionists, name);
        if (existingReceptionist != null) {
            System.out.print("Enter new shift (Morning/Evening/Night) : ");
            String newShift = sc.next();

            System.out.print("Enter new working hours : ");
            int newHoursWorked = sc.nextInt();

            existingReceptionist.setShift(newShift);
            existingReceptionist.setHoursWorked(newHoursWorked);
            existingReceptionist.setSalary(existingReceptionist.calculateSalary());
            ReceptionistBusinessLogic.writeReceptionistsToFile(receptionists);
            System.out.println("Receptionist information updated successfully.");
        } else {
            System.out.println("Receptionist not found.");
        }
    }

    private static void removeReceptionist() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Receptionist name to Remove: ");
        String name = sc.nextLine();

        Receptionist existingReceptionist = findReceptionistByName(receptionists,name);
        if (existingReceptionist != null) {
            if (employeeExists(name, receptionists)) {
                receptionists.remove(existingReceptionist);
                ReceptionistBusinessLogic.writeReceptionistsToFile(receptionists);
                System.out.println("Receptionist removed successfully.");
            } else {
                System.out.println("Receptionist not found.");
            }
        } else {
            System.out.println("Receptionist not found.");
        }
    }
    private static Receptionist findReceptionistByName(ArrayList<Receptionist> receptionists,String name) {
        for (Receptionist receptionist : receptionists) {
            if (receptionist.getName().equalsIgnoreCase(name)) {
                return receptionist;
            }
        }
        return null;
    }
    private static void displayReceptionists() {
        receptionists = ReceptionistBusinessLogic.readReceptionistsFile();
        System.out.println("\nReceptionists");
        System.out.println("_____________________________________________________________________________________________________________________");
        for (Receptionist receptionist : receptionists) {
            System.out.println(receptionist.toString());
        }
        System.out.println("_____________________________________________________________________________________________________________________\n");
    }




    private static void chefOperations() {
        Scanner sc = new Scanner(System.in);
        int chefChoice;

        do {
            System.out.println("\nChef Operations:");
            System.out.println("1. Add Chef");
            System.out.println("2. Update Chef");
            System.out.println("3. Remove Chef");
            System.out.println("4. Check Salary");
            System.out.println("5. Display Chefs");
            System.out.println("6. Back to Employee Menu");
            System.out.print("Enter your choice: ");
            chefChoice = sc.nextInt();

            switch (chefChoice) {
                case 1:
                    addChef();
                    break;
                case 2:
                    updateChef();
                    break;
                case 3:
                    removeChef();
                    break;
                case 4:
                    checkSalaryforChef();
                    break;
                case 5:
                    displayChefs();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (chefChoice != 6);
    }

    private static Chef findChefByName(ArrayList<Chef> chefs,String name) {
        for (Chef chef : chefs) {
            if (chef.getName().equalsIgnoreCase(name)) {
                return chef;
            }
        }
        return null;
    }

    private static void addChef() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nAdding Chef..");

        String name;
        do {
            System.out.print("Enter Chef name : ");
            name = sc.nextLine();
            if (employeeExists(name, chefs)) {
                System.out.println("Name already exists. Please choose a different one.");
            }
        } while (employeeExists(name, chefs));


        System.out.print("Enter Age : ");
        int age = sc.nextInt();

        System.out.print("Enter Chef's Cuisine Specialty: ");
        String cuisineSpecialty = sc.next();
        System.out.print("Enter Chef's Experience in Years: ");
        int experienceInYears = sc.nextInt();

        Chef newChef = new Chef(name,age,cuisineSpecialty,experienceInYears);
        chefs.add(newChef);
        ChefBusinessLogic.writeChefsToFile(chefs);
        System.out.println("Chef added successfully.");
        addAuthentication("Chef");
    }



    private static void updateChef() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Chef name to update: ");
        String name = sc.nextLine();

        Chef existingChef = findChefByName(chefs,name);
        if (existingChef != null) {
            System.out.print("Enter New Experience in Years: ");
            int newExperienceInYears = sc.nextInt();
            existingChef.setExperienceInYears(newExperienceInYears);
            existingChef.setSalary(existingChef.calculateSalary());
            ChefBusinessLogic.writeChefsToFile(chefs);

            System.out.println("Chef information updated successfully.");
        } else {
            System.out.println("Chef not found.");
        }
    }


    private static void removeChef() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Chef name to Remove: ");
        String name = sc.nextLine();

        Chef existingChef = findChefByName(chefs,name);
        if (existingChef != null) {
            if (employeeExists(name, chefs)) {
                chefs.remove(existingChef);
                ChefBusinessLogic.writeChefsToFile(chefs);
                System.out.println("Chef removed successfully.");
            } else {
                System.out.println("Chef not found.");
            }
        } else {
            System.out.println("Chef not found.");
        }
    }


    private static void checkSalaryforChef() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Chef name to check the salary : ");
        String name = sc.nextLine();

        Chef chef = findChefByName(chefs,name);
        if (chef != null) {
            double salary = chef.calculateSalary();
            System.out.println("Salary of Chef " + chef.getName() + ": " + salary);
        } else {
            System.out.println("Chef not found.");
        }
    }

    private static void displayChefs() {
        chefs = ChefBusinessLogic.readChefsFile();
        System.out.println("\nChefs");
        System.out.println("_____________________________________________________________________________________________________________________");
        for (Chef chef : chefs) {
            System.out.println(chef.toString());
        }
        System.out.println("_____________________________________________________________________________________________________________________\n");
    }


    public static void displayLoginMenu() throws IOException {
        Scanner sc = new Scanner(System.in);
        Login login=new Login();
        int choice;

        System.out.println("Choose the Employee Type:");
        System.out.println("1. Manager");
        System.out.println("2. Receptionist");
        System.out.println("3. Chef");
        System.out.println("4. Waiter");
        System.out.println("0. Exit");

        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                Login.authenticateUser("Manager");
                break;
            case 2:
                Login.authenticateUser("Receptionist");
                break;
            case 3:
                Login.authenticateUser("Chef");
                break;
            case 4:
                Login.authenticateUser("Waiter");
                break;
            case 0:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                displayLoginMenu();
        }
    }

    private static void reservationSystem() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        //int reservationChoice;

        int choice;

        do {
            System.out.println("\nReservation Menu:");
            System.out.println("1. Add Reservation");
            System.out.println("2. Remove Reservations");
            System.out.println("3  Display Reservation ");
            System.out.println("4. Back to Menu");
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();



            switch (choice) {
                case 1:
                    addReservation(reservationSystem, scanner);
                    break;
                case 2:
                    removeReservation(reservationSystem, scanner);
                    break;
                case 3:
                    displayReservations();
                    break;
                case 4:
                    displayMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }


    private static Date parseStringToDate(String dateString) {
        while (true) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                java.util.Date parsedDate = dateFormat.parse(dateString);
                return new Date(parsedDate.getTime());
            } catch (ParseException e) {
                System.out.print("Invalid date format. Please enter a valid date (yyyy-MM-dd HH:mm:ss): ");
                dateString = getValidDateStringFromUser();
            }
        }
    }

    private static String getValidDateStringFromUser() {
        Scanner scanner = new Scanner(System.in);
        String dateString;

        do {
            System.out.print("Enter a valid date and time (yyyy-MM-dd HH:mm:ss): ");
            dateString = scanner.nextLine();
        } while (!isValidDateFormat(dateString));

        return dateString;
    }

    private static boolean isValidDateFormat(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateFormat.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private static Table getTableDetails(Scanner scanner) {
        // Consume the newline character
        scanner.nextLine();

        System.out.print("Enter Table Number: ");
        int tableNumber = scanner.nextInt();
        System.out.print("Enter Table Capacity: ");
        int tableCapacity = scanner.nextInt();

        // Create and return a new Table object
        return new Table(tableNumber, tableCapacity);
    }

    private static Customer getCustomerDetails(Scanner scanner) {
        // Consume the newline character
        scanner.nextLine();

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Customer Email: ");
        String customerEmail = scanner.nextLine();


        int customerId = 1;
        return new Customer(customerId, customerName, customerEmail);
    }



    private static void getConfirmedReservations(ReservationSystem reservationSystem) {

    }
    private static void addReservation(ReservationSystem reservationSystem, Scanner scanner) {
        ArrayList<Reservation> reservations=ReservationSystem.readReservationsFromFile("reservations.txt");
        System.out.print("Enter Reservation ID:");
        int reservationID = scanner.nextInt();

        String reservationDate = new String();
        boolean validDate = false;

        do {
            System.out.print("Enter Reservation Date (YYYY-MM-DD):");
            try {
                reservationDate = scanner.next();
                LocalDate.parse(reservationDate);
                validDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            }
        } while (!validDate);

        Table reservedTable = getTableDetails(scanner);
        Customer customer = getCustomerDetails(scanner);

        Reservation newReservation = new Reservation(reservationID, reservationDate, reservedTable);
        reservations.add(newReservation);
        reservationSystem.writeReservationsToFile(reservations);

        System.out.println("Reservation added successfully.");
    }



    private static void removeReservation(ReservationSystem reservationSystem, Scanner scanner) {

        boolean found=false;
        System.out.print("Enter Reservation ID to Remove:");
        int reservationIDToRemove = scanner.nextInt();

        ArrayList<Reservation> reservations=ReservationSystem.readReservationsFromFile("reservations.txt");
        for (Reservation reservation: reservations)
        {
            if (reservation.getReservationID()==reservationIDToRemove)
            {
                reservations.remove(reservation);
                System.out.println("Reservation removed successfully.");
                found=true;
                break;
            }
        }
        reservationSystem.writeReservationsToFile(reservations);
        if (!found)
        {
            System.out.println("Reservation ID not found.");
        }


    }

    private static void displayReservations() {
        System.out.println("Reservations:");
        ArrayList<Reservation> reservations = ReservationSystem. readReservationsFromFile("reservations.txt");

        if (reservations.isEmpty()) {
            System.out.println("No reservations available.");
        } else {
            System.out.println("List of Reservations");
            System.out.println("_____________________________________________________________________________________________________________________\n");
            for (Reservation reservation : reservations) {
                System.out.println(reservation.toString());
            }
            System.out.println("_____________________________________________________________________________________________________________________\n");
        }
    }



    public static void placeOrder() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Cart> cartArrayList = new ArrayList<>();
        ArrayList<Menu> menu1ArrayList = new ArrayList<>();
        File file = new File("menu.txt");
        File cartFile = new File("cart.txt");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator<Menu> li = null;
        int choice;
        String choice1 = null;
        int priceOfOne = 0;

        System.out.println("Placing Order...");
        System.out.println("Select the items you want to add to cart from the menu below : ");
        displayFoodMenu();

        do {
            if (cartFile.exists() && cartFile.length() != 0) {
                ois = new ObjectInputStream(new FileInputStream(cartFile));
                cartArrayList = (ArrayList<Cart>) ois.readObject();
                ois.close();
            }
            String size = null;
            String selectedItemName = null;
            System.out.print("Enter Food ID you want to add : ");
            int foodItemID = sc.nextInt();
            do {
                System.out.println("1. SMALL  2. MEDIUM  3. LARGE");
                System.out.print("Select its size : ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> size = "SMALL";
                    case 2 -> size = "MEDIUM";
                    case 3 -> size = "LARGE";
                    default -> System.out.println("Invalid choice. Please enter again..!!");
                }
            } while (choice != 1 && choice != 2 && choice != 3);
            System.out.print("Enter the quantity you want : ");
            int quantity = sc.nextInt();

            if (file.exists()) {
                ois = new ObjectInputStream(new FileInputStream(file));
                menu1ArrayList = (ArrayList<Menu>) ois.readObject();
                ois.close();

                li = menu1ArrayList.listIterator();
                while (li.hasNext()) {
                    Menu item = li.next();
                    if (item.getFoodID() == foodItemID) {
                        selectedItemName = item.getFoodName();
                        priceOfOne = getPriceForSize(item, size);
                        break;
                    }
                }

                if (priceOfOne == 0) {
                    System.out.println("Invalid Food ID or size. Please try again.");
                    continue;
                }

                boolean isAvailable = checkAvailability(selectedItemName, quantity);
                if (isAvailable) {
                    Cart item = new Cart(foodItemID, selectedItemName, size, quantity, (priceOfOne * quantity));
                    item.setPriceOfOne(priceOfOne);
                    cartArrayList.add(item);
                    System.out.println("Item added successfully to cart..!!\n");

                    oos = new ObjectOutputStream(new FileOutputStream(cartFile));
                    oos.writeObject(cartArrayList);
                    oos.close();
                } else {
                    System.out.println("Sorry! The requested quantity is not available.");
                }
            } else {
                System.out.println("Menu file does not exist. Cannot proceed.");
            }

            sc.nextLine();
            System.out.print("Do you want to add another item (yes/no) : ");
            choice1 = sc.next();

        } while (!choice1.equalsIgnoreCase("no"));

        displayCart();
        confirmOrder();
        cartArrayList.clear();
        cartFile.delete();
        displayMenu();
    }

    private static int getPriceForSize(Menu item, String size) {
        switch (size) {
            case "SMALL":
                return item.getSmallPrice();
            case "MEDIUM":
                return item.getMediumPrice();
            case "LARGE":
                return item.getLargePrice();
            default:
                return 0;
        }
    }

    public static void confirmOrder() throws IOException, ClassNotFoundException {
        Scanner sc=new Scanner(System.in);
        String choice;
        int choice1;
        do {
            System.out.print("Do you want to confirm your order (yes/no) ? ");
            choice = sc.next();
            if (choice.equalsIgnoreCase("no")) {
                System.out.println("What do you want to do with your order ?");
                System.out.println("1. Add another Item");
                System.out.println("2. Remove Item");
                System.out.println("3. Cancel Order");
                System.out.println("4. Back to Main Menu");
                System.out.print("Enter your choice: ");
                choice1 = sc.nextInt();
                switch (choice1) {
                    case 1 -> placeOrder();
                    case 2 -> removeItem();
                    case 3 -> cancelOrder();
                    case 4 -> displayMenu();
                    default -> System.out.println("Invalid choice!! Try again!!");
                }
            } else if (choice.equalsIgnoreCase("yes")){
                System.out.println("Your order has been confirmed.\n");
                System.out.println("Generating bill....");
                generateBill();
            }
        }while (!choice.equalsIgnoreCase("yes"));
    }


    public static void cancelOrder() throws IOException, ClassNotFoundException {
        File cartFile = new File("cart.txt");
        File inventoryFile = new File("Inventory.txt");

        ArrayList<Cart> cart = new ArrayList<>();

        ObjectInputStream ois = null;


        if (cartFile.exists()) {
            ois=new ObjectInputStream(new FileInputStream(cartFile));
            cart=(ArrayList<Cart>)ois.readObject();
            ois.close();
            // Process items in cart to restore inventory
            if (!cart.isEmpty()) {
                for (Cart item : cart) {
                    restoreInventory(item, inventoryFile, true); // Increment inventory quantities
                }
            }
        }

        cartFile.delete();
        System.out.println("Your order has been cancelled.\n");
        displayMenu();
    }




    // Method to update inventory quantities
    private static void restoreInventory(Cart item, File inventoryFile, boolean increment) throws IOException, ClassNotFoundException {
        ArrayList<Inventory> inventoryArrayList;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inventoryFile));
        inventoryArrayList = (ArrayList<Inventory>) ois.readObject();
        ois.close();

        for (Inventory invItem : inventoryArrayList) {
            if (invItem.getFoodItemName().equals(item.getFoodItemName())) {
                if (increment) {
                    invItem.setFoodItemQuantity(invItem.getFoodItemQuantity() + item.getQuantity());
                } else {
                    invItem.setFoodItemQuantity(invItem.getFoodItemQuantity() - item.getQuantity());
                }
                break;
            }
        }

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(inventoryFile));
        oos.writeObject(inventoryArrayList);
        oos.close();
    }
    public static void removeItem() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Inventory> inventoryArrayList = new ArrayList<>();
        ArrayList<Cart> cartArrayList = new ArrayList<>();
        File file = new File("cart.txt");
        File inventoryFile = new File("Inventory.txt");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator<Cart> li = null;
        String choice;
        boolean found = false;

        if (file.exists()) {
            System.out.print("Enter the food item name you want to delete: ");
            choice = sc.nextLine();

            ois = new ObjectInputStream(new FileInputStream(file));
            cartArrayList = (ArrayList<Cart>) ois.readObject();
            ois.close();

            li = cartArrayList.listIterator();

            while (li.hasNext()) {
                Cart item = li.next();
                if (item.getFoodItemName().equalsIgnoreCase(choice)) {
                    li.remove();
                    found = true;
                    restoreInventory(item, inventoryFile,true);
                    break;
                }
            }

            if (found) {
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(cartArrayList);
                oos.close();

                System.out.println("Item removed successfully from cart..!!");
            } else {
                System.out.println("Item not found...!!");
            }
        } else {
            System.out.println("File does not exist..!!");
        }
        System.out.println("_____________________________________________________________________________________________________________________");
    }


    public static void displayCart() throws IOException, ClassNotFoundException {
        ArrayList<Cart> cartArrayList=new ArrayList<>();
        File file=new File("cart.txt");
        ListIterator li=null;
        li=cartArrayList.listIterator();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            cartArrayList= (ArrayList<Cart>) ois.readObject();
            ois.close();
            li = cartArrayList.listIterator();
            System.out.println("_____________________________________________________________________________________________________________________");
            while (li.hasNext())
                System.out.printf(li.next().toString());
            System.out.println("_____________________________________________________________________________________________________________________");

        }
        else {
            System.out.println("File does not exist...!!");
        }

    }
    public static boolean checkAvailability(String selectedItemName, int quantity) throws IOException, ClassNotFoundException {
        File file = new File("Inventory.txt");
        ArrayList<Inventory> inventoryArrayList = new ArrayList<>();
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        ListIterator<Inventory> li = null;
        boolean isAvailable = false;

        if (file.exists()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            inventoryArrayList = (ArrayList<Inventory>) ois.readObject();
            ois.close();

            li = inventoryArrayList.listIterator();
            while (li.hasNext()) {
                Inventory item = li.next();
                if (item.getFoodItemName().equalsIgnoreCase(selectedItemName)) {
                    if (item.getFoodItemQuantity() >= quantity) {
                        isAvailable = true;
                        item.setFoodItemQuantity(item.getFoodItemQuantity() - quantity);
                        restoreInventory(item, file);
                        break;
                    }
                }
            }
        } else {
            System.out.println("File does not exist..!!");
        }
        return isAvailable;
    }
    private static void restoreInventory(Inventory updatedItem, File inventoryFile) throws IOException, ClassNotFoundException {
        ArrayList<Inventory> inventoryArrayList = new ArrayList<>();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inventoryFile));
        inventoryArrayList = (ArrayList<Inventory>) ois.readObject();
        ois.close();

        for (Inventory inventory : inventoryArrayList) {
            if (inventory.getFoodItemName().equalsIgnoreCase(updatedItem.getFoodItemName())) {
                inventory.setFoodItemQuantity(updatedItem.getFoodItemQuantity());
                break;
            }
        }

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(inventoryFile));
        oos.writeObject(inventoryArrayList);
        oos.close();
    }

    public static void displayMenuOperations() throws IOException, ClassNotFoundException,EOFException {
        Scanner sc = new Scanner(System.in);
        int choice1;

        while (true) {
            System.out.println("\nMenu Operations");
            System.out.println("1. Display Menu ");
            System.out.println("2. Add Item to Menu");
            System.out.println("3. Search Item by ID");
            System.out.println("4. Delete Item from Menu");
            System.out.println("5. Update Food Item prices ");
            System.out.println("6. Sort Food items with respect to ID");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice1 = sc.nextInt();
            switch (choice1) {
                case 1:
                    displayFoodMenu();
                    break;
                case 2:
                    addFoodItem();
                    break;
                case 3:
                    searchByID();
                    break;
                case 4:
                    deleteFoodItem();
                    break;
                case 5:
                    updateFoodItem();
                    break;
                case 6:
                    sortFoodItems();
                    break;
                case 7:
                    displayMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }

    }
    public static void updateFoodItem() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Menu> menu1ArrayList = new ArrayList<>();
        File file = new File("menu.txt");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        if (file.exists()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            menu1ArrayList = (ArrayList<Menu>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("Enter Food Item ID to update its prices: ");
            int IDToSearch = sc.nextInt();
            System.out.println("_____________________________________________________________________________________________________________________");

            li = menu1ArrayList.listIterator();
            while (li.hasNext()) {
                Menu item = (Menu) li.next();
                if (item.getFoodID() == IDToSearch) {
                    System.out.print("Enter updated SMALL portion price : ");
                    int newSmallPrice = sc.nextInt();
                    System.out.print("Enter updated MEDIUM portion price : ");
                    int newMediumPrice = sc.nextInt();
                    System.out.print("Enter updated LARGE portion price : ");
                    int newLargePrice = sc.nextInt();
                    li.set(new Menu(IDToSearch, item.getFoodName(), item.getSMALL(), newSmallPrice, item.getMEDIUM(),
                            newMediumPrice, item.getLARGE(), newLargePrice, item.getDescription()));
                    found = true;
                }
            }
            if (found) {
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(menu1ArrayList);
                oos.close();
                System.out.println("Food Item updated successfully..!!");
            } else {
                System.out.println("Item not found...!!");
            }
            System.out.println("_____________________________________________________________________________________________________________________");
        } else {
            System.out.println("File does not exist...!!!");
        }
    }
    public static void deleteFoodItem() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Menu> menu1ArrayList = new ArrayList<>();
        ArrayList<Inventory> inventoryArrayList=new ArrayList<>();
        Menu menu1 = new Menu();
        File file = new File("menu.txt");
        File inventoryFile=new File("Inventory.txt");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;
        ListIterator li2 = null;

        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            menu1ArrayList = (ArrayList<Menu>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("Enter Food Item ID to delete: ");
            int IDToSearch = sc.nextInt();
            System.out.println("_____________________________________________________________________________________________________________________");

            li = menu1ArrayList.listIterator();
            li2=inventoryArrayList.listIterator();
            while (li.hasNext()) {
                Menu item = (Menu) li.next();
                if (item.getFoodID() == IDToSearch) {
                    li.remove();
                    found = true;
                    for (Inventory inventory: inventoryArrayList)
                    {
                        if (inventory.getFoodItemName()==item.getFoodName())
                        {
                            li2.remove();
                        }
                    }
                }
            }
            if (found) {
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(menu1ArrayList);
                oos = new ObjectOutputStream(new FileOutputStream(inventoryFile));
                oos.writeObject(inventoryArrayList);
                oos.close();
                System.out.println("Food Item deleted successfully..!!");
            } else {
                System.out.println("Item not found...!!");
            }
            System.out.println("_____________________________________________________________________________________________________________________");
        } else {
            System.out.println("File does not exist...!!!");
        }
    }
    public static void searchByID() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Menu> menu1ArrayList = new ArrayList<>();
        Menu menu = new Menu();
        File file = new File("menu.txt");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            menu1ArrayList = (ArrayList<Menu>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("Enter Food Item ID to search: ");
            int IDToSearch = sc.nextInt();
            System.out.println("_____________________________________________________________________________________________________________________");

            li = menu1ArrayList.listIterator();
            while (li.hasNext()) {
                Menu item = (Menu) li.next();
                if (item.getFoodID() == IDToSearch) {
                    System.out.println(item);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Item not found...!!");
            }
            System.out.println("_____________________________________________________________________________________________________________________");
        } else {
            System.out.println("File does not exist...!!!");
        }
    }
    public static void sortFoodItems() throws IOException, ClassNotFoundException {
        ArrayList<Menu> menu1ArrayList = new ArrayList<>();
        File file = new File("menu.txt");
        if (file.exists())
        {
            Collections.sort(menu1ArrayList, new Comparator<Menu>() {
                @Override
                public int compare(Menu o1, Menu o2) {
                    return o1.getFoodID() - o2.getFoodID();
                }
            });
        }
        displayFoodMenu();
    }

    public static void addFoodItem() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Menu> menu1ArrayList = new ArrayList<>();
        ArrayList<Inventory> inventoryArrayList=new ArrayList<>();
        Menu menu = new Menu();
        File file = new File("menu.txt");
        File inventoryFile=new File("Inventory.txt");
        ObjectOutputStream oos;
        ObjectInputStream ois = null;

        if (file.exists() && file.length()!=0) {
            ois = new ObjectInputStream(new FileInputStream(file));
            menu1ArrayList = (ArrayList<Menu>) ois.readObject();
            ois.close();
        }
        if (inventoryFile.exists() && inventoryFile.length()!=0)
        {
            ois=new ObjectInputStream(new FileInputStream(inventoryFile));
            inventoryArrayList= (ArrayList<Inventory>) ois.readObject();
            ois.close();
        }

        System.out.println("\nAdding Item....");
        System.out.print("Enter Food Item ID : ");
        int foodID = sc.nextInt();
        sc.nextLine(); //discards next line character
        System.out.print("Enter Food Item name : ");
        String foodName = sc.nextLine();
        System.out.print("Enter price for small: ");
        int smallPrice = sc.nextInt();
        sc.nextLine(); //discards next line character
        System.out.print("Enter price for medium: ");
        int mediumPrice = sc.nextInt();
        sc.nextLine(); //discards next line character
        System.out.print("Enter price for large: ");
        int largePrice = sc.nextInt();
        sc.nextLine(); //discards next line character
        System.out.print("Enter description: ");
        String description = sc.nextLine();
        System.out.print("Enter quantity available: ");
        int quantity=sc.nextInt();

        menu1ArrayList.add(new Menu(foodID, foodName, menu.getSMALL(), smallPrice, menu.getMEDIUM(), mediumPrice, menu.getLARGE(), largePrice, description));
        inventoryArrayList.add(new Inventory(foodName,quantity));
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(menu1ArrayList);
        oos=new ObjectOutputStream(new FileOutputStream(inventoryFile));
        oos.writeObject(inventoryArrayList);
        oos.close();
    }
    public static void displayFoodMenu() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Menu> menu1ArrayList = new ArrayList<>();
        ListIterator li = null;
        File file = new File("menu.txt");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            menu1ArrayList = (ArrayList<Menu>) ois.readObject();
            ois.close();
            li = menu1ArrayList.listIterator();
            System.out.println("_____________________________________________________________________________________________________________________");
            while (li.hasNext())
                System.out.printf(li.next().toString());
            System.out.println("_____________________________________________________________________________________________________________________");

        }
        else {
            System.out.println("File does not exist...!!");
        }
    }

    public static void displayInventoryOperations() throws IOException, ClassNotFoundException {
        Scanner sc=new Scanner(System.in);
        int choice;
        do{
            System.out.println("\nInventory Operations");
            System.out.println("1. Display Inventory");
            System.out.println("2. Update Inventory");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter choice :");
            choice=sc.nextInt();

            switch (choice)
            {
                case 1:
                    displayInventory();
                    break;
                case 2:
                    updateInventory();
                    break;
                case 3:
                    displayMenu();
                    break;

            }

        }while (choice !=3);

    }
    public static void updateInventory() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Inventory> inventoryArrayList = new ArrayList<>();
        File file = new File("Inventory.txt");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            inventoryArrayList = (ArrayList<Inventory>) ois.readObject();
            ois.close();
            boolean found = false;
            System.out.print("Enter Food Item Name to update its quantity: ");
            String foodItemToSearch = sc.nextLine();
            System.out.println("_____________________________________________________________________________________________________________________");

            li = inventoryArrayList.listIterator();
            while (li.hasNext()) {
                Inventory item = (Inventory) li.next();
                if (item.getFoodItemName().equalsIgnoreCase(foodItemToSearch)) {
                    System.out.print("Enter updated quantity : ");
                    int newQuantity = sc.nextInt();
                    li.set(new Inventory(foodItemToSearch,newQuantity));
                    found = true;
                }
            }
            if (found) {
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(inventoryArrayList);
                oos.close();
                System.out.println("Quantity updated successfully..!!");
            } else {
                System.out.println("Item not found...!!");
            }
            System.out.println("_____________________________________________________________________________________________________________________");
        } else {
            System.out.println("File does not exist...!!!");
        }
    }

    public static void displayInventory() throws IOException, ClassNotFoundException,EOFException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Inventory> inventoryArrayList = new ArrayList<>();
        ListIterator li = null;
        File file = new File("Inventory.txt");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            inventoryArrayList = (ArrayList<Inventory>) ois.readObject();
            ois.close();
            li = inventoryArrayList.listIterator();
            System.out.println("_____________________________________________________________________________________________________________________");
            while (li.hasNext())
                System.out.printf(li.next().toString());
            System.out.println("_____________________________________________________________________________________________________________________");

        }
        else {
            System.out.println("File does not exist...!!");
        }
    }

    public static void generateBill() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cart> cartArrayList = new ArrayList<>();
        ArrayList<String> billArrayList=new ArrayList<>();
        File file = new File("cart.txt");
        File bills=new File("bills.txt");
        ListIterator li = null;
        li = cartArrayList.listIterator();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        double totalBill = 0.0;

        if (file.exists()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            cartArrayList = (ArrayList<Cart>) ois.readObject();
            ois.close();
            li = cartArrayList.listIterator();
            System.out.println("____________________________________________________B I L L____________________________________________________\n");
            while (li.hasNext())
            {
                Cart cartItem=(Cart)li.next();
                System.out.printf(cartItem.toString());
                int itemTotalPrice = cartItem.getPriceOfOne() * cartItem.getQuantity();
                totalBill += itemTotalPrice;
            }
            double serviceCharges=(5.0/100.0)*totalBill;
            System.out.println("5% service charges                                    Rs."+serviceCharges);
            System.out.println("Total amount                                          Rs." +(totalBill+serviceCharges));
            System.out.println("_________________________________________________________________________________________________________________\n");


            Bill bill=new Bill(serviceCharges,(totalBill+serviceCharges));
            oos=new ObjectOutputStream(new FileOutputStream(bills,true));
            oos.writeObject(bill.toString());
            oos.close();


            System.out.println("Select payment method");
            System.out.println("1. By Cash");
            System.out.println("2. By Card");
            System.out.print("Enter choice: ");
            int paymentOption = scanner.nextInt();
            switch (paymentOption) {
                case 1:
                    handleCashPayment(bill);
                    break;
                case 2:
                    handleCardPayment(bill);
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid payment method.");
            }


        }
    }



    private static void handleCashPayment(Bill bill) {
        Scanner scanner = new Scanner(System.in);
        int count=0;
        double cashAmount;
        do {
            if (count==0) {

            }
            else {
                System.out.println("Insufficient Cash. Please provide full amount.");
            }

            System.out.print("Enter the amount in cash:");
            cashAmount = scanner.nextDouble();
            count++;
        }while(cashAmount<bill.getTotalBill());

        double remainingAmount = cashAmount - bill.getTotalBill();
        System.out.println("_________________________________________________________________________________________________________________");
        System.out.println("Amount paid: " + bill.getTotalBill());
        System.out.println("Remaining cash returned: " + remainingAmount);
        System.out.println("_________________________________________________________________________________________________________________");
    }


    private static void handleCardPayment(Bill bill) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter card details");
        System.out.print("Card Holder Name: ");
        String cardHolderName = scanner.nextLine();

        System.out.print("Card ID: ");
        String cardID = scanner.next();

        //card details
        System.out.println("_________________________________________________________________________________________________________________");
        System.out.println("Successfully withdrawn bill from card. Card ID: " + cardID);
        System.out.println("_________________________________________________________________________________________________________________");
    }



    public static void VenderOperation() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);


        int choice;
        do {
            System.out.println("\nVendor Menu");
            System.out.println("1. Add a New Vendor");
            System.out.println("2. Display Vendors");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // consume the invalid input
                choice = 0; // assign a default value to avoid an infinite loop
            }
            ArrayList<Vendor> vendors = VendorBusinessLogic.readVendorsFromFile();
            switch (choice) {
                case 1:
                    addVendor(vendors);
                    break;
                case 2:
                    displayVendors();
                    break;
                case 3:
                    displayMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                    break;
            }
        } while (choice != 3);


    }


    private static void addVendor( ArrayList<Vendor> vendors) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the name of the new vendor: ");
        String name = scanner.nextLine();

        System.out.print("Enter the address of the new vendor: ");
        String address = scanner.nextLine();

        System.out.print("Enter the contact number of the new vendor: ");
        String contactNumber = scanner.nextLine();

        System.out.print("Enter the email of the new vendor: ");
        String email = scanner.nextLine();

        Vendor newVendor = new Vendor(name, address, contactNumber, email);
        vendors.add(newVendor);
        VendorBusinessLogic.writeVendorsToFile(vendors);
        System.out.println("Vendor added successfully.");
    }


    private static void displayVendors() {
        ArrayList<Vendor> vendors = VendorBusinessLogic.readVendorsFromFile();
        System.out.println("\nVendors");
        System.out.println("_____________________________________________________________________________________________________________________");
        for (Vendor vendor : vendors) {
            System.out.println("Name: " + vendor.getName());
            System.out.println("Address: " + vendor.getAddress());
            System.out.println("Contact Number: " + vendor.getContactNumber());
            System.out.println("Email: " + vendor.getEmail());
            System.out.println();
        }
        System.out.println("_____________________________________________________________________________________________________________________\n");
    }


}
