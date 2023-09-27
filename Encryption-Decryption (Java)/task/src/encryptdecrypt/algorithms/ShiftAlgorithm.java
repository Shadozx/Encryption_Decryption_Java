package encryptdecrypt.algorithms;

import encryptdecrypt.algorithms.EncryptionDecryptionAlgorithm;

public class ShiftAlgorithm implements EncryptionDecryptionAlgorithm {
    @Override
    public String encrypt(String data, int key) {
        StringBuilder encryptedData = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) (base + (c - base + key) % 26);
            }
            encryptedData.append(c);
        }
        return encryptedData.toString();
    }

    @Override
    public String decrypt(String data, int key) {

        return encrypt(data, 26 - key);
    }
}
