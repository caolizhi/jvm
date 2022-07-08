package top.caolizhi.example.compiler.lexer;

public class Token {

	public final int tag;

	public Token(int tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "" + (char)tag;
	}

	public static void main(String[] args) {
		Token token = new Token('&');
		System.out.println(token);
	}
}
