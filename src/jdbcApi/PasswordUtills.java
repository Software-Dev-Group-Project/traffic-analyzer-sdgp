package jdbcApi;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Authorship information 
 * @author Gervais Boadi Appiah, w1735205
 * Information: This is a java file that is used for password encryption and verification 
 */
 
public class PasswordUtills {
    
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;
    
     public static String getSalt(int length) {
        StringBuilder returnValue = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(returnValue);
    }

    public static byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }
    
    //This method generates the secure password
    public static String generateSecurePassword(String password, String salt) {
        String generatedSP;

        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
 
        generatedSP = Base64.getEncoder().encodeToString(securePassword);
        System.out.println("Secure Password has been generated! \n");
        return generatedSP;
    }
    
    //This method verifies a users password
    public static boolean verifyUserPassword(String providedPassword, String securedPassword, String salt)
    {
        boolean outcome;
        
        // Generate New secure password using the same salt
        String newSecurePassword = generateSecurePassword(providedPassword, salt);
        
        // Verfies if two passwords are equal
        outcome = newSecurePassword.equalsIgnoreCase(securedPassword);
        System.out.println("Password verification has returned: "+ outcome);
        return outcome;
    }
}