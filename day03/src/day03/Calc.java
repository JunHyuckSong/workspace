package day03;

public class Calc {
	
	private int res;
	
	public int getRes() {
		return res;
	}
	//생성자를 정의
	//->기본생성자 형태가 아닌 형태를 사용하고 싶다는 뜻
	public Calc(int num1, int num2, String op) {
		/*if(op.equals("+")) {
			res = num1 + num2;
		}
		else {
			res = num1 - num2;
		}*/
		res = calc(num1, num2, op);
	}
	
	public int calc(int num1, int num2, String op) {
		int res;
		if(op.equals("+")) {
			res = num1 + num2;
		}
		else {
			res = num1 - num2;
		}
		
		return res;
	}
}