package com.ubs.opsit.interviews.clock.lamp;

public class RectangularLamp{
	private final Color lampColor;
	private Switch lampSwitch;

	public RectangularLamp(Color color) {
		this.lampColor = color;
		this.lampSwitch=Switch.OFF;
	}

	public Switch getLampSwitch() {
		return lampSwitch;
	}

	public void setLampSwitch(Switch lampSwitch) {
		this.lampSwitch = lampSwitch;
	}

	public Color getLampColor() {
		return lampColor;
	}

	
}
