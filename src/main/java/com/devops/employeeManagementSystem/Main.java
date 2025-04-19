package com.devops.employeeManagementSystem;

import com.codahale.metrics.*;
import com.codahale.metrics.graphite.*;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final MetricRegistry metrics = new MetricRegistry();
    private static final Counter requestCounter = metrics.counter("requests");

    public static void main(String[] args) {
        // Setup Graphite Reporter
        final Graphite graphite = new Graphite(new InetSocketAddress("graphite", 2003));
        final GraphiteReporter reporter = GraphiteReporter.forRegistry(metrics)
                .prefixedWith("employeeApp")
                .build(graphite);
        reporter.start(10, TimeUnit.SECONDS);

        // Simulating Employee creation and counting
        Employee emp1 = new Employee("Devansh Kumar Gupta 22BCE10417", "Developer");
        Employee emp2 = new Employee("Ainesh Sridhar 22BCE11157", "Tester");
        Employee emp3 = new Employee("Tejas Dev Lakhanpal 22BCE11157", "Cleaner");

        emp1.printDetails();
        requestCounter.inc();

        emp2.printDetails();
        requestCounter.inc();
        
        emp3.printDetails();
        requestCounter.inc();

        // Keep the app alive to push metrics
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
