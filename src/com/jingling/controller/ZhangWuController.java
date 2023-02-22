package com.jingling.controller;
import com.jingling.domain.ZhangWu;
import com.jingling.service.ZhangWuService;
import java.util.List;

/*
*   控制器层
*   接受视图层的数据，将数据传输给service
*
* */
public class ZhangWuController {
    private ZhangWuService zhangWuService = new ZhangWuService();
    //查询--条件查询
    public List<ZhangWu> select(String startData,String endData){
        /**
         * 定义方法实现条件查询账务
         * 方法由视图层进行调用
         * 调用zhangwuservice方法传递两个日期字符串，获取结果集合
         * 结果返回给视图层
         * */
      return zhangWuService.select(startData, endData);
    }
    //查询--全部查询
    public List<ZhangWu> SelectAll(){
        /**
         * 定义方法
         * 此方法是控制层调用
         * 去调用service
         * */
        return zhangWuService.SelectAll();
    }
    //添加功能
    public void addzhangwu(ZhangWu zhangWu){
        /**
         * 添加功能
         * 由视图层进行调用，传递过来的参数不能是五个参数，不方便，封装后进行传递，更加的便捷
         * 方法调用servier层方法，传递账务对象，获取到添加到的结果集合
         *
         * */
        zhangWuService.addzhangwu(zhangWu);
    }
    //编辑
    public void editZhangWu (ZhangWu zhangWu){
        zhangWuService.editZhangWu(zhangWu);
    }
    //删除
    public void deleteZhangWu(int zwid) {
        zhangWuService.eleteZhangWu(zwid);
    }

}
