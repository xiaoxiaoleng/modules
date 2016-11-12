package org.iac.module.metrics.exporter;

import org.iac.module.metrics.Histogram;
import org.iac.module.metrics.Timer;
import org.iac.module.metrics.Counter;

public interface MetricRegistryListener {

	void onCounterAdded(String name, Counter counter);

	void onHistogramAdded(String name, Histogram histogram);

	void onTimerAdded(String name, Timer timer);
}
