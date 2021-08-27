import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pattern_Matching {
    Pattern pattern = Pattern.compile("'.*'");
    Matcher matcher = pattern.matcher("'Moin Folks");
    boolean doesMatch = matcher.matches();



    public static void main(String[] args) {

    }
}