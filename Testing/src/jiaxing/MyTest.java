package jiaxing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MyTest {

	public static void main(String[] args) {

		//Array to ArrayList
		ArrayList<Integer> myInt = new ArrayList<Integer>(Arrays.asList(4, 7, 9, 8, 15));
		myInt.add(1,3);
		myInt.add(3,4);
		myInt.add(4,2);
		System.out.println("Content of ArrayList:" + myInt);
		Collections.sort(myInt);	//Sort ArrayList
		System.out.println("After sorting:" + myInt);
		
		//ArrayList to array
		int num[] = new int[myInt.size()];
		for(int i=0;i<myInt.size();i++){
			num[i] = myInt.get(i);
			System.out.println(num[i]);
		}
		
		//LinkedList
		LinkedList<String> myLinkedList = new LinkedList<String>();
		myLinkedList.add("Star");
		myLinkedList.add(0,"Chris");
		myLinkedList.add("Jack");
		
		System.out.println("Content of LinkedList:" + myLinkedList);
		myLinkedList.addFirst("New Name");
		myLinkedList.addLast("New Name");
		myLinkedList.set(0, "Jon");
		System.out.println(myLinkedList.remove("New Name"));
		for(String name:myLinkedList){
			System.out.println(name);
		}
		
		//Hash Map
		HashMap<Integer,String> hmap = new HashMap<Integer, String>();
		hmap.put(2, "Star");
		hmap.put(0, "Chris");
		hmap.put(1, "loves");
		hmap.put(3, "forever.");
		
		//Loop Hash Map
		Set mentry = hmap.entrySet();
		Iterator it = mentry.iterator();
		while(it.hasNext()){
			Map.Entry myEntry = (Map.Entry)it.next();
			System.out.println("Key is: " + myEntry.getKey() + "; Value is: " + myEntry.getValue());
		}
		
		//Iterator
		Iterator myIt = hmap.entrySet().iterator();
		while(myIt.hasNext()){
			Map.Entry pair = (Map.Entry)myIt.next();
			System.out.println("Key: " + pair.getKey() + " Value: " + pair.getValue());
		}
		//For loop
		for(Map.Entry en:hmap.entrySet())
			System.out.println("Key: "+en.getKey()+" Value: "+en.getValue());
		
		//Sort hashmap according to key value based on TreeMap
		Map<Integer,String> map = new TreeMap<Integer,String>(hmap);
		for(Map.Entry entry:map.entrySet())
			System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());
		
		int[] nums = {1,2,4,4,5};
		int[] uni = Arrays.stream(nums).distinct().toArray();
		System.out.println(""+Arrays.asList(uni));
		String l = Integer.toString(429496729,2);
		
		int c=0;
		for(int i=0;i<l.length();i++)
			if(l.charAt(i)=='1') c++;
		System.out.println(l + c + "\n" + Integer.MAX_VALUE);
		
		//HashSet does not maintain any order
		//No duplicates allowed 
		Set<Integer> hset = new HashSet<Integer>();
		hset.add(1);
		hset.add(2);
		
		for(int i:hset){
			System.out.println(i);
		}
		int array []= {1,4,5,3,9};
		MergeSort myMerge = new MergeSort(array);
		myMerge.quickSort(0, array.length-1);
		System.out.println(Arrays.toString(array));
		
		RunnableEx ex = new RunnableEx();	//runnable object implements runnable interface with run()
		Thread thread = new Thread(ex);		//create a new thread with the runnable object in constructor
		thread.start();	//invoke start() to begin thread
		ThreadEx myThread = new ThreadEx();
		myThread.start();
		while(ex.count!=5&&myThread.count!=5){	//wait for count to 5
			try{
				Thread.sleep(250);
				System.out.println("Main Thread");
			}catch(InterruptedException exc){
				exc.printStackTrace();
			}
		}
		System.out.println("Terminate Program");
	}

}
