import java.util.Scanner;
/**
 * 出租车计费功能实现
 * @version 1.0
 * @author Andy
 */
public class TaxiFare {
    public static void main(String[] args) {
        /* 第一步：声明好程序所需的变量，用于存储数据，请注意数据类型。 */
        Scanner input = new Scanner(System.in);
        double totCost = 0;   // 总费用
        double km = 0;  // 全程公里数
        double kmCost = 0;// 里程费用
        double lowSpeedTime = 0;// 低速行驶时长，单位：分钟
        double lowSpeedCost = 0;// 低速行驶费用
        String isRes = "";// 是否预约叫车（值：是|否）
        double resCost = 0;// 预约费用
        double overrunCost = 0;// 空驶费
        double nighttime = 0;// 夜间收费
        double fuel = 1;// 燃油附加费，默认1元
        String beginTime = "";// 开始乘车时间
        String endTime = "";// 结束乘车时间
        int beginHour = 0;  // 开始乘车时间（记录小时）
        int endHour = 0 ;// 结束乘车时间（记录小时）
        String kmMessage="";// 里程费用信息
        String lowSpeedMessage = "无低速行驶费用"; // 低速行驶费信息
        String resMessage = "无预约费用";// 预约服务费用信息
        String overrunMessage = "无空驶费用"; // 空驶费信息
        String nigthMessage = "无夜间费用"; // 夜间收费信息
        String fuelMessage = ""; // 燃油附加费信息

        /* 第二步：提示用户输入总里程数、开始乘车时间、结束乘车时间
        是否预约叫车（如果是预约叫车还需要确认是否在4小时以内）
        是否有低速行驶（如果有，提示输入低速行驶时间，需要考虑早晚高峰）
        如果里程超过15公里，需要输入是否往返2公里范围内，决定空驶费
        分别将这些用户输入的值，通过赋值存入对应的变量中。*/
        System.out.println("===== 出租车计费功能 =====");
        System.out.print("请输入打车总里程（KM）：");
        km = input.nextDouble();
        System.out.print("请输入开始乘车时间，24小时制（hh:mm:ss）：");
        beginTime = input.next();
        beginHour = Integer.parseInt( beginTime.substring(0,2) );   // 转换为int类型
        System.out.print("请输入结束乘车时间24小时制（hh:mm:ss）：");
        endTime = input.next();
        endHour = Integer.parseInt(endTime.substring(0,2));         // 转换为int类型
        System.out.print("输入是否预约叫车（是|否）：");
        isRes = input.next();
        if(isRes.equals("是")){
            System.out.print("\t\t预约时间是否在4小时以内（是|否）？");
            String isFourIn = input.next();
            if(isFourIn.equals("是")){   // 判断预约叫车服务费，4小时以内5元
                resCost = 5;
            }else{
                resCost = 6;    // 4小时以外6元
            }
            resMessage = "预约叫车服务费：" + resCost; // 设置好提示信息
        }
        System.out.print("是否有低速行驶（是|否）？");
        String isLow = input.next();
        if(isLow.equals("是")){
            System.out.print("\t请输入不含早晚高峰期间低速行驶时长（分钟）：");
            lowSpeedTime = input.nextDouble();
            lowSpeedCost =  Math.round((lowSpeedTime / 5) * (2.3)); // 其他时间段每5分钟加收一公里租价
            lowSpeedMessage = "其他时间段低速行驶费：" + lowSpeedCost;
            // 判断开始和结束时加是否在早晚高峰时间段
            if((beginHour >= 7 && beginHour < 9) ||
                    (beginHour >= 17 && beginHour < 19) ||
                    (endHour >= 7 && endHour < 9) ||
                    (endHour >= 17 && endHour < 19)){
                System.out.print("\t请输入早晚高峰期间低速行驶时长（分钟）：");
                double peak = input.nextDouble();
                double peakCost =Math.round( (peak / 5) * (2.3 * 2));// 每5分钟早晚高峰期间加收2公里租价
                lowSpeedMessage += "\n\t早晚高峰时间段低速行驶费：" + peakCost;
                lowSpeedCost = Math.round(lowSpeedCost + peakCost);// 将早晚高峰低速行驶费累加
            }
            lowSpeedMessage = "低速行驶费一共：" + lowSpeedCost + "元，其中:\n\t" + lowSpeedMessage;
        }
        // 如果里程超过15公里，需要输入是否往返2公里范围内，决定空驶费
        if(km > 15){
            System.out.print("是否往返载客（起点终点在2公里范围内）（是|否）？");
            String isNull = input.next();
            if(isNull.equals("否")){
                // 单程载客行驶超过15公里部分，基本单价加收50%的费用
                overrunCost = Math.round((km - 15) * (2.3 * 0.5));
                overrunMessage = "空驶费：" + overrunCost + "元";
            }
        }
        /* 第三步：根据计费标准和用户输入的数据进行总费用计算处理。*/
        kmCost = 13;    // 起步价13元
        kmMessage = "里程在3公里以内，里程价格：" + kmCost;
        if(km > 3){
            kmCost = Math.round((kmCost + (km - 3) * 2.3));
            kmMessage = "里程超过3公里，里程价格：" + kmCost;
        }
        // 判断夜间收费
        // 23：00（含）至次日5：00（不含）运营时，基本单价加收20%的费用
        // 开始乘车与结束乘车时间只要在夜间范围内，全程收夜间收费
        if(beginHour >= 23 || beginHour < 5 || endHour >= 23 || endHour < 5){
            nighttime = Math.round((km-3)*(2.3*0.2));
            nigthMessage = "夜间收费：" + nighttime + "元";
        }
        // 燃油附加费
        fuel = 1;
        fuelMessage = "燃油附加费：" + fuel + "元";
        // 计算总费用
        // 总车费=里程费用+低速行驶费（或者等候费）+预约叫车服务费+空驶费+夜间收费+燃油附加费
        totCost = Math.round( kmCost + lowSpeedCost + resCost + overrunCost + nighttime + fuel); // 四舍五入取整

        /* 第四步：输出总费用和每个产生费用单项的详细情况说明。*/
        System.out.println("总车费：" + totCost + "元");
        System.out.println("---产生费用项目详细情况---");
        System.out.println(kmMessage + "\n"
                            + lowSpeedMessage + "\n"
                            + resMessage + "\n"
                            + overrunMessage + "\n"
                            + nigthMessage + "\n"
                            + fuelMessage);
    }
}
