package authentication;
import java.io.*;
import java.util.Scanner;

public class Login {
    public static String employeeType;
    public static String username;
    public static String password;
    static int ln;

    public static void readAuthenticationFile(String fileName) throws IOException {
        try {
            FileReader fileReader = new FileReader(fileName);
        } catch (FileNotFoundException fileNotFoundException) {
            FileWriter fileWriter = new FileWriter(fileName);
        }

    }

    public static void addAuthenticationData(String employeeType, String username, String password) {
        try {

            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("EmployeesAuthentication.txt",true));
            bufferedWriter.write("\n");
            bufferedWriter.write("Employee Type :" + employeeType + "\r\n");
            bufferedWriter.write("Username      :" + username + "\r\n");
            bufferedWriter.write("Password      :" + password + "\r\n");
            System.out.println("New employee successfully authenticated.");
            bufferedWriter.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println(fileNotFoundException);
        } catch (IOException ioException) {
            System.err.println(ioException);
        }


    }

    public static void authenticateUser(String currentEmployeeType) throws IOException {
        String usernameEntered;
        String passwordEntered;
        boolean loggedIn = false;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Username: ");
            usernameEntered = sc.next();
            System.out.print("Enter password: ");
            passwordEntered = sc.next();

            readAuthenticationFile("EmployeesAuthentication.txt");
            try (BufferedReader br = new BufferedReader(new FileReader("EmployeesAuthentication.txt"))) {
                String line;
                String employeeType = "";
                String username = "";
                String password = "";

                while ((line = br.readLine()) != null) {
                    if (line.startsWith("Employee Type")) {
                        employeeType = line.substring(15).trim();
                    } else if (line.startsWith("Username")) {
                        username = line.substring(15).trim();
                    } else if (line.startsWith("Password")) {
                        password = line.substring(15).trim();

                        if (currentEmployeeType.equals(employeeType) && usernameEntered.equals(username) && passwordEntered.equals(password)) {
                            System.out.println("\nWelcome User!!");
                            greetingDetails();
                            loggedIn = true;
                            break;
                        }
                    }
                }

            }
            catch(IOException e){
                System.out.println("Error reading file or invalid file.");
            }
            if (!loggedIn) {
                System.out.println("Authentication failed. Invalid credentials.");
                System.out.println("Please try again.");
            }

        }while (!loggedIn);
    }




    public static void greetingDetails() {
        // Display restaurant name, location,  etc.
        System.out.println("\nWELCOME TO THE DELIGHT RESTAURANT PORTAL ");
        System.out.println("Location: Lahore");
    }

}
