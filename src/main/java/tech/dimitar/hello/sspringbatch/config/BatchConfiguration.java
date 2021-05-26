package tech.dimitar.hello.sspringbatch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.dimitar.hello.sspringbatch.listener.HelloWorldJobExecutionListener;
import tech.dimitar.hello.sspringbatch.listener.HelloWorldStepExecutionListener;
import tech.dimitar.hello.sspringbatch.processor.InMemoryItemProcessor;
import tech.dimitar.hello.sspringbatch.reader.InMemoryReader;
import tech.dimitar.hello.sspringbatch.writer.ConsoleItemWriter;

@EnableBatchProcessing
@Configuration
@RequiredArgsConstructor
public class BatchConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final HelloWorldJobExecutionListener helloWorldJobExecutionListener;
    private final HelloWorldStepExecutionListener helloWorldStepExecutionListener;


    public Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println("Hello World Step....");
                    return RepeatStatus.FINISHED;
                })
                .listener(helloWorldStepExecutionListener)
                .build();
    }


    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2")
                .<Integer, Integer>chunk(3)
                .reader(new InMemoryReader())
                .processor(new InMemoryItemProcessor())
                .writer(new ConsoleItemWriter())
                .build();
    }

    @Bean
    public Job helloWorldJob() {
        return jobBuilderFactory.get("helloWorldJob")
                .start(step1())
                .listener(helloWorldJobExecutionListener)
                .next(step2())
                .build();
    }

}
