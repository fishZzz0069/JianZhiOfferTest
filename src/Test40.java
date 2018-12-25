public class Test40 {



    public int[] getTopK(int[] num,int k){

        if (num == null){
            return null;
        }else if (num.length < k){
            System.out.println("dont have enough numbers");
            return num;
        }



        MaxHeap maxHeap = new MaxHeap(k);
        for (int i = 0 ; i < num.length ; i++){
            if (maxHeap.size() < k) {
                maxHeap.insert(num[i]);
            }else {
                if (maxHeap.getMax().compareTo(num[i])>0){
                    maxHeap.replace(num[i]);

                }

            }
        }
        int[] res = new int[k];



        for (int i = 0 ; i < maxHeap.capacity ; i++){
            res[i] = (int) maxHeap.getData(i+1);
        }


        for (int i = 0; i < maxHeap.capacity ; i++){
            System.out.println(res[i]);
        }
        return res;





    }
    class MaxHeap<Item extends Comparable> {

        protected Item[] data;
        protected int count;
        protected int capacity;

        // 构造函数, 构造一个空堆, 可容纳capacity个元素
        public MaxHeap(int capacity) {
            data = (Item[]) new Comparable[capacity + 1];
            count = 0;
            this.capacity = capacity;
        }

        // 构造函数, 通过一个给定数组创建一个最大堆
        // 该构造堆的过程, 时间复杂度为O(n)
        public MaxHeap(Item arr[]) {

            int n = arr.length;

            data = (Item[]) new Comparable[n + 1];
            capacity = n;

            for (int i = 0; i < n; i++)
                data[i + 1] = arr[i];
            count = n;

            for (int i = count / 2; i >= 1; i--)
                shiftDown(i);
        }

        // 返回堆中的元素个数
        public int size() {
            return count;
        }

        // 返回一个布尔值, 表示堆中是否为空
        public boolean isEmpty() {
            return count == 0;
        }

        public Item getData(int index) {
            return data[index];
        }

        // 像最大堆中插入一个新的元素 item
        public void insert(Item item) {

            assert count + 1 <= capacity;
            data[count + 1] = item;
            count++;
            shiftUp(count);
        }

        // 从最大堆中取出堆顶元素, 即堆中所存储的最大数据
        public Item extractMax() {
            assert count > 0;
            Item ret = data[1];

            swap(1, count);
            count--;
            shiftDown(1);

            return ret;
        }

        public void replace(Item item){
            data[capacity-1] = item;
            shiftUp(count);

        }

        // 获取最大堆中的堆顶元素
        public Item getMax() {
            assert (count > 0);
            return data[1];
        }


        // 交换堆中索引为i和j的两个元素
        private void swap(int i, int j) {
            Item t = data[i];
            data[i] = data[j];
            data[j] = t;
        }

        //********************
        //* 最大堆核心辅助函数
        //********************
        private void shiftUp(int k) {

            while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
                swap(k, k / 2);
                k /= 2;
            }
        }

        private void shiftDown(int k) {

            while (2 * k <= count) {
                int j = 2 * k; // 在此轮循环中,data[k]和data[j]交换位置
                if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0)
                    j++;
                // data[j] 是 data[2*k]和data[2*k+1]中的最大值

                if (data[k].compareTo(data[j]) >= 0) break;
                swap(k, j);
                k = j;
            }
        }
    }


    public static void main(String[] args){
        System.out.println(new Test40().getTopK(new int[]{},3));
    }


}
