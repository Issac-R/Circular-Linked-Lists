/*************************************************************************
 * This class is for a circular linked list. You will notice that it has 
 * the same attributes as in a regular linked list. What will be different 
 * though is the way we manipulate the list.
 * Also, instead of calling a node the head, we call it start since there 
 * is no more head of the list
 *************************************************************************/ 

public class CList<T> {
    private Node<T> start;
    private int size;
    
    // CONSTRUCTORS ******************************************************
    public CList() {}
    
    // TODO 1: Complete the following constructor that takes a node as a parameter
    // Pre-condition: N is a single node
    public CList(Node<T> N) { 
        // YOUR CODE GOES HERE...
		start = N;
		size = N.sizeFromNode();
		start.setNext(start);
    }
    
    // SETTERS ***********************************************************
    // TODO 2: Write a setter method for setting the attribute start:
    // YOUR CODE (INCLUDING THE SIGNATURE) GOES HERE...
	public void setStart(Node<T> N){
		start = N;
		size = N.sizeFromNode();
		start.setNext(start);
	}
    
    // no setter for the size since it is a consequence of other methods
        
    // GETTERS ***********************************************************
    // TODO 3 & TODO 4: Write a getter method for accessing each of the attributes:
    // YOUR CODE (INCLUDING SIGNATURE) GOES HERE...
	public Node<T> getStart(){
		return start;
	}

	public int getSize(){
		return size;
	}
    
    // OTHER METHODS *****************************************************
    
    // ADDING NODES OR SEQUENCES OF NODES ////////////////////////////////
    /* Method addAtEnd: 
     *      Takes a node N 
     *      Adds it to the circle "at the end", i.e., just before start.
     *      Notes: 1/ take into account when the list is null
     *          2/ Make sure to update the size
     ********************************************************************/
    public void addAtEnd(Node<T> N) {
        // YOUR CODE GOES HERE...
		size += N.sizeFromNode();
		if(start == null){
			setStart(N);
		}else{
			Node<T> iter = start.getNext();
			while(iter.getNext() != start){
				iter = iter.getNext();
			}
			iter.setNext(N);
			N.setNext(start);
		}
    }
    
    /* Method addDataAtEnd: 
     *      Takes data of type T 
     *      Creates a node that contains T
     *      Adds it to the circle "at the end", i.e., just before start.
     *      Notes: 1/ take into account when the list is null
     *          2/ Make sure to update the size
     ********************************************************************/
    public void addDataAtEnd(T data) {
        // YOUR CODE GOES HERE...
		Node<T> iter = new Node<T>(data);
		if(start == null){
			setStart(iter);
		}else{
			addAtEnd(iter);
		}
    }
    
    /* Method addAtStart: 
     *      Takes a node N 
     *      Adds it to the circle just before det and makes it the new start.
     *      Notes: 1/ take into account when the list is null
     *          2/ Make sure to update the size
     ********************************************************************/
    public void addAtStart(Node<T> N) {
        // YOUR CODE GOES HERE...
		size += N.sizeFromNode();
		if(start != null){
			Node<T> iter = N;
			Node<T>	iter2 = start;
			while(iter2.getNext() != start){
				iter2 = iter2.getNext();
			}
			iter.setNext(start);
			start = iter;
			iter2.setNext(start);
		}else{
			setStart(N);
		}
    }
    
    /* Method addAtLocation: 
     *      Takes a node N and an integer n
     *      Adds N to the circle just after the n-th node in the circle
     *          (where start is the first node)
     *      Notes: 1/ take into account when the list is null or has 
     *          less than n nodes
     *          2/ Make sure to update the size
     ********************************************************************/
    public void addAtLocation(Node<T> N, int n) {
        // YOUR CODE GOES HERE...
		size += N.sizeFromNode();
		if(size == 0){
			setStart(N);
		}else if(size<=n){
			addAtEnd(N);
		}else{
			Node<T> iter = start;
			for(int i = 0; i<n-1; i++){
				iter = iter.getNext();
			}
			Node<T> temp = iter.getNext();
			iter.setNext(N);
			N.setNext(temp);
		}
    }   
    
    /* Method addMultiAtEnd: 
     *      Similar to addAtEnd
     *      But adds N along with its possible sequence of following nodes
     ********************************************************************/
    public void addMultiAtEnd(Node<T> N) {
        // YOUR CODE GOES HERE...
		size += N.sizeFromNode();
		if(start == null){
			setStart(N);
		}else{
			Node<T> iter = start;
			while(iter.getNext() != start){
				iter = iter.getNext();
			}
			Node<T> iter2 = N;
			while(iter2.getNext() != null){
				iter2 = iter2.getNext();
			}
			iter.setNext(N);
			iter2.setNext(start);
		}		
    }
    
    /* Method addMultiAtStart: 
     *      Similar to addAtStart
     *      But adds N along with its possible sequence of following nodes
     ********************************************************************/
    public void addMultiAtStart(Node<T> N) {
        // YOUR CODE GOES HERE...
		size += N.sizeFromNode();
		if(start == null){
			setStart(N);
		}else{
			Node<T> iter = start;
			while(iter.getNext() != start){
				iter = iter.getNext();
			}
			Node<T> iter2 = N;
			while(iter2.getNext() != null){
				iter2 = iter2.getNext();
			}
			iter2.setNext(start);
			start = N;
			iter.setNext(start);
		}
    }
    
    /* Method addMultiAtLocation: 
     *      Similar to addAtLocation
     *      But adds N along with its possible sequence of following nodes
     ********************************************************************/
    public void addMultiAtLocation(Node<T> N, int n) {
        // YOUR CODE GOES HERE...
		size += N.sizeFromNode();
		if(start == null){
			Node<T> iter = N;
			while(iter.getNext() != null){
				iter = iter.getNext();
			}
			start = N;
			iter.setNext(start);
		}else if(size < n){
			addMultiAtEnd(N);
		}else{
			Node<T> iter = start;
			for(int i = 0; i<n-1; i++){
				iter = iter.getNext();
			}
			Node<T> iter2 = iter.getNext();
			Node<T> iter3 = N;
			while(iter3.getNext() != null){
				iter3 = iter3.getNext();
			}
			iter.setNext(N);
			iter3.setNext(iter2);
		}
    }   
    
    // REMOVING NODES OR SEQUENCES OF NODES ////////////////////////////////

    /* Method removeStart: 
     *      Removes the start node
     *      Makes the next node in sequence the start
     *  Notes: 1/ take into account the case where the list is empty or 
     *      has only one node
     *      2/ do not forget to update the value of size
     ********************************************************************/
    public void removeStart() {
        // YOUR CODE GOES HERE...
		if(start == null){
		}else if(size == 1){
			start = null;
			size--;
		}else{
			Node<T> iter = start.getNext();
			Node<T> iter2 = start;
			while(iter2.getNext() != start){
				iter2 = iter2.getNext();
			}
			start = iter;
			iter2.setNext(start);
			size--;
		}
    }
    
    /* Method removeLast: 
     *      Removes the node just before start in the circle (i.e., the last node)
     *  Notes: 1/ take into account the case where the list is empty or 
     *      has only one node
     *      2/ do not forget to update the value of size
     ********************************************************************/
    public void removeLast() {
        // YOUR CODE GOES HERE...
		if(start == null){
		}else if(size == 1){
			start = null;
			size--;
		}else if(size == 2){
			start.setNext(start);
			size--;
		}else{
			Node<T> iter = start;
			while(iter.getNext().getNext() != start){
				iter = iter.getNext();
			}
			iter.setNext(start);
			size--;
		}
    }
    
    /* Method removeNode: 
     *      Takes a node N
     *      Removes this node N from the list if it is in the list
     *  Notes: 1/ take into account the case where N is not in the list,
     *      or the list is empty 
     *      2/ do not forget to update the value of size if relevant
     ********************************************************************/
    public void removeNode(Node<T> N) {
        // YOUR CODE GOES HERE...
		if(start == null){
		}else{
			Node<T> iter = start;
			Node<T> iter2 = N;
			Node<T> temp = null;
			if(iter == iter2){
				removeStart();
			}else{
				iter = start;
				while(iter.getNext() != start){
					if(iter.getNext() == iter2){
						temp = iter.getNext().getNext();
						iter.setNext(temp);
						size--;
						break;
					}else{
						iter = iter.getNext();
					}
				}
			}
		}
    }
    
    /* Method removeLocation: 
     *      Takes an integer n
     *      Removes the n-th node from the list if there is such a node
     *  Notes: 1/ take into account the case there are fewer nodes than n
     *      in the list
     *      2/ do not forget to update the value of size if relevant
     ********************************************************************/
    public void removeLocation(int n) {
        // YOUR CODE GOES HERE...
		if(size<n){
		}else{
			Node<T> iter = start;
			for(int i = 1; i<n; i++){
				iter = iter.getNext();
			}
			Node<T> iter2 = iter.getNext().getNext();
			iter.setNext(iter2);
			size--;
		}
    }
	
    // PRINTING THE CONTENT OF A CLIST //////////////////////////////////
    /* Method print: 
     *      Prints every element of the circle once
     *      Prints "There is nothing to print" if the list is empty
     ********************************************************************/
    public void print() {
        // YOUR CODE GOES HERE...
		if(size == 0){
			System.out.println("There is nothing to print");
		}else{
			Node<T> iter = start.getNext();
			start.printNode();
			while(iter != start){
				iter.printNode();
				iter = iter.getNext();
			}
		}
    }
    
    /*******************************************************************/
    /* Method: ChildrenRonde: 
     * It applies to a circular linked list and takes an integer s 
     *      (given a CList L, you will call it as L.ChildrenRonde(s)). 
     * It successively removes every s-th child from the circle until 
     *      only one child is left. 
     * It does not return anything, but it directly modifies the list 
     *      of children, which contains only one child at the end of 
     *      the game, the winner. 
     * NOTE: make sure to handle special cases like when the list may
     *      be empty
     * ALSO: if the list contains only one element, print out:
     *      "There is only one element remaining: "
     *      and then print the node (its content) using the appropriate
     *      method
     *******************************************************************/
    public void ChildrenRonde(int s) {
        // YOUR CODE GOES HERE...
		//Creates a pointer to the start of the linked list so where know where to start
		Node<T> iter = start;
		//Runs as long as the size of the list is greater then one 
		while(size > 1){
			//Changes i to the Nth child in the list
			for(int i = 1; i<s; i++){
				iter = iter.getNext();
			}
			//Creates a temp node to keep track of where we left off and who will be next after the node is removed
			Node<T> temp = iter.getNext();
			removeNode(iter);
			iter = temp;
		}
		//At this point only one Node is in the list and the winner will be printed
		System.out.print("Winner: ");
		print();
    }

}