package com.jingling.service;

import com.jingling.dao.ZhangWuDao;
import com.jingling.domain.ZhangWu;

import java.util.List;

/*
* 业务层类
*       接受上一层的数据
*       进行计算后传递给dao层
* */
public class ZhangWuService {
        private ZhangWuDao zhangWuDao = new ZhangWuDao();

        //查询--条件查询
        public List<ZhangWu> select (String startData,String endData){
                /**
                 * 定义方法，实现条件查询账务，
                 * 方法由控制层进行调用，传递两个日期字符串
                 * 调用dao层的方法，传递两个日期字符串
                 * 获取查询结果集合
                 * */
        return zhangWuDao.select(startData, endData);
        }
       //查询--全部查询
        public  List<ZhangWu>  SelectAll(){
            /**
             * 定义方法
             * 实现查询所有的账务数据
             * 此方法是控制层调用
             * 去调用dao
             * 返回存储对象的List集合
             * */
            return zhangWuDao.selectAll();
        }
        //添加
        public void addzhangwu(ZhangWu zhangWu){
        /**
         * 添加账务，实现添加账务
         * 由控制层进行调用，传递ZhangWu类型的对象
         * 调用dao层进行传递
         * */
        zhangWuDao.addzhangwu(zhangWu);
        }
        //编辑
        public void editZhangWu(ZhangWu zhangWu) {
        /**
         * 编辑账务
         * @param zhangWu
         */
        zhangWuDao.editZhangWu(zhangWu);
    }
        //删除
        public void eleteZhangWu (int zwid){
            zhangWuDao.deleteZhangWu(zwid);
        }
}
