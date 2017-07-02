package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.clock.BerlinClock;
import com.ubs.opsit.interviews.clock.Clock;

public class BerlenClockTimeConverter implements TimeConverter{
	Clock clock=BerlinClock.INSTANCE;
	public String convertTime(String aTime) {
		String result = null;
		clock.reset();
		if (aTime != null && aTime.length() > 0) {
			clock.setTime(aTime);
			result=clock.readTime();
		}
		return result;
	}
}
