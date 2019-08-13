import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by: Jeffrey V on 8/12/2019
 *
 * @10:38 PM
 */
public class TestOffByN {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByN = new OffByN(1);

    // Your tests go here.
    @Test
    public void testequalChar(){
        boolean expected = true;
        boolean actual = offByN.equalChars('x', 'x');
        Assert.assertEquals(expected,actual);

        boolean expected2 = true;
        boolean  actual2 = offByN.equalChars('x', 'y');
        Assert.assertEquals(expected2, actual2);

        boolean expected3 = true;
        boolean  actual3 = offByN.equalChars('y', 'x');
        Assert.assertEquals(expected3, actual3);

        boolean expected4 = false;
        boolean actual4 = offByN.equalChars('x', 'z');
        Assert.assertEquals(expected4,actual4);

        boolean expected5 = false;
        boolean  actual5 = offByN.equalChars('z', 'x');
        Assert.assertEquals(expected5, actual5);

    }
}
