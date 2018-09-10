package datastructure;

import databases.ConnectToSqlDB;

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

		HashMap<Integer, String> hmap = new HashMap<Integer, String>();

		hmap.put(1, "Asif");
		hmap.put(2, "Tanvir");
		hmap.put(3, "Jhon");
		hmap.put(4, "David");
		hmap.put(5, "Steve");

		String var = hmap.get(2);
		System.out.println("Value at index 0 is: " + var);
		String var1 = hmap.get(3);
		System.out.println("Value at index 3 is: " + var1);

		Map<String, List<String>> list = new HashMap<String, List<String>>();
		List<String> carList = new ArrayList<String>();
		carList.add("Toyota");
		carList.add("Ferari");
		carList.add("Honda");
		list.put("car", carList);
		System.out.println(list);

		List<String> fruits = new ArrayList<String>();
		fruits.add("Apple");
		fruits.add("Bananas");
		fruits.add("Grapes");
		list.put("Fruit", fruits);
		System.out.println(list);

		for (Object str : list.keySet()) {
			System.out.println("KeySet:" + str);
			for (String str1 : list.get(str)) {
				System.out.println("Value: " + str1);
			}
		}
		Iterator itr = list.entrySet().iterator();
		System.out.println("While Loop:");
		Iterator iterator = list.keySet().iterator();
		while (iterator.hasNext()) {
			Object kvalues = iterator.next();
			for (String str1 : list.get(kvalues)) {
				System.out.println("Value: " + str1);
			}
		}
		ConnectToSqlDB connectDB = new ConnectToSqlDB();

		connectDB.createTableFromStringToMySql("use_map", "mapKey", "mapValue");
		for (Object str : list.keySet()) {
			for (String str1 : list.get(str)) {
				List<String> list1 = new ArrayList<String>();
				list1.add(str.toString()); // adds key
				list1.add(str1); // adds value
				connectDB.InsertDataFromArrayListToMySql(list1, "use_map", "mapKey", "mapValue");
			}
		}
		System.out.println("Reading data from database: ");
		List<String> numbers = (List<String>) connectDB.readDataBase("use_map", "mapKey", "mapValue");
		for (String st : numbers) {
			System.out.println(st);
		}
	}
}