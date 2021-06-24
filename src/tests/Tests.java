package tests;

import WordChain.DistanceCalculator;
import WordChain.WordChainGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Tests {
    @Test
    public void checkDifference(){
        int numOfChanges = DistanceCalculator.numberOfChanges("Teszt", "Zest");
        assertEquals(2, numOfChanges);
    }

    @Test
    public void checkDifferenceIfOneEmpty(){
        int numOfChanges = DistanceCalculator.numberOfChanges("Teszt", "");
        assertEquals(5, numOfChanges);
    }

    @Test
    public void checkSameWord(){
        int numOfChanges = DistanceCalculator.numberOfChanges("Teszt", "Teszt");
        assertEquals(0, numOfChanges);
    }

    @Test
    public void checkOneDifference(){
        int numOfChanges = DistanceCalculator.numberOfChanges("Teszt", "Test");
        assertEquals(1, numOfChanges);
    }

    @Test
    public void checkWrongChain(){
        assertNull(WordChainGenerator.makeWordChain(new String[]{"alma", "korte", "barack"}));
    }

    @Test
    public void checkCorrectChain(){
        assertNotNull(WordChainGenerator.makeWordChain(new String[]{"coat", "hat", "hot", "dog", "cat", "hog", "cot", "oat"}));
    }

    @Test
    public void checkOneWordChain(){
        assertNotNull(WordChainGenerator.makeWordChain(new String[]{"teszt"}));
    }

    @Test
    public void checkEmptyWordChain(){
        assertNull(WordChainGenerator.makeWordChain(new String[]{}));
    }

}
