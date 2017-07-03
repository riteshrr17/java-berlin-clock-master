package com.ubs.opsit.interviews.clock;

import com.ubs.opsit.interviews.clock.lamp.Color;
import com.ubs.opsit.interviews.clock.lamp.RectangularLamp;
import com.ubs.opsit.interviews.clock.lamp.Switch;
public enum BerlinClock implements Clock {
	INSTANCE;

	private ClockRow[] rows = new ClockRow[5];

	private void setSeconds(Integer seconds) {
		if ((seconds & 1) == 0)
			setRowLamp(1, rows[0], Switch.ON);
		else
			setRowLamp(1, rows[0], Switch.OFF);
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
		row0();
		row1();
		row2();
		row3();
		row4();
	}

	private void row4() {
		RectangularLamp[] rectangularLightRow4 = new RectangularLamp[4];
		rectangularLightRow4[0] = new RectangularLamp(Color.Y);
		rectangularLightRow4[1] = new RectangularLamp(Color.Y);
		rectangularLightRow4[2] = new RectangularLamp(Color.Y);
		rectangularLightRow4[3] = new RectangularLamp(Color.Y);
		rows[4] = new ClockRow(rectangularLightRow4);
	}

	private void row3() {
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
	}

	private void row2() {
		RectangularLamp[] rectangularLightRow2 = new RectangularLamp[4];
		rectangularLightRow2[0] = new RectangularLamp(Color.R);
		rectangularLightRow2[1] = new RectangularLamp(Color.R);
		rectangularLightRow2[2] = new RectangularLamp(Color.R);
		rectangularLightRow2[3] = new RectangularLamp(Color.R);
		rows[2] = new ClockRow(rectangularLightRow2);
	}

	private void row1() {
		RectangularLamp[] rectangularLightRow1 = new RectangularLamp[4];
		rectangularLightRow1[0] = new RectangularLamp(Color.R);
		rectangularLightRow1[1] = new RectangularLamp(Color.R);
		rectangularLightRow1[2] = new RectangularLamp(Color.R);
		rectangularLightRow1[3] = new RectangularLamp(Color.R);
		rows[1] = new ClockRow(rectangularLightRow1);
	}

	private void row0() {
		RectangularLamp secLight = new RectangularLamp(Color.Y);
		rows[0] = new ClockRow(secLight);
	}

	public boolean setTime(String aTime) {
		String[] timeToken = aTime.split(BerlenClockConstant.TIME_SEPERATOR);
		setHours(Integer.parseInt(timeToken[0]));
		setMinutes(Integer.parseInt(timeToken[1]));
		setSeconds(Integer.parseInt(timeToken[2]));
		return true;
	}

}
