package com.free.currency.quartz;

import java.io.IOException;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class CurrencyScheduler {

    public static void triggerCurrencyScheduler() throws IOException, SchedulerException {

        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        JobDetail job = JobBuilder.newJob(CurrencyConversionJob.class)
                .withIdentity("job1", "group1")
                .build();

        // Trigger the job to run on the next round minute
        Trigger trigger = TriggerBuilder.newTrigger().forJob(job)
                .withIdentity("Qrtz_Trigger")
                .withDescription("Sample trigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInHours(1))
                .build();

        sched.scheduleJob(job, trigger);

        sched.start();
    }

}
