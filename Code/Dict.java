import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Dict {
//    Trie trie;
//    String[] words= new String[]{"attack", "at", "dawn","regroup", "alpha","beta","delta","ten",
//    "four","asap","military","defense","outnumbered","situation","report","copy","that","repeat",
//    "cancel","rendezvous", "closing","in","are","is","guns","arms","ammunition","ammo","out","of","under",
//    "heavy","fire","dusk","operation","secret","troops","tank","tanks","infantry","intelligence","message",
//    "lets","let","us","we","order","squad","major","general","lotus","the","field","battle",
//    "battlefield","garden","gardeners","surrounded","surrender","give","up","hold","position",
//    "i","them","us"};
    static String path="";
    HashSet<String> words;

//    Dict(){
//        trie=new Trie();
//        for(String word: words){
//            trie.insert(word);
//        }
//        //words added in the dictionary
//    }

    Dict() throws FileNotFoundException {
        //read the file and add everything to the hashset
        words=new HashSet<>();
        Scanner scan=new Scanner(System.in);
        File file = new File(path);
        Scanner sc= new Scanner(file);
        while (sc.hasNext()){
            words.add(sc.next());
        }
//        System.out.println(words.size());
    }

    boolean find(String[] words){
        float total= words.length;
        float found=0;
        for(String word:words){
            if(this.words.contains(word.toLowerCase())){
                found++;
            }
        }

        float percent = (found/total)*100;
//        System.out.println(percent);
        if(percent>=68.0){
            System.out.println(percent + "% of words found in the dictionary");
            return true;
        }
        return false;
    }

}
