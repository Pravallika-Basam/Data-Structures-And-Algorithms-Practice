package Strings;

public class PractiseStrings {
    public static void main(String[] args) {
        String m = new String("aabbccddee");
        String s = m;
        m+=(" hello");
        System.out.println("m is "+m);
        System.out.println("s is "+s);
        System.out.println("Same object "+(s==m));
    }
}
