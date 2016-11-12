package org.iac.module.metrics.reporter;

import java.util.Map;

import org.iac.module.metrics.Counter;
import org.iac.module.metrics.Histogram;
import org.iac.module.metrics.Timer;

/**
 * Reporter的公共接口，被ReportScheduler定时调用。
 * 
 * @author
 * 
 */
public interface Reporter {
	void report(Map<String, Counter> counters, Map<String, Histogram> histograms, Map<String, Timer> timers);
}
