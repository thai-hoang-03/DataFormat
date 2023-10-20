package DataFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidateProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Function 1: Display GUI and Input Data
        System.out.println("======== Validate Program ========");

        // Validate Phone
        String phone;
        do {
            System.out.print("Phone number: ");
            phone = scanner.nextLine();
            String phoneError = checkPhone(phone);
            if (!phoneError.isEmpty()) {
                System.out.println(phoneError);
            }
        } while (!checkPhone(phone).isEmpty());

        // Validate Email
        String email;
        do {
            System.out.print("Email: ");
            email = scanner.nextLine();
            String emailError = checkEmail(email);
            if (!emailError.isEmpty()) {
                System.out.println(emailError);
            }
        } while (!checkEmail(email).isEmpty());

        // Validate Date
        String date;
        do {
            System.out.print("Date: ");
            date = scanner.nextLine();
            String dateError = checkDate(date);
            if (!dateError.isEmpty()) {
                System.out.println(dateError);
            }
        } while (!checkDate(date).isEmpty());

        // Exit the program
        scanner.close();
    }

    // Function 2: Perform function
    public static String checkPhone(String phone) {
        if (!phone.matches("\\d+")) {
            return "Phone number must be numbers.";
        } else if (phone.length() != 10) {
            return "Phone number must contain 10 numbers.";
        }
        return "";
    }

    // Function 3: Check the date format
    public static String checkDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(date);
        } catch (ParseException e) {
            return "Date must be in correct format (dd/MM/yyyy).";
        }

        return "";
    }

    // Function 4: Check email format
    public static String checkEmail(String email) {
        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher matcher = emailPattern.matcher(email);

        if (!matcher.matches()) {
            return "Email must be in correct format.";
        }

        return "";
    }
    
}
