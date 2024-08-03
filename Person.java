import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
	private String firstName;
	private String lastName;
	private int age;
	
	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return "Person{" +
			   "firstName='" + firstName + '\'' +
			   ", lastName='" + lastName + '\'' +
			   ", age=" + age +
			   '}';
	}

	class Queue {
		private List<Person> queue;
		
		public Queue() {
			queue = new ArrayList<>();
		}
		
		public void enqueue(Person person) {
			queue.add(person);
		}
		
		public void display() {
			for (Person person : queue) {
				System.out.println(person);
			}
		}
		public void quickSortByLastName() {
			quickSortByLastName(0, queue.size() - 1);
		}
		
		private void quickSortByLastName(int low, int high) {
			if (low < high) {
				int pi = partitionByLastName(low, high);
				quickSortByLastName(low, pi - 1);
				quickSortByLastName(pi + 1, high);
			}
		}
		
		private int partitionByLastName(int low, int high) {
			Person pivot = queue.get(high);
			int i = (low - 1);
			for (int j = low; j < high; j++) {
				if (queue.get(j).getLastName().compareTo(pivot.getLastName()) > 0) {
					i++;
					Person temp = queue.get(i);
					queue.set(i,  queue.get(j));
					queue.set(j,  temp);
				}
			}
			Person temp = queue.get(i + 1);
			queue.set(i + 1, queue.get(high));
			queue.set(high, temp);
			return i + 1;
					
		}
		
		public void quickSortByAge() {
			quickSortByAge(0, queue.size() - 1);
		}
		
		private void quickSortByAge(int low, int high) {
			if (low < high) {
				int pi = partitionByAge(low, high);
				quickSortByAge(low, pi - 1);
				quickSortByAge(pi + 1, high);
			}
		}
		
		private int partitionByAge (int low, int high) {
			Person pivot = queue.get(high);
			int i = (low - 1);
			for (int j = low; j < high; j++) {
				if (queue.get(j).getAge() > pivot.getAge()) {
					i++;
				}
			}
			Person temp = queue.get(i + 1);
			queue.set(i + 1, queue.get(high));
			queue.set(high, temp);
			return i + 1;
		}
		
	}
	
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Queue queue = new Queue();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Enter first name for person " + (i + 1) + ": ");
			String firstName = scanner.nextLine();
			System.out.println("Enter last name for person " + (i + 1) + ": ");
			String lastName = scanner.nextLine();
			System.out.println("Enter age for person " + (i + 1) + ": ");
			int age = Integer.parseInt(scanner.nextLine());
			
			queue.enqueue(new Person(firstName, lastName, age));
		}
		
		System.out.println("\nQueue contents:");
		queue.display();
		
		System.out.println("\nQueue sorted by last name (descending):");
		queue.quickSortByLastName();
		queue.display();
		
		System.out.println("\nQueue sorted by age (descending):");
		queue.quickSortByAge();
		queue.display();

	}

}
