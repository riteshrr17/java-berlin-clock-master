package com.ubs.opsit.interviews.clock;

public interface Clock {
	public String readTime();
	public boolean setTime(String aTime);
	public void reset();
	
}
