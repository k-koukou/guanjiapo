package com.jingling.dao;
import com.jingling.domain.ZhangWu;
import com.jingling.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.SQLException;
import java.util.List;
/*
* 实现对数据表的操作
* */
public class ZhangWuDao {
    private QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

    //查询部分
    public List<ZhangWu> select (String startData,String endData){
        /**
         * 定义方法，实现查询数据库，条件查询账务表
         * 由业务层进行调用，查询结果存储到Bean对象中，存储到List集合中
         * 调用者传递两个日期字符串
         * */
        try {
            //编写sql语句
            String sql = "SELECT * FROM LYB.gjp_zhangwu WHERE createtime BETWEEN  ? AND ?";
            //定义对象数据，存储占位符
            Object[] objects = {startData, endData};
            //获取sql语句执行平台
            return queryRunner.query(sql, new BeanListHandler<>(ZhangWu.class), objects);
        }catch (SQLException sqlException){
            throw new RuntimeException("条件查询失败");
        }
    }
    //查询所有
    public List <ZhangWu> selectAll (){
        /**
         *   定义方法，查询数据库，获取所有的账务信息
         * 方法由业务层进行调用
         * */
        //查询的SQL语句
        try {
            String sql = "SELECT  * FROM lyb.gjp_zhangwu";
            List<ZhangWu> list = queryRunner.query(sql, new BeanListHandler<>(ZhangWu.class));
            return list;
        }catch (SQLException sqlException){
            System.out.println(sqlException);
            throw new RuntimeException("查询所有账务失败");
        }
    }
    //添加账务
    public void addzhangwu(ZhangWu zhangWu){

        /**
         * 实现添加账务的功能
         * 由业务层进行调用，传递ZhangWu对象
         *  将账务数据添加到账务表内
         *  */
        String sql = "INSERT INTO lyb.gjp_zhangwu (flname, money, zhanghu, createtime, description) VALUES (?,?,?,?,?);";
        //创建对象数组，存储五个占位符的实际数据。我们的实际参数来自于我们的账务
        try {
        Object[] params = {zhangWu.getFlname(), zhangWu.getMoney(), zhangWu.getZhangHu()
                , zhangWu.getCreatetime(), zhangWu.getDescription()};
        queryRunner.update(sql, params);
        }catch(SQLException sqlException){
        System.out.println(sqlException);
        throw new RuntimeException("账务添加失败，请重新核验后添加数据");
    }
    }
    //编辑
    public void editZhangWu(ZhangWu zw) {
        /**
         * 编辑账务
         * @param zw
         */
        String sql = "update LYB.gjp_zhangwu SET flname=?, money=?,zhanghu=?,createtime=?,description=? where zwid=?";
        try {
            Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhangHu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //删除
    public void deleteZhangWu(int zwid) {
        /**
         * 删除账务
         * @param zwid
         */
        String sql = "delete from LYB.gjp_zhangwu where zwid=?";
        try {
            queryRunner.update(sql, zwid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
