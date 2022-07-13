package top.caolizhi.example.compiler.inter;

import top.caolizhi.example.compiler.lexer.Word;
import top.caolizhi.example.compiler.symbols.Type;

public class Id extends Expr {

	public int offset;     // relative address

	public Id(Word id, Type p, int b) { super(id, p); offset = b; }

//	public String toString() {return "" + op.toString() + offset;}
}
