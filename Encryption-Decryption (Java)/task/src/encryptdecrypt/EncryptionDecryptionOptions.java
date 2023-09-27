package encryptdecrypt;

import encryptdecrypt.algorithms.EncryptionDecryptionAlgorithm;
import encryptdecrypt.algorithms.ShiftAlgorithm;

public class EncryptionDecryptionOptions {

    private Mode mode;
    private int key = 0;
    private String data = "";
    private String in;
    private String out;
    private EncryptionDecryptionAlgorithm algorithm = new ShiftAlgorithm();

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public EncryptionDecryptionAlgorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(EncryptionDecryptionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }
}
