package ru.madhouse;

public class Neuron {
	
	protected byte[] signalWeights;
	//protected int[] signalSources;
	protected short[] signalHistory;

	public Neuron() {
		System.out.println("Neuron object is init");
	}

	public void setSignal(int sourceId, byte signalStrage) {

	}
	
	public byte execute() {
		return (byte) 0xff;
	}
}