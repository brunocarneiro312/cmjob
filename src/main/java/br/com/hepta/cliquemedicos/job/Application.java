package br.com.hepta.cliquemedicos.job;

import org.apache.log4j.Logger;

public class Application {

    final static Logger logger = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        System.out.println("Application");
        logger.debug("Application");
        logger.info("Application");
        logger.warn("Application");
        logger.error("Application");
        logger.fatal("Application");
    }

}
