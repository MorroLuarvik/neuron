package ru.madhouse;

public class Neuron {
	private static int counterId;
	protected int id;
	
	protected byte[] signalWeights;
	//protected int[] signalSources;
	protected short[] signalHistory;

	public Neuron() {
		id = counterId++;
		System.out.println("Neuron object is init " + id);
	}



	public void setSignal(int sourceId, byte signalStrage) {

	}
	
	public byte execute() {
		return (byte) 0xff;
	}
}