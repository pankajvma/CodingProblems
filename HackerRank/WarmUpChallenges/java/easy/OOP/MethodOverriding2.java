// https://www.hackerrank.com/challenges/java-method-overriding-2-super-keyword/problem
package hackerrank.warmupChallenges.java.easy.OOP;

class BiCycle{
	String define_me(){
		return "a vehicle with pedals.";
	}
}

class MotorCycle extends BiCycle{
	String define_me(){
		return "a cycle with an engine.";
	}
	
	MotorCycle(){
		System.out.println("Hello I am a motorcycle, I am "+ define_me());

		String temp=super.define_me(); //Fix this line

		System.out.println("My ancestor is a cycle who is "+ temp );
	}
	
}
class MethodOverriding2{
	public static void main(String []args){
		MotorCycle M=new MotorCycle();
	}
}
