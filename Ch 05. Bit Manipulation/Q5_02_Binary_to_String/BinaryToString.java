package Q5_02_Binary_to_String;

public class BinaryToString {
	public static String binaryToString(double val) {
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		int exp = 1;

		while (val != 0) {
			if (binary.length() == 32) {
				return "ERROR";
			}

			double d = val - (1 / Math.pow(2, exp));

			if (d < 0) {
				binary.append("0");
			} else {
				binary.append("1");
				val = d;
			}
			exp++;
		}

		return binary.toString();
	}

	public static String binaryToStringBookSolution(double num) {
		if (num <= 0 || num >= 1) {
			return "ERROR";
		}

		StringBuilder binary = new StringBuilder();
		binary.append(".");

		while (num > 0) {
			if (binary.length() >= 32) {
				return "ERROR";
			}

			double r = num * 2;
			if (r >= 1) {
				binary.append("1");
				num = r - 1;
			} else {
				binary.append("0");
				num = r;
			}
		}

		return binary.toString();
	}
}
