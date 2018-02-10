package io.ikrelln.tag;

import io.opentracing.tag.StringTag;

public class Tags {
    /**
     * TEST_SUITE is the name of the test suite. If not present, the local endpoint service name will be used.
     */
    public static final StringTag TEST_SUITE = new StringTag("test.suite");

    /**
     * TEST_CLASS is the name of the test class.
     */
    public static final StringTag TEST_CLASS = new StringTag("test.class");

    /**
     * TEST_NAME is the name of the test.
     */
    public static final StringTag TEST_NAME = new StringTag("test.name");

    /**
     * TEST_RESULT is the result of the test. If not present, test result will be computed from the ERROR tag.
     */
    public static final StringTag TEST_RESULT = new StringTag("test.result");

    /**
     * TEST_ENVIRONMENT is the name of the test environment (QA, STAGING, PROD, ...).
     */
    public static final StringTag TEST_ENVIRONMENT = new StringTag("test.environment");


    /**
     * TEST_STEP_TYPE is the kind of step of the span in a test trace (assertion, setup, ...).
     */
    public static final StringTag TEST_STEP_TYPE = new StringTag("test.step_type");

    /**
     * TEST_STEP_PARAMETERS is extra information on the step, it's value depends on the step type.
     */
    public static final JSONObjectTag TEST_STEP_PARAMETERS = new JSONObjectTag("test.step_parameters");

    /**
     * TEST_STEP_STATUS is the result of the step, it's value depends on the step type.
     */
    public static final JSONObjectTag TEST_STEP_STATUS = new JSONObjectTag("test.step_status");

}
