package WordChain;

public class DistanceCalculator {

    public static int numberOfChanges(String w1, String w2) {
        return calculateDistance(w1.toCharArray(), w2.toCharArray());
    }

    private static int calculateDistance(char[] c1, char[] c2) {

        // Mátrix amiben a távolságokat tároljuk, erre a rekurzió elkerülése érdekében van szükség
        int[][] d = new int[c1.length + 1][c2.length + 1];

        for(int i = 0; i < c1.length + 1; i++) {
            d[i][0] = i;
        }

        for(int j = 0; j < c2.length + 1; j++) {
            d[0][j] = j;
        }

        for(int i = 1; i < c1.length + 1; i++) {
            for(int j = 1; j < c2.length + 1; j++) {
                int d1 = d[i - 1][j] + 1; // Törlés számolása
                int d2 = d[i][j - 1] + 1; // Beszúrás számolása
                int d3 = d[i - 1][j - 1]; // Csere számolása
                if (c1[i - 1] != c2[j - 1]) d3 += 1; // Csere számolásának kiegészítő feltétele
                d[i][j] = Math.min(Math.min(d1, d2), d3);
            }
        }

        return d[c1.length][c2.length];
    }
}
