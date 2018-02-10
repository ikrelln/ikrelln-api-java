package io.ikrelln;

import io.ikrelln.tag.Tags;
import io.opentracing.Tracer;

public final class TestTracer {

    public static Tracer.SpanBuilder buildTestSpan(Tracer tracer, String testSuite, String testClass, String testName, String environment) {
        Tracer.SpanBuilder spanBuilder = tracer.buildSpan(String.format("{} - {}", testClass, testName))
                .withTag(io.opentracing.tag.Tags.SPAN_KIND.getKey(), "test");
        if (testName != null)
            spanBuilder.withTag(Tags.TEST_NAME.getKey(), testName);
        if (environment != null)
            spanBuilder.withTag(Tags.TEST_ENVIRONMENT.getKey(), environment);
        if (testSuite != null)
                spanBuilder.withTag(Tags.TEST_SUITE.getKey(), testSuite);
        if (testClass != null)
            spanBuilder.withTag(Tags.TEST_CLASS.getKey(), testClass);
        return spanBuilder;
    }

}
