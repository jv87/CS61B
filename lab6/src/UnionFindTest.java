import org.junit.Assert;
import org.junit.Test;
import java.util.Random;


public class UnionFindTest {
    @Test
    public void UnionFindConstructorTest(){
        UnionFind set = new UnionFind(10);
        for(int i = 0; i < 10; i++){
            int expElem = i;
            int actElem = set.items[i];
            Assert.assertEquals(expElem, actElem);

            int expParent = -(i+1);
            int actParent = set.tree[i];
            Assert.assertEquals(expParent, actParent);

            int expTreeSize = 1;
            int actTreesize = set.treesize[i];
            Assert.assertEquals(expTreeSize, actTreesize);
        }
    }
    @Test
    public void ConnectedTest(){
        // Initially nothing should be connected
        UnionFind set = new UnionFind(10);
        for (int i=0; i< 9; i++){
            for (int j = 1+i; j < 10; j++){
                boolean act1 = set.connected(i,j);
                Assert.assertFalse(act1);
            }

        }
        Random rand = new Random();
        int elem1 = rand.nextInt(5);
        int elem2 = rand.nextInt(5) + 5;
        set.union(elem1,elem2);

        boolean act2 = set.connected(elem1,elem2);
        Assert.assertTrue(act2);

    }
}
