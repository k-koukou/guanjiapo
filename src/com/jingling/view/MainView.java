package com.jingling.view;
import com.jingling.controller.ZhangWuController;
import com.jingling.domain.ZhangWu;
import java.util.List;
import java.util.Scanner;
/*
* 视图层
* */
public class MainView {
    private ZhangWuController zhangWuController = new ZhangWuController();
    //界面效果
    public void run() {
        //接受用户录入的数据
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("---------------管家婆家庭记账软件---------------");
            System.out.println("------------------欢迎使用--------------------");
            System.out.println("------------ -Wellcome to GJP-----------------");
            System.err.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
            System.out.println("请输入要操作的功能序号[1-5]:");
           int choose = scanner.nextInt();
            switch(choose){
                case 1 :
                 //选择添加的账务，然后调用方法
                    addzhangwu();
                    break;
                case 2:
                 //选择编辑的账务，然后调用方法
                    editZhangWu();
                    break;
                case 3 :
                 //选择删除的账务，然后调用方法
                   deleteZhangWu();
                    break;
                case 4:
                 //选择查询的账务，然后调用方法
                    selectZhangWu();
                    break;
                case 5 :
                    //这里就直接调用方法停止jvm虚拟机即可
                    System.exit(0);
                    break;
                default :
                    System.out.println("请您输入正确的插叙条件");
                    break;
            }
        }
    }
    //账务查询-查询
    public void selectZhangWu(){
        /**
         * 定义方SelectZhangwu
         * 显示查询的方法，1，所有查询 2， 部分查询
         * 接受用户录入的数据
         * */
        System.out.println("请输入您需要插叙的类别");
        System.out.println("1--条件查询 2--所有查询");
        Scanner scanner = new Scanner(System.in);
        //然后就开始接收数据
        int selectChooser = scanner.nextInt();
        switch(selectChooser) {
            case 1 :
                select();
                break;
            case 2 :
                selectAll();
                break;
            default:
                System.out.println("请输入正确的查询条件");
                break;
             }
        }
     //查询部分
    public void select (){
        //条件查询   调用控制层中的方法查询
        /**
         * 定义方法，实现条件查询的账务数据
         * 用户录入日期，作为开始和结束的日期
         * 将两个日期传递给zhangwucontroller层
         * 获取到zhangwucontroller层查询的结果集合
         * */
        System.out.println("欢迎使用调价查询平台");
        System.out.println("日期的输入格式==XXXX-XX-XX");
        System.out.println("请输入开始时间");
        Scanner scanner = new Scanner(System.in);
        String startData = scanner.nextLine();
        System.out.println("请输入结束时间");
        String endData = scanner.nextLine();
        //调用controller的方法获语句的结果集合
            List<ZhangWu> list = zhangWuController.select(startData,endData);
        //添加条件判断语句
        if (list.size() != 0){
            print(list);
        }else{
            System.err.println("没有查询到该时间段内的任何账务数据");
        }
    }
      //输出结果
    private void print(List<ZhangWu> list) {
        /**
         * 输出账务表的方法，接受list集合，遍历集合，输出表格
         * */
        //然后遍历集合中的数据
        System.err.println("ID\t\t类别\t\t\t账户\t\t\t金额\t\t\t时间\t\t\t说明");
        //遍历集合，输出到控制台
        for (ZhangWu zhangWu: list) {
            System.out.println(zhangWu.getZwid()+"\t\t"+zhangWu.getFlname()+"\t\t"+zhangWu.getZhangHu()+"\t\t"+
                    zhangWu.getMoney()+"\t\t"+zhangWu.getCreatetime()+"\t\t"+zhangWu.getDescription());
            }
    }
      //查询所有
        public void selectAll(){
            //所有表格的查询，调用控制层中的方法查询
            List<ZhangWu> list =zhangWuController.SelectAll();
            //添加条件判断语句
           if (list.size() != 0){
            print(list);
           }else{
               System.err.println("没有查询到该时间段内的任何账务数据");
           }
        }
      //添加账务
    public void addzhangwu (){
        /**
         *  定义方法，addzhangwu
         *      添加账务的方法，用户在功能
         *   实现思想
         *  让我们接受键盘录入的数据五项输入数据，调用controller层的方法
         */
        //键盘录入数据
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入类别：--支出方式");
        String flname = scanner.next();
        System.out.println("请输入金额 ");
        String money = scanner.next();
        System.out.println("请输入支付方式，现金还是微信，以支付结尾");
        String zhanghu = scanner.next();
        System.out.println("请输入时间");
        String createtime = scanner.next();
        System.out.println("请输入描述");
        String description = scanner.next();
        //然后传递参数
        ZhangWu zhangWu = new ZhangWu(0,flname ,money ,zhanghu , createtime,description);
        zhangWuController.addzhangwu(zhangWu);
        System.out.println("恭喜添加账务成功");

    }
        //编辑账务
    public void editZhangWu (){
        //键盘录入
        Scanner in = new Scanner(System.in);
        System.out.print("请输入ID：");
        String ID = in.nextLine();
            System.out.print("请输入新类别：");
            String name = in.nextLine();
            System.out.print("请输入新账户：");
            String zhanghu = in.nextLine();
            System.out.print("请输入新金额：");
            String time = in.nextLine();
            System.out.print("请输入新时间：");
            String descrp = in.nextLine();
            System.out.print("请输入新说明：");
            ZhangWu zhangWu = new ZhangWu(0, ID, name, zhanghu, time, descrp);
            zhangWuController.editZhangWu(zhangWu);
            System.out.println("编辑账务成功！");
        }
        //删除
    public void deleteZhangWu() {
        //删除账务
        /**
         * 删除账务方法
         */
        /*
         * 1. 获取用户输入，封装到bean中。
         * 2. 调用service的deleteZhangWu()方法完成添加功能
         */
        Scanner in = new Scanner(System.in);
        System.out.print("请输入ID：");
        zhangWuController.deleteZhangWu(in.nextInt());
        System.out.println("删除账务成功！");
    }

    }




