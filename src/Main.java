import javax.annotation.processing.SupportedSourceVersion;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Main {
    static ArrayList<Block> blockchain = new ArrayList<>();

    public static void main(String[] args){
        Block b1 = new Block("0", "first");
        blockchain.add(b1);
        Block b2 = new Block(blockchain.get(blockchain.size() - 1).getHash(), "second");

        blockchain.add(b2);

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
    }

    public static boolean isChainValid(){
        Block cur = null;
        Block prev = null;

        for(int i = 1; i < blockchain.size(); i++){
            cur = blockchain.get(i);
            prev = blockchain.get(i - 1);

            if(!prev.getHash().equals(cur.getPreviousHash()))
                return false;
            if(!cur.getHash().equals(cur.calculateHash()))
                return false;
        }
        return true;
    }
}
