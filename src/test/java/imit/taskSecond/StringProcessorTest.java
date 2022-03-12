package imit.taskSecond;

import imit.taskSecond.StringProcessor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static imit.taskSecond.StringProcessor.*;
import static org.testng.Assert.assertEquals;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;

//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.fail;

//import static org.junit.Assert.*;

public class StringProcessorTest {
/*
    @org.junit.Test
    public void copyString() {
        String str = "World";
        String expected = "WorldWorldWorld";
        assertEquals(expected, StringProcessor.copyString(str, 3));
    }

    @org.junit.Test
    public void entryStr() {
        String str = "darhjdakkda";
        int expected = 3;
        assertEquals(expected, StringProcessor.entryStr(str, "da"));
    }

    @org.junit.Test
    public void newString() {
        String str = "123";
        String expected = "одиндватри";
        assertEquals(expected, StringProcessor.newString(str));
    }

    @org.junit.Test
    public void redactStringBuilder() {
        StringBuilder str = new StringBuilder("abcdef");
        String expected = "ace";
        StringProcessor.redactStringBuilder(str);
        assertEquals(expected, str.toString());
    }
}
   */
    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {"N", 3, "NNN"},
                {"qwe", 3, "qweqweqwe"},
                {"", 3, ""},
                {"", 0, ""}
        };
    }

    @DataProvider
    public static Object[][] countData() {
        return new Object[][]{
                {"a", "a", 1},
                {"aa", "a", 2},
                {"aaa", "aa", 2},
                {"aaaa", "vvv", 0},
                {"aeqra facwda", "a", 4},
        };
    }

    @DataProvider
    public static Object[][] countDataEx() {
        return new Object[][]{
                {"", ""},
                {"", "123",},
                {"123", ""}
        };
    }

    @DataProvider
    public static Object[][] onetwothreeData() {
        return new Object[][]{
                {"", ""},
                {"567890", "567890"},
                {" 1 ", " один "},
                {" 2", " два"},
                {"1 2 3", "один два три"}
        };
    }

    @DataProvider
    public static Object[][] changeWords() {
        return new Object[][]{
                {"", ""},
                {" qq ", " qq "},
                {"   123 erty 11 ", "   11 erty 123 "},
                {" 11 222 1234 23 456  ", " 456 23 1234 222 11  " }
        };
    }

    @DataProvider
    public static Object[][] changeAge() {
        return new Object[][]{
                {"Васе 0x00000010 лет", "Васе 16 лет"},
                {"Васе 0x00000010 лет, Андрею 0x00000011 лет", "Васе 16 лет, Андрею 17 лет"},
                {"Васе 16 лет", "Васе 16 лет"}
        };
    }

    @Test(dataProvider = "data")
    public void testCopy(String str, int N, String expected) {
        assertEquals(copyString(str, N), expected);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testCopyExc() throws IllegalArgumentException {
        copyString("qwe", -6);
    }

    @Test(dataProvider = "countData")
    public void testFind(String big, String small, int expected) {
        assertEquals(entryStr(big, small), expected);
    }

    @Test(dataProvider = "countDataEx", expectedExceptions = {IllegalArgumentException.class})
    public void testFind(String big, String small) {
        entryStr(big, small);
    }

    @Test(dataProvider = "onetwothreeData")
    public void testChange(String source, String expected) {
        assertEquals(newString(source), expected);
    }

    @Test
    public void testChange2() {
        StringBuilder stringBuilder = new StringBuilder("1234567");
        redactStringBuilder(stringBuilder);
        assertEquals(stringBuilder.toString(), "1357");
        redactStringBuilder(stringBuilder);
        assertEquals(stringBuilder.toString(), "15");
        redactStringBuilder(stringBuilder);
        assertEquals(stringBuilder.toString(), "1");
        redactStringBuilder(stringBuilder);
        assertEquals(stringBuilder.toString(), "1");
    }
}





/*
    @org.junit.Test
    public void copyString() {
        String str = "World";
        String expected = "WorldWorldWorld";
        assertEquals(expected, StringProcessor.copyString(str, 3));
    }

    @org.junit.Test
    public void entryStr() {
        String str = "darhjdakkda";
        int expected = 3;
        assertEquals(expected, StringProcessor.entryStr(str, "da"));
    }

    @org.junit.Test
    public void newString() {
        String str = "123";
        String expected = "одиндватри";
        assertEquals(expected, StringProcessor.newString(str));
    }

    @org.junit.Test
    public void redactStringBuilder() {
        StringBuilder str = new StringBuilder("abcdef");
        String expected = "ace";
        StringProcessor.redactStringBuilder(str);
        assertEquals(expected, str.toString());
    }*/