

public class Main {
	public static void main(String[] args) {
		JLinkedList numbers = new JLinkedList();
		
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.add(1, 15);
		//System.out.println(numbers.indexOf(30));
		System.out.println(numbers);
		
		JLinkedList.ListIterator i = numbers.listIterator(); // class 안의 class를 명시적으로 호출하는 
		i.next();
		i.remove();
	}
}
