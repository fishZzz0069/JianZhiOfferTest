public class Test {

    /**
     * 避免使用辅助空间
     */


     public int getDuplication(int[] arr){

         int start = 0 ;
         int end = arr.length-1;
         int flag = 0;
         int middle = 0;
         while(end >= start){

             if (flag == 0){
                 middle = start + (end-start)/2;
             }

             int count = getCount(arr , start ,middle);

             if (start == end){
                 if (count > 1)
                     return end;
                 else
                     break;
             }

             if (count > (middle - start) +1){
                 //说明（start,middle）中有重复的数字，在该范围段每个数字出现1一次的话最多也就(middle - start) +1，现在有重复数字才会导致多余(middle - start) +1
                 end = middle ; // 继续进行下一轮循环寻找
                 flag = 0 ;//flag重置再次计算middle的值
             }else if (count == middle -start +1){
                 //不能确定是否有重复数
                 middle = middle - 1;
                 //将middle的指针往前进
                 if (start > middle)
                 {
                     //说明该区间已经遍历完middle到start并且count的值都满足数字出现一次的情况，从右边开始寻找
                     start = (end-start)/2 + 1;
                     flag = 0;
                 }else
                     flag = 1; //不再重置middle 进行下一轮循环
             }else{
                 start = middle + 1;
                 flag = 0;
             }







         }




         return -1;
     }

    public int getCount(int[] arr, int start , int end ){
         int count = 0 ;
         for (int i = 0 ; i < arr.length ; i++){
             if (arr[i]<=end && arr[i] >= start){
                 count++;
             }
         }

         return count;
    }


    public static void main(String[] args) {

        Test test = new Test();
        int[] arr = {7,6,5,2,1,2,3,0};
        int value = test.getDuplication(arr);
        System.out.print(value);
    }
}

