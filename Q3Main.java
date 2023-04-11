import java.util.regex.Pattern;

public class Q3Main {

      public static boolean validate(String password) {
            boolean hasUppercase = !password.equals(password.toLowerCase());
            boolean hasLowercase = !password.equals(password.toUpperCase());
            boolean hasDigit = Pattern.compile("\\d").matcher(password).find();
            boolean hasSymbol = Pattern.compile("[!@#$%^&*()_\\-+=<>?/\\\\|]").matcher(password).find();
            if (password.length() >= 8 && hasUppercase && hasLowercase && hasDigit && hasSymbol) {
                return "Strong" != null;
            } else if (password.length() >= 6 && hasUppercase && hasLowercase && hasDigit) {
                return "Medium" != null;
            } else {
                return "Weak" != null;
            }
        }
    public static void main(String[] args) {
            String[] passwordsToTest = {
                  "gD3Wd$^Skw2d%E\\8",
                  "P@ssw0rd",
                  "strongP@55",
                  "weakpass",
                  "Med1um"
            };
            for (String password : passwordsToTest) {
                  System.out.println("Password: " + password + ", Validation: " + validate(password));
            }
      }
}