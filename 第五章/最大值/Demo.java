public class Demo {
    public static void main(String[] args) {
        int[] nums = {9, 14, 8, 20, 4};
        int max = nums[0];// 假定数组中的第一个元素为最大值
        for (int i = 1; i < nums.length; i++) {
            // 从第二个元素开始依次与假定的最大值进行比较
            if(max < nums[i]){
                max = nums[i];// 如果假定值较小，将大的值赋值给假定值
            }
        }
        // 数组循环结束后假定值就是最大值
        System.out.println("max：" + max);
    }
}
