package Strings;

public class AnagramOfEachOther {
    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "baa";
        boolean b = checkAnagrams(s1,s2);
        System.out.println("Anagrams "+b);
    }

    private static boolean checkAnagrams(String s1, String s2) {
        int arr[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            int pos = s1.charAt(i)%97;
            int pos2 = s2.charAt(i)%97;
            arr[pos]++;
            arr[pos2]--;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
}
