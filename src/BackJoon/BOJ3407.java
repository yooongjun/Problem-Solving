package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

// 맹세
public class BOJ3407 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < t; i++) {
            System.out.println(isPronounceable(bufferedReader.readLine()) ? "YES" : "NO");
        }
    }

    static boolean isPronounceable(String s) {
        String tmp = s.replaceAll(" ","").toLowerCase();

        HashSet<String> set = new HashSet<>(Arrays.asList("h", "b", "c", "n", "o", "f", "p", "s", "k", "v", "y", "i","w", "u","ba", "ca" , "ga", "la", "na", "pa", "ra", "ta", "db", "nb", "pb", "rb", "sb", "tb", "yb", "ac",
                "sc", "tc", "cd", "gd", "md", "nd", "pd", "be", "ce", "fe", "ge", "he", "ne", "re", "se", "te",
                "xe", "cf", "hf", "rf", "ag", "hg", "mg", "rg", "sg", "bh", "rh", "th", "bi", "li", "ni", "si",
                "ti", "bk", "al", "cl", "fl", "tl", "am", "cm", "fm", "pm", "sm", "tm", "cn", "in", "mn", "rn",
                "sn", "zn", "co", "ho", "mo", "no", "po", "np", "ar", "br", "cr", "er", "fr", "ir", "kr", "lr",
                "pr", "sr", "zr", "as", "cs", "ds", "es", "hs", "os", "at", "mt", "pt", "au", "cu", "eu", "lu",
                "pu", "ru", "lv", "dy"));



        for (int i = 0; i < tmp.length(); i++) {
            if (set.contains(tmp.substring(i, i + 1))) {
                continue;
            } else if (i < tmp.length() - 1 && set.contains(tmp.substring(i, i + 2))) {
                i++;
            } else {
                return false;
            }
        }

        return true;
    }

}
