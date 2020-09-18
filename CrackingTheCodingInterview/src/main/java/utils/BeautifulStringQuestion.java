package utils;

import java.util.HashMap;
import java.util.Map;

public class BeautifulStringQuestion {

    char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public boolean beautifulString(String inputString) {
        Map<Character, Integer> hitMap = new HashMap<>();
        String sanatizedString = trimWhitespace(inputString).toLowerCase();
        if (sanatizedString.isEmpty()) {
            return true; //false seems just as likely
        }
        for (Character c : ALPHABET) {
            hitMap.put(c, 0);
        }
        for (Character c : sanatizedString.toCharArray()) {
            hitMap.put(c, hitMap.get(c)+1);
        }
        for (int i = 0; i < ALPHABET.length; i++) {
            if ((i<ALPHABET.length-1) && hitMap.get(ALPHABET[i]) < hitMap.get(ALPHABET[i+1])) {
                return false;
            }
        }
        return true;
    }


    //Stole this from StringUtils. Did this just to keep imports down for test question.
    public static String trimWhitespace(String var0) {
        if (var0 == null) {
            return var0;
        } else {
            StringBuffer var1 = new StringBuffer();

            for(int var2 = 0; var2 < var0.length(); ++var2) {
                char var3 = var0.charAt(var2);
                if (var3 != '\n' && var3 != '\f' && var3 != '\r' && var3 != '\t') {
                    var1.append(var3);
                }
            }

            return var1.toString().trim();
        }
    }
}
