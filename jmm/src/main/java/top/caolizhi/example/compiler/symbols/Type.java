package top.caolizhi.example.compiler.symbols;

import top.caolizhi.example.compiler.lexer.Tag;
import top.caolizhi.example.compiler.lexer.Word;

/**
 * 像 int 这样的属于保留字，映射为 Type 对象
 * 这些对象从超类中继承了字段 tag，相应的值设置为 Tag.Basic
 */
public class Type extends Word {
	public int width = 0; // width 用于存储分配

	public Type(String s, int tag, int w) {
		super(tag, s);
		width = w;
	}

	public static final Type
		Int = new Type("int", Tag.BASIC, 4),
		Float = new Type("float", Tag.BASIC, 8),
		Char = new Type("char", Tag.BASIC, 1),
		Bool = new Type("bool", Tag.BASIC, 1);

	public static boolean numberic(Type p) {
		if (p == Type.Char || p == Type.Int || p == Type.Float) {
			return  true;
		}
		return false;
	}

	public static Type max(Type p1, Type p2) {
		if (!numberic(p1) || !numberic(p2)) {
			return null;
		} else if (p1 == Type.Float || p2 == Type.Float) {
			return Type.Float;
		} else if (p1 == Type.Int || p2 == Type.Int) {
		    return Type.Int;
		} else return Type.Char;
	}
}
