package br.com.hepta.cliquemedicos.schedule;

import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;

public interface SchedulerService {

    /**
     * ----------------------------
     * Inicia agendamento de um job
     * ----------------------------
     * @param
     *      jobDetail: Job a ser executado
     *      trigger: configurações de gatilho do job
     */
    void iniciarAgendamento(JobDetail jobDetail, Trigger trigger) throws SchedulerException;

}
