import ru.madhouse.Neuron;
import java.util.Random;

public class Main {
	protected static final int MAX_ARRAY_SIZE = 10;
	protected static final int MAX_VAL = 256;

	protected static Neuron[] neuronNetwork = new Neuron[MAX_ARRAY_SIZE];

	public static void main(String[] args)	 {
		System.out.println("Main.main is started");

		//Random rnd = new Random();

		byte[] arr; // = new byte[MAX_ARRAY_SIZE];

		arr[0] = new Object();
		arr[0] = 0x1;


		for (int cou = 0; cou < MAX_ARRAY_SIZE; cou++)
			neuronNetwork[cou] = new Neuron();
			

		/*byte ss1, ss0;

		ss1 = (byte) 0xfa;

		ss0 = (byte) 0xf9;

		if (ss1 > ss0)
			System.out.println(ss1 + " is large than " + ss0);

		System.out.printf("%x is large than %x%n", ss1, ss0);

		for (int cou = 0; cou < arr.length; cou++) {
			String aleft = "";
			if (arr[cou] == (byte) 0xff)
				aleft = "alert!";
			System.out.printf("[%s] : %x %s%n", cou, arr[cou], aleft);
		}*/

	}
}