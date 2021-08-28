import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scanning {
    public static void matchingScanning(){
        List<String> list = new ArrayList<String>();
        String str = "Ein    Tag   im Jahr    der    Schlange";
        Scanner scn = new Scanner(str);
        scn.useDelimiter("\\s+");
        while (scn.hasNext()){
            list.add(scn.next());
        }
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        matchingScanning();
    }
}
