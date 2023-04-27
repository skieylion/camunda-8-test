package com.example.camundaspringboot;

import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Runner {

    private static final String PROCESS_ID = "Process_1fbohh7";

    @Autowired
    private ZeebeClient zeebeClient;

    void run() {
        zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId(PROCESS_ID)
                .latestVersion()
                .send().join();
    }
}
