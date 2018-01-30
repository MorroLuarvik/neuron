package ru.madhouse;

import java.util.Random;

public class Synaps {
	protected int sourceId;
	protected byte weight; // signed byte
	protected short history;

	private byte signal;
	protected Synaps next;

	final static byte forgetingSpeed = 1;

	public Synaps(int sourceId) {
		Random rnd = new Random();
		weight = (byte) rnd.nextInt(256);

		this.sourceId = sourceId;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setNext(Synaps next) {
		this.next = next;
	}

	public Synaps getNext() {
		return next;
	}

	public void setSignal(byte signal) {
		if ((history + signal) > 0xffff)
			history = (short) 0xffff;
		else
			history = (short) (history + signal);

		this.signal = signal;
	}
	
	public int getSignal() {
		int ret = 0;

		byte shift = weight;
		if ((weight & 0x80) == 0x80) {
			shift = (byte) ((~ weight) + 0); // -128 is too large
		}

		for (int i = 0; i < 7; i++) {
			signal = (byte) ((signal & 0xff) >>> 1);
			shift = (byte) (shift << 1);
			if ((shift & 0x80) == 0x80)
				ret += signal;
		}

		if ((int) forgetingSpeed > (int) history)
			history = 0;
		else
			history -= forgetingSpeed;

		if ((weight & 0x80) == 0x80)
			return -ret;
		else 
			return ret;
	}
}
