package ru.madhouse;

import java.util.Random;

public class Synaps {
	protected static final int MAX_VAL = 255;
	protected int sourceId;
	protected byte weight; // signed byte
	protected short history; // unsigned world

	private byte signal;	// unsigned byte
	protected Synaps next;	// link 2 next synaps

	final static byte forgetingSpeed = 1;

	public Synaps(int sourceId) {
		Random rnd = new Random();
		weight = (byte) rnd.nextInt(MAX_VAL);

		this.sourceId = sourceId;
	}

	public void print() {
		System.out.printf("Synaps: sourceId: %d, weight: %d, history: %x%n", sourceId, weight, history);
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
		if (((history & 0xffff) + (signal & 0xff)) > 0xffff)
			history = (short) 0xffff;
		else {
			history = (short) ((history & 0xffff) + (signal & 0xff));
		}

		this.signal = signal;
	}
	
	public int getSignal() {
		int ret = 0;

		byte shift = weight;
		if ((weight & 0x80) == 0x80) {
			if (weight == (byte) 0x80)
				shift = 0x7f;
			else
				shift = (byte) ((~ weight) + 1);
		}

		for (int i = 0; i < 7; i++) {
			signal = (byte) ((signal & 0xff) >>> 1);
			shift = (byte) (shift << 1);
			if ((shift & 0x80) == 0x80)
				ret += signal;
		}

		if ((int) (forgetingSpeed & 0xff) > (int) (history & 0xffff))
			history = 0;
		else
			history -= forgetingSpeed;

		if ((weight & 0x80) == 0x80)
			return -ret;
		else 
			return ret;
	}
}
