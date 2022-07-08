package top.caolizhi.example.compiler.lexer;

/**
 *  处理浮点数
 */
public class Real extends Token{

	public final float value;

	public Real(float value) {
		super(Tag.REAL);
		this.value = value;
	}

	@Override
	public String toString() {
		return "" + value ;
	}
}
