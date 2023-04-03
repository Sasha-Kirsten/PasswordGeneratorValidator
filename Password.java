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

    public String generator(int length, int numSymbol, int numDigits) {
        String[] result = new String[lengthOfPassword];
        for (int x =0; x<numSymbol; x++) {
            int indexSpecial = (int) Math.random() * SPECIAL_CHARS.length;
            if(result[indexSpecial] == null){
                result[(int) (Math.random() * lengthOfPassword)] = String.valueOf(SPECIAL_CHARS.length);
            }
            else {
                indexSpecial = (int) Math.random() * SPECIAL_CHARS.length;
                x--;
            }
        }

        for(int y=0; y<numDigits; y++){
            int indexDigits = (int) Math.random() * NUMERIC.length;
            if(result[indexDigits] == null){
                result[(int) (Math.random() * lengthOfPassword)] = String.valueOf(NUMERIC[indexDigits]);
            }
            else{
                indexDigits = (int) Math.random() * NUMERIC[indexDigits];
                y--;
            }
        }

        int counter = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == ""){
                counter++;
            }
        }

        for(int z = 0; z<counter; z++){
          int indexLetter = (int) Math.floor(Math.random() * result.length);
            if(result[indexLetter] == null){
              int randLetter = (int) Math.floor((Math.random()) * 2);
                if(randLetter == 0){
                  int randomSmallAlpha = (int) Math.random() * ALPHA.length;
                  result[(int) (Math.random() * lengthOfPassword)] = String.valueOf(ALPHA[randomSmallAlpha]);
                }
                else{
                  int randomBigAlpha = (int) Math.random() * ALPHA_CAPS.length;
                  result[(int) (Math.random() * lengthOfPassword)] = String.valueOf(ALPHA_CAPS[randomBigAlpha]);
                 }
            }
            else{
                indexLetter = (int) Math.floor(Math.random() * result.length);
              z--;
             }
         }
        String completePassword = String.join("",result);
        return completePassword;
    }





    // public static String generator(int length, int symbols, int digits) {
    //     if (length < symbols + digits) {
    //         throw new IllegalArgumentException("Password length should be greater than or equal to the sum of symbols and digits");
    //     }

    //     SecureRandom random = new SecureRandom();
    //     String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //     String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
    //     String digitsStr = "0123456789";
    //     String symbolsStr = "!@#$%^&*()_-+=<>?/\\|";
    //     StringBuilder passwordBuilder = new StringBuilder();
    //     int remainingCharacters = length - symbols - digits;

    //     for (int i = 0; i < symbols; i++) {
    //         passwordBuilder.append(symbolsStr.charAt(random.nextInt(symbolsStr.length())));
    //     }
    //     for (int i = 0; i < digits; i++) {
    //         passwordBuilder.append(digitsStr.charAt(random.nextInt(digitsStr.length())));
    //     }
    //     for (int i = 0; i < remainingCharacters; i++) {
    //         if (random.nextBoolean()) {
    //             passwordBuilder.append(upperAlphabet.charAt(random.nextInt(upperAlphabet.length())));
    //         } else {
    //             passwordBuilder.append(lowerAlphabet.charAt(random.nextInt(lowerAlphabet.length())));
    //         }
    //     }
    //     return passwordBuilder.toString();
    // }

    // public static boolean validate(String password) {
    //     boolean hasUppercase = !password.equals(password.toLowerCase());
    //     boolean hasLowercase = !password.equals(password.toUpperCase());
    //     boolean hasDigit = Pattern.compile("\\d").matcher(password).find();
    //     boolean hasSymbol = Pattern.compile("[!@#$%^&*()_\\-+=<>?/\\\\|]").matcher(password).find();
    //     if (password.length() >= 8 && hasUppercase && hasLowercase && hasDigit && hasSymbol) {
    //         return "Strong" != null;
    //     } else if (password.length() >= 6 && hasUppercase && hasLowercase && hasDigit) {
    //         return "Medium" != null;
    //     } else {
    //         return "Weak" != null;
    //     }
    // }


}
