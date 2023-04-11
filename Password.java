import java.security.SecureRandom;
import java.util.regex.Pattern;

public class Password {
    // private static SecureRandom random = new SecureRandom();
    char[] ALPHA_CAPS = {'A','B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    char[] ALPHA = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    char[] NUMERIC = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    char[] SPECIAL_CHARS = {'!', '@', '#', '$', '%', '^', '&', '*', '_', '=', '+', '-', '/'};
    int lengthOfPassword;
    int numberOfDigits;
    int numberOfSymbols;

    public Password(int length, int numDigits, int numSymbols) {
        lengthOfPassword = length;
        numberOfDigits = numDigits;
        numberOfSymbols = numSymbols;
    }

    public static String generator(int length, int symbols, int digits) {
        if (length < symbols + digits) {
            throw new IllegalArgumentException("Password length should be greater than or equal to the sum of symbols and digits");
        }
        SecureRandom random = new SecureRandom();
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String digitsStr = "0123456789";
        String symbolsStr = "!@#$%^&*()_-+=<>?/\\|";
        StringBuilder passwordBuilder = new StringBuilder();
        int remainingCharacters = length - symbols - digits;
        for (int i = 0; i < symbols; i++) {
            passwordBuilder.append(symbolsStr.charAt(random.nextInt(symbolsStr.length())));
        }
        for (int i = 0; i < digits; i++) {
            passwordBuilder.append(digitsStr.charAt(random.nextInt(digitsStr.length())));
        }
        for (int i = 0; i < remainingCharacters; i++) {
            if (random.nextBoolean()) {
                passwordBuilder.append(upperAlphabet.charAt(random.nextInt(upperAlphabet.length())));
            } else {
                passwordBuilder.append(lowerAlphabet.charAt(random.nextInt(lowerAlphabet.length())));
            }
        }
        return passwordBuilder.toString();
    }

}
