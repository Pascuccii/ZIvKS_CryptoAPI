import javax.crypto.Cipher;
import java.io.*;
import java.security.Key;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            String srcPath;
            String resPath;
            File password = new File("password.txt");
            File source;
            File result;
            BufferedReader passReader = new BufferedReader(new FileReader(password));
            BufferedReader sourceReader;
            String pas = passReader.readLine().trim();
            FileWriter resWriter;

            int ch = 0;
            while (ch != 3) {
                System.out.println("Enter password (password.txt): ");
                if (!scan.nextLine().equals(pas))
                    continue;
                System.out.println("Choose operation type:\n1.Encryption\n2.Decryption");
                ch = scan.nextInt();
                scan.nextLine();
                System.out.println("Choose source file (source.txt): ");
                srcPath = scan.nextLine();
                System.out.println("Choose result file (result.txt): ");
                resPath = scan.nextLine();

                source = new File(srcPath);
                result = new File(resPath);

                sourceReader = new BufferedReader(new FileReader(source));

                String src = sourceReader.readLine();

                resWriter = new FileWriter(result, false);
                String res = "Error";
                Cipher cpr = Cipher.getInstance("AES");
                Key key = new Key() {
                    @Override
                    public String getAlgorithm() {
                        return null;
                    }

                    @Override
                    public String getFormat() {
                        return null;
                    }

                    @Override
                    public byte[] getEncoded() {
                        return new byte[0];
                    }
                };

                cpr.init(Cipher.DECRYPT_MODE, key);
                switch (ch) {
                    case 1:
                        res = src;
                        break;
                    case 2:
                        res = src;
                        break;
                }

                System.out.println("Source: " + src);
                System.out.println("Result: " + res);
                resWriter.write(res);
                resWriter.flush();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
