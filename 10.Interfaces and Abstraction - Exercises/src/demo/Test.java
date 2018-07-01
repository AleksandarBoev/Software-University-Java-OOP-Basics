package demo;

public class Test implements ITest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("aaaaa").append("\n");
        sb.delete(sb.length() - 1, sb.length());
        sb.append("bbbbb");

//        for (int i = 0; i < sb.length(); i++) {
//            System.out.println(sb.charAt(i));
//        }
        System.out.println(sb);
    }
}
