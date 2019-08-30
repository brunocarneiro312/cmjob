package br.com.hepta.cliquemedicos.job.impl;

import br.com.hepta.cliquemedicos.job.JobBoletoService;
import org.apache.log4j.Logger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobBoletoServiceImpl implements JobBoletoService {

    Logger logger = Logger.getLogger(JobBoletoServiceImpl.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            logger.debug("Executando Job do boleto.");
        }
        catch (Exception e) {
            logger.error("Não foi possível executar o Job de boleto.");
            throw new JobExecutionException(e);
        }
    }

    @Override
    public JobDetail getJobBoletoDetail() throws Exception {
        try {
            return JobBuilder.newJob(JobBoletoServiceImpl.class)
                    .withIdentity("jobBoleto", "grupo1")
                    .build();
        }
        catch (Exception e) {
            logger.error("Não foi possível obter o JobDetail do boleto.");
            throw new Exception(e);
        }
    }
}
