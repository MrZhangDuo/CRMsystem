package com.hy.crmsystem.mrpan.provider.selectProvider;

import com.hy.crmsystem.mrpan.entity.Customer;

public class customerManage {


    /*客户管理页面联合查询*/
    public String customerselect(Customer customer){
        boolean selectName;
        StringBuffer sql=new StringBuffer("SELECT  cus.CustName,COUNT(cus.Busid),SUM( bus.BusBeforeMoney),COUNT(cus.ContractId),\n" +
                "                        SUM(con.ContractMoney),SUM(money.incomesMoney), COUNT(cus.ServiceId),AVG(ser.ServicesCore)\n" +
                "                FROM customer cus,business bus,contract con,moneyregister money,service ser\n" +
                "                WHERE cus.BusId=bus.BusId AND cus.ContractId=con.ContractId AND con.incomeId=money.incomeId AND cus.ServiceId=ser.ServiceId AND 1=1");


        return sql.toString();
    }





}
