import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        BSTree bsTree = new BSTree();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> dataList = new ArrayList<>();
        String[] dataStr = br.readLine().split(" ");
        for (String s : dataStr) {
           dataList.add(Integer.parseInt(s));
        }
        Iterator<Integer> it = dataList.iterator();
        while (it.hasNext()){
            bsTree.insert(it.next());
        }
        // 5 6 3 7 4 2 8 1 9 0
        List<Integer> preList = bsTree.preOrder();
        System.out.println("preOrder :");
        preList.forEach((Integer nodeV) -> System.out.print(nodeV + " "));
        System.out.println();

        System.out.println(bsTree.remove(3));

        List<Integer> inList = bsTree.inOrder();
        System.out.println("inOrder :");
        inList.forEach((Integer nodeV) -> System.out.print(nodeV + " "));
        System.out.println();

        List<Integer> postList = bsTree.postOrder();
        System.out.println("postOrder :");
        postList.forEach((Integer nodeV) -> System.out.print(nodeV + " "));
        System.out.println();

        List<Integer> levelList = bsTree.levelOrder();
        System.out.println("levelOrder :");
        levelList.forEach((Integer nodeV) -> System.out.print(nodeV + " "));
        System.out.println();
    }
}
