package ru.madhouse;

import ru.madhouse.ByteOps;
import java.util.Random;

public class Synaps {
	protected static final int MAX_VAL = 255; // 256 eq -128, but weight must be from -127 to 127, bec - 255
	protected int sourceId;
	protected byte weight; // signed byte
	protected short history; // unsigned world

	private byte signal;	// unsigned byte
	protected Synaps next;	// link 2 next synaps

	final static byte forgettingRate = 1;

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
		history = ByteOps.addUnSigned(history, signal);

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

		history = ByteOps.subUnSigned(history, forgettingRate);

		if ((weight & 0x80) == 0x80)
			return -ret;
		else 
			return ret;
	}
}
