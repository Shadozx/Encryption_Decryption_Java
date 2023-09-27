package encryptdecrypt;


import encryptdecrypt.algorithms.UnicodeAlgorithm;

import java.io.*;

public class Main {
    public static void main(String[] args) {


        var options = parseOptions(args);


        String text = options.getData();

        if (text.isEmpty() && !options.getIn().isEmpty()) {
            text = readFromFile(options.getIn());
        }

        String result;
        if (options.getMode() == Mode.ENCRYPT) {
            result = options.getAlgorithm().encrypt(text, options.getKey());
        } else if (options.getMode() == Mode.DECRYPT) {
            result = options.getAlgorithm().decrypt(text, options.getKey());
        } else {
            System.out.println("Invalid mode");
            return;
        }

        if (!options.getOut().isEmpty()) {
            writeToFile(result, options.getOut());
        } else {
            System.out.println(result);
        }
    }

    public static EncryptionDecryptionOptions parseOptions(String[] args) {
        var options = new EncryptionDecryptionOptions();

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            switch (arg) {
                case "-mode" -> {
                    String modeArg = args[i + 1];
                    if (modeArg.equals("enc")) {
                        options.setMode(Mode.ENCRYPT);
                    } else if (modeArg.equals("dec")) {
                        options.setMode(Mode.DECRYPT);
                    }
                }
                case "-data" -> options.setData(args[i + 1]);
                case "-in" -> options.setIn(args[i + 1]);
                case "-out" -> options.setOut(args[i + 1]);
                case "-alg" -> {
                    String alg = args[i + 1];
                    if (alg.equals("unicode")) {
                        options.setAlgorithm(new UnicodeAlgorithm());
                    }
                }
                case "-key" -> {
                    try {
                        options.setKey(Integer.parseInt(args[i + 1]));
                    } catch (NumberFormatException e) {
                        System.out.println("Error:" + e.getMessage());
                    }
                }
            }
        }

        return options;
    }


    public static String readFromFile(String inFile) {

        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return text.toString();
    }

    public static void writeToFile(String text, String outFile) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outFile))) {

            writer.write(text);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
