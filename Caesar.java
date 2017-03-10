/**
 *
 * @author Taha Emara
 * Website: http://www.emaraic.com
 * Email  : taha@emaraic.com
 * Created on: Mar 5, 2017
 */
public class Caesar {

    private byte shift = 1;

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public byte getShift() {
        return shift;
    }

    public Caesar setShift(byte shift) {
        this.shift = shift;
        return this;
    }

    public String encrypt(String plaintext) {
        byte shift = this.getShift();
        StringBuilder ciphertext = new StringBuilder();

        for (char chr : plaintext.toLowerCase().toCharArray()) {
            byte position = (byte) alphabet.indexOf(chr);
            if (chr == ' ') {
                ciphertext.append(" ");
            } else {
                ciphertext.append(alphabet.charAt((position + shift) % 26));
            }
        }

        return ciphertext.toString();
    }

    public String decrypt(String chipertext) {
        byte shift = this.getShift();
        StringBuilder ciphertext = new StringBuilder();

        for (char chr : chipertext.toLowerCase().toCharArray()) {
            byte position = (byte) alphabet.indexOf(chr);
            if (chr == ' ') {
                ciphertext.append(" ");
            } else {
                /**
                 * In order to calculate mod for negative arguments we use
                 * Euclidean division (position - shift)<0 ? ((position - shift)%26 + 26)%26 : (position - shift)%26) 
                 *
                 */
                ciphertext.append(alphabet.charAt((position - shift) < 0 ? ((position - shift) % 26 + 26) % 26 : (position - shift) % 26)); // this
                //Uncomment the next line if you use in Java 8
                // ciphertext.append(alphabet.charAt(Math.floorMod(position - shift ,26))); }
            }}

            return ciphertext.toString();      
    }
    
    
    
    /* Test */
    public static void main(String[] args) {
        String plaintext = "ceasar encryption algorithm";
        Caesar ceasar = new Caesar();
        System.out.println("Plaintext message : " + plaintext);
        String ciphertext = ceasar.setShift((byte) 3).encrypt(plaintext);
        System.out.println("Ciphertext message: " + ciphertext);
        System.out.println("Recovered message : " + ceasar.setShift((byte) 3).decrypt(ciphertext));

    }

}
