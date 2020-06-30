// 二维数组遍历
public class Demo {
    public static void main(String[] args) {
        // 声明二维数组
        int[][] nums = new int[3][];
        // 在二维数组对应索引处创建一维数组空间
        nums[0] = new int[]{34, 19};
        nums[1] = new int[]{45, 67, 88};
        nums[2] = new int[]{47, 98, 12};
        // 遍历输出
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
