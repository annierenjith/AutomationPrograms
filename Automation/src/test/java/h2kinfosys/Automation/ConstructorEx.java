package h2kinfosys.Automation;

public class ConstructorEx {
	int i=10;
	ConstructorEx(){
		i=20;
	}
	
	ConstructorEx(int j){
		i=j;
	}
	
	
	
	public static void main(String[] args) {
		ConstructorEx e1 = new ConstructorEx();
		System.out.println(e1.i);
		
		ConstructorEx e2 = new ConstructorEx(30);
		System.out.println(e2.i);
	}

	

}
