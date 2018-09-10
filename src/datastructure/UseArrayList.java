package datastructure;

import databases.ConnectToSqlDB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;




public class UseArrayList {

	public static void main(String[] args) throws Exception {

		/*
		 * Demonstrate how to use ArrayList that includes add,peek,remove,retrieve elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * Store all the sorted data into one of the databases.
		 *
		 */

		ArrayList<Integer> arrList = new ArrayList<>();

		arrList.add(150);
		arrList.add(200);
		arrList.add(300);
		arrList.add(25);
		arrList.add(90);


		System.out.println("Retrieving elements from ArrayList: " + arrList);

		System.out.println("Peek first element: " + arrList.get(0));

		System.out.println("Remove element at index 1: " + arrList.remove(1));

		System.out.println("Re-retrieving elements from ArrayList: " + arrList);

		System.out.println("Use of for-each loop: ");
		for (Integer in : arrList) {
			System.out.println(in);
		}

		System.out.println("Use of iterator using while loop: ");
		Iterator it = arrList.iterator();
		while (it.hasNext()) {
			Integer i = (Integer) it.next();
			System.out.println(i);
		}

		Collections.sort(arrList);
		System.out.println(arrList);
		List list = new ArrayList();
		list = arrList;

		ConnectToSqlDB connectDB = new ConnectToSqlDB();

		connectDB.createTableFromStringToMySql("use_map", "array_list","listElement");

		connectDB.InsertDataFromArrayListToMySql(list, "use_map", "array_list", "listElement");

		List<String> numbers = connectDB.readDataBase("array_list", "listElement", "mapValue");
		for(String st:numbers){
			System.out.println(st);
		}
	}
}









