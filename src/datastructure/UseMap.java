package datastructure;

import java.util.*;

public class UseMap {

	/*
	 * Demonstrate how to use Map that includes storing and retrieving elements.
	 * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
	 * Use For Each loop and while loop with Iterator to retrieve data.
	 *
	 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
	 */


	public static void main(String[] args) throws Exception {

		Map<String, List<String>> hString = new HashMap	<String, List<String>>();

		List<String> lValue1 = new ArrayList<String>();
		List<String> lValue2 = new ArrayList<String>();
		List<String> lValue3 = new ArrayList<String>();
		List<String> lValue4 = new ArrayList<String>();
		List<String> lValue5 = new ArrayList<String>();

		// add data
		lValue1.add("Asif Tanvir");
		lValue2.add("Jhon");
		lValue3.add("Steve King");
		lValue4.add("David");
		lValue5.add("Johnny");

		hString.put("A", lValue1);
		hString.put("B", lValue2);
		hString.put("C", lValue3);
		hString.put("D", lValue4);
		hString.put("E", lValue5);

		// for each
		System.out.println("For each");
		for (Map.Entry<String, List<String>> entry : hString.entrySet()) {
			String key = entry.getKey();
			List<String> values = entry.getValue();
			System.out.println("Key = " + key + " Values = " + values);
		}

		// Iterator
		System.out.println("Iterator");
		Iterator itr = hString.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry pair = (Map.Entry)itr.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
			itr.remove();
		}

	}


}