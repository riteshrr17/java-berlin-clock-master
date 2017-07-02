package com.ubs.opsit.interviews.clock;

import com.ubs.opsit.interviews.clock.lamp.Color;
import com.ubs.opsit.interviews.clock.lamp.RectangularLamp;
import com.ubs.opsit.interviews.clock.lamp.Switch;
public enum BerlinClock implements Clock {
	INSTANCE;

	private ClockRow[] rows = new ClockRow[5];

	private void setSeconds(Integer seconds) {
		if (seconds > 0 && (Math.ceil(seconds / 2)) % 2 == 0 || seconds > 58)
			setRowLamp(1, rows[0], Switch.OFF);
		else
			setRowLamp(1, rows[0], Switch.ON);
	}

	private void setMinutes(Integer minutes) {
		setRowLamp(minutes / 5, rows[3], Switch.ON);
		setRowLamp(minutes % 5, rows[4], Switch.ON);
	}

	private void setHours(Integer hours) {
		setRowLamp(hours / 5, rows[1], Switch.ON);
		setRowLamp(hours % 5, rows[2], Switch.ON);
	}

	private void setRowLamp(int counter, ClockRow clockRow, Switch lampSwitch) {
		for (int i = 0; i < counter && i < clockRow.getLamps().length; i++) {
			clockRow.getLamps()[i].setLampSwitch(lampSwitch);
		}

	}

	public String readTime() {
		StringBuilder result = new StringBuilder();
		for (ClockRow row : rows) {
			for (RectangularLamp lamp : row.getLamps()) {
				if (lamp.getLampSwitch().equals(Switch.ON))
					result.append(lamp.getLampColor());
				else
					result.append(BerlenClockConstant.NULL);
			}
			result.append(BerlenClockConstant.NEXT_LINE);
		}
		if (result.length() > 0)
			result.delete(result.lastIndexOf(BerlenClockConstant.NEXT_LINE), result.length() + 1);
		return result.toString();
	}

	public void reset() {
		defaultTime();
	}

	private void defaultTime() {
		RectangularLamp secLight = new RectangularLamp(Color.Y);
		rows[0] = new ClockRow(secLight);
		RectangularLamp[] rectangularLightRow1 = new RectangularLamp[4];
		rectangularLightRow1[0] = new RectangularLamp(Color.R);
		rectangularLightRow1[1] = new RectangularLamp(Color.R);
		rectangularLightRow1[2] = new RectangularLamp(Color.R);
		rectangularLightRow1[3] = new RectangularLamp(Color.R);
		rows[1] = new ClockRow(rectangularLightRow1);
		RectangularLamp[] rectangularLightRow2 = new RectangularLamp[4];
		rectangularLightRow2[0] = new RectangularLamp(Color.R);
		rectangularLightRow2[1] = new RectangularLamp(Color.R);
		rectangularLightRow2[2] = new RectangularLamp(Color.R);
		rectangularLightRow2[3] = new RectangularLamp(Color.R);
		rows[2] = new ClockRow(rectangularLightRow2);
		RectangularLamp[] rectangularLightRow3 = new RectangularLamp[11];
		rectangularLightRow3[0] = new RectangularLamp(Color.Y);
		rectangularLightRow3[1] = new RectangularLamp(Color.Y);
		rectangularLightRow3[2] = new RectangularLamp(Color.R);
		rectangularLightRow3[3] = new RectangularLamp(Color.Y);
		rectangularLightRow3[4] = new RectangularLamp(Color.Y);
		rectangularLightRow3[5] = new RectangularLamp(Color.R);
		rectangularLightRow3[6] = new RectangularLamp(Color.Y);
		rectangularLightRow3[7] = new RectangularLamp(Color.Y);
		rectangularLightRow3[8] = new RectangularLamp(Color.R);
		rectangularLightRow3[9] = new RectangularLamp(Color.Y);
		rectangularLightRow3[10] = new RectangularLamp(Color.Y);
		rows[3] = new ClockRow(rectangularLightRow3);
		RectangularLamp[] rectangularLightRow4 = new RectangularLamp[4];
		rectangularLightRow4[0] = new RectangularLamp(Color.Y);
		rectangularLightRow4[1] = new RectangularLamp(Color.Y);
		rectangularLightRow4[2] = new RectangularLamp(Color.Y);
		rectangularLightRow4[3] = new RectangularLamp(Color.Y);
		rows[4] = new ClockRow(rectangularLightRow4);
	}

	public boolean setTime(String aTime) {
		String[] timeToken = aTime.split(BerlenClockConstant.TIME_SEPERATOR);
		setHours(Integer.parseInt(timeToken[0]));
		setMinutes(Integer.parseInt(timeToken[1]));
		setSeconds(Integer.parseInt(timeToken[2]));
		return true;
	}

}
