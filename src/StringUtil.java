import java.security.MessageDigest;

public class StringUtil {
    public static String applySHA256(String input){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(input.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) sb.append('0');
                sb.append(hex);
            }
            return sb.toString();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
