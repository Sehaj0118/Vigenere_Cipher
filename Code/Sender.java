import java.util.Scanner;

public class Sender {
    //What will he have
    char[] arr;
    String key;
    String plainText;
    Sender(String pText, String k){
        arr=new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        key=k;
        plainText=pText;
    }
    Sender(String k){
        key=k;
    }

    private char shiftLetter(char ch, char k){
        char shift;
        if(ch<97){
            int pos=ch-65;
//            System.out.println(ch + " " +  pos);
            shift= Character.toUpperCase(arr[(pos+ (k-97))%26]);
        }
        else{
            int pos=ch-97;
            shift= arr[(pos+ (k-97))%26];
        }
        return shift;
    }

    public String encode(){
        StringBuilder cipherText= new StringBuilder();

        int i=0; // counter for key
        for(char ch : plainText.toCharArray()){
            if(ch!=' ') {
                char ciph= shiftLetter(ch, key.charAt(i));
                cipherText.append(ciph);
                i=(i+1)%key.length();
            }
            else{
                cipherText.append(' ');
            }
        }

        return cipherText.toString();
    }

//    public static void main(String[] args) {
//        Scanner scan= new Scanner(System.in);
//        System.out.println("Enter a plain text");
//        String plainText= scan.nextLine();
//        System.out.println("Enter the Key for encryption");
//        String key= scan.nextLine();
//        Sender sender= new Sender(plainText, key);
//        System.out.println(sender.encode());
//
//    }

}
