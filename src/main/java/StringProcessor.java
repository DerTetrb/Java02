public class StringProcessor {
    public static String copyString(String str, int n) {
        String copy = "";
        if (n < 0) throw new IllegalArgumentException("n<0");
        if (n == 0) return copy;
        for (int i = 0; i < n; i++) copy += str;
        return copy;
    }

    public static int contains(String str1, String str2) {
        if (str1 == null || str2 == null || str2.isEmpty()) throw new IllegalArgumentException("String null");
        if (str1.length() < str2.length()) throw new IllegalArgumentException("Length error");

        int res = 0;

        int i = str1.indexOf(str2);
        while (i >= 0) {
            res++;
            i = str1.indexOf(str2, ++i);
        }
        return res;
    }

    public static String newString(String str) {
        if (str == null) throw new IllegalArgumentException("string null");
        if (str.equals("")) return "";

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

    /*public static void main(String[] args) {
        System.out.println(copyString("String", 0));
        System.out.println(copyString("String", 3));
        System.out.println(contains("abcadababababab", "j"));
        System.out.println(contains("abcadababababab", "ab"));
        System.out.println(newString("this is 311 \nthis is 222\nthis is 3  301"));

        StringBuilder stringBuilder = new StringBuilder("abababababababa");
        redactStringBuilder(stringBuilder);
        System.out.println(stringBuilder);
    }*/
}
