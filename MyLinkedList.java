public class MyLinkedList{
 private int size;
 private Node start,end;
 public MyLinkedList(int s, Node st, Node en){/*create a constructor*/
   size = s;
   start = st;
   end = en;
   start.setNext(end);
   end.setPrev(start);
 }
 public int size() {
   return size;
 }
 public boolean add(String value) {
   Node n = new Node(value);
   end.setNext(n);
   n.setPrev(end);
   size++;
   return true;
 }
 public boolean add(int index, String value) {
   Node current = start;
   for (int i = 0; i < size; i++) {
     if (i == index) {
       Node n = new Node(value);
       current.getPrev().setNext(n);
       n.setPrev(current.getPrev());
       n.setNext(current);
       current.setPrev(n);
     }
     current = current.getNext();
   }
 }
 public String get(int index);
 public String set(int index, String value);
 public String toString();
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
