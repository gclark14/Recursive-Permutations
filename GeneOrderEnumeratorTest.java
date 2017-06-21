package dna.rosalind;

import org.junit.Test;

/**
 * Created by gabe.clark on 6/20/17.
 */
public class GeneOrderEnumeratorTest {
    GeneOrderEnumerator geo = new GeneOrderEnumerator(5);

    @Test
    public void testConstrutor(){
    }

    @Test
    public void testPrintPermutations(){
        geo.printPermutations();
    }

    @Test
    public void createsAllPermutations(){
        geo.generatePermutations('a');
    }

    @Test
    public void testStringMethod(){
        geo.generatePermutations('s');
        System.out.println(geo.count);
    }
}
