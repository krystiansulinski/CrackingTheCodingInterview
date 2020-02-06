package MagicIndex;

public class MagicIndex {
	// assume the array is sorted in a descending order
	public static int magicIndex(int[] arr) {
		return magicIndex(arr, 0, arr.length - 1);
	}

	public static int magicIndex(int[] arr, int low, int high) {
		if (low > high) {
			return -1;
		}

		int mid = (low + high) / 2;
		if (arr[mid] == mid) {
			return mid;
		}
		if (arr[mid] > mid) {
			return magicIndex(arr, mid + 1, high);
		} else {
			return magicIndex(arr, low, mid - 1);
		}
	}

	// assume the array is sorted in a descending order
	public static int magicIndexNonDistinct(int[] arr) {
		return magicIndexNonDistinct(arr, 0, arr.length - 1);
	}

	public static int magicIndexNonDistinct(int[] arr, int low, int high) {
		if (low > high) {
			return -1;
		}

		int mid = (low + high) / 2;
		if (arr[mid] == mid) {
			return mid;
		}
		int left = magicIndex(arr, Math.max(mid, arr[mid]), high); // TODO: check
		if (left != -1) {
			return left;
		}

		int right = magicIndex(arr, low, Math.max(mid, arr[mid])); // TODO: check
		return right;
	}
}
