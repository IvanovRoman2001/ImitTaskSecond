package imit.taskSecond;

public class StringProcessor {
    public static String copyString(String str, int n) {
        if (str == null) throw new IllegalArgumentException();
        if (n < 0) throw new IllegalArgumentException("n < 0");
        if (n == 0) return "";

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(str.repeat(n));

        return stringBuilder.toString();
    }

    public static int entryStr(String str1, String str2) {
        if (str1 == null || str2 == null || str2.isEmpty()) throw new IllegalArgumentException("Can't be empty");
        if (str1.length() < str2.length()) throw new IllegalArgumentException("Length error");

        int res = 0;

        for (int i = 0; i <= str1.length() - str2.length(); i++) {
            if (str2.equals(str1.subSequence(i, str2.length() + i).toString())) res++;
        }

        return res;
    }

    public static String newString(String str) {
        if (str == null) throw new IllegalArgumentException("str can't be null");
        if (str.isEmpty()) return "";

        str = str.replaceAll("1", "один");
        str = str.replaceAll("2", "два");
        str = str.replaceAll("3", "три");

        return str;
    }

    public static void redactStringBuilder(StringBuilder stringBuilder) {
        if (stringBuilder == null || stringBuilder.length() < 2) return;

        int size = stringBuilder.length();

        for (int i = 1; i < size; i++) {
            if (i >= stringBuilder.length()) return;
            stringBuilder.deleteCharAt(i);
        }
    }
}
