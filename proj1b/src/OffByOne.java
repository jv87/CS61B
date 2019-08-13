/**
 * Created by: Jeffrey V on 8/12/2019
 *
 * @9:19 PM
 */
public class OffByOne implements CharacterComparator{

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) <= 1;
    }
}
