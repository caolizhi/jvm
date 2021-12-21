package top.caolizhi.example.jvm.bytecode;

public class Bytecode01 {

	public int a = 3;
	static Integer si = 6;
	String s = "Hello World!";

	public static void main(String[] args) {
		Bytecode01 bytecode01 = new Bytecode01();
		bytecode01.a = 8;
		si = 9;
	}

	private void test() {
		this.a = a;
	}
}
