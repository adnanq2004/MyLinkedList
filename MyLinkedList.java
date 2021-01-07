public class MyLinkedList{

 private int size;

 private Node start,end;

 public MyLinkedList(){/*create a constructor*/
 
   /*size = s;
   start = st;
   end = en;
   start.setNext(end);
   end.setPrev(start);*/

	size = 0;
	start = null;
	end = null;

 }

 public int size() {

   return size;

 }

 public boolean add(String value) {
   Node n = new Node(value);
   if (size == 0) {
	start = n;
	end = n;
   }
   else if (size == 1) {
	end = n;
	start.setNext(end);
	end.setPrev(start);
   }
   else {
   	end.setNext(n);
  	n.setPrev(end);
   }	
   size++;
   return true;

 }

 public void add(int index, String value) {

   Node current = start;
   for (int i = 0; i < size; i++) {
     if (i == index) {
       Node n = new Node(value);
       current.prev().setNext(n);
       n.setPrev(current.prev());
       n.setNext(current);
       current.setPrev(n);
     }
     current = current.next();
   }

 }

 public String get(int index) {

	Node current = start;
	for (int count = 0; count < index;count++) {
		current = current.next();
	}
	return current.value();

 }

 public String set(int index, String value) {

	 Node current = start;
	 for (int count = 0; count < index; count++) {
		current = current.next();
	 }
	 String val = current.value();
	 current.setValue(value);
	 return val;
	 

 }

 public String toString() {
	
	Node current = start;
	String val = "";
	while (current.next().value() != null) {
		val += current.value();
		val += ", ";
	}
	val += end.value();
	return val;
 }
 

	private Node getN(int n) {
		
		Node current = start;
		for (int i = 0; i < n; i++) {
			current = current.next();
		}
		return current;

	}

 //Any helper method that returns a Node object MUST BE PRIVATE!
}
