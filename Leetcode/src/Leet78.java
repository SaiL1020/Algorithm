import java.util.*;
/**
 * Created by sail on 9/1/16.
 * Code one more line :)
 */
public class Leet78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> subset = new LinkedList<>();
        solve(0, nums.length, nums, subset, ans);
        Arrays.sort(nums);
//        for (List<Integer> l : ans) {
//            for (int k : l) {
//                System.out.print(k + " ");
//            }
//            System.out.println();
//        }
        return ans;
    }

    public void solve(int cur, int n, int[] nums, List<Integer> subset, List<List<Integer>> ans) {
        //System.out.println(cur);
        ans.add(new LinkedList<Integer>(subset));
        for (int i = cur; i < n; i++) {
            subset.add(nums[i]);
            solve(i + 1, n, nums, subset, ans);
            subset.remove(subset.size() - 1);
        }
    }
    public static void main(String[] args) {
        new Leet78().run();
    }
    public void run() {
        subsets(new int[]{1,2,3,3});
    }

//    private void solve(List<List<Integer>> res,int[] nums,List<Integer> tmpList,int index){
//        if(index==nums.length){
//            res.add(new LinkedList(tmpList));
//            return;
//        }
//        solve(res,nums,tmpList,index+1);
//        tmpList.add(nums[index]);
//        solve(res,nums,tmpList,index+1);
//        tmpList.remove(tmpList.size()-1);
//    }
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new LinkedList<>();
//        List<Integer> tmpList = new LinkedList<>();
//
//        Arrays.sort(nums);
//        solve(res, nums, tmpList, 0);
//
//        for (List<Integer> l : res) {
//            for (int k : l) {
//                System.out.print(k + " ");
//            }
//            System.out.println();
//        }
//        return res;
//    }


//    private void solve(List<List<Integer>> res,int[] nums,List<Integer> tmpList,int index){
//        if(index==nums.length){
//            res.add(new LinkedList(tmpList));
//            return;
//        }
//        solve(res,nums,tmpList,index+1);      //divide and conquer, interesting!
//        tmpList.add(nums[index]);
//        solve(res,nums,tmpList,index+1);
//        tmpList.remove(tmpList.size()-1);
//    }
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new LinkedList<>();
//        List<Integer> tmpList = new LinkedList<>();
//
//        Arrays.sort(nums);
//        solve(res, nums, tmpList, 0);
//
//        return res;
//    }
}
