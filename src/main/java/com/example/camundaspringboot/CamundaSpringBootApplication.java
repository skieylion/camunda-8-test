package com.example.camundaspringboot;

import io.camunda.zeebe.spring.client.EnableZeebeClient;
import io.camunda.zeebe.spring.client.annotation.ZeebeDeployment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableZeebeClient
@ZeebeDeployment(resources = {"classpath:example.bpmn", "classpath:permits.dmn"})
public class CamundaSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(CamundaSpringBootApplication.class, args).getBean(Runner.class).run();
    }

}
