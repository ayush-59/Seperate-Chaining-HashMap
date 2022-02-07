package SeperateChainingHash;


public class HashMap<K extends Comparable<K>, V> {
	Node[] list;
	int maxSize;
	int size;
	private class Node<K,V>{
		K key;
		V val;
		Node next;
		
		public Node(K key, V val) {
			this.key = key;
			this.val = val;
		}
		
	
	}
	
	public HashMap() {
		maxSize = 10;
		size = 0;
		list = new Node[maxSize];
	}
	
	public HashMap(int maxSize) {
		this.maxSize = maxSize;
		size = 0;
		list = new Node[maxSize];
	}
	
	 private int hash(K key) {
	        int h = key.hashCode();
	        h ^= (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4);
	        return h & (maxSize-1);
	    }
	
	public void put(K key, V val) {
		int index = hash(key);
		Node node = new Node(key, val);
		if(list[index] == null) {
			list[index] = node;
		}else {
			Node curr = list[index];
			while(curr.next != null) {
				if(curr.key == key) {
					curr.val = val;
					return;
				}
				curr = curr.next;
			}
			curr.next = node;
		}
	}
	
	public V get(K key) {
		int index = hash(key);
		
		if(list[index] == null) 
			return null;
		else {
			Node curr = list[index];
			while(curr != null) {
				if(curr.key == key) {
					return((V)curr.val);
				}
				
				curr = curr.next;
			}
			return null;
		}
	}
	
	public static void main(String[] args) {
		HashMap<Student, Integer> hm = new HashMap();
		
		Student s1 = new Student(1, "Simran", 9.8);
		Student s2 = new Student(2, "Ayush", 9.6);
		Student s3 = new Student(3, "Abhishek", 9.4);
		Student s4 = new Student(4, "Amisha", 9.7);
		Student s5 = new Student(5, "a", 9.7);
		Student s6 = new Student(6, "B", 9.7);
		Student s7 = new Student(7, "C", 9.7);
		Student s8 = new Student(8, "d", 9.7);
		Student s9 = new Student(9, "f", 9.7);
		
		hm.put(s1, 1);
		hm.put(s2, 2);
		hm.put(s3, 3);
		hm.put(s4, 4);
		hm.put(s5, 5);
		hm.put(s6, 6);
		hm.put(s7, 7);
		hm.put(s8, 8);
		hm.put(s9, 9);
		System.out.println(hm.get(s1));
		System.out.println(hm.get(s2));
		System.out.println(hm.get(s3));
		System.out.println(hm.get(s4));
		System.out.println(hm.get(s5));
		System.out.println(hm.get(s6));
		System.out.println(hm.get(s7));
		System.out.println(hm.get(s8));
		System.out.println(hm.get(s9));
		
	}
	
}
