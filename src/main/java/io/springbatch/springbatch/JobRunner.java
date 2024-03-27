package io.springbatch.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class JobRunner implements ApplicationRunner {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job jobByJobInstanceConfiguration;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        jobLauncher.run(jobByJobInstanceConfiguration,
                new JobParametersBuilder().addString("name","user3").toJobParameters());
    }

}
