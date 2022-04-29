package a_BinaryAlgorithm;

public class Template {
    /**
     * 检查x是够满足某种性质
     * @param x
     * @return
     */
    public static<E> boolean check(E x){
        /*...*/
        return true;
    }

    /**
     * 区间[l, r]被划分成[l, mid]和[mid + 1, r]时使用。用于确定最左端的位置
     * @param l
     * @param r
     * @return
     */
    public static int bSearchLeft(int l, int r){
        while (l < r){
            int mid = l + r >> 1;
            if(check(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    /**
     * 区间[l, r]被划分成[l, mid - 1]和[mid, r]时使用。用于确定最右端的位置
     * @param l
     * @param r
     * @return
     */
    public static int bSearchRight(int l, int r){
        while (l < r){
            int mid = l + r + 1 >> 1;
            if(check(mid)) l = mid;
            else r = mid - 1;
        }
        return l;
    }
}
