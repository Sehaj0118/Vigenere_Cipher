import java.util.Scanner;

public class Receiver {
    //What will he have
    char[] arr;
    String key;
    String cipherText;
    Receiver(String k){
        arr=new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        key=k;
    }
    Receiver(String cText, String k){
        arr=new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        key=k;
        cipherText=cText;
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

    public String decode (){
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

        return plainText.toString();
    }

//    public static void main(String[] args) {
//        Scanner scan= new Scanner(System.in);
//        System.out.println("Enter a cipher text");
//        String cipherText= scan.nextLine();
//        System.out.println("Enter the Key for decryption");
//        String key= scan.nextLine();
//        Receiver receiver= new Receiver(cipherText, key);
//        System.out.println(receiver.decode());
//    }
}
