import java.util.Scanner;
/**
 * 实现会议室预定管理
 * @author LiWeiJie
 * @version 1.0
 */
public class MeetingRoomReserve {
    public static void main(String[] args) {
        //初始化接收用户输入
        Scanner input = new Scanner(System.in);
        //初始化会议室名称
        String[] names = {"一会议室(24人)", "二会议室(12人)", "三会议室(8人)", "四会议室(8人)", "五会议室(6人)", "六会议室(4人)", "七会议室(4人)", "八会议室(4人)"};
        //初始化会议室时间表 (时间表后续使用预订人名称填充,所以类型为String)
        String[][] times = new String[names.length][24];
        //显示欢迎语句
        System.out.println("** 欢迎使用会议室预定系统 **");
        //循环显示主菜单
        main:
        while (true) {
            System.out.println("1. 预定会议室");
            System.out.println("2. 会议室状态查看");
            System.out.println("0. 退出");
            System.out.print("请输入功能序号:");
            //判断输入是否为数字
            if (input.hasNextInt()) {
                int menuNum = input.nextInt();
                //当输入不合理时, 跳出本次循环
                if (menuNum < 0 || menuNum > 2) {
                    System.out.println("输入有误,请检查");
                    continue main;
                }
                //根据用户选择的菜单,进行相应功能的实现
                switch (menuNum) {
                    case 1: {
                        //开始会议室预定流程
                        System.out.println("-------------\t 会议室预定 \t-------------");
                        while (true) {
                            //提示输入开会时间
                            System.out.print("请输入开会时间 (请输入0-23数字 , 表示0点-23点)：");
                            if (input.hasNextInt()) {
                                int time = input.nextInt();
                                //判断时间是否有误
                                if (time < 0 || time > 23) {
                                    System.out.println("输入有误,请重新输入");
                                } else {
                                    //计算此时间是否有空闲会议室
                                    boolean flag = false;
                                    for (int i = 0; i < times.length; i++) {
                                        if (times[i][time] == null) {
                                            flag = true;
                                            break;
                                        }
                                    }
                                    //无空闲
                                    if (!flag) {
                                        System.out.println("此时间段暂无空闲会议室，请更换开会时间");
                                    } else {
                                        //有空闲会议室时, 循环提示选择会议室
                                        while (true) {
                                            System.out.println("空闲的会议室如下");
                                            //显示空闲的所有会议室
                                            for (int i = 0; i < times.length; i++) {
                                                if (times[i][time] == null) {
                                                    System.out.println(i + "\t" + names[i]);
                                                }
                                            }
                                            System.out.print("请选择要使用的会议室序号：");
                                            //接收会议室序号选择
                                            if (input.hasNextInt()) {
                                                int num = input.nextInt();
                                                if (num < 0 || num > names.length || times[num][time] != null) {
                                                    System.out.println("输入有误,请重新输入");
                                                } else {
                                                    //提示输入预定人员名称
                                                    System.out.println("请输入您的姓名:");
                                                    times[num][time] = input.next();
                                                    System.out.println("恭喜你" + times[num][time] + ", 会议室预定成功");
                                                    System.out.println("会议室名称:" + names[num]);
                                                    System.out.println("开会时间:" + time + "点");
                                                    break;
                                                }
                                            } else {
                                                //输入非数字会议室序号时  提示
                                                input.next();
                                                System.out.println("输入有误,请重新输入");
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else {
                                //输入非数字会议室时间时
                                input.next();
                                System.out.println("输入有误,请重新输入");
                            }
                        }
                        break;
                    }
                    case 2: {
                        //显示会议室列表
                        System.out.println("-------------\t 会议室列表如下 \t-------------");
                        for (int i = 0; i < names.length; i++) {
                            System.out.println(i + ".\t" + names[i]);
                        }
                        System.out.println("会议室列表如上所示,请输入序号查看会议室状态");
                        //接收输入要查看的会议室序号
                        while (true) {
                            if (input.hasNextInt()) {
                                int num = input.nextInt();
                                if (num < 0 || num > names.length - 1) {
                                    System.out.println("输入有误,请重新输入");
                                } else {
                                    //获取指定会议室的24小时预定情况
                                    String[] status = times[num];
                                    System.out.println("< " + names[num] + " >会议室使用情况如下:");
                                    for (int i = 0; i < status.length; i++) {
                                        //提示时间和空闲状态
                                        System.out.println((i > 9 ? "" + i : " " + i) + "点\t:" + (status[i] == null ? "空闲" : status[i] + " 已预定"));
                                    }
                                    break;
                                }
                            } else {
                                //当用户输入非数字会议室序号时,进入else
                                //消耗此次else
                                input.next();
                                System.out.println("输入有误,请重新输入");
                            }
                        }
                        break;
                    }
                    case 0: {
                        break main;
                    }
                }
            } else {
                //当用户在主菜单输入非数字时,进入else
                //主动消耗主菜单此次输入的非数字
                input.next();
                System.out.println("输入有误,请检查");
            }
        }
        System.out.println("系统退出, 再见!");
    }
}