import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.String;
public class Hacker {
    //What does he have?
    String cipherText;
    int keyLength;
    boolean keyFound;
    String plainText;
    Dict dictionary;
    char[] arr;

    Hacker(String cText, int keyL) throws FileNotFoundException {
        arr=new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        cipherText=cText;
        keyLength=keyL;
        plainText="";
        keyFound=false;
        dictionary= new Dict();
    }
    private char shiftLetter(char ch, char k){
        char shift;
        if(ch<97){
            int pos=ch-65;
            int computed=(pos - (k-97))%26;
//            System.out.println(ch + " " +  pos +  " " + computed);
            shift= Character.toUpperCase(arr[computed<0?computed+26:computed]);
        }
        else{
            int pos=ch-97;
            int computed=(pos - (k-97))%26;
            shift= arr[computed<0?26+computed:computed];
        }
        return shift;
    }

    private void checkKey(String key){
        StringBuilder plainText= new StringBuilder();

        int i=0; // counter for key
        for(char ch : cipherText.toCharArray()){
            if(ch!=' ') {
                char plain= shiftLetter(ch, key.charAt(i));
                plainText.append(plain);
                i=(i+1)%key.length();
            }
            else{
                plainText.append(' ');
            }
        }
        //check the words in the plaintext with a dictionary
        String[] words= plainText.toString().split("\\s+");
        if(dictionary.find(words)){
            System.out.println("The key found: "+ key);
            this.plainText=plainText.toString();
            System.out.println("Message decrypted: " + this.plainText);
            System.out.println("Does this make sense? (yes/no)");
            Scanner scan= new Scanner(System.in);
            String ans=scan.next();
            if(ans.equals("yes") || ans.equals("Yes") || ans.equals("YES"))
                keyFound=true;
        }
        
    }

    private void keyGenerator(StringBuilder key){
        if(keyFound){
            return;
        }

        if(key.length()==keyLength){
//            System.out.println("Checking: " + key.toString());
            checkKey(key.toString());
            return;
        }
        for(int i=0;i<26;i++){
            if(keyFound){
                return;
            }
            keyGenerator(key.append(arr[i]));
            key.deleteCharAt(key.length()-1);
        }
    }

    public String breakCipher(){
        keyGenerator(new StringBuilder());
        return plainText;
    }

//    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan= new Scanner(System.in);
//        System.out.println("Enter a cipherText");
//        String cipherText= scan.nextLine();
//        System.out.println("Enter Key length");
//        int kLen= scan.nextInt();
//        Hacker hacker= new Hacker(cipherText,kLen);
//        System.out.println(hacker.breakCipher());
//    }

}
