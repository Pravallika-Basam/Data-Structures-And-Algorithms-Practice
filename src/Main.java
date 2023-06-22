public class Main {
    public void main(String args[]) {
        System.out.println("Hello world!");
        try{
            return;
        } catch (Exception e) {
            return;
        } finally {
            System.out.println("Hi I am still in Final block!!");
        }
    }
}