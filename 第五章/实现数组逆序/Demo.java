import java.util.Arrays;
// 实现数组逆序
public class Demo {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("原始顺序：" + Arrays.toString(nums));
        // 进行逆序操作
        for (int i = 0; i < nums.length / 2; i++) {
            // 俩俩交换
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        System.out.println("处理后顺序：" + Arrays.toString(nums));
    }
}
