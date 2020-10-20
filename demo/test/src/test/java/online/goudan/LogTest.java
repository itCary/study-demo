package online.goudan;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.slf4j.LoggerFactory;

/**
 * @author chenglongliu
 * @date 2020/10/19 17:05
 * @desc log
 */
public class LogTest {


    /**
     * log4j
     */
    @Test
    public void test01() {
        Logger logger = Logger.getLogger(LogTest.class.getName());

        BasicConfigurator.configure();
        logger.info("test01: ");
    }

    /**
     * slf4j
     */
    @Test
    public void test02() {
        org.slf4j.Logger logger = LoggerFactory.getLogger(LogTest.class);

        logger.debug("test02: ");
    }

    /**
     * util.logger
     */
    @Test
    public void test03() {
        java.util.logging.Logger logger = java.util.logging.Logger.getGlobal();
        logger.info("test03: ");
//        logger.severe("test03: severe");
    }
}
