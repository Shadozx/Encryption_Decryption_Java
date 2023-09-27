package encryptdecrypt.algorithms;

import encryptdecrypt.algorithms.EncryptionDecryptionAlgorithm;

public class UnicodeAlgorithm implements EncryptionDecryptionAlgorithm {

    @Override
    public String encrypt(String data, int key) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);

            encryptedMessage.append((char) (c + key));
        }

        return encryptedMessage.toString();

    }

    @Override
    public String decrypt(String data, int key) {
        return encrypt(data, -key);
    }
}
