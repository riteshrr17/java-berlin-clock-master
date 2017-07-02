package com.ubs.opsit.interviews.clock;

import com.ubs.opsit.interviews.clock.lamp.RectangularLamp;


public class ClockRow {
	final private RectangularLamp[] lamps;
	
	public ClockRow(RectangularLamp[] lamps) {
		super();
		this.lamps = lamps;
	}
	
	public ClockRow(RectangularLamp lamp) {
		super();
		this.lamps = new RectangularLamp[]{lamp};
	}

	public RectangularLamp[] getLamps() {
		return lamps;
	}
	
}
