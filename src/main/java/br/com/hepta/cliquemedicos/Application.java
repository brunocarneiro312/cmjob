package br.com.hepta.cliquemedicos;

import br.com.hepta.cliquemedicos.job.JobBoletoService;
import br.com.hepta.cliquemedicos.job.impl.JobBoletoServiceImpl;
import br.com.hepta.cliquemedicos.schedule.SchedulerService;
import br.com.hepta.cliquemedicos.schedule.impl.SchedulerServiceImpl;
import br.com.hepta.cliquemedicos.trigger.JobBoletoTrigger;
import br.com.hepta.cliquemedicos.trigger.impl.JobBoletoTriggerImpl;
import org.apache.log4j.Logger;
import org.quartz.SchedulerException;

public class Application {

    static Logger logger = Logger.getLogger(Application.class);

    private static SchedulerService schedulerService = new SchedulerServiceImpl();
    private static JobBoletoTrigger jobBoletoTrigger = new JobBoletoTriggerImpl();
    private static JobBoletoService jobBoletoService = new JobBoletoServiceImpl();

    public static void main(String[] args) throws SchedulerException {
        try {
            // Inicia serviço agendado do boleto
            Application.schedulerService.iniciarAgendamento(
                    Application.jobBoletoService.getJobBoletoDetail(),
                    Application.jobBoletoTrigger.trigger());
        }
        catch (Exception e) {
            logger.error("Erro durante a execução do job.");
            throw new SchedulerException(e);
        }
    }

}
