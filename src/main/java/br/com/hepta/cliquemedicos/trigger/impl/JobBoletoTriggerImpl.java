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

    // Nome da propriedade que define intervalo de execução do Job
    private final String INTERVAL_PROPERTY = "jobBoleto.seconds";

    // Variável que armazena o intervalo de execução
    private int interval;

    /**
     * Lendo o arquivo properties e setando o intervalo de execução do job
     */
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
    public Trigger trigger() {
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
