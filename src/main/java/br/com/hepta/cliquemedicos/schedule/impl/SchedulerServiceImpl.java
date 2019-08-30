package br.com.hepta.cliquemedicos.schedule.impl;

import br.com.hepta.cliquemedicos.schedule.SchedulerService;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulerServiceImpl implements SchedulerService {

    @Override
    public void iniciarAgendamento(JobDetail jobDetail, Trigger trigger) throws SchedulerException {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
