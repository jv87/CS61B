public class UnionFind {

    // TODO - Add instance variables?
    int[] items;
    int[] tree;
    int[] treesize;


    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets.
       ex) items = [0, 1, 2, 3, ..., n-1] // create an array with N accending elements
           tree = [-1, -1,-1,-1, ... ]    // initially each element is its own parent
       treesize =  [1, 1, 1, ...]         // since each element is its own parent all trees have one element
       */
    public UnionFind(int n) {
        this.items = new int[n];
        this.tree = new int[n];
        this.treesize = new int[n];
        for (int i = 0; i < n; i++){
            items[i] = i;
            tree[i] = -1;
            treesize[i] = 1;
        }

    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        // TODO
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        // TODO
        return -1;
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        // TODO
        return -1;
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        // TODO
        return false;
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        // TODO
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        // TODO
        return -1;
    }

}
