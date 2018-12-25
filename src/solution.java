import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

// 167. Two Sum II - Input array is sorted
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
//
// 二分搜索法
// 时间复杂度: O(nlogn)
// 空间复杂度: O(1)
class solution {

   public List<Integer> findDuplicates(int[] nums) {

//       ArrayList<Integer> res = new ArrayList<Integer>();
//       for (int i = 0; i < nums.length; i++) {
//           if (nums[i] == i + 1) {
//               continue;
//           } else if (nums[i] != nums[nums[i]-1]){
//
//                   if (nums[nums[i]-1] == nums[nums[nums[i]-1]-1]){
//                       res.add(nums[nums[i]-1]);
//                   }
//
//                   int temp = nums[nums[i]-1];
//                   nums[nums[i]-1] = nums[i];
//                   nums[i] = temp;
//
//
//
//           } else {
//                   res.add(nums[i]);
//           }
//
//
//       }
//
//       return res;

       ArrayList<Integer> res = new ArrayList<Integer>();
       for (int i = 0; i < nums.length; i++) {

         while(nums[i]!= i+1) {

             if (nums[i] == nums[nums[i] - 1]){
                break;
             }

             int temp = nums[nums[i] - 1];
             nums[nums[i] - 1] = nums[i];
             nums[i] = temp;
         }



       }

       for (int j = 0 ; j <nums.length ; j++){
           if (nums[j] != j+1){
               res.add(nums[j]);
           }
       }


       return res;
   }







             public static void  main(String[] args){
//        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(2);
//        lists.add(list);
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.add(3);
//        list2.add(4);
//        lists.add(list2);
//        ArrayList<Integer> list3 = new ArrayList<>();
//        list3.add(6);
//        list3.add(5);
//        list3.add(7);
//        lists.add(list3);
//        ArrayList<Integer> list4 = new ArrayList<>();
//        list4.add(4);
//        list4.add(1);
//        list4.add(8);
//        list4.add(3);
//        lists.add(list4);

        int[][] lists = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.print(new solution().findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }
}



