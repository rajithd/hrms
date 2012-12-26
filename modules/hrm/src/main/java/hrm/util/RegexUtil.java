package hrm.util;

import java.util.regex.Pattern;

/**
 * Responsible for checking given reg ex is validating
 */
public class RegexUtil {

    private static final Pattern alphaCharPattern = Pattern.compile("\\p{Alpha}*");

    public static boolean isValidateAlphaChars(String input){
        return alphaCharPattern.matcher(input).matches();
    }

}
