/**
 * Created by: Jeffrey V on 8/9/2019
 *
 * @8:27 PM
 */
public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordChar = new ArrayDeque<>();
        for(int i=0; i < word.length(); i++){
            wordChar.addLast(word.charAt(i));
        }
        return wordChar;
    }
}
