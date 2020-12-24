import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class VigenereCipher {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan= new Scanner(System.in);

        System.out.println("Enter the plain text messages that the sender will send");
        String plainText= scan.nextLine();
        System.out.println("Enter the key for encryption");
        String key= scan.next().toLowerCase();
        int kLength= key.length();
        //All necessary sender information gathered
        Sender sender= new Sender(plainText,key);
        String cipherText=sender.encode();
        System.out.println("Sending the cipher text: " + cipherText);

        Receiver receiver= new Receiver(cipherText, key);
        System.out.println("Received by the receiver... Decrypting.. \n");
        System.out.println("Received decrypted messages: " + receiver.decode() + "\n");

        System.out.println("Interference by a hacker... He got hold of the cipher text.");
        System.out.println("Enter the full path to the 'words.txt' file: ");
        String path= scan.next();
        long startTime = System.currentTimeMillis();
        Dict.path=path;
        for(int i=1;i<=6;i++) {
            Hacker hacker = new Hacker(cipherText, i);
            hacker.breakCipher();
            if (hacker.keyFound) {
                System.out.println("Hacker plainText: " + hacker.plainText);
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        //System.out.println("Time taken to crack the key (seconds): " + (endTime-startTime)/1000f);
    }
}

// C:\Users\sehaj\Desktop\Monsoon2020\NS\Assignments\Assignment_1\Code\words.txt
