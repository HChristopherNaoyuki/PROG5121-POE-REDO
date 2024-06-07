/*
 * Author: Naoyuki Christopher Higaki
 * Student Number: ST10462415
 * 
 * This program is written by Naoyuki Christopher Higaki.
 * Purpose: This class provides functionality for user registration and login, including username and password validation.
 */

package registration;

public class Login {
    private String username;
    private String name;
    private String surname;
    private String password;

    // Method to check if username meets formatting requirements
    public boolean checkUserName(String username) {
        this.username = username;
        return username.length() <= 5 && username.contains("_");
    }

    // Method to check if password meets complexity requirements
    public boolean checkPasswordComplexity(String password) {
        int uppercase = 0, digit = 0, specialC = 0;
        if (password.length() >= 8) {
            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) uppercase++;
                else if (Character.isDigit(c)) digit++;
                else if (!Character.isLetterOrDigit(c)) specialC++;
            }
            return uppercase > 0 && digit > 0 && specialC > 0;
        }
        return false;
    }

    // Method to register a user
    public String registerUser(String username, String password, String firstName, String lastName) {
        this.name = firstName;
        this.surname = lastName;
        String correctUsername = checkUserName(username) ? "Username successfully captured" : "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length";
        String correctPassword = checkPasswordComplexity(password) ? "Password successfully captured" : "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";

        if (checkUserName(username) && checkPasswordComplexity(password)) {
            this.username = username;
            this.password = password;
            return correctUsername + "\n" + correctPassword + "\nUsername and password entered successfully\nRegistration successful";
        }
        return correctUsername + "\n" + correctPassword;
    }

    // Method to check if provided login credentials match stored credentials
    public boolean loginUser(String uName, String pWord) {
        return username != null && username.equals(uName) && password != null && password.equals(pWord);
    }

    // Method to return login status
    public String returnLoginStatus(String username, String password) {
        return loginUser(username, password) ? "Login successful" : "Login unsuccessful";
    }
}
