import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Scanner;

public class Whirpool {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Security.addProvider(new BouncyCastleProvider());

        System.out.println("Write input String : ");
        String s = new Scanner(System.in).nextLine();

        MessageDigest crypt = MessageDigest.getInstance("Whirlpool");
        crypt.update(s.getBytes(StandardCharsets.UTF_8));
        String digest = Hex.toHexString(crypt.digest());

        System.out.println(digest);
    }
}