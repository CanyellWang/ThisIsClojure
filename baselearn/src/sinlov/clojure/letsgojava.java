package sinlov.clojure;

import com.sun.xml.internal.messaging.saaj.util.Base64;

import java.security.MessageDigest;


/**
 * Created by wangchangye on 17-7-21.
 */
public class letsgojava {
    private final static String hashKey = "universal_redis_hash_key";

    public static String hashName(String salt, String pw, int iter) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.reset();
            digest.update(salt.getBytes());
            digest.update(pw.getBytes());
            byte[] temp = digest.digest();
            for (int i = 0; i < iter; i++) {
                digest.reset();
                temp = digest.digest(temp);
            }
            byte[] bytes = Base64.encode(temp);
            String result = new String(bytes);
            return result.substring(0, 4);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
