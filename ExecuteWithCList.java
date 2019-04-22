public class ExecuteWithCList {
    
    public static void main(String[] args) {
		if((Integer.valueOf(args[0]))<1){
			System.out.println("There are children playing at the moment.");
		}else if((Integer.valueOf(args[1]))<1){
			System.out.println("The count number is negative please try again.");
		}else{
			int size = Integer.valueOf(args[0]);
			int step = Integer.valueOf(args[1]);
			
			CList<Child> ronde = new CList<Child>();
			Child C;
			for (int i=0 ; i<size; i++) {
				C = new Child("child", i+1);  
				ronde.addDataAtEnd(C);
			}
			ronde.print();
			System.out.println("------------------");
			ronde.ChildrenRonde(step);
		}
    }
}