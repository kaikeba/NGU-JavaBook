public class Demo {
    public static void main(String[] args) {
        int[] nums = {9, 14, 8, 20, 4};
        int sum = 0;        // 初始化为0
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // 累加
        }
        // 循环结束后得到总和
        System.out.println("sum：" + sum);   // 输出sum：55
        double avg = (double) sum / nums.length;
        System.out.println("avg：" + avg);
    }
}
