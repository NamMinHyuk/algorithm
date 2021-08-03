package algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MTest {
	
	public static int[] makeArr(int size) {
		List<Integer> list = IntStream.range(1, size).boxed().collect(Collectors.toList());
		Collections.shuffle(list);
		int[] arr = list.stream().mapToInt(x -> x).toArray();
		System.out.println(Arrays.toString(arr));
		return arr;
	}
	public static void main(String[] args) {
		int[] arr = makeArr(10);
		System.out.println("------------");
		// bubble(arr);
		// selection(arr);
		insertion(arr);
	}
	
	public static void insertion(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			int insert = arr[i];
			int j = i-1;
			for(; j >=0 && arr[j]> insert;j--) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = insert;
			System.out.println(Arrays.toString(arr));
		}
	}
	
	public static void selection(int[] arr) {
		for(int i=0; i<arr.length-1;i++) {
			int min = i;
			for(int j=i;j<arr.length;j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[min];
			arr[min] = tmp;
			System.out.println(Arrays.toString(arr));
		}
	}
	public static void bubble(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
			System.out.println(Arrays.toString(arr));
		}
	}
}
