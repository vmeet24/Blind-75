import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    public boolean isNumber(String s) {
        boolean seenSign = false, seenDigit = false, seenDot = false, seenExponent = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'E' && s.charAt(i - 1) != 'e') {
                    return false;
                }
                seenSign = true;
            } else if (c == 'e' || c == 'E') {
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false;
            }else if(c == '.'){
                if(seenDot || seenExponent){
                    return false;
                }
                seenDot = true;
            }else{
                return false;
            }
        }
        return seenDigit;
    }
}
