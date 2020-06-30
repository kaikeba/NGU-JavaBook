public class Demo {
    public static void main(String[] args) {
        // 大学生活模拟
        System.out.println("即将开始愉快的大学生活！");
        // 1）进入循环前的初始化语句。ability:通过高考，能力指数达到80分
        int ability = 80;
        // 2）循环条件。当能力指数达不到100的时候需要在大学不断学习
        while (ability < 100) {
            // 3）循环体。开始丰富多彩的大学生活
            System.out.println("听课、学习、做作业");
            System.out.println("参加活动、谈恋爱");
            ability = ability + 5; // 4）在循环体中“线索”发生变化，此处每次能力值提升5个单位
            System.out.println("本次循环中ability指数：" + ability);
            // 输出ability值，观察循环过程
        }
        // 循环结束后的其他代码
        System.out.println("恭喜你！大学毕业了！");

    }
}
