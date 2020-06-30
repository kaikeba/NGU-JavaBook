// 从数组中查找
public class Demo {
    public static void main(String[] args) {
        int[] nums = {15, 3, 21, 49, 8};
        int value = 21;// 要查找的值
        int index = -1;// 用于记录索引位置，默认-1
        // 开始循环查找
        for(int i =0;i<nums.length;i++){
            if(nums[i] == value){
                index = i;  // 找到了记录索引位置
                break;
            }
        }
        // 循环查找后根据不同情况进行提示输出
        if(index != -1) {
            System.out.format("找到了%d，数组中索引位置是：%d",value,index);
        }else{
            System.out.format("数组中不存在%d值，返回索引为：%d",value,index);
        }
    }
}
