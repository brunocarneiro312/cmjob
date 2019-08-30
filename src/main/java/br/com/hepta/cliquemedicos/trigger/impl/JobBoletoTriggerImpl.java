package br.com.hepta.cliquemedicos.trigger.impl;

import br.com.hepta.cliquemedicos.trigger.JobBoletoTrigger;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

public class JobBoletoTriggerImpl implements JobBoletoTrigger {

    @Override
    public Trigger trigger() throws Exception {
        Trigger triggerJobBoleto = TriggerBuilder
                .newTrigger()
                .withIdentity("jobBoletoTrigger", "grupo1")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(5)
                                .repeatForever())
                .build();
        return triggerJobBoleto;
    }
}
