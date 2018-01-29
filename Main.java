import ru.madhouse.Neuron;
import java.util.Random;

public class Main {
	protected static final int MAX_ARRAY_SIZE = 10;
	protected static final int MAX_VAL = 256;

	protected Neuron[] neurons = new Neuron[MAX_ARRAY_SIZE];

	public static void main(String[] args)	 {
		System.out.println("Main.main is started");

		Random rnd = new Random();

		byte[] arr = new byte[MAX_ARRAY_SIZE];

		System.out.println(arr.length);
		for (int cou = 0; cou < arr.length; cou++)
			arr[cou] = (byte) rnd.nextInt(MAX_VAL);
			

		byte ss1, ss0;

		ss1 = (byte) 0xfa;

		ss0 = (byte) 0xf9;

		if (ss1 > ss0)
			System.out.println(ss1 + " is large than " + ss0);

		//ss0 += (byte) 0xc;

		//System.out.println(ss1 + " is large than " + ss0);
		System.out.printf("%x is large than %x%n", ss1, ss0);

		for (int cou = 0; cou < arr.length; cou++) {
			String aleft = "";
			if (arr[cou] == (byte) 0xff)
				aleft = "alert!";
			System.out.printf("[%s] : %x %s%n", cou, arr[cou], aleft);
		}

	}
}