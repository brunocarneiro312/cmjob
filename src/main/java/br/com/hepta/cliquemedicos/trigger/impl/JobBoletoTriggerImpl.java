package br.com.hepta.cliquemedicos.trigger.impl;

import br.com.hepta.cliquemedicos.trigger.JobBoletoTrigger;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class JobBoletoTriggerImpl implements JobBoletoTrigger {



    Properties properties = null;

    public JobBoletoTriggerImpl() {

    }

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
