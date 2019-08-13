import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        Assert.assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome(){

        /** the following 3 test are palindromes word */
        Assert.assertTrue(palindrome.isPalindrome("a"));
        Assert.assertTrue(palindrome.isPalindrome("racecar"));
        Assert.assertTrue(palindrome.isPalindrome("noon"));

        /** the following 3 words are NOT palindrome words */
        Assert.assertFalse(palindrome.isPalindrome("horse"));
        Assert.assertFalse(palindrome.isPalindrome("rancor"));
        Assert.assertFalse(palindrome.isPalindrome("aaaaab"));

    }
    @Test
    public void testIspalindromeOverload(){
        CharacterComparator offByOne = new OffByOne();
        Assert.assertTrue(palindrome.isPalindrome("noon",offByOne));
        Assert.assertTrue(palindrome.isPalindrome("moon", offByOne));
        Assert.assertTrue(palindrome.isPalindrome("aaaaab", offByOne));

        Assert.assertFalse(palindrome.isPalindrome("toon", offByOne));
        Assert.assertFalse(palindrome.isPalindrome("horse", offByOne));
        Assert.assertFalse(palindrome.isPalindrome("rancor", offByOne));
    }



}  //   Uncomment this class once you've created your Palindrome class. */