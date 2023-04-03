import java.util.Scanner;

public class Q3Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("The length of the password you want: ");

        int length = (int) scanner.nextInt();

        System.out.println("Number of digits you want: ");

        int numDigits = (int) scanner.nextInt();

        System.out.println("Number of symbols you want: ");

        int numSymbols = (int) scanner.nextInt();



        Password password = new Password(length, numDigits, numSymbols);



        if(length<8 && numDigits<=1 && numSymbols<=2){
              System.out.println("Poor");
        }

        if(length>8 && numDigits>1 && numSymbols>2){
              System.out.println("Good");
        }

        if(length>12 && numDigits>3 && numSymbols>3){
              System.out.println("ok");
        }
        if(length>=16 && numDigits>4 && numSymbols>4){
              System.out.println("Excellent");
        }


    }
}







// public class Q3Main {
//     private static final String Password = null;

// public static void main(String[] args) {
//         String[] passwordsToTest = {
//             "gD3Wd$^Skw2d%E\\8",
//             "P@ssw0rd",
//             "strongP@55",
//             "weakpass",
//             "Med1um"
//         };

//         for (String password : passwordsToTest) {
//             System.out.println("Password: " + password + ", Validation: " + Password.validate(password));
//         }
//     }
// }