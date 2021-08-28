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
        }
    }


    private static void capturingGroups2() {
        String regex = "((\\d+?)([a-zA-Z.]+(\\d+?)))";
        String str = "123aaaaXX.klaa756";
        Pattern pt = Pattern.compile(regex);
        Matcher matcher = pt.matcher(str);
        for (int i = 0; ; ) {
            while (matcher.find(i)) {
                System.out.println(matcher.group(0));
                System.out.println(matcher.group(1));
                System.out.println(matcher.group(2));
                System.out.println(matcher.group(3));
                System.out.println(matcher.group(4));
                i = matcher.start() + 1;
            }
            break;
        }
    }

    public static void a1() {
        String regex = "((\\d{1})\\d*(\\d{1}))";
        //String regex = "/^[0-9].*[0-9]$/igm";
        String zahlenfolge = "512345";
        Pattern pt = Pattern.compile(regex);
        Matcher mt = pt.matcher(zahlenfolge);
        System.out.println(mt);
        while (mt.find()) {
            System.out.println(mt.group(0));
            System.out.println(mt.group(1));
            System.out.println(mt.group(2));
            System.out.println(mt.group(3));
            System.out.println(mt.group(2).equals(mt.group(3)));
        }
        // System.out.println(mt.start(0) == mt.end(zahlenfolge.length()-1));
    }

    public static void a2() {
        String regex = "<.*>\\s(.*)\\s</.*>";
        Pattern pt = Pattern.compile(regex);
        Matcher matcher = pt.matcher("<h1> Hallo Welt </h1>");
        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
        }
    }

    public static void a3() {
        String regex = "(\\s([A-Z{1}][a-z]+)\\s([A-Z{1}][a-z]+)\\s)";
        String name = "Akif Aydin";
        Pattern pt = Pattern.compile(regex);
        Matcher mt = pt.matcher(name);
        //System.out.println(mt.replaceAll("$2$1"));
        while (mt.find()) {
            System.out.println(mt.group(0));
            System.out.println(mt.group(1));
            System.out.println(mt.group(2));
            System.out.println(mt.group(3));
            String sb = mt.group(3) + " " + mt.group(2);
            System.out.println(sb);
        }
    }

    private static void capturingGroups3() {
        String regex = "((.{2})\\s(.{3}\\s(.{3})))";
        Pattern pt = Pattern.compile(regex);
        Matcher matcher = pt.matcher("--das-matched-nicht--Ab zwo Uhr--das-matched-nicht--");
        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group(4));
        }
    }

    public static void urlParse() {
        String regex = "<a href=\"(.*?)\".*?>";
        Pattern pt = Pattern.compile(regex);
        Matcher matcher = pt.matcher("<a href=\"http://haw-hamburg.de\"   HAW >");
        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
        }
    }

    private static void wordBoundaries(){
        String calender = "2.11.2015, 12:30, 13:30, Labor\n"
                + "2.11.2015, 14:00, 16:00, Masterkurs\n"
                + "12.11.2015, 8:15, 11:30, Praktikum\n"
                + "nonsense 2.11.2015, 9:00, 15:00, Bremen\n";
        String regex = "^2\\.11\\.2015\\s*,(.*)\\s";
        Matcher mt = Pattern.compile(regex).matcher(calender);
        while (mt.find()){
            System.out.println(mt.group(1));
        }
    }

    public static void main(String[] args) {
        System.out.println("capturingGroups1");
        capturingGroups1();
        System.out.println("capturingGroups2");
        capturingGroups2();
        System.out.println("capturingGroups3");
        capturingGroups3();
        System.out.println("UrlParsen");
        urlParse();
        System.out.println("Aufgabe.1");
        a1();
        System.out.println("Aufgabe.2");
        a2();
        System.out.println("Aufgabe.3");
        a3();
        System.out.println("wordBoundaries");
        wordBoundaries();
    }
}


