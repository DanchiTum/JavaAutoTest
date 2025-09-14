package task3;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
//Array Reverse: Write a Java program that takes an array of integers and reverses its elements.
//Your program should prompt the user to enter the array size and the elements of the array, and then output the reversed array.
//Make HashMap from the result array and perform the following operations:
// a) Add a key-value pair to the map;
// b) Remove a key-value pair from the map;
// c) Check if a key is in the map;
// d) Find the value associated with a given key;
// e) Print all the keys and values in the map;
//Make up the situation for ArrayIndexOutOfBoundsException. Catch it and display the explanation for your custom case.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        reverseArray(arr);
//        System.out.println("Reversed array:");
//        System.out.println(Arrays.toString(arr));
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        System.out.println("HashMap reversed array:");
        System.out.println(map);
        sc.close();
        map.put(10, 11);
        System.out.println(map);
        map.remove(10);
        System.out.println(map);
        map.put(10, 11);
        if (map.containsKey(10)) {
            System.out.println("Key 10 exists in the map with value = " + map.get(10));
        } else {
            System.out.println("Key 10 does not exist.");
        }
        System.out.println(map.get(10));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println(map.get(-1)); //In short, when we try to get the value of an element with a non-existent ID
                                         //we get ArrayIndexOutOfBoundsException, but in HashMap we get null
        int[] arr2 = {1, 2, 3};
        System.out.println(arr2[-1]);    //How you told me i make new array and make this mistake
    }
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
