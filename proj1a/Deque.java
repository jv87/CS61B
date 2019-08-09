public interface  Deque<T> {
    public void addFirst(T item);

    // adds item to the end of the list */
    public void addLast(T x);

    public T removeFirst();

    public T removeLast();


    // public void resize();


    /**
     * returns the number of elements in the list
     */
    public int size();

    /**
     * returns true if list is empty (hence size == 0)
     */
    public boolean isEmpty();

    /**
     * prints the elements in the array from nextFirst to nextLast in order
     */
    public void printDeque();

    public T get(int index);

}
