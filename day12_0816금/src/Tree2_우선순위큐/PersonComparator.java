package Tree2_우선순위큐;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person>{
	@Override
	public int compare(Person o1, Person o2) {
		return o2.age - o1.age; // 내림차순
	}
}
