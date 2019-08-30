package br.com.hepta.cliquemedicos.job.impl;

import br.com.hepta.cliquemedicos.job.JobPagSeguroService;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobPagSeguroServiceImpl implements JobPagSeguroService {

    Logger logger = Logger.getLogger(JobBoletoServiceImpl.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("Executando Job do PagSeguro");
    }

}
