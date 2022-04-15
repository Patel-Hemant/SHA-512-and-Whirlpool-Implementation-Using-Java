import java.security.*;
import java.math.BigInteger;
import java.util.*;

class Main {

    public static void main(String[] args) {
        System.out.println("Write String for encrypt Using SHA-512 Algorithm : ");
        String s = new Scanner(System.in).nextLine();
        System.out.println("Encrypted Data of " + s + " :  \n" + encrypt(s));
    }

    // Encrypt Function
    public static String encrypt(String input) {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);

            while (hashtext.length() < 32) hashtext = "0" + hashtext;

            return hashtext;

        } catch (Exception e) {
            // For specifying wrong message digest algorithms
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}