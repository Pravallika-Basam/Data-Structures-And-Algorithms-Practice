package Strings;

public class PalindromeString {
    public static void main(String[] args) {
        String s = "aba";
       boolean b =  palindrome(s);
        System.out.println(b);
    }

    private static boolean palindrome(String s) {
        int start = 0,end = s.length()-1;
        while (start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
