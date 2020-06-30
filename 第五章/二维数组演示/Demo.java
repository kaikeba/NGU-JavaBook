// 二维数组演示
public class Demo {
    public static void main(String[] args) {
        // 声明二维数组
        int [][] nums = new int[3][];
        // 在二维数组对应索引处创建一维数组空间
        nums[0] = new int[]{34,19};
        nums[1] = new int[]{45,67,88};
        nums[2] = new int[]{47,98,12};
        // 测试输出
        System.out.println(nums[0][1]); // 输出19
    }
}
