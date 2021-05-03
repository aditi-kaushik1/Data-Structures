public class Main {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(bubbleSort(new int[] {7,2,35,1,3})));
	}
	
	public static int[] bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			boolean flag = false;
			for(int j = 0; j < arr.length - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = true;
				}
			}
			if(flag == false)
				break;
		}
		return arr;
	}
}
