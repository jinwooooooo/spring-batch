package io.springbatch.springbatch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@RequiredArgsConstructor
@Configuration
public class JobInstanceConfiguration {

    @Bean
    public Job jobByJobInstanceConfiguration(JobRepository jobRepository, Step step1ByJobInstanceConfiguration, Step step2ByJobInstanceConfiguration) {
        return new JobBuilder("jobByJobInstanceConfiguration", jobRepository)
                .start(step1ByJobInstanceConfiguration)
                .next(step2ByJobInstanceConfiguration)
                .build();
    }

    @Bean
    public Step step1ByJobInstanceConfiguration(JobRepository jobRepository, PlatformTransactionManager tx) {
        return new StepBuilder( "step1ByJobInstanceConfiguration", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    System.out.println(" step1 executed JobInstance");
                    return RepeatStatus.FINISHED;
                }, tx).build();
    }

    @Bean
    public Step step2ByJobInstanceConfiguration(JobRepository jobRepository, PlatformTransactionManager tx) {
        return new StepBuilder( "step2ByJobInstanceConfiguration", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    System.out.println(" step2 executed JobInstance");
                    return RepeatStatus.FINISHED;
                }, tx).build();
    }
}
