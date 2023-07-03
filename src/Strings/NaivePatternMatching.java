package Strings;

import java.util.ArrayList;
import java.util.List;

public class NaivePatternMatching {
    public static void main(String[] args) {
//        String s = "abababacd";
//        String pat = "aba";
        String s = "aaaaaa";
        String pat = "ab";
        List<Integer> list = findPattern(s,pat);
        System.out.println(list.toString());

        s = "abcabcddabcd";
        pat = "abcd";
        list.clear();
        list = findPatternWithUniqueChars(s,pat);
        System.out.println(list.toString());

    }

    //When chars are unique

    private static List<Integer> findPatternWithUniqueChars(String s, String pattern) {
        List<Integer> indexes = new ArrayList<>();
        char[] str = s.toCharArray();
        char[] pat = pattern.toCharArray();
        int n = str.length;
        int m = pat.length;
        for (int i = 0; i <n-m+1 ; ) {
            boolean found = true;
            int j;
            for (j = 0; j < m; j++) {
                if(str[i+j]!=pat[j]){
                    found = false;
                    break;
                }
            }
            if(found){
                indexes.add(i);
            }
            if(j==0){
                i++;
            } else {
                i+=j;
            }

        }
        return indexes;
    }


    //When chars are not unique
    private static List<Integer> findPattern(String s, String pattern) {
        List<Integer> indexes = new ArrayList<>();
        char[] str = s.toCharArray();
        char[] pat = pattern.toCharArray();
        int n = str.length;
        int m = pat.length;
        for (int i = 0; i <n-m+1 ; i++) {
            boolean found = true;
            for (int j = 0; j < m; j++) {
                if(str[i+j]!=pat[j]){
                    found = false;
                    break;
                }
            }
            if(found){
                indexes.add(i);
            }
        }
        return indexes;
    }
}
