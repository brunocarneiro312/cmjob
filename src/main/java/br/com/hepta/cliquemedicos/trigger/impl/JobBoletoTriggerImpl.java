package br.com.hepta.cliquemedicos.trigger.impl;

import br.com.hepta.cliquemedicos.trigger.JobBoletoTrigger;
import org.apache.log4j.Logger;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import java.io.IOException;
import java.util.Properties;

public class JobBoletoTriggerImpl implements JobBoletoTrigger {

    static Logger logger = Logger.getLogger(JobBoletoTriggerImpl.class);

    Properties properties = null;

    private final String INTERVAL_PROPERTY = "jobBoleto.seconds";

    private int interval;

    public JobBoletoTriggerImpl() {
        this.properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            this.setInterval(Integer.parseInt(properties.getProperty(INTERVAL_PROPERTY)));
        }
        catch (IOException e) {
            logger.error("Erro ao ler arquivo de propriedades");
        }
    }

    @Override
    public Trigger trigger() throws Exception {
        try {
            return TriggerBuilder
                    .newTrigger()
                    .withIdentity("jobBoletoTrigger", "grupo1")
                    .withSchedule(
                            SimpleScheduleBuilder.simpleSchedule()
                                    .withIntervalInSeconds(this.getInterval())
                                    .repeatForever())
                    .build();
        }
        catch (Exception e) {
            logger.error("Não foi possível obter a Trigger para o Job de boleto");
            e.printStackTrace();
        }
        return null;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }
}
