import ru.madhouse.Neuron;
import ru.madhouse.Synaps;
import ru.madhouse.ByteOps;

import java.util.Random;

public class Main {
	protected static final int MAX_ARRAY_SIZE = 10;
	protected static final int MAX_VAL = 256;

	protected static Neuron[] neuronNetwork = new Neuron[MAX_ARRAY_SIZE];

	public static void main(String[] args)	 {
		System.out.println("Main.main is started");

		byte s1, res;
		byte s2;

		s1 = (byte) 0xa0;
		s2 = (byte) 0x6;

		res = ByteOps.subUnSigned(s1, s2);

		System.out.printf("%x - %x = %x%n", s1, s2, res);

		/*System.out.printf("s1: %d s2: %x%n", (s1 & 0xff), s2);

		if ((s1 & 0xff) > (s2 & 0xff))
			System.out.printf("%x is largest than %x%n", s1, s2);
		else
			System.out.printf("%x is smalest than %x%n", s1, s2);*/


		//Random rnd = new Random();

		//byte[] arr; // = new byte[MAX_ARRAY_SIZE];

		//arr[0] = new Object();
		//arr[0] = 0x1;


		for (int cou = 0; cou < MAX_ARRAY_SIZE; cou++) {
			neuronNetwork[cou] = new Neuron(MAX_ARRAY_SIZE);
			neuronNetwork[cou].print();
		}
		

		neuronNetwork[0].setSignal(0, (byte) 0x10);
		neuronNetwork[0].setSignal(1, (byte) 0x7e);
		neuronNetwork[0].setSignal(2, (byte) 0xff);

		neuronNetwork[0].print();

		neuronNetwork[1].setSignal(1, (byte) 0xe0);

		neuronNetwork[1].print();
	}
}