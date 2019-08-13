

/**
 * Created by: Jeffrey V on 7/13/2019
 *INVARIANTS:
            * nextFirst is the first item in the list
            * nextLast is the last item in the list
            * size keeps count of the items added to the list
            * capacity is the items that the list starts with
            * factor is a constant multiplicative that we use for resizing
 * @3:30 PM
 */
public class ArrayDeque<Item> implements Deque<Item>{
    private Item[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    private int capacity = 8;
    private int factor = 2;


    // Empty array constructor
    public ArrayDeque(){
        items = (Item[]) new Object[capacity];
        size = 0;
        nextFirst = 3;
        nextLast = nextFirst;
    }

    /**Creates a deep copy of other.
     Creating a deep copy means that you create an entirely new ArrayDeque,
     with the exact same items as other.However, they should be different
     objects, i.e. if you change other, the new ArrayDeque you created
     should not change as well. */

    public ArrayDeque(ArrayDeque other){
        //STILL NEEDS WORK TO ACCOUNT FOR ARRAYS BIGGER THAN 8 (needs resize)
        Item[] temp = (Item[]) new Object[other.items.length];
        items = temp;
        System.arraycopy(other.items,0,items,0,other.items.length);
        size = other.size;
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
    }
    // checks that nextFirst and nextLast dont point at the same item
    private boolean pointerCheck(){
        return nextFirst == nextLast;
    }

    // if nextFirst or nextLast is negative it loops to the back of the list accordingly
    private void loopBack(){
        if(nextFirst < 0){
            nextFirst = items.length - 1;
        }
        if(nextLast < 0){
            nextLast = items.length - 1;
        }
    }
    // checks if array is full
    private boolean isFull(){
        return size == items.length;
    }

    // adds item to the front of the list */
    @Override
    public void addFirst(Item x){
        if (isFull()){
            resize();

        }
        if (pointerCheck() && size == 0){
            nextFirst -= 1;
        }
        if (nextFirst < 0){
            loopBack();
        }
        items[nextFirst] = x;
        nextFirst -= 1;
        size += 1;
    }

    // loops to the front of the list
    private void loopFoward(){
        if(nextLast == items.length){
            nextLast = 0;
        }
        if(nextFirst == items.length){
            nextFirst = 0;
        }
    }

    // adds item to the end of the list */
    @Override
    public void addLast(Item x){
        /*
        items[nextLast] = x;
        nextLast += 1;
        pointerCheck();
        if (nextLast == items.length){
            loopFoward();
        }
        size += 1;
        */
        if (isFull()){
            resize();

        }
        if (pointerCheck() && size == 0){
            nextLast += 1;
        }
        if (nextLast == items.length){
            loopFoward();
        }
        items[nextLast] = x;
        nextLast += 1;
        size += 1;
    }

    /** removes item from the front of the list
     * RESIZE OCCURS WHEN size/items.length FALLS BELOW 25% */
    @Override
    public  Item removeFirst(){
        if (isEmpty()){
            return null;
        }
        size -= 1;
        nextFirst += 1;
        if (nextFirst == items.length){
            nextFirst = 0;
        }
        if (items.length > 16 && (size * 100)/items.length < 25){
            shrink();
        }
        loopFoward();
        loopBack();
        Item elem = items[nextFirst];
        return elem;

    }
    /** removes item from the end of the list
     * RESIZE OCCURS WHEN size/items.length FALLS BELOW 25% */
    @Override
    public Item removeLast(){
        if (isEmpty()){
            return null;
        }
        size -= 1;
        nextLast -= 1;
        //if (nextLast == 0){
        //    nextLast = items.length;
        //}
        if (items.length > 16 && (size * 100)/items.length < 25){
            shrink();
        }
        loopBack();
        loopFoward();
        Item elem = items[nextLast];
        return elem;
    }
    /** shrinks array size to 2* (number of elements in array */
    private void shrink(){
        int len = items.length;
        int middle =  Math.abs(nextLast - nextFirst); // empty boxes between nextLast and nextFirst
        int end = (len - middle - (nextLast + 1));
        int start = Math.abs(size - (nextLast + end));
        //int[] temp = new int[2*size]; // Current capacity / factor
        Item[] temp = (Item[]) new Object[2*size]; //new int[2*size]; // Current capacity / factor

        int end2 = temp.length/2 - Math.abs(size - end);
        System.arraycopy(items,nextFirst + 1, temp, 0, end);
        System.arraycopy(items,start, temp, end, end2) ;
        items = temp;
        nextLast = size;
        nextFirst = items.length - 1;
        return;
    }
    private void shrinkFirst(){
        int len = items.length;
        int middle =  Math.abs(nextLast - nextFirst); // non empty boxes
        int end = (len - middle - (nextLast + 1));
        int start = Math.abs(size - (nextLast + end));
        //int[] temp = new int[2*size]; // Current capacity / factor
        Item[] temp = (Item[]) new Object[2*size]; //new int[2*size]; // Current capacity / factor

        int end2 = temp.length/2 - Math.abs(size - end);
        System.arraycopy(items,nextFirst + 1, temp, 0, end);
        System.arraycopy(items,start, temp, end, end2) ;
        items = temp;
        nextLast = size;
        nextFirst = items.length - 1;
        return;
    }

    /** resize the current array so to (length of current array) * factor */
    private void resize(){
        Item[] temp = (Item[]) new Object[items.length * factor];
        int start = nextLast - 1 - nextFirst;
        int end = items.length - (nextFirst + 1);
        System.arraycopy(items,nextFirst+1, temp,1, end);
        System.arraycopy(items,start,temp,items.length - nextFirst ,items.length - end);
        items = temp;
        nextFirst = 0;
        nextLast = size +1;

        return;
    }

    /** returns the number of elements in the list */
    @Override
    public int size(){
        return size;
    }


    /** prints the elements in the array from nextFirst to nextLast in order */
    @Override
    public void printDeque(){
        for (int count = nextFirst+1; count != nextLast; count++){
            if (count == items.length){
                count = 0;
            }
            System.out.print(items[count] + " ");
        }
        System.out.println();
    }

    /** returns the items in the index position
     * **NOTE: SINCE FIRSt ITEM EXIST AT NEXTFIRST INDEX IS SHIFTED
     * NOTE: since array is circular that is if a first item exist in front
     * of the last item then when we reach the items.length we must move
     * nextFirst to the front of the items list. otherwise a bug
     * ex -->   0   1   2   3   4  -- actual position
     *         3rd 4th 5th 1st 2nd -- synthetic position (based on next first)
     *         [3, 4 ,5, 1, 2] --> get(3) --> return 3 (nexfirst must loop back)
     * ex2 --> null 1st 2nd ...
     *         [null, 1, 2 ...]--> get(0) --> return 1 (nextfirst == 1)
     *         */
    @Override
    public Item get(int index){
        if(itemDoesNotExist(index)){
            return null;
        }
        int position;
        if (index + nextFirst + 1 > items.length-1){
            position = index - (items.length - 1 - nextFirst);
        }
        else{
            position = index + nextFirst + 1;
        }

        return items[position];
    }
    //return true if elements cannot be indexed otherwise false
    private boolean itemDoesNotExist(int index){
        if (isEmpty()){
            return true;
        }
        if (index > size){
            return true;
        }
        return false;
    }

}
