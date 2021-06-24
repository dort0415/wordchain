import WordChain.WordChainGenerator;

import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            // Input fájl beolvasása
            File input = new File("input.txt");
            Scanner sc = new Scanner(input);
            String line = sc.nextLine();
            // Szavak tömbbé alakítása
            String[] words = line.split(" ");

            // Szólánc elkészítése
            String[] result = WordChainGenerator.makeWordChain(words);
            if(result != null){
                for(String w : result){
                    System.out.print(w+" ");
                }
            }else{
                System.out.println("A megadott szavakbol nem lehet szolancot epiteni!");
            }
        }catch (Exception e){
            System.err.println("Hiba tortent a fajl olvasasa kozben.");
        }
    }

}
