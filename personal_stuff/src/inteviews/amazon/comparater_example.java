package inteviews.amazon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class comparater_example {

	public static void main(String[] args) {
		List<String> boxList = new ArrayList<String>();
		boxList.add("123 old box a very old");
		boxList.add("111 old box a old");
		boxList.add("xyz old box stuff");
		
		System.out.println(orderedJunctionSets(3, boxList));
		
	}

	public static List<String> orderedJunctionSets(int numberOfBoxes, List<String> boxList) {
		List<String> result = new ArrayList<String>(boxList);
		Collections.sort(result, new comp());
		return result;
	}

}

class comp implements Comparator<String> {

	@Override
	public int compare(String first, String second) {
		int firstIndex = first.indexOf(" ");
		int secondIndex = second.indexOf(" ");

		String firstFirstPart = first.substring(0, firstIndex);
		String secondFirstPart = second.substring(0, secondIndex);

		String firstSecondPart = first.substring(firstIndex + 1);
		String secondSecondPart = second.substring(secondIndex + 1);
		int result = firstSecondPart.compareTo(secondSecondPart);
		if (result == 0)
			return firstFirstPart.compareTo(secondFirstPart);
		else
			return result;
	}
}
