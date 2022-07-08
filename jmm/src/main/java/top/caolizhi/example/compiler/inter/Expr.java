package top.caolizhi.example.compiler.inter;

import top.caolizhi.example.compiler.lexer.Token;
import top.caolizhi.example.compiler.symbols.Type;

/**
 * 表达式构造实现对象
 */
public class Expr extends Node {
	public Token op;
	public Type type;

	public Expr(Token tok, Type p) {
		this.op = tok;
		this.type = p;
	}
}
