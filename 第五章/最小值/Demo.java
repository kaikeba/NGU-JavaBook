public class Demo {
    public static void main(String[] args) {
        int[] nums = {9, 14, 8, 20, 4};
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = min > nums[i] ? nums[i] : min;
        }
        System.out.println("min：" + min);
    }
}
