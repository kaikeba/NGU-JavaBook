public class Demo {
    public static void main(String[] args) {
        //制造一个汽车对象，命名为car1
        Car car1 = new Car();
        //给car1汽车设置颜色为红色
        car1.color = "红色";
        //给car1汽车设置价格为199999.00
        car1.price = 199999.00;
        //调用car1汽车的加速方法
        car1.speedUp();

    }
}