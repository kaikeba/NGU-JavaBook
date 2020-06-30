// 杨辉三角
public class Demo {
    public static void main(String[] args) {
        int[][] num = new int[10][];
        // 动态初始化数组
        for (int i = 0; i < num.length; i++) {
            num[i] = new int[i + 1];
        }
        // 按照规律进行循环赋值
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                if (j == 0 || i == j) {
                    // 前后赋值为1
                    num[i][j] = 1;
                } else {
                    // 每一行第二列到第j-1列的值=上一行前一列的数+上一行该列的数
                    num[i][j] = num[i - 1][j - 1] + num[i - 1][j];
                }
            }
        }
        // 格式输出
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                System.out.print(num[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
