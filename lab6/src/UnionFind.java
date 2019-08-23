/**
 * Invariants:
 * elements are hidden within the items list
 * tree contains
 */


public class UnionFind {

    int[] items;
    int[] tree;
    int[] treesize;


    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets.

       EX) items = [0, 1, 2, 3, ..., n-1] // create an array with N accending elements
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
        int ancestor = find(v1);
        return -tree[ancestor];
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        int guardianIndex = tree[v1]; // if guardian index is negative then v1 is a root
        if(guardianIndex < 0){
            return treesize[v1];
        }
        int guardian = items[guardianIndex];
        return guardian;
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        int ancestor1 = find(v1);
        int ancestor2 = find(v2);
        return ancestor1 == ancestor2;
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        int ancestor1 = find(v1);
        int ancestor2 = find(v2);

        if (ancestor1 != ancestor2){
            int p1 = parent(ancestor1);
            int p2 = parent(ancestor2);
            // if the ones family size is bigger than twos, then two family becomes a decendant of ones
            if(p1 < p2){
                tree[v2] = v1; // v1 becomes a parent
                tree[v1] -= 1;
            }
            // if two has the bigger family, then ones family become decendants of two
            if(p2 < p1 ){
                tree[v1] = v2;
                tree[v2] -= 1;
            }

        }

    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time.

       no joins (hence no ancestor)
       ex) items --> [0, 1, 2, 3]
           tree --->[-1,-2,-3,-4]
      0,1,3 joins (3 has its ancestor which is 0 and a parent which is 1)
       ex) items --> [0, 1, 2, 3]
           tree --->[-1,0,-3,1]

       */
    public int find(int vertex) {
        int ancestor = tree[vertex]; // ancestor == root which are identified with negative number
        int guardian = items[vertex];
        while(ancestor >= 0){
            guardian = items[ancestor];
            ancestor = parent(ancestor);
        }

        return guardian;
    }

}
