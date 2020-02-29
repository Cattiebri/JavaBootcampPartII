package lv.accenture.bootcamp.network;

public class EffectiveString {

    public static void main(String[] args){
        String s = "";
        s+= "Hello";
        s+= " ";
        s+= "world";
        s+= "!";
        System.out.println(s);

        StringBuilder sb = new StringBuilder();

        sb.append("Hello");
        sb.append(" ");
        sb.append("world");
        sb.append("!");

        System.out.println(sb);

        String s2 = sb.toString();

        System.out.println(s2);
    }
}
