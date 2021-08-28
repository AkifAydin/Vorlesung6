package Bestellung;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class ScanBestellung {

    public static void main(String[] args) throws FileNotFoundException {
        //zeilen();
        //zeilenOhneLeerzeilen();
        System.out.println((scanMatch()));
    }

    public static List<Bestellung> scanMatch() throws FileNotFoundException {
        // a5datei liegt im Rootverzeichnis des Javaprojektes
        List<Bestellung> bestellListe = new ArrayList<Bestellung>();
        try (Scanner scanner = new Scanner(new File("C:\\temp\\mypack\\Vorlesung6\\src\\Bestellung\\a5datei"))) {
            Pattern leerZeile = Pattern.compile("\\s*");
            // Muster um die Token einer Zeile zu lesen
            Pattern delims = Pattern.compile("\\s*(\\$|&|%)\\s*");
            // Zeilen einlesen und Leerzeilen überspringen
            while (scanner.hasNextLine()
                    && scanner.skip(leerZeile).hasNextLine()) {
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(delims);
                // Bestellnummer
                String bestnr = lineScanner.next();
                Bestellung best = new Bestellung(bestnr);
                // Positionen
                String name = "";
                while (lineScanner.hasNext()) {
                    if (lineScanner.hasNextInt()) {
                        best.add(new Position(name, lineScanner.nextInt()));
                    } else {
                        name = lineScanner.next();
                    }
                }
                bestellListe.add(best);
                lineScanner.close();
            }
        }
        return bestellListe;
    }

    private static void  zeilen() throws FileNotFoundException {

        // a5datei liegt im Rootverzeichnis des Javaprojektes
        try (Scanner scanner = new Scanner(new File("C:\\temp\\mypack\\Vorlesung6\\src\\Bestellung\\a5datei"))) {
            // Zeilen einlesen
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println((line));
            }
        }
    }

    private static void  zeilenOhneLeerzeilen() throws FileNotFoundException {
        // a5datei liegt im Rootverzeichnis des Javaprojektes
        try (Scanner scanner = new Scanner(new File("C:\\temp\\mypack\\Vorlesung6\\src\\Bestellung\\a5datei"))) {
            Pattern leerZeile = Pattern.compile("\\s*");
            // Zeilen einlesen und Leerzeilen überspringen
            while (scanner.hasNextLine()
                    && scanner.skip(leerZeile).hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println((line));
            }
        }
    }

}