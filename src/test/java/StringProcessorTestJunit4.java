import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringProcessorTestJunit4 {

    @Test
    public void copyString() {
        String s = "";
        s = StringProcessor.copyString("a", 4);
        assertEquals("aaaa", s);
        System.out.println(s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCopyString1Fail() {
        StringProcessor.copyString("a", -2);
    }

    @Test
    public void contains() {
        assertEquals(2, StringProcessor.contains("abcabc", "b" ));
        assertEquals(0,StringProcessor.contains("absda","i"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testContainsFail() {
        StringProcessor.contains("abcd", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContainsFail1() {
        StringProcessor.contains("abcd", "abcde");
    }


    @Test
    public void newString() {
        assertTrue("одиндватри4".equals(StringProcessor.newString("1234")));
    }


    @Test
    public void redactStringBuilder() {
        StringProcessor str = new StringProcessor();
        StringBuilder s = new StringBuilder("123456789");
        str.redactStringBuilder(s);
        assertEquals("13579", s.toString());
        System.out.println(s);
    }


}