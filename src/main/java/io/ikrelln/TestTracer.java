package io.ikrelln;

import io.ikrelln.tag.Tags;
import io.opentracing.Span;
import io.opentracing.Tracer;

/**
 * TestTracer is a thin wrapper for Span creation that adds tags expected by i'Krelln to match test information.
 */
public final class TestTracer {

    /**
     * Return a new SpanBuilder for a Span from the given `tracer` with the given `testSuite`, `testClass`, `testName`
     * and `environment`.
     *
     * <p>You can override the testName later via {@link Span#setOperationName(String)}.
     *
     * @param tracer the general tracer used
     * @param testSuite the current test suite or null
     * @param testClass the current test class or null
     * @param testName the current test name or null
     * @param environment the current environment or null
     *
     * @return a spanBuilder with tags set up for test recognition by i'Krelln
     *
     */
    public static Tracer.SpanBuilder buildTestSpan(Tracer tracer, String testSuite, String testClass, String testName, String environment) {
        Tracer.SpanBuilder spanBuilder = tracer.buildSpan(String.format("%s - %s", testClass, testName))
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
