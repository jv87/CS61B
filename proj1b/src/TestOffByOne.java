import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testequalChar(){
        boolean expected = true;
        boolean actual = offByOne.equalChars('x', 'x');
        Assert.assertEquals(expected,actual);

        boolean expected2 = true;
        boolean  actual2 = offByOne.equalChars('x', 'y');
        Assert.assertEquals(expected2, actual2);

        boolean expected3 = true;
        boolean  actual3 = offByOne.equalChars('y', 'x');
        Assert.assertEquals(expected3, actual3);

        boolean expected4 = false;
        boolean actual4 = offByOne.equalChars('x', 'z');
        Assert.assertEquals(expected4,actual4);

        boolean expected5 = false;
        boolean  actual5 = offByOne.equalChars('z', 'x');
        Assert.assertEquals(expected5, actual5);

    }
} /**Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/

