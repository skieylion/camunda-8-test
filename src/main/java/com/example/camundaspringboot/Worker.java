package com.example.camundaspringboot;

import io.camunda.zeebe.spring.client.annotation.ZeebeVariable;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@Component
public class Worker {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @ZeebeWorker(type = "getFullYearsOld", autoComplete = true)
    public Map<String, Object> getFullYearsOld(@ZeebeVariable String birthday) {
        LocalDate birthDate = LocalDate.parse(birthday, DATE_FORMAT);
        long years = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
        return Map.of("fullYearsOld", years);
    }

    @ZeebeWorker(type = "getScore", autoComplete = true)
    public Map<String, Object> getScore(
            @ZeebeVariable String education,
            @ZeebeVariable String areChildren,
            @ZeebeVariable String familyStatus
    ) {
        float score = 0.0f;
        if ("high".equals(education)) {
            score += 1.0f;
        } else if ("middle".equals(education)) {
            score += 0.5f;
        }
        if ("no".equals(areChildren)) {
            score += 1.0f;
        } else {
            score += 0.5f;
        }
        if ("single".equals(familyStatus)) {
            score += 1.0f;
        } else {
            score += 0.5f;
        }
        return Map.of("score", score);
    }
}
