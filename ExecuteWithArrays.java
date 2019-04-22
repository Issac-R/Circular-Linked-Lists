public class ExecuteWithArrays {

    public static int ChildrenRonde(int[] C, int s) {
		
        // YOUR CODE GOES HERE
		int winner = -1;
		
		//If the Nth term is negative you cant play the game
		if(s<1){
			return -99;
		}
		//As long as there is more then one child playing the game runs
		if(C.length > 1){
			int counter = 0;
			int counter2 = 1;
			int i = 0;

			//Runs as long as the number of kids-1 dose not equal the counter
			while(counter != C.length-1){
				//If counter2 is equal to s then that is the Nth person in the list and its value is changed to -1
				if(counter2 == s){
					C[i] = -1;
					counter++;
					counter2 = 1;
				//If not it moves i to the next child
				}else{
					counter2++;
				}
				i++;
				//Makes sure i dose not pass the amount of children-1
				if(i == C.length){
						i = 0;
				}
				//Makes sure the next child has not already lost
				while(C[i] == -1){
					i++;
					if(i == C.length){
						i = 0;
					}
				}
			}
			//Finds the index of what child won and changes winner to that index plus one
			for(int j = 0; j<C.length; j++){
				if(C[j] != -1){
					winner = j + 1;
				}
			}
		//If there is only one child they are the winner
		}else if(C.length == 1){
			return 1;
		}
		//Returns the variable winner
		return winner;
    }
    
    public static void main(String[] args) {
		try{
			int size = Integer.valueOf(args[0]);
			int step = Integer.valueOf(args[1]);
			int[] children = new int[size];
			for(int i = 0; i<children.length; i++){
				System.out.println("Child: " + (i+1));
			}
			int last = ChildrenRonde(children, step);
			if(last == -1){
				System.out.println("There are no kids playing");
			}else if(last == -99){
				System.out.println("The count number is negative please try again.");
			}else{
				System.out.println("The winner is child: " + last);
			}
		}catch(Exception e){
			System.out.println("There are no children playing at the moment.");
		}
    }
}