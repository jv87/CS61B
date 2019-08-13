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
    public boolean isPalindrome(String word){
        Deque<Character> wordArr = wordToDeque(word);

        return palindromeCheck(wordArr);
    }
    private boolean palindromeCheck(Deque<Character> wordArr){
        if (wordArr.size() == 1 || wordArr.size() == 0){
            return true;
        }
        if (wordArr.removeFirst() == wordArr.removeLast()){
            return palindromeCheck(wordArr);
        }
        return false;
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> wordCharArr = wordToDeque(word);
        boolean charEqual = true;
        while(wordCharArr.size() > 0){
            char first = wordCharArr.removeFirst();
            char last = wordCharArr.removeLast();
            charEqual = cc.equalChars(first,last);
            if (charEqual == false){
                return charEqual;
            }
        }
        return charEqual;
    }
}
