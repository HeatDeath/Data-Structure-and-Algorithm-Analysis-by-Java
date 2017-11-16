package com.dataStructure.tree;

import java.util.LinkedList;

// 二叉搜索树
// 由于Key需要能够进行比较，所以需要extends Comparable<Key>
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    // 树中的节点为私有的类，外界不需要了解二叉搜索树节点的具体实现
    private class Node{
        private Key key;
        private Value value;
        private Node left, right;

        Node(Key key, Value value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        Node(Node node){
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }
    }

    private Node root; // 根节点
    private int count; // 树中的节点个数

    // 构造函数，默认构造一棵空二叉搜索树
    public BinarySearchTree() {
        root = null;
        count = 0;
    }

    // 返回二叉搜索树的节点个数
    public int size() {
        return count;
    }

    // 返回二叉搜索树是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // --------------------------------------------------------------------
    // 插入操作

    // 向二叉搜索树中插入一个新的(key,value)数据对
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    // 向以 node 为根的二叉搜索树中插入新节点(key,value),使用递归算法
    private Node insert(Node node, Key key, Value value) {
        // 递归到底的情况
        if (node == null) {
            count++;
            return new Node(key, value);
        }

        // 如果要插入的 key == node.key，更新 node.value
        if (key.compareTo(node.key) == 0) {
            node.value = value;

            // 如果要插入的 key > node.key，向右子树 insert
        } else if (key.compareTo(node.key) > 0) {
            node.right = insert(node.right, key, value);

            // 如果要插入的 key < node.key，向左子树 insert
        } else {
            node.left = insert(node.left, key, value);
        }

        // 返回 insert (key,value) 后 二叉搜索树的根节点
        return node;
    }

    // --------------------------------------------------------------------
    // 搜索操作

    // 查看二叉搜索树中是否包含 key
    public boolean contain(Key key) {
        return contain(root, key);
    }

    // 查看以 node 为根的二叉搜索树中是否包含键值为 key 的节点，使用递归算法
    private boolean contain(Node node, Key key) {
        // 递归到底
        if (node == null) {
            return false;
        }

        if (key.compareTo(node.key) == 0) {
            return true;
        } else if (key.compareTo(node.key) > 0) {
            return contain(node.right, key);
        } else { // key < node->key
            return contain(node.left, key);
        }
    }

    // 在二叉搜索树中搜索键key所对应的值。如果这个 key 不存在, 则返回null
    public Value search(Key key) {
        Node node = search(root, key);
        return node == null ? null : node.value;
    }

    // 在以 node 为根的二叉搜索树中搜索 key 所对应的 value，递归算法
    private Node search(Node node, Key key) {
        // 递归到底，二叉搜索树中不存在键值 key ，返回 null
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) > 0) {
            return search(node.right, key);
        } else { // key < node.key
            return search(node.left, key);
        }
    }

    // --------------------------------------------------------------------
    // 深度优先遍历

    // 先序遍历二叉搜索树
    public void preOrder() {
        preOrder(root);
    }

    // 对以node为根的二叉搜索树进行前序遍历, 递归算法
    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 中序遍历二叉搜索树
    public void inOrder(){
        inOrder(root);
    }

    // 对以 node 为根的二叉搜索树进行中序遍历，递归算法
    private void inOrder(Node node){
        if (node != null){
            inOrder(node.left);
            System.out.println(node.value);
            inOrder(node.right);
        }
    }

    // 后序遍历二叉搜索树
    public void postOrder(){
        postOrder(root);
    }

    // 对以 node 为根的二叉搜索树进行后序遍历，递归算法
    private void postOrder(Node node){
        if (node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.value);
        }
    }

    // --------------------------------------------------------------------
    // 广度优先遍历

    // 二叉搜索树的层序遍历（广度优先）
    public void levelOrder(){
        // 使用LinkedList来作为我们的队列
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);

        // 先将 根节点 放入 q 中，再移除 此节点，将此节点的 左子节点 和 右子节点 放入 q 中
        // 直到 q 为空
        while (!q.isEmpty()) {
            Node node = q.remove();
            System.out.println(node.key);

            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
    }

    // --------------------------------------------------------------------
    // 搜索 最小节点操作

    // 寻找二叉搜索树的最小 key
    public Key minimum(){
        Node minNode = minimum(root);
        return minNode.key;
    }

    // 返回以node为根的二叉搜索树的最小键值所在的节点
    private Node minimum(Node node){
        if (node.left == null) return node;
        return minimum(node.left);
    }

    // --------------------------------------------------------------------
    // 移除 最小节点操作

    // 移除二叉搜索树中最小 key 节点
    public void removeMin(){
        if (root != null)
            root = removeMin(root);
    }

    // 删除掉以node为根的二叉搜索树中的最小节点
    // 返回删除节点后新的二叉搜索树的根
    private Node removeMin(Node node){
        // 递归到底，获取到二叉搜索树 key 最小的节点
        if (node.left == null){

            // 保存此节点的 右子节点
            Node rightNode = node.right;

            // 移除此节点
            node.right = null;
            count--;

            // 返回 右子节点
            return rightNode;
        }
        // 将被删除的节点替换为该节点的 右子节点
        node.left = removeMin(node.left);
        return node;
    }

    // --------------------------------------------------------------------
    // 搜索 最大节点操作

    // 寻找二叉搜索树的最大 key
    public Key maximum(){
        Node maxNode = maximum(root);
        return maxNode.key;
    }

    // 返回以node为根的二叉搜索树的最大键值所在的节点
    private Node maximum(Node node){
        if (node.right == null) return node;
        return maximum(node.right);
    }

    // --------------------------------------------------------------------
    // 移除 最大节点操作

    // 从二分搜索树中删除最大值所在节点
    public void removeMax(){
        if (root != null)
            root = removeMax(root);
    }

    // 删除掉以node为根的二叉搜索树中的最大节点
    // 返回删除节点后新的二叉搜索树的根
    private Node removeMax(Node node){
        // 递归到底，获取到二叉搜索树 key 最大的节点
        if (node.right == null){
            // 保存该节点的 左子节点
            Node leftNode = node.left;
            // 删除该节点
            node.left = null;
            count--;
            // 返回该节点的 左子节点
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    // --------------------------------------------------------------------
    // 移除 指定 key 的节点操作
    public void remove(Key key){
        root = remove(root, key);
    }

    // 删除掉以node为根的二分搜索树中键值为key的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, Key key){
        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
            return node;
        }else if (key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
            return node;
        }else { // key = node.key

            // 待删除节点 左子树 为空
            if (node.left == null){

                // 存储 右子树
                Node rightNode = node.right;

                // 删除节点
                node.right = null;
                count--;

                // 返回右子树
                return rightNode;
            }

            // 待删除节点 右子树 为空
            if (node.right == null){
                // 存储 左子树
                Node leftNode = node.left;

                // 删除节点
                node.left = null;
                count--;

                // 返回左子树
                return leftNode;
            }

            // 待删除节点 左右子树 都不为空
            // 找到比 待删除节点大 的最小节点，即待删除节点 右子树 的最小节点
            // 使用此节点顶替 待删除节点的位置

            // 找到 右子树 的最小节点
            Node successor = new Node(minimum(node.right));
            count++;

            // successor 的 右子树 为被删除节点的 右子树（删除了最小节点）
            successor.right = removeMin(node.right);

            // successor 的 左子树 为被删除节点的 左子树
            successor.left = node.left;

            // 删除节点
            node.left = node.right = null;
            count--;
            return successor;
        }
    }

    // --------------------------------------------------------------------
    // 查找 key 的前驱

    public Key predecessor(Key key){

        // 在二叉搜索树中查找 key 对应的节点
        Node node = search(root, key);

        // 如果 key 对应的节点不存在，则 key 没有前驱，返回 null
        if (node == null)
            return null;

        // 如果 key 对应节点的左子树不为空，则返回左子树最大 key
        if (node.left != null)
            return maximum(node.left).key;

        // 否则，key 的前驱在从根节点到 key 的路径上，在这个路径上寻找到比 key 小的最大值
        // 即为 key 的前驱
        Node preNode = predecessorFromAncestor(root, key);
        return preNode == null ? null : preNode.key;
    }

    // 在以node为根的二叉搜索树中, 寻找key的祖先中,比key小的最大值所在节点, 递归算法
    // 算法调用前已保证key存在在以node为根的二叉树中
    private Node predecessorFromAncestor(Node node, Key key){
        if (key.compareTo(node.key) == 0)
            return null;
        Node maxNode;
        if (key.compareTo(node.key) < 0){
            // 如果当前节点 > key，则当前节点不可能是比 key 小的最大值
            // 向下搜索到的结果直接返回
            return predecessorFromAncestor(node.left, key);
        }else { // key > node.key
            // 如果当前节点 < key，则当前节点可能是比 key 小的最大值
            // 向下搜索结果存储到 maxNode 中
            maxNode = predecessorFromAncestor(node.right, key);
            if (maxNode != null)
                // maxNode 和当前节点 node 取最大值返回
                return maxNode.key.compareTo(node.key) > 0 ? maxNode: node;
            else
                // maxNode 为，返回 node
                return node;
        }
    }

    // --------------------------------------------------------------------
    // 查找 key 的后继

    // 查找key的后继, 递归算法
    // 如果不存在key的后继(key不存在, 或者key是整棵二叉树中的最大值), 则返回 null
    public Key successor(Key key){
        Node node = search(root, key);

        // 如果key所在的节点不存在, 则key没有前驱, 返回 null
        if (node == null)
            return null;

        // 如果key所在的节点右子树不为空,则其右子树的最小值为key的后继
        if (node.right != null)
            return minimum(node.right).key;

        // 否则, key的后继在从根节点到key的路径上, 在这个路径上寻找到比key大的最小值, 即为key的后继
        Node sucNode = successorFromAncestor(root, key);
        return sucNode == null ? null : sucNode.key;
    }

    // 在以node为根的二叉搜索树中, 寻找key的祖先中,比key大的最小值所在节点, 递归算法
    // 算法调用前已保证key存在在以node为根的二叉树中
    private Node successorFromAncestor(Node node, Key key){
        if (key.compareTo(node.key) == 0){
            return null;
        }
        Node minNode = null;
        if (key.compareTo(node.key) > 0 ){
            // 如果当前节点小于key, 则当前节点不可能是比key大的最小值
            // 向下搜索到的结果直接返回
            return successorFromAncestor(node.right, key);
        }else { // key < node.key
            // 如果当前节点大于key, 则当前节点有可能是比key大的最小值
            // 向下搜索结果存储到minNode中
            minNode = successorFromAncestor(node.left, key);
            if (minNode != null)
                // minNode和当前节点node取最小值返回
                return minNode.key.compareTo(node.key) > 0 ? node : minNode;
            else
                // 如果minNode为空, 则当前节点即为结果
                return node;
        }
    }


    // 测试二叉搜索树
    public static void main(String[] args) {
        int N = 1000000;

        // 创建一个数组
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

        // 打乱数组顺序
        for (int i = 0; i < N; i++) {
            int pos = (int) (Math.random() * (i + 1));
            Integer temp = arr[pos];
            arr[pos] = arr[i];
            arr[i] = temp;
        }

        // 由于我们实现的二叉搜索树不是平衡二叉树，
        // 所以如果按照顺序插入一组数据，我们的二叉搜索树会退化成为一个链表

        // 我们测试用的的二叉搜索树的键类型为Integer，值类型为String
        // 键值的对应关系为每个整型对应代表这个整型的字符串
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        for (int i = 0; i < N; i++) {
            bst.insert(arr[i], Integer.toString(arr[i]));
        }

        // 对[0...2*N]的所有整型测试在二叉搜索树中搜索
        // 若 i 在 [0...N) 之间，则能搜索到整型所对应的字符串
        // 若 i 在 [N...2*N) 之间，则结果为 null
        for (int i = 0; i < 2 * N; i++) {
            String res = bst.search(i);
            String test = Integer.toString(i);
            if (i < N)
                if (res.equals(test))
                    System.out.println("I get it!");
                else if (res.equals(null))
                    System.out.println("Not find!");
        }
    }
}
