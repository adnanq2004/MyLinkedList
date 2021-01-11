import java.util.*;
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
	end = start;
   }
   else if (size == 1) {
	end = n;
	start.setNext(end);
	end.setPrev(start);
   }
   else {
	   Node temp = new Node(end.value());
	   Node pre = end.prev();
	   pre.setNext(n);
	   n.setPrev(pre);
	   n.setNext(end);
	   end.setPrev(n);
	   end.setValue(n.value());
	   n.setValue(temp.value());
   	//end.setNext(n);
  	//n.setPrev(end);
   }
   this.size++;
   return true;

 }

 public void add(int index, String value) {
   if (index > size) {
	   throw new IndexOutOfBoundsException("Index greater than size of linked list");
   }
   if (index == 0) {
	start.setValue(value);
	end = start;
   }
   if (index == size) {
	add(value);
   }
   else {
	   Node current = getN(index);
   	    Node n = new Node(value);
   	    current.prev().setNext(n);
   	    n.setPrev(current.prev());
   	    n.setNext(current);
   	    current.setPrev(n);
   	}
   size++;
 }

 public String get(int index) {

	Node current = getN(index);
	return current.value();

 }

 public String set(int index, String value) {

	 Node current = getN(index);
	 String val = current.value();
	 current.setValue(value);
	 return val;


 }

 public String toString() {
   if (size == 0) {
     String val = "[]";
     return val;
   }
	Node current = start;
	String val = "[";
	while (current.next() != null) {
		val += current.value();
		val += ", ";
		current = current.next();
	}
	val += end.value();
  val += "]";
  return val;
 }

 /*public String toStringReverse() {

	Node current = end;
	String val = "";
	while (current.prev() != null) {
		val += current.value();
		val += ", ";
		current = current.prev();
	}
	return val;

 } */


	private Node getN(int n) {

		Node current = start;
		for (int i = 0; i < n; i++) {
			current = current.next();
		}
		return current;

	}

  public String remove(int index) {

    Node current = getN(index);
    current.prev().setNext(current.next());
    current.next().setPrev(current.prev());
    return current.value();

  }

  public void extend(MyLinkedList other) {

    Node temp = new Node(end.value());
    Node firstend = new Node(end.value());
    end.prev().setNext(firstend);
    firstend.setPrev(end.prev());
    firstend.setNext(other.start);
    other.start.setPrev(firstend);
    end.setPrev(other.end.prev());
    other.end.prev().setPrev(end);
    end.setValue(other.end.value());
    other.end.setValue(temp.value());
	  //end.setNext(other.start);
    //other.start.setPrev(this.end);
    size += other.size();
    // MyLinkedList f = new MyLinkedList();
    // other = f;
  other.size = 0;
  // other.start.setValue(null);
	//other.start.setValue(null);
	//other.end.setValue(null);
  }

 //Any helper method that returns a Node object MUST BE PRIVATE!
}
