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

            int expParent = -1;
            int actParent = set.tree[i];
            Assert.assertEquals(expParent, actParent);

            int expTreeSize = 1;
            int actTreesize = set.treesize[i];
            Assert.assertEquals(expTreeSize, actTreesize);
        }
    }
    @Test
    public void unionTest(){
        //TODO: add more test
        UnionFind set = new UnionFind(10);
        boolean related = set.connected(0,1); // should be false at first
        Assert.assertFalse(related);
        // creating a child
        set.union(0,1);
        related = set.connected(0,1);
        Assert.assertTrue(related);
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
    @Test
    public void findTest(){
        //TODO needs more test
        UnionFind set = new UnionFind(10);
        int expAncestor1 = 0;
        set.union(0,1);
        set.union(1,2);
        set.union(2,3);
        int actAncestor1 = set.find(3);

        Assert.assertEquals(expAncestor1,actAncestor1);

    }
    @Test
    public void parentTest(){
        //TODO: add more test
        UnionFind set = new UnionFind(10);
        int expParent1 = 0;
        int expParent2 = 1;
        set.union(0,1); // parent is 0
        set.union(1,2); // parent is 1
        set.union(0,3); // parent is 0

        int actParent1 = set.parent(1);
        int actParent2 = set.parent(2);
        Assert.assertEquals(expParent1, actParent1);
        Assert.assertEquals(expParent2,actParent2);

        // 1 and 3 are direct descendants of 0
        actParent1 = set.parent(3);
        Assert.assertEquals(expParent1,actParent1);
    }

    @Test
    public void sizeOfTest(){
        UnionFind set = new UnionFind(10);


        boolean related = set.connected(0,1); // should be false at first
        int expFamsize = 1;
        int actFamSize = set.sizeOf(0);
        Assert.assertFalse(related);
        Assert.assertEquals(expFamsize, actFamSize);

        // creating a child
        set.union(0,1);
        expFamsize += 1;
        actFamSize = set.sizeOf(0);
        related = set.connected(0,1);
        Assert.assertTrue(related);
        Assert.assertEquals(expFamsize,actFamSize);

        // testing family larger than 2
        set.union(1,2);
        expFamsize += 1;
        actFamSize = set.sizeOf(0);
        related = set.connected(0,2);
        Assert.assertTrue(related);
        Assert.assertEquals(expFamsize,actFamSize);






        int expSize = 1;
        int actSize = set.sizeOf(2);
        Assert.assertEquals(expSize,actSize);


        //increase family tree
        set.union(0,1);
        set.union(1,2);
        expSize = 3;
        actSize = set.sizeOf(2);
        Assert.assertEquals(expSize,actSize);
    }


}
