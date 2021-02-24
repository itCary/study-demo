package online.goudan.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author chenglongliu
 * @date 2020/12/14 15:01
 * @desc TaskDemo
 */
@Component
@Slf4j
public class TaskDemo {


    private int count = 0;

    @Scheduled(fixedDelay = 5 * 1000L)
    public void runTask() throws Exception {
        log.debug("runTask: " + count++);
        log.info("runTask: " + log.getClass());
        log.error("runTask: " + "这是 error");
        log.warn("runTask: 这是 warn");
    }

}
