package ru.maximenko.votingsystem.service;

import org.junit.AssumptionViolatedException;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class MyStopWatch extends Stopwatch {

    private static final Logger logger = LoggerFactory.getLogger("result");

    private static void logInfo(Description description, String status, long nanos) {
        String result = String.format("Test %s %s, spent %d microseconds%n",
                description.getMethodName(), status, TimeUnit.NANOSECONDS.toMicros(nanos));
        logger.info(result);
    }

    @Override
    protected void succeeded(long nanos, Description description) {
        logInfo(description, "succeeded", nanos);
    }

    @Override
    protected void failed(long nanos, Throwable e, Description description) {
        logInfo(description, "failed", nanos);
    }

    @Override
    protected void skipped(long nanos, AssumptionViolatedException e, Description description) {
        logInfo(description, "skipped", nanos);
    }

}
