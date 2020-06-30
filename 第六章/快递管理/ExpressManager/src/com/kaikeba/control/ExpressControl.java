package com.kaikeba.control;

import com.kaikeba.bean.Express;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 包含快递集合，用于将集合中的存储快递的控制类
 */
public class ExpressControl {
    private ArrayList<Express> data = new ArrayList<Express>();
    private Random random = new Random();

    /**
     * 存储快递
     * @param e 快递参数
     * @return 返回的是自动生成的6位取件码
     */
    public void addExpress(Express e){
        //随机生成100000 - 999999的数字作为取件码
        int code;
        p:while(true){
            code = random.nextInt(900000)+100000;
            for (int i=0;i<data.size();i++){
                if(code == data.get(i).getExtractionCode()){
                    //随机生成的取件码重复时，就重新生成。
                    continue p;
                }
            }
            break;
        }
        //设置取件码
        e.setExtractionCode(code);
        //将快递存储到集合中
        data.add(e);
        System.out.println("快递录入成功，取件码："+code);
    }

    /**
     * 取出快递
     * @param code 取件码
     * @return 取出的快递信息
     */
    public Express getExpress(int code){
        for(int i=0;i<data.size();i++){
            if(code == data.get(i).getExtractionCode()){
               //如果有， 则取出 并 从集合中删除。
               return data.remove(i);
            }
        }
        //如果没有，则返回空
        return null;
    }

    public List<Express> findAll(){
        return data;
    }

}
