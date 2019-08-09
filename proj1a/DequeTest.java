/**
 * Created by: Jeffrey V on 7/9/2019
 *
 * @9:21 PM
 */
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

public class DequeTest {
    @Test
    public void testAddFirst(){
        // starting with an empty list testing that we add an element to the front of the list
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        Object exp = null;
        Assert.assertEquals(exp, L.get(0));

        L.addFirst(3);
        int exp2 = 3;
        int pnode = 3;
        int actual2 = L.get(0);
        int act2 = L.get(1);
        Assert.assertEquals(exp2, actual2);
        Assert.assertEquals(pnode, act2);

        L.addFirst(2);
        int exp3 = 2;
        int actual3 = L.get(0);
        int pnode2 = 2;
        int pnode3 = 3;
        int act3 = L.get(1);
        int act4 = L.get(2);
        Assert.assertEquals(exp3, actual3);
        Assert.assertEquals(pnode2,act4);
        Assert.assertEquals(pnode3, act3);


        // starting a one element list testing that we add an element to the front of the list
        LinkedListDeque<Integer> L2 = new LinkedListDeque<>(3);
        int Exp = 3;
        int Actual1 = L2.get(0);
        Assert.assertEquals(Exp, Actual1);

        L2.addFirst(2);
        int Exp2 = 2;
        int Actual2 = L.get(0);
        Assert.assertEquals(Exp2, Actual2);

        L2.addFirst(1);
        int Exp3 = 1;
        int Actual3 = L2.get(0);
        Assert.assertEquals(Exp3, Actual3);

        L.printDeque();
        L2.printDeque();
    }
    @Test
    public void testAddLast(){
        // starting with an empty list testing that we add an element to the front of the list
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        Object exp = null;
        Assert.assertEquals(exp, L.get(0));

        L.addLast(1);
        int exp2 = 1;
        int actual2 = L.get(1);
        Assert.assertEquals(exp2, actual2);


        L.addLast(2);
        int exp3 = 2;
        int actual3 = L.get(6);

        Assert.assertEquals(exp3, actual3);



        // starting a one element list testing that we add an element to the front of the list
        LinkedListDeque<Integer> L2 = new LinkedListDeque<>(1);
        int Exp = 1;
        int Actual1 = L2.get(0);
        Assert.assertEquals(Exp, Actual1);

        L2.addLast(2);
        int Exp2 = 2;
        int Actual2 = L.get(1);
        Assert.assertEquals(Exp2, Actual2);

        L2.addLast(3);
        int Exp3 = 3;
        int Actual3 = L2.get(2);
        Assert.assertEquals(Exp3, Actual3);

        L.printDeque();
        L2.printDeque();
    }


    @Test
    public void testRemoveFirst(){
        LinkedListDeque<Integer> L = new LinkedListDeque<>(3);
        L.addFirst(2);
        L.addFirst(1);
        L.printDeque();

        int elem = L.removeFirst();
        int elemExp = 1;
        Assert.assertEquals(elemExp, elem);

        L.printDeque();

        int exp = 2;
        int exp2 = 3;
        int act = L.get(0);
        int act2 = L.get(1);
        int expsize = 2;
        int actSize = L.size();
        Assert.assertEquals(exp, act);
        Assert.assertEquals(exp2, act2);
        Assert.assertEquals(expsize, actSize);

        LinkedListDeque<Integer> L2 = new LinkedListDeque<>();
        L2.addFirst(2);
        L2.addFirst(1);
        L2.addLast(3);
        L2.printDeque();

        int Elem = L2.removeFirst();
        int ElemExp = 1;
        Assert.assertEquals(ElemExp, Elem);

        L2.printDeque();

        int Exp = 2;
        int Exp2 = 3;
        int Act = L2.get(0);
        int Act2 = L2.get(1);
        int Expsize = 2;
        int ActSize = L2.size();
        Assert.assertEquals(Exp, Act);
        Assert.assertEquals(Exp2, Act2);
        Assert.assertEquals(Expsize, ActSize);

    }

    @Test
    public void testRemoveLast(){
        LinkedListDeque<Integer> L = new LinkedListDeque<>(3);
        L.addFirst(2);
        L.addFirst(1);
        L.printDeque();

        int elem = L.removeLast();
        int elemExp = 3;
        Assert.assertEquals(elemExp, elem);

        L.printDeque();

        int exp = 1;
        int exp2 = 2;
        int act = L.get(0);
        int act2 = L.get(1);
        int expsize = 2;
        int actSize = L.size();
        Assert.assertEquals(exp, act);
        Assert.assertEquals(exp2, act2);
        Assert.assertEquals(expsize, actSize);

        LinkedListDeque<Integer> L2 = new LinkedListDeque<>();
        L2.addFirst(2);
        L2.addFirst(1);
        L2.addLast(3);
        L2.printDeque();

        int Elem = L2.removeLast();
        int ElemExp = 3;
        Assert.assertEquals(ElemExp, Elem);
        L2.printDeque();

        int Exp = 1;
        int Exp2 = 2;
        int Act = L2.get(0);
        int Act2 = L2.get(1);
        int Expsize = 2;
        int ActSize = L2.size();
        Assert.assertEquals(Exp, Act);
        Assert.assertEquals(Exp2, Act2);
        Assert.assertEquals(Expsize, ActSize);

    }


    @Test
    public void testSize(){
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        int expected = 0;
        int actual = L.size();
        Assert.assertEquals(expected, actual);

        L.addFirst(3);

        int expected2 = 1;
        int actual2 = L.size();
        Assert.assertEquals(expected2, actual2);

        LinkedListDeque<Integer> L2 = new LinkedListDeque<>(10);

        int expected3 = 1;
        int actual3 = L2.size();
        Assert.assertEquals(expected3, actual3);

    }

    @Test
    public void testIsEmpty(){
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        boolean exp = true;
        boolean act = L.isEmpty();
        Assert.assertEquals(exp,act);

        L.addFirst(2);
        boolean exp2 = false;
        boolean act2 = L.isEmpty();
        Assert.assertEquals(exp2, exp2);

        LinkedListDeque<Integer> L2 = new LinkedListDeque<>(10);
        boolean exp3 = false;
        boolean act3 = L2.isEmpty();
        Assert.assertEquals(exp3, act3);
    }

}
