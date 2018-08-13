package com.hf.quartz;

import org.springframework.scheduling.support.CronSequenceGenerator;

import java.util.Date;

public class getNextDate {
    public static void main(String[] args) {
        Date next = null;
        try{
            String  cronExpr = "0 30 23 * * ?";
            System.out.println("自动计费表达式为----" + cronExpr);
            CronSequenceGenerator generator = new CronSequenceGenerator(cronExpr);
            next = generator.next(new Date());
        }catch (Exception e){
            System.out.println("获取自动计费定时任务下一次时间异常----" +e.getMessage());
            e.printStackTrace();
        }

        System.out.println("输出下次执行的任务的时间---" + next);
    }
}
