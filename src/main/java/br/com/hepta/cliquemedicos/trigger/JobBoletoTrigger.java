package br.com.hepta.cliquemedicos.trigger;

import org.quartz.Trigger;

/**
 * ----------------------------------------------------------
 * Classe que define a instanciação e configuração do serviço
 * de agendamento do boleto
 * ----------------------------------------------------------
 * @author bruno.carneiro
 */
public interface JobBoletoTrigger {

    Trigger trigger() throws Exception;

}
