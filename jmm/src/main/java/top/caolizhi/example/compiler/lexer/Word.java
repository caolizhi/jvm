package top.caolizhi.example.compiler.lexer;

/**
 * 管理保留字、标识符和像 && 这样的复合词法单元的词素
 */
public class Word extends Token{

	public String lexeme = "";

	public Word(int tag, String lexeme) {
		super(tag);
		this.lexeme = lexeme;
	}

	@Override
	public String toString() {
		return  lexeme;
	}

	public static final Word
		and = new Word(Tag.AND,"&&"), or = new Word(Tag.OR, "||"),
		eq = new Word(Tag.EQ, "=="), ne = new Word(Tag.NE, "!="),
		le = new Word(Tag.NE, "<="), ge = new Word(Tag.GE, ">="),
		minus = new Word(Tag.MINUS, "minus"),
		True = new Word(Tag.TRUE, "true"),
		False = new Word(Tag.FALSE, "false"),
		temp = new Word(Tag.TEMP, "t");
}
