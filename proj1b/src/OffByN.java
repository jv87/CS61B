/**
 * Created by: Jeffrey V on 8/12/2019
 *
 * @10:35 PM
 */
public class OffByN implements CharacterComparator{
    private int n;

    OffByN(int N){
        n = N;
    }


    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) <= this.n;
    }
}
