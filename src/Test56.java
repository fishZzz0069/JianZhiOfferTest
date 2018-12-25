public class Test56 {

    public void FindNumsAppearOnce(int [] array) {
        if(array==null ||array.length<2)
            return ;
        int temp = 0;
        for(int i=0;i<array.length;i++)
            temp ^= array[i];

        int indexOf1 = findFirstBitIs(temp);
        int num1 = 0;
        int num2 = 0;
        for(int i=0;i<array.length;i++){
            if(isBit(array[i], indexOf1))
                num1 ^=array[i];
            else
                num2 ^=array[i];
        }
        System.out.println(num1);
        System.out.println(num2);


    }
    public int findFirstBitIs(int num){
        int indexBit = 0;
        while(((num & 1)==0) && (indexBit)<8*4){
            num = num >> 1;
            ++indexBit;
        }
        return indexBit;
    }
    public boolean isBit(int num,int indexBit){
        num = num >> indexBit;
        return (num & 1) == 1;
    }


    public int FindNumberAppearanceOnceOfThree(int[] nums){



        int[] bit = new int[32];

        for(int k = 0; k < bit.length ; k++){
            bit[k] = 0;
        }

        int res = 0;
        for (int i =0 ; i < 32 ; i++){
            int bitmask = 1 ;

            for (int j = 0 ; j < nums.length ; j++){
                bit[i] += (nums[j]>>i) & bitmask;
            }
            res |= (bit[i]%3) <<i;

        }
        return res;
    }


    public static void main(String[] args){
        System.out.print(new Test56().FindNumberAppearanceOnceOfThree(new int[]{1,2,3,1,2,3,5,3,2,1}));
    }

}
