/**
 * 1. 节点是黑色或红色
 * 2. 根节点是黑色
 * 3. 所有叶节点是黑色（叶节点是NIL节点）
 * 4. 每个红色节点必须有两个黑色的子节点（从每个叶子到根的所有路径上不能有两个连续的红色节点。）
 * 5. 从任一节点到其每个叶子的所有简单路径都包含相同数目的黑色节点。
 */
class RBTNode<T>{
    public T value;
    public RBTNode<T> parent;
    public RBTNode<T> left;
    public RBTNode<T> right;
    public boolean isRead; //判断该节点是黑色（false）还是红色（true）
}
public class RBTree {
}
