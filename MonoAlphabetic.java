
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Taha Emara 
 * Website: http://www.emaraic.com 
 * Email : taha@emaraic.com
 * Created on: Mar 5, 2017
 */
public class MonoAlphabetic {

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public String getCharsPermutation() {//Get shuffled alphabet  

        Set set = new LinkedHashSet(); // I use linkedhashset because we don't want a sorted set 
        SecureRandom random;
        StringBuilder chars = new StringBuilder();
        try {
            random = SecureRandom.getInstance("SHA1PRNG");
            while (set.size() < 26) {
                set.add(alphabet.charAt(random.nextInt(alphabet.length())));
            }
            for (Object object : set) {
                chars.append(object);
            }
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("No such Algorithm");
        }
        return chars.toString();
    }

    public String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();

        for (char chr : plaintext.toLowerCase().toCharArray()) {
            byte position = (byte) alphabet.indexOf(chr);
            if (chr == ' ') {
                ciphertext.append(" ");
            } else {
                ciphertext.append(key.charAt(position));
            }
        }

        return ciphertext.toString();
    }
    
    public String decrypt(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder();

        for (char chr : ciphertext.toLowerCase().toCharArray()) {
            byte position = (byte) key.indexOf(chr);
            if (chr == ' ') {
                plaintext.append(" ");
            } else {
                plaintext.append(alphabet.charAt(position));
            }
        }

        return plaintext.toString();
    }

    /* Test */
    public static void main(String[] args) {
        String plaintext="monoalphabetic encryption algorithm";
        MonoAlphabetic mono = new MonoAlphabetic();
        String key=mono.getCharsPermutation();
        System.out.println("Plaintext : "+plaintext +"\nAlphabet  : "+alphabet+"\nkey       : "+key);
        String ciphertext=mono.encrypt(plaintext, key);
        System.out.println("Ciphertext message: "+ciphertext);
        System.out.println("Recovered message : " +mono.decrypt(ciphertext,key ));
        

    }
}
