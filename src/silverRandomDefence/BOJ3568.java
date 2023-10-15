package silverRandomDefence;

import java.util.Scanner;

public class BOJ3568 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();

        String s[] = scanner.nextLine().replace(",", "").replace(";", "").split(" ");

        String prefix = s[0];

        for (int i = 1; i < s.length; i++) {
            String v = s[i];
            stringBuilder.append(prefix);
            for (int j = v.length() - 1; j >= 0; j--) {
                if (v.charAt(j) == ']') {
                    stringBuilder.append("[]");
                    j--;
                    continue;
                }
                else if (v.charAt(j) != '&' && v.charAt(j) != '*')
                {
                    stringBuilder.append(" ");
                    for (int k = 0; k <= j; k++) {
                        stringBuilder.append(v.charAt(k));
                    }
                    break;
                }

                stringBuilder.append(v.charAt(j));
            }
            stringBuilder.append(";");
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);


    }


}
