// 循环实现二分法查找
public class Demo {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        // 要查找的数据
        int num = 20;
        // 关键的三个变量：
        // 1.最小范围下标
        int minIndex = 0;
        // 2.最大范围下标
        int maxIndex = nums.length - 1;
        // 3.中间数据下标
        int centerIndex = (minIndex + maxIndex) / 2;
        while (true) {
            System.out.println("循环了一次");// 测试
            if (nums[centerIndex] > num) {
                // 中间数据较大
                maxIndex = centerIndex - 1;
            } else if (nums[centerIndex] < num) {
                // 中间数据较小
                minIndex = centerIndex + 1;
            } else {
                // 找到了数据  数据位置：centerIndex
                break;
            }
            if (minIndex > maxIndex) {
                centerIndex = -1;
                break;
            }
            // 当边界发生变化， 需要更新中间下标
            centerIndex = (minIndex + maxIndex) / 2;
        }
        System.out.println("位置：" + centerIndex);
    }
}