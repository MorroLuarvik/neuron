package ru.madhouse;

public class Neuron {
	private static int counterId;
	protected int id;
	protected Synaps synapses;

	public Neuron() {
		id = counterId++;
	}
	
	public void print() {
		System.out.println("Neuron #" + id);
		
		if (synapses != null)
			System.out.println("Synapses:");
		Synaps next = synapses;
		while (next != null) {
			next.print();
			next = next.getNext();
		}		
	} 
	

	public void setSignal(int sourceId, byte signalStrength) {
		Synaps curSynaps;

		if (hasSynaps(sourceId)) {
			curSynaps = getSynaps(sourceId);
			curSynaps.setSignal((byte) signalStrength);

			return;
		}

		curSynaps = new Synaps(sourceId);
		curSynaps.setSignal((byte) signalStrength);

		if (synapses == null) {
			synapses = curSynaps;

			return;
		}
		
		getLastSynaps().setNext(curSynaps);
	}

	public int getId() {
		return id;
	}

	protected boolean hasSynaps(int sourceId) {
		Synaps next = synapses;
		
		while (next != null) {
			if (next.getSourceId() == sourceId)
				return true;

			next = next.getNext();
		}

		return false;
	}

	protected Synaps getSynaps(int sourceId) {
		Synaps next = synapses;
		
		while (next != null) {
			if (next.getSourceId() == sourceId)
				return next;

			next = next.getNext();
		}

		return next;
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

	public byte execute() {
		return (byte) 0xff;
	}
}