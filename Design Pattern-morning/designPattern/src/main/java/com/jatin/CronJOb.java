package com.jatin;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class CronJOb {
    public static void main(String args[])
    {
        try
        {
            JobDetail job1 = JobBuilder.newJob(NotificationJob.class)
                    .withIdentity("job1", "group1").build();

            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger1", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0 12 15 1/1 ? *"))
                    .build();

            Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
            scheduler1.start();
            scheduler1.scheduleJob(job1, trigger1);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
