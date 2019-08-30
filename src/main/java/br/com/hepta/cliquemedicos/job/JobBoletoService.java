package br.com.hepta.cliquemedicos.job;

import org.quartz.Job;
import org.quartz.JobDetail;

/**
 * ----------------------------------------------
 * Job responsável pelo processamento dos boletos
 * ----------------------------------------------
 * @author bruno.carneiro
 */
public interface JobBoletoService extends Job {

    /**
     * ----------------------------------
     * Obtém o JobDetail do job de boleto
     * ----------------------------------
     */
    JobDetail getJobBoletoDetail() throws Exception;
}
