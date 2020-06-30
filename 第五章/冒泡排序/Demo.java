import java.util.Arrays;
// 实现冒泡排序
public class Demo {
    public static void main(String[] args) {
        int[] nums = {15, 3, 21, 49, 8};
        System.out.println("原始顺序：" + Arrays.toString(nums));
        for (int i = 0; i < nums.length - 1; i++) {         // 外层循环控制进行几轮冒泡
            for (int j = 0; j < nums.length - i - 1; j++) { // 里层循环控制每一轮需要进行几次对比
                if (nums[j] > nums[j + 1]) {                // 符合条件后交换
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            // 打印每一轮比较后的结果（查看过程数据）
            System.out.format("第 %d 轮：" + Arrays.toString(nums) + "%n", (i + 1));
        }
        // 最终排序后结果
        System.out.println("排序结果：" + Arrays.toString(nums));
    }
}
