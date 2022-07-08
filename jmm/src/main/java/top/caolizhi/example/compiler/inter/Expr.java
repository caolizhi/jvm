package top.caolizhi.example.compiler.inter;

import top.caolizhi.example.compiler.lexer.Token;
import top.caolizhi.example.compiler.symbols.Type;

/**
 * 表达式构造实现对象
 */
public class Expr extends Node {
	public Token op; // 表示抽象语法树节点上的运算符
	public Type type; // 表示抽象语法树节点上的类型

	public Expr(Token tok, Type p) {
		this.op = tok;
		this.type = p;
	}

	/**
	 * 返回了一个项，该项可以称为一个三地址指令的右部
	 * 比如： E = E1 + E2，gen() 返回一个项 x1 + x2，x1 和 x2 分别是存放 E1 和 E2 值的地址。
 	 */
	public Expr gen() {
		return this;
	}

	/**
	 *
	 * 把一个表达式计算成为一个单一的地址
	 */
	public Expr reduce() {
		return this;
	}

	public void jumping(int t, int f) {
		emitJumps(toString(), t, f);
	}

	public void emitJumps(String test, int t, int f) {
		if (t != 0 && f != 0) {
			emit("if " + test + " goto L" + t);
			emit("goto L" + f);
		} else if (t != 0) {
			emit("if " + test + " goto L" + t);
		} else if (f != 0) {
			emit("iffalse " + test + " goto L" + f);
		}else ;// 不生成指令，t 和 f 都直接穿越
	}

	@Override
	public String toString() {
		return op.toString();
	}
}
