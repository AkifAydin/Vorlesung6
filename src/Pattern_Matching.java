import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pattern_Matching {

    private static void capturingGroups1() {
        String regex = "((\\d+?)([a-zA-Z.]+(\\d+?)))";
        String str = "123aaaaXX.klaa756";
        Pattern pt = Pattern.compile(regex);
        Matcher matcher = pt.matcher(str);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group(4));
            System.out.println(matcher.start());
            System.out.println(matcher.end());
        }
    }

    public static void main(String[] args) {
        capturingGroups1();

    }


}