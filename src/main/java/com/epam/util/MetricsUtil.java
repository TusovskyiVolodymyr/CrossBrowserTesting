package com.epam.util;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

import java.util.concurrent.TimeUnit;

public class MetricsUtil {

     private final MetricRegistry metrics = new MetricRegistry();

    private Timer timer = metrics.timer("Locators-speed-test");

    private Timer.Context context;

    public synchronized void startTimer(){
         context = timer.time();
    }

    public synchronized void stopTimer(){
        context.stop();
    }

    public synchronized void reportMetrics(){
        ConsoleReporter reporter = ConsoleReporter
                .forRegistry(metrics)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(10, TimeUnit.SECONDS);
        reporter.report();
    }
}
