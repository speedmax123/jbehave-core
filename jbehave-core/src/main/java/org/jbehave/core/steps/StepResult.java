package org.jbehave.core.steps;

import org.jbehave.core.failures.UUIDExceptionWrapper;
import org.jbehave.core.reporters.StoryReporter;

import java.util.List;

public interface StepResult {

    enum Type {
        FAILED,
        NOT_PERFORMED,
        PENDING,
        SUCCESSFUL,
        SILENT,
        IGNORABLE,
        COMMENT,
        SKIPPED
    }

    String parametrisedStep();

    StepResult withParameterValues(String parametrisedStep);

    StepResult setTimings(Timer timer);

    StepResult setMessages(List<String> messages);

    void describeTo(StoryReporter reporter);

    UUIDExceptionWrapper getFailure();
}
