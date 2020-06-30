public class Demo {
    public static void main(String[] args) {
        int[] nums = {9, 14, 7, 20, 4};
        int count = 0;        // 计数器变量初始化为0
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0){
                count++;
            }
        }
        // 循环结束后输出计数器值
        System.out.println("count：" + count);   // 输出count：3
    }
}
