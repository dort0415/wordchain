package WordChain;

import java.util.*;

public class WordChainGenerator {

    public static String[] makeWordChain(String[] words) {
        Map<Integer, Set<Integer>> map = makeMap(words);

        Set<List<Integer>> results = new HashSet<List<Integer>>();

        // Map-ek végigjárása és szóláncok felépítése
        for (Map.Entry<Integer, Set<Integer>> e : map.entrySet()) {
            List<Integer> built = new ArrayList<>();
            built.add(e.getKey());
            buildWordChain(map, e.getValue(), built, results);
        }

        // Ellenőrzés, hogy létezik-e szólánc, ha nem null visszatérési érték
        if (results.size() == 0) {
            return null;
        }

        // Elkészült szólánchoz szükséges tömb létrehozása és inicializálása
        String[] chain = new String[words.length];

        // Első kész szólánc lekérése
        List<Integer> list = results.iterator().next();

        // Szólánc felépítése az indexek alapján
        for(int i = 0; i < words.length; i++){
            chain[i] = words[list.get(i)];
        }

        return chain;
    }

    private static Map<Integer, Set<Integer>> makeMap(String[] words) {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();

        // Integer setek inicializálása a map-ben.
        for (int i = 0; i < words.length; i++) {
            map.put(i, new HashSet<Integer>());
        }

        // Azon szavak indexeinek keresése és csoportosítása amelyeknél csak 1 betű különbség van
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    continue;
                }
                if (DistanceCalculator.numberOfChanges(words[i], words[j]) == 1) {
                    map.get(i).add(j);
                }
            }
        }

        return map;
    }

    private static void buildWordChain(Map<Integer, Set<Integer>> map, Set<Integer> set, List<Integer> built, Set<List<Integer>> results) {

        // Elkészült szólánc hozzáadása az eredményekhez
        if (built.size() == map.size()) {
            results.add(built);
        }

        // Rekurzív szólánc építés
        for (int i : set) {
            if (built.contains(i)) {
                continue;
            }
            List<Integer> newList = new ArrayList<>(built);
            newList.add(i);
            buildWordChain(map, map.get(i), newList, results);
        }
    }
}
