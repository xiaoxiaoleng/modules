/*******************************************************************************
 * Copyright (c) 2005, 2014
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.iac.module.metrics;

import static org.assertj.core.api.Assertions.*;

import org.iac.module.metrics.utils.Clock;
import org.junit.Test;

public class ExecutionTest {

	@Test
	public void normal() {
		Clock.MockClock clock = new Clock.MockClock();
		Timer.clock = clock;
		Counter.clock = clock;
		Timer timer = new Timer(new Double[] { 90d });

		Timer.TimerContext timerContext = timer.start();
		clock.increaseTime(200);
		timerContext.stop();

		Timer.TimerContext timer2 = timer.start();
		clock.increaseTime(300);
		timer2.stop();

		TimerMetric metric = timer.calculateMetric();

		assertThat(metric.counterMetric.totalCount).isEqualTo(2);
		assertThat(metric.counterMetric.meanRate).isEqualTo(4);
		assertThat(metric.counterMetric.lastCount).isEqualTo(2);
		assertThat(metric.counterMetric.lastRate).isEqualTo(4);

		assertThat(metric.histogramMetric.min).isEqualTo(200);
		assertThat(metric.histogramMetric.mean).isEqualTo(250);
		assertThat(metric.histogramMetric.pcts.get(90d)).isEqualTo(300);
	}
}
