package ru.madhouse;

public class ByteOps {
	
	public static short addUnSigned(short op1, byte op2) {
		if ((op1 & 0xffff) + (op2 & 0xff) > 0xffff)
			return (short) 0xffff;

		return (short) (op1 + (op2 & 0xff));
	}

	public static byte addUnSigned(byte op1, byte op2) {
		if ((op1 & 0xff) + (op2 & 0xff) > 0xff)
			return (byte) 0xff;

		return (byte) (op1 + op2);
	}

	public static short subUnSigned(short op1, byte op2) {
		if ((int) (op2 & 0xff) > (int) (op1 & 0xffff))
			return (short) 0x0;

		return (short) (op1 - (op2 & 0xff));
	}
	
	public static byte subUnSigned(byte op1, byte op2) {
		if ((int) (op2 & 0xff) > (int) (op1 & 0xff))
			return (byte) 0x0;

		return (byte) (op1 - op2);
	}
}