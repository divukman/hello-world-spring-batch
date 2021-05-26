package tech.dimitar.hello.sspringbatch.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloWorldJobExecutionListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("Before executing the job: " + jobExecution.getJobInstance().getJobName());
        log.info("Before executing the job, context: " + jobExecution.getExecutionContext().toString());

        jobExecution.getExecutionContext().put("name", "john");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("After executing the job: " + jobExecution.getJobInstance().getJobName());
        log.info("After executing the job, context: " + jobExecution.getExecutionContext().toString());
    }
}
