package BinaryToString;

public class BinaryToString {
	public static String binaryToString(double val) {
		String binary = "0.";
		int exp = 1;

		while (val != 0) {
			if (binary.length() == 32) {
				return "ERROR";
			}

			double d = val - (1 / Math.pow(2, exp));

			if (d < 0) {
				binary += "0";
			} else {
				binary += "1";
				val = d;
			}
			exp++;
		}

		return binary;
	}
}
