/**
 * @idea 构建BST，实现BST的插入和删除
 * @param <E>
 */

import java.util.*;


public class BSTree<E extends Comparable<E>> {


    /**
     * BST节点
     * @param <E>
     */
    static class BSTNode<E>{
        public E value;
        public BSTNode<E> left;
        public BSTNode<E> right;

        public BSTNode(E value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    /**
     * 根节点
     */
    private BSTNode<E> root;

    /**
     * 向BST插入元素
     * @param data
     * @return
     */
    public boolean insert(E data){
        if (data == null) return false;
        BSTNode<E> newNode = new BSTNode<>(data);
        if(root == null){
            root = newNode;
            return true;
        }
        BSTNode<E> parent = null;
        BSTNode<E> node = root;
        while (node != null){
            parent = node;
            int compare = data.compareTo(node.value);
            if(compare > 0) {
                node = node.right;
            }else if(compare < 0){
                node = node.left;
            }else {
                return false;
            }
        }
        if(data.compareTo(parent.value) < 0){
            parent.left = newNode;
        }else{
            parent.right = newNode;
        }
        return true;
    }

    /**
     * 删除BST中指定节点
     * @param data 带删除元素
     * @return 删除成功返回true，元素不存在返回false；
     */
    public boolean remove(E data){
        if(data == null || root == null) {
            return false;
        }
        BSTNode<E> parent = null;
        BSTNode<E> deleteNode = root;
        while (deleteNode != null){
            int compare = data.compareTo(deleteNode.value);
            if(compare == 0){
                break;
            }
            parent = deleteNode;
            if(compare < 0){
                deleteNode = deleteNode.left;
            }else {
                deleteNode = deleteNode.right;
            }
        }
        if (deleteNode == null) return false;
        removeNode(deleteNode, parent);
        return true;
    }

    /**
     * 待删除节点又三种情况：
     * 1. 有左孩子和右孩子（用待删除结点的中序遍历的后继节点或前驱节点代替待删除结点）
     * 2. 只有一个孩子
     * 3. 叶子节点
     * @param deleteNode
     * @param parent
     */
    private void removeNode(BSTNode<E> deleteNode, BSTNode<E> parent) {
        //deleteNode左右孩子都存在，转为删除直接后继
        if(deleteNode.left != null && deleteNode.right != null){
            parent = deleteNode;
            BSTNode<E> successor = deleteNode.right;
            while (successor.left != null){
                parent = successor;
                successor = successor.left;
            }
            deleteNode.value = successor.value;
            deleteNode = successor;
        }
        //deleteNode只有左孩子或右孩子，直接用孩子节点代替
        BSTNode<E> child = null == deleteNode.left ? deleteNode.right : deleteNode.left;
        if(child != null){
            deleteNode.value = child.value;
            deleteNode.left = child.left;
            deleteNode.right = child.right;
            child.left = null;
            child.right = null;
            return;
        }
        //deleteNode是叶子节点
        if(deleteNode == root){
            root = null;
        }else {
            if(deleteNode == parent.left){
                parent.left = null;
            }else {
                parent.right = null;
            }
        }
    }

    /**
     * 先序遍历
     * @return 先序遍历集合
     */
    public List<E> preOrder(){
        List<E> preOrderList = new ArrayList<>();
        Stack<BSTNode<E>> s = new Stack<>();
        BSTNode p = root;
        while (p != null || !s.empty()){
            if(p != null){
                s.push(p);
                preOrderList.add((E) p.value);
                p = p.left;
            }else {
                p = s.pop();
                p = p.right;
            }
        }
        return preOrderList;
    }

    /**
     * 中序遍历
     * @return 中序遍历集合
     */
    public List<E> inOrder(){
        List<E> inOrderList = new ArrayList<>();
        Stack<BSTNode<E>> s = new Stack<>();
        BSTNode p = root;
        while (p != null || !s.empty()){
            if(p != null){
                s.push(p);
                p = p.left;
            }else {
                p = s.pop();
                inOrderList.add((E)p.value);
                p = p.right;
            }
        }
        return inOrderList;
    }

    /**
     * 后序遍历
     * @return 后序遍历集合
     */
    public List<E> postOrder() {
        List<E> postOrderList = new ArrayList<>();
        Stack<BSTNode<E>> s = new Stack<>();
        BSTNode p = root;
        BSTNode r = null;
        while (p != null || !s.empty()){
            if(p != null){
                s.push(p);
                p = p.left;
            }else {
                p = s.peek();
                if(p.right != null && p.right != r){
                    p = p.right;
                }else {
                    postOrderList.add((E)p.value);
                    s.pop();
                    r = p;
                    p = null;
                }
            }
        }
        return postOrderList;
    }

    /**
     * 层序遍历
     * @return 层序遍历集合
     */
    public List<E> levelOrder(){
        List<E> sequenceList = new ArrayList<>();
        LinkedList<BSTNode<E>> q = new LinkedList<>();
        BSTNode<E> p;
        q.addLast(root);
        while (!q.isEmpty()){
            p = q.getFirst();
            sequenceList.add(p.value);
            q.removeFirst();
            if(p.left != null) q.addLast(p.left);
            if(p.right != null) q.addLast(p.right);
        }
        return sequenceList;
    }


}
