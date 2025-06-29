package datastructure.tree;
// import datastructure.tree.BinaryTree.BTNode;

/**
 * Binary Search Tree implementation
 * @param <K> type of the key value
 * @param <D> type of the data object 
 */
public class BinarySearchTree<K extends Comparable<K>,D> extends BinaryTree<K,D> implements Tree<K,D> {
    /** Number of nodes in the Binary Search Tree */
    protected int size;

    /**
     * Creates an empty Binary Search Tree
     */
    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    /**
     * Inserts a node storing the mapping (<code>key</code>,<code>data</code>) into the Binary Search Tree; Cost: O(h)
     * <p>
     * <code>Null</code> key values are not allowed, while <code>null</code> data values are allowed. Same costs as {@link #insertNode(BTNode) insertNode}
     * @param key key value
     * @param data data mapped to the key value
     * @throws IllegalStateException if the <code>key</code> paramenter is <code>null</code>
     */
    public void insert(K key, D data) throws IllegalStateException {
        if (key == null)
            return;
        else insertNode(new BTNode(key,data));
    }

    /**
     * Inserts <code>node</code> into the Binary Search Tree; Cost: O(h)
     * <p>
     *  Inserting a new node involves searching for the insertion position along a root-leaf path
     * <ul>
     * <li> Worst-case cost: &Theta;(h);
     * <li> Average-case cost: &Theta;(<span style="text-decoration:overline">h</span>)
     * <li> Best-case cost: O(1)
     * </ul> 
     * <p>
     * where h is the tree height and <span style="text-decoration:overline">h</span> the average tree height
     * @param node node to insert into the tree
     */
    protected void insertNode(BTNode node) {
        BTNode prev = null;
        BTNode curr = this.root;

        while(curr!=null){
            prev = curr;
            if (node.key.compareTo(curr.key)<0)
                curr = curr.left;
            else curr = curr.right;
        }
        if (prev == null)
            this.root = node;
        else {
            node.parent = prev;
            if (node.key.compareTo(prev.key)<0)
                prev.left = node;
            else prev.right = node;
        }
        this.size++;
    }

    /**
     * Returns the data stored in the first node in the Binary Search Tree matching <code>key</code>; Cost: O(h)
     * <p>
     * Same costs as {@link #searchNode(K) searchNode}
     * @param key key value to search
     * @return the data mapped to <code>key</code> or <code>null</code> if <code>key</code> is not in the tree
     */
    public D search(K key) {
        if (key==null)
            return null;

        BTNode node = searchNode(key);
        if(node==null)
            return null;

        return node.data;
    }

    /**
     * Searches and returns the first node matching <code>key</code>; Cost: O(h)
     * <p>
     * Equivalent to a linear search on a root-leaf path
     * <ul>
     * <li> Worst-case cost: &Theta;(h);
     * <li> Average-case cost: &Theta;(<span style="text-decoration:overline">h</span>)
     * <li> Best-case cost: O(1)
     * </ul> 
     * <p>
     * where h is the tree height and <span style="text-decoration:overline">h</span> the average tree height
     * @param key key value to search
     * @return the searched node or <code>null</code>
     */ 
    protected BTNode searchNode(K key)  {
        BTNode curr = this.root;
        while(curr!=null){
            if(curr.key==key)
                return curr;
            if(key.compareTo(curr.key)<0)
                curr = curr.left;
            else curr = curr.right;
        }
        return null;
    }

    /**

     * <p>
     * Same costs as {@link #deleteNode(K) deleteNode}
     * @param key key value to search
     * @return the data mapped to <code>key</code> or <code>null</code> if <code>key</code> is not in the tree
     */
    public D delete(K key) {
        BTNode node = deleteNode(key);
        if(node==null)
            return null;
        return node.data;
    }

    /**
     * Disconnects (and returns) from the Binary Search Tree the first node with key value <code>key</code>; Cost: O(h)
     * <p>
     * The procedure does not erase the parent pointer of the disconnected node. In this way it is possible
     * to traverse the tree from the disconnected node up to the root node and update local infomation in each
     * node in the path.
     * <ul>
     * <li> Worst-case cost: &Theta;(h)
     * <li> Average-case cost: &Theta;(<span style="text-decoration:overline">h</span>)
     * <li> Best-case cost: O(1)
     * </ul> 
     * <p>
     * where h is the tree height and <span style="text-decoration:overline">h</span> the average tree height
     * @param key a key value
     * @return a node with key value <code>key</code> or null 
     */
    protected BTNode deleteNode(K key) {
        BTNode node = searchNode(key);
        if(node!=null){
            if (node.hasTwoChildren()){
                BTNode u = node.predecessor();
                node.swap(u);
                node = u;
            }
            node.disconnect();
            this.size--;
        }
        return node;
    }

    /**
     *  Returns the number of nodes in the Binary Search Tree; Cost: O(1)
     *  @return number of nodes in the Binary Search Tree
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns <code>true</code> if the Binary Search Tree is empty; Cost: O(1)
     * @return <code>true</code> if the Binary Search Tree is empty
     */
    public boolean isEmpty() {
        return this.size==0;
    }

}
