/**
 * Created by: Jeffrey V on 7/9/2019
 *
 * @10:13 PM
 */
public class LinkedListDeque<T> implements Deque<T> {

        private class node{
            node prev;
            T   item;
            node next;
            private  node(T i, node p, node n){
                prev = p;
                item = i;
                next = n;
            }
        }

        private node sentinal;
        private int size;

        /** single item Deque constructor */
        public LinkedListDeque(T x){
            sentinal = new node(x,null,null);
            sentinal.next = new node(x,null,null);
            sentinal.prev = sentinal.next;
            sentinal.next.prev = sentinal.next;
            sentinal.next.next = sentinal.next;
            size = 1;
        }
        /** Empty Deque Constructor */
        public LinkedListDeque(){
            sentinal = new node(null,null,null);
            sentinal.prev = sentinal;
            sentinal.next = sentinal;
            size = 0;
        }

        /** Returns the number of items in the deque. */
        @Override
        public int size(){
            return size;
        }


        /** Prints the items in the deque from first to last, separated by a space.
         * Once all the items have been printed, print out a new line.
         */
        @Override
        public void printDeque(){
            node ptr = sentinal.next;
            for (int count = 0; count < size; count++){
                System.out.print(ptr.item + " ");
                ptr = ptr.next;
            }
            System.out.println();
        }

        /** Adds an item of type T to the front of the deque. */
        @Override
        public void addFirst(T item){
            sentinal.next = new node(item, sentinal.next.prev,sentinal.next);
            sentinal.next.next.prev = sentinal.next;
            sentinal.prev.next = sentinal.next;
            sentinal.next.prev = sentinal.prev;
            size += 1;
        }

        /** Adds an item of type T to the back of the deque. */
        @Override
        public void addLast(T item){
            sentinal.prev = new node(item,sentinal.prev, sentinal.prev.next);
            sentinal.prev.prev.next = sentinal.prev;
            sentinal.next.prev = sentinal.prev;
            sentinal.prev.next = sentinal.prev;
            size += 1;
        }

        /** Removes and returns the item at the front of the deque.
         If no such item exists, returns null.  */
        @Override
        public T removeFirst(){
            if (!isEmpty()){
                T elem = sentinal.next.item;
                sentinal.prev.next = sentinal.next.next;
                sentinal.next.next.prev = sentinal.prev;
                sentinal.next.prev = null;
                sentinal.next.next = null;
                sentinal.next = sentinal.prev.next;
                if(size == 1) {
                    sentinal.prev = sentinal.prev.prev;
                }
                size -= 1;
                return elem;
                }
                return null;
            }
        @Override
        public T removeLast(){
            if (!isEmpty()) {
                T elem = sentinal.prev.item;
                sentinal.prev.prev.next = sentinal.next;
                sentinal.next.prev = sentinal.prev.prev;
                sentinal.prev.next = null;
                sentinal.prev.prev = null;
                sentinal.prev = sentinal.next.prev;
                size -= 1;
                return elem;
            }
            return null;
        }



        //** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
        // If no such item exists, returns null. Must not alter the deque!
        @Override
        public T get(int index){
            if (index > size){
                return sentinal.prev.item;
            }

            node ptr = sentinal.next;
            for(int count = 0; count < index; count++){
                ptr = ptr.next;
            }
            return ptr.item;
        }

}


