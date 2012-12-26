package hrm.util;

import org.junit.Assert;
import org.junit.Test;


public class RegexUtilTest {

    String input = "abc";
    String input1 = "Aabc";
    String input2 = "Cabc";
    String input3 = "abc1";
    String input4 = "abc a";
    String input5 = "abc/";

    @Test
    public void testIsValidateAlphaChars(){
        Assert.assertTrue(RegexUtil.isValidateAlphaChars(input));
        Assert.assertTrue(RegexUtil.isValidateAlphaChars(input1));
        Assert.assertTrue(RegexUtil.isValidateAlphaChars(input2));
        Assert.assertFalse(RegexUtil.isValidateAlphaChars(input3));
        Assert.assertFalse(RegexUtil.isValidateAlphaChars(input4));
        Assert.assertFalse(RegexUtil.isValidateAlphaChars(input5));
    }
}
