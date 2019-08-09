import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by: Jeffrey V on 7/14/2019
 *
 * @12:21 PM
 */

public class ArrayDequeTest {
    @Test
    public void testIsEmpty(){
        ArrayDequeJeff<Integer> arr = new ArrayDequeJeff<>();
        boolean exp = true;
        boolean actual = arr.isEmpty();
        Assert.assertEquals(exp,actual);

        arr.addFirst(1);
        boolean exp2 = false;
        boolean actual2 = arr.isEmpty();
        Assert.assertEquals(exp2, actual2);

        arr.removeFirst();
        boolean actual3 = arr.isEmpty();
        Assert.assertEquals(exp,actual3);

        arr.addLast(2);
        boolean actual4 = arr.isEmpty();
        Assert.assertEquals(exp2, actual4);

        arr.removeLast();
        boolean actual5 = arr.isEmpty();
        Assert.assertEquals(exp, actual5);

        arr.addFirst(3);
        arr.removeLast();
        boolean actual6 = arr.isEmpty();
        Assert.assertEquals(exp,actual6);

        arr.addLast(4);
        arr.removeFirst();
        boolean actual7 = arr.isEmpty();
        Assert.assertEquals(exp,actual7);

         for (int elem = 0; elem <= 20; elem++){
         arr.addFirst(20-elem);
         }
         boolean actual8 = arr.isEmpty();
         Assert.assertEquals(exp2, actual8);
         for(int elem = 0; elem < 20; elem++){
         //arr.removeLast();
             arr.removeFirst();
         }
         boolean actual9 = arr.isEmpty();
         Assert.assertEquals(exp2, actual9);
         arr.removeFirst();
         actual = arr.isEmpty();
         Assert.assertEquals(exp,actual);
    }
    @Test
    public void testAddFirst(){
        ArrayDequeJeff<Integer> arr = new ArrayDequeJeff<>();
        arr.addFirst(8);
        int exp = 8;
        int actual = arr.get(0);
        Assert.assertEquals(exp, actual);

        arr.addFirst(7);
        exp = 7;
        actual = arr.get(0);
        Assert.assertEquals(exp, actual);

        for (int i = 6; i > 0; i--){
            arr.addFirst(i);
        }
        exp = 1;
        actual = arr.get(0);
        Assert.assertEquals(exp, actual);
        while (!arr.isEmpty()){
            arr.removeFirst();
        }
        //actual = arr.get(0);
        //Assert.assertEquals(null,actual);

        for (int elem = 0; elem <= 20; elem++){
            arr.addFirst(20-elem);
        }
        exp = 0;
        actual = arr.get(0);
        Assert.assertEquals(exp,actual);
    }

    @Test
    public void testGet() {
        ArrayDequeJeff<Integer> arr = new ArrayDequeJeff<>();
        for (int elem = 0; elem <= 20; elem++) {
            arr.addFirst(20 - elem);
            int exp = 20 - elem;
            int actual = arr.get(0);
            Assert.assertEquals(exp, actual);
        }
        for (int elem = 0; elem <= 20; elem++) {
            int exp = elem;
            int actual = arr.get(elem);
            Assert.assertEquals(exp,actual);
        }
        arr.prinDeque();


    }

    @Test
    public void testAddLast() {
        ArrayDequeJeff<Integer> arr = new ArrayDequeJeff<>();
        for (int elem = 0; elem <= 20; elem++) {
            arr.addLast(elem);
            int exp = elem;
            int actual = arr.get(elem);
            Assert.assertEquals(exp, actual);
        }

    }
    @Test
    public void testResie(){
        ArrayDequeJeff<Integer> arr = new ArrayDequeJeff<>();
        for(int count = 0; count < 20; count++){
            boolean add = Math.random() < 0.5;
            if (add){
                arr.addFirst(count);
            }
            else{
                arr.addLast(count);
            }
        }
        System.out.println();
        for (int count = 0; count < 20; count++){
            System.out.print(arr.get(count) + ", ");
        }
        System.out.println();
        arr.prinDeque();
    }
}

