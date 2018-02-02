package ru.madhouse;

import ru.madhouse.ByteOps;
import java.util.Random;

public class Neuron {
	protected static final int MAX_AKSON_COUNT = 10;
	private static int counterId;
	
	protected int id;
	protected Synaps synapses;
	protected int[] aksons;
	protected short value; // value of current neuron

	final static byte forgettingRate = 4;

	public Neuron(int maxAksonId) {
		id = counterId++;

		aksons = new int[MAX_AKSON_COUNT];
		Random rnd = new Random();
		for (int cou = 0; cou < MAX_AKSON_COUNT; cou++)
			aksons[cou] = rnd.nextInt(maxAksonId);
	}
	
	public void print() {
		System.out.println("Neuron #" + id);

		System.out.print("Aksons:");
		for (int cou = 0; cou < MAX_AKSON_COUNT; cou++)
			System.out.print(" " + aksons[cou]);
		System.out.println();
		
		if (synapses != null)
			System.out.println("Synapses:");
		Synaps next = synapses;
		while (next != null) {
			next.print();
			next = next.getNext();
		}

		System.out.println();
	} 
	
	public void setSignal(int sourceId, byte signalStrength) {
		getSynaps(sourceId).setSignal((byte) signalStrength);
	}

	public int getId() {
		return id;
	}
	
	public void execute() {
		return;
	}

	public byte getSignal() {
		return (byte) 0xff;
	}

	protected Synaps getSynaps(int sourceId) {
		if (synapses == null) {
			synapses = new Synaps(sourceId);
			return synapses;
		}

		Synaps next = synapses;
		
		while (next != null) {
			if (next.getSourceId() == sourceId)
				return next;

			next = next.getNext();
		}

		getLastSynaps().setNext(new Synaps(sourceId));

		return getLastSynaps();
	}

	protected Synaps getLastSynaps() {
		Synaps next = synapses;

		while (next != null) {
			if (next.getNext() == null)
				return next;

			next = next.getNext();
		}

		return next;
	}

}