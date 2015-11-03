import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class queuetest{
    // Author: dustin HU
    // DAte: 08-01-2015
    // Purpose: To demonstrate the quees

    // Methods: main: The main
    public static void main (String [] args) throws IOException {
	// Author: DUstin Hu
	// Date: 06-01-2015
	// Purpoes: To be the main
	// Input: None
	// Output: None
	
	BufferedReader input = new BufferedReader(
						  new InputStreamReader(System.in));
	int i = 1;
	PartialShiftedArrayQ partiallyShifted = new PartialShiftedArrayQ(14);
	StraightLineArrayQ straightLine = new StraightLineArrayQ(14);
	FullyShiftedArrayQ fullyShifted = new FullyShiftedArrayQ(14);
	CircularArrayQ circularArray = new CircularArrayQ(14);
	LinkedListQ linkedQ = new LinkedListQ();
	String userInput = "";
	String size;
	System.out.println("Welcome to the Queue simulation");
	System.out.println("Your current queues:");
	System.out.println("Partially shifted: " + partiallyShifted.toString());
	System.out.println("Straight line:     " + straightLine.toString());
	System.out.println("Fully shifted:     " + fullyShifted.toString());
	System.out.println("Circular:          " + circularArray.toString());
	System.out.println("Linked:            " + linkedQ.toString());
	while (!userInput.equals("5")){
	    System.out.println("Your options are as follows:");
	    System.out.println("1) Add an item to the queue");
	    System.out.println("2) Remove an item from the queue");
	    System.out.println("3) Reset the queue");
	    System.out.println("4) Create new queues with a size of your choice");
	    System.out.println("5) Exit the queue");

	    userInput = input.readLine();
	    if (userInput.equals("1")){
		partiallyShifted.add(i);
		straightLine.add(i);
		fullyShifted.add(i);
		circularArray.add(i);
		linkedQ.add(i);
		i = i + 1;
		System.out.println("Your current queues:");
		System.out.println("Partially shifted: " + partiallyShifted.toString());
		System.out.println("Straight line:     " + straightLine.toString());
		System.out.println("Fully shifted:     " + fullyShifted.toString());
		System.out.println("Circular:          " + circularArray.toString());
		System.out.println("Linked:            " + linkedQ.toString());
		
	    }
	    else if (userInput.equals("2")){
		partiallyShifted.remove();
		straightLine.remove();
		fullyShifted.remove();
		circularArray.remove();
		linkedQ.remove();
		System.out.println("Your current queues:");
		System.out.println("Partially shifted: " + partiallyShifted.toString());
		System.out.println("Straight line:     " + straightLine.toString());
		System.out.println("Fully shifted:     " + fullyShifted.toString());
		System.out.println("Circular:          " + circularArray.toString());
		System.out.println("Linked:            " + linkedQ.toString());
	    }
	    else if (userInput.equals("3")){
		partiallyShifted.reset();
		straightLine.reset();
		fullyShifted.reset();
		circularArray.reset();
		linkedQ.reset();
		System.out.println("Your current queues:");
		System.out.println("Partially shifted: " + partiallyShifted.toString());
		System.out.println("Straight line:     " + straightLine.toString());
		System.out.println("Fully shifted:     " + fullyShifted.toString());
		System.out.println("Circular:          " + circularArray.toString());
		System.out.println("Linked:            " + linkedQ.toString());
	    }
	    else if (userInput.equals("4")){
		System.out.println("Please enter a size between 1 and 1000");
		size = input.readLine();
		while (Integer.parseInt(size) < 1 || Integer.parseInt(size) > 1000){
		    System.out.println("Invalid value.");
		    System.out.println("Please enter a size between 1 and 1000");
		    size = input.readLine();
		}
		partiallyShifted = new PartialShiftedArrayQ(Integer.parseInt(size));
		straightLine = new StraightLineArrayQ(Integer.parseInt(size));
		fullyShifted = new FullyShiftedArrayQ(Integer.parseInt(size));
		circularArray = new CircularArrayQ(Integer.parseInt(size));
		System.out.println("Your current queues:");
		System.out.println("Partially shifted: " + partiallyShifted.toString());
		System.out.println("Straight line:     " + straightLine.toString());
		System.out.println("Fully shifted:     " + fullyShifted.toString());
		System.out.println("Circular:          " + circularArray.toString());
		System.out.println("Linked:            " + linkedQ.toString());


	    }
	    else if (userInput.equals("5")){
		System.out.println("Bye bye!");
	    }
	    else {
		System.out.println("Incorrect input. Please try again");
	    }
	}
    }
}


abstract class Queue {
    /*
      Author: Dustin Hu
      Date: 05-01-2015
      Purpoes: To be the supercalss of the queeu
      
      Methods:
          add: Adds an element to the queue
	  remove: Removes an element from the queue
	  reset: Resets the queue
	  toString: Returns the string of the queue
	  isFull: Checsk if hthe queue is full
	  isEmpty: Checks if the queue is empty
	  
      
      Data fields:
          size: The size of the queue

      In a queue, items are always removed from the front and added ot the back
      i.e
      [9,8,7,5,6,2] <---- 9 is the front and 2 is the back. If you were to add a 8, it'd become
      [9,8,7,5,6,2,8]. If you were to remove an item, it'd become
      [8,7,5,6,2,8]. If you were to remove another item, it'd become
      [7,5,6,2,8].
   
     */
    protected int size;
    
    public Queue(){
	this.size = 0;
    }

    abstract public boolean add (int input);
    abstract public int remove ();
    abstract public void reset ();
    abstract public String toString();
    abstract public boolean isEmpty();
}

abstract class ArrayQueue extends Queue{
    /*
      Author: Dustin Hu
      Date: 05-01-2015
      Purpoes: To be the superclass of the array-based queues

      Methods: 
          ArrayQueue: To cerate the array queue
	  isFull: Checks if the queue is full
	  isEmpty: Checks if the quee is empty
	  remove: Removes the item at the front
	  add: Adds an item to the back

      Data fields:
          size: The size of the queue
	  front: The front of the queue
	  back: The back of the queue
     */
    protected int [] queue;
    protected int size;
    protected int front;
    protected int back;
    protected int physSize;
    
    public ArrayQueue(){
	// Author: Dustin Hu
	// Date: 05-01-2015
	// Purpoes: To create the arrayqueue
	// Input: None
	// Output: None
	super();
	this.size = 0;
	this.front = 0;
	this.back = 0;
	this.queue = new int [10];
    }
    public ArrayQueue(int size){
	// Author: Dustin Hu
	// Date: 08-01-2015
	// Purpoes: To create an array queue with variable size
	// Input: The size of the array to create
	// Output: None
	super();
	this.size = 0;
	this.front = 0;
	this.back = 0;
	this.queue = new int[size];
	this.physSize = size;
    }	
    public boolean isFull(){
	// AUthor: Dustin Hu
	// Date: 05-01-2015
	// Purpoes: To check if the queue is full
	// Input: None
	// Output: true if the queue is full, false if not full
	boolean output;
	if (this.back < this.queue.length){
	    output = false;
	}
	else{
	    output = true;
	}
	return output;
       
    }
    public boolean isEmpty(){
	// Author: DUstin Hu
	// Date: 05-01-2015
	// Purpose: To check if the array is empty
	// Input: None
	// Output: True if the array queue is empty, false if it's not empty.
	boolean output;
	if (this.size == 0){
	    output = true;
	}
	else{
	    output = false;
	}
	return output;	
    }
    public int remove(){
	// AUthor: Dustin Hu
	// Date: 05-01-2015
	// Purpose: To remove an item from the front of the queue
	// Input: None
	// OUtput: THe value removed, if one exists, else return max value
	int output;
	if (!this.isEmpty()){
	    output = this.queue[this.front];
	    this.queue[this.front] = 0;
	    this.front = this.front + 1;
	    this.size = this.size - 1;
	}
	else{
	    output = Integer.MIN_VALUE;
	}
	return output;
    }
    public boolean add (int input){
	// Author: Dustiin Hu
	// Date: 05-01-2015
	// Purpose: To add an item
	// Input: The number to add
	// Output: True if added, false if not
	boolean output;
	if (!this.isFull() && this.back < this.queue.length ){
	    this.queue[this.back] = input;
	    this.back = this.back + 1;
	    this.size = this.size + 1;
	    output = true;
	}
	else{
	    output = false;
	}
	return output;
    }
    public void reset (){
	// AUthor: Dustin Hu
	// Date: 06-01-2015
	// Purpoes: To reset the queue
	// Input: None
	// OUtput: None
	this.queue = new int [this.physSize];
	this.front = 0;
	this.back = 0;
	this.size = 0;
    }
    public String toString (){
	// AUthor: Dustin Hu
	// Date: 06-01-2015
	// Purpoes: To get the string of the arrayq
	// Input: None
	// OUtput: A string from front to back
	// String output = "F: ";
	// for (int i = this.front; i < this.back ; i++){
	//     if (i < this.queue.length){
	// 	output = output + this.queue[i] + " <- ";
	//     }
	//     else{
	// 	output = output + this.queue[i];
	//     }
	// }
	// for (int i = this.back; i < this.queue.length; i++){
	//     if (i < this.queue.length){
	// 	output = output + " NULL <- ";
	//     }
	//     else{
	// 	output = output +  " NULL ";
	//     }
	// }
	// if (this.isFull() || this.back == 9){
	//     output = output + " :B ; Full";
	// }
	// else{
	//     output = output + " :B ; Not full";
	// }
	// return output;
	String output = "F: ";
	for (int i= 0; i < this.queue.length ; i++){
	    if (i < this.front || i  >= this.back || (this.front - this.back == 0)){
		output = output + " \\ ";
	    }
	    else{
		output = output + this.queue[i] + " ";
	    }
	}
	output = output + " :B";
	if (this.isFull()){
	    output = output + "; Full";
	}
	else{
	    output = output + "; Not full";
	}
	    
	return output;

    }
}

class StraightLineArrayQ extends ArrayQueue{

    /*
      Author: DUstin Hu
      Date: 05-01-2015
      Purppose: To impleement the array queue using a straight line array

      Methods: 
          StraightLineArrayQ: Creates the array queue
	  STraightLineArrayQ: Creates the array quee
     */
    public StraightLineArrayQ (){
	// Author: Dustin Hu
	// Date: 06-01-2015
	// Purpose: To cerate the StraightLineArrayQ
	// Input: None
	// Output: None
	super();
    }
    public StraightLineArrayQ (int size){
	// Author: Dustin Hu
	// Date: 06-01-2015
	// Purpose: To cerate the StraightLineArrayQ
	// Input: The size
	// Output: None
	super(size);
    }
}

class PartialShiftedArrayQ extends ArrayQueue{
    /*
      Author: Dustin Hu
      Date: 06-01-2015
      Purpoes: To implement a shifted array version of the queue
      Methods:
          PartialShiftedArrayQ: Creates the partial shifted array
          PartialShiftedArrayQ: Creates the partial shifted array
          remove: Overrides the original remove.
      
     */
    public PartialShiftedArrayQ(){
	// Author: Dustin Hu
	// Date: 06-01-2015
	// Purpose: To cerate the PartialShiftedArray
	// Input: None
	// Output: None

	super();
    }
    public PartialShiftedArrayQ(int size){
	// Author: Dustin Hu
	// Date: 06-01-2015
	// Purpose: To cerate the PartialShiftedArray
	// Input: The size
	// Output: None

	super(size);
    }

    public int remove(){
	// AUthor: Dustin Hu
	// Date: 05-01-2015
	// Purpose: To remove an item from the front of the queue
	// Input: None
	// OUtput: THe value removed, if one exists, else return max value
	int output;
	if (!this.isEmpty()){
	    output = this.queue[0];
	    this.back = this.back - 1;
	    this.size = this.size -1 ;
	    for (int i = 1; i < this.queue.length; i++){
		this.queue[i - 1] = this.queue[i];
	    }
	}
	else{
	    output = Integer.MIN_VALUE;
	}
	return output;
    }
    }

class FullyShiftedArrayQ extends ArrayQueue{
    /*
      Author; Dustin Hu
      Date: 07-01-2015
      Purpoes: To be the fully shifetd array
      
      Methods:
          arrayQueue: Constructor
          arrayQueue: Constructor with one input
	  isEmpty: Inherited, checks if empty
	  remove: Inherited, removes the item at back
	  toString: Inherited, gets the string of the queue
	  isFull: Checks if full
          add: Ovverrides the original add. We want it to shift the array when we reach the end.
	  shiftToFront: Shifts the entire array over to the front
     */
    public FullyShiftedArrayQ(){
	// author: Dustin Hu
	// Date: 08-01-2015
	// Purpose: To create the array queue
	// Input: None
	// Output: None
	super();
    }
    public FullyShiftedArrayQ(int size){
	// author: Dustin Hu
	// Date: 08-01-2015
	// Purpose: To create the array queue
	// Input: The size
	// Output: None
	super(size);
    }
    public boolean isFull(){
	// Author: Dustin Hu
	// Date: 07-01-2015
	// Purpoes: To check if the array is empty
	// Input: None
	// OUtput: True if full, false if not full
	boolean output;
	if (this.size < this.queue.length){
	    output = false;
	}
	else{
	    output = true;
	}
	return output;
    }
    public boolean add (int input){
	// Author: DUstin Hu
	// Date: 07-01-2015
	// Puproes: To add a number
	// Input: THe number to add
	// Output: True if the number was added, false if it wasn't
	boolean output;
	if (!this.isFull()){
	    if (this.back == this.queue.length  && this.size < this.queue.length && this.front != 0){
	    	this.shiftToFront();
	    	this.back = this.back - this.front;
	    	// this.back = this.back + 1;
	    	this.front = 0;
	    	this.size = this.size + 1;
	    	this.queue[this.back] = input;
		this.back = this.back + 1;
	    }
	    else{
	    	super.add(input);
	    }
	    output = true;
	}
	else{
	    output = false;
	}
	return output;
    }
    public void shiftToFront (){
	// Author: Dsutin Hu
	// Date: 07-01-2015
	// Purpoes: To shift the array over to the front
	// Input: None
	// OUtput: None
	for (int i = 0; i < (this.back - this.front); i++){
	    this.queue[i] = this.queue[this.front + i];
	}
    }
}

class CircularArrayQ extends ArrayQueue{
    /*
      AUthor: DUstin Hu
      Date: 08-01-2015
      purpoes: To be the circular array queue
      
      Methods:
          circularArrayQ: Construcotr
          circularArrayQ: Construcotr with one input
          isEmpty: Inherited, checks if empty
	  consructor: Creates the array
          isFull: Checks if the array is full
	  add: Adds an integer to the queue
	  remove: Removes the front item from the queue
	  toString: Creates the string
     */
    public CircularArrayQ(){
	// Author: Dustin
	// Date: 08-01-2015
	// Purpose: To create the circular array
	// Input: None
	// Output: None
	super();
    }
    public CircularArrayQ(int size){
	// Author: Dustin
	// Date: 08-01-2015
	// Purpose: To create the circular array
	// Input: THe size
	// Output: None
	super(size);
    }

    public boolean isFull(){
	// AUthor: Dsutin Hu
	// Date: 08-01-2015
	// Purpoes: To check if the circular queue is full
	// Input: 08-01-2015
	// Output: True if it's full, false if it's not
	boolean output;
	if (this.size == this.queue.length){
	    output = true;
	}
	else{
	    output = false;
	}
	return output;
    }
    public boolean add (int input){
	// AUthor: Dustin Hu
	// Date: 08-01-2015
	// Purpoes: To add an integer to the queue
	// Input: The number to add
	// OUtput: True if added, false if not.
	boolean output;

	if (!this.isFull()){
	    this.size = this.size + 1;
	    this.queue[this.back] = input;
	    this.back = (this.back + 1) % this.queue.length;

	    output = true;
	}
	else{
	    output = false;
	}
	return output;
    }
    public int remove (){
	// AUthor: Dustin Hu
	// Date: 08-01-2015
	// Purpoes: To remove the front
	// Input: None
	// OUtput: The number being removed

	int output;

	if (!this.isEmpty()){
	    this.size = this.size - 1;
	    this.queue[this.front] = Integer.MIN_VALUE;
	    output = this.queue[this.front];
	    this.front = (this.front + 1)  % this.queue.length;
	}
	else{
	    output = Integer.MIN_VALUE;
	}
	return output;
    }
    public String toString(){
	// Autohr: DusitN Hu
	// Daet: 08-01-2015
	// Purpoes: To get the strring of thequeue
	// Input: None
	// OUtput: The stringof the queue
	String output = "F: ";
	
	for (int i= 0; i < this.queue.length ; i++){
	    if (this.queue[i] != Integer.MIN_VALUE && this.queue[i] != 0){
		output = output + this.queue[i] + " ";
	    }
	    else{
		output = output + " \\ ";
	    }
	}
	output = output + " :B";
	if (this.isFull()){
	    output = output + "; Full";
	}
	else{
	    output = output + "; Not full";
	}
	    
	return output;
    }
}

class Node implements Cloneable{
    /*
      Author: Dsutin Hu
      Date: 24-11-2014
      Purpose: To be a node
      Methods:

          Node: Constructor with no paramateres
	  Node: Constructor with info parameter
	  clone: Clones the Node
	  toString: Outputs the node as a string
     */

    public int data; 
    public Node next;

    public Node(){
	// AUthor: DUstin Hu
	// Date: 24-11-2014
	// Purpose: To create the node
	// Input: None
	// Output: None

	this.data = Integer.MIN_VALUE;
	this.next = null;
    }
    public Node(int info){
	// AUthor: Dustin Hu
	// Date: 24-11-2014
	// Purpose: To create a new node
	// Input: THe data, a string
	// Output: None
	
	this.data = info;
	this.next = null;
    }
    public Object clone() throws CloneNotSupportedException {
	// AUthor: Dustin Hu
	// Date: 24-11-2014
	// Purpoes: To clone the node
	// Input: None
	// Output: A cloned node

	Node output = (Node) super.clone();
	if (this.next == null){
	    output.next = null;
	}
	else{
	    output.next = (Node) this.next.clone();
	}
	return output;
    }
    public String toString() {
	// AUthor: Dusitn Hu
	// Date: 11-25-2014
	// Purpose: To create the string 
	// Input: None
	// OUtput: THe node as a string
	String output = "";
	if (this.next == null){
	    output = output + this.data + " -> NULL";
	}
	else{
	    output = output + this.data + " -> " + this.next.toString();
	}
	return output;

    }
}

class LinkedListQ extends Queue{
    /*
      Author: Dustin Hu
      Date: 08-10-2015
      Purpoes: To hold the linked list queue
      
      MethodS:
          reset: Resets the quueue
          LinkedListQ: Creates the linked list
	  isEmpty: Checks if the quee is empty
	  toString: Prints the linked list
	  add: Adds a value to the array
      Fields:
          front: A node, the root.
	  back: The back node, the end of the list
    
    */
    protected Node front;
    protected Node back;

    public void reset(){
	// AUthor: Dustin Hu
	// Date: 08-01-2015
	// Purpose: To reset the queue
	// Input: None
	// Output: None
	this.front = null;
	this.back = null;
    }
    
    public LinkedListQ (){
	// Author: Dustin Hu
	// Date: 08-01-2015
	// Purpose: To create the linked list quee
	// Input: None
	// Output: None
	super();
	this.front = null;
	this.back = null;
    }
    public boolean isEmpty(){
	// AUtohr: Dustin Hu
	// Date: 08-01-2015
	// Purpoes: To check if the queue is empty
	// Input: None
	// OUtput: True if the queue is empty, false if not
	boolean output;
	if (front == null){
	    output = true;
	}
	else{
	    output = false;
	}
	return output;
    }
    public String toString(){
	// Author: DSUtin Hu
	// Date: 08-01-2015
	// Purpoes: To get the string of the linked list
	// Input: None
	// Output: THe string of the liknked list
	String output = "F: ";
	if (front != null){
	    output = output + front.toString() + " :B; Not full";
	}
	else{
	    output = output + " :B; Empty";
	}
	return output;
    }
    public boolean add (int input){
	// Author: Dustin Hu
	// Date: 08-01-2015
	// Purpose: To adda n item to the queue
	// Input: The integer to add
	// Output: True if the number's been added and false if it's not added
	boolean output = true;
	Node temp = new Node(input);
	if (this.isEmpty()){
	    this.front = temp;
	    this.back = temp;
	    
	}
	else{
	    this.back.next = temp;
	    this.back = temp;
	}
	return output;
    }
    public int remove (){
	// Author :DSUtin Hu
	// Date: 08-01-2015
	// Purpose: Remove the front
	// Input: None
	// OUtput: THe value of front
	int output;
	if (!this.isEmpty()){
	    output = this.front.data;
	    this.front = this.front.next;
	}
	else{
	    output = Integer.MIN_VALUE;
	}
	return output;
    }
}
			  
