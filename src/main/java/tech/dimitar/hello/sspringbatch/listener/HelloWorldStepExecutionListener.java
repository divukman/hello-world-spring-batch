package tech.dimitar.hello.sspringbatch.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloWorldStepExecutionListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("Before executing the step " + stepExecution.getStepName());
        log.info("Before executing the step, execution context:  " + stepExecution.getExecutionContext());
        log.info("Before executing the step, parent job context:  " + stepExecution.getJobExecution().getExecutionContext());
        log.info("Before executing the step, job params:  " + stepExecution.getJobParameters());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
}
