package top.caolizhi.example.compiler.inter;

import top.caolizhi.example.compiler.lexer.Lexer;

/**
 * 抽象语法树中的节点类
 */
public class Node {
	int lexline = 0; // 本节点对应的构造在源程序中的行号
	Node() {
		lexline = Lexer.line;
	}

	void error(String s) {
		throw new Error("near line " + lexline + ": " + s);
	}

	static int labels = 0;

	public int newLabel() {
		return ++ labels;
	}

	public void emitLabel(int i) {
		System.out.println("L" + i + ":");
	}

	public void emit(String string) {
		System.out.println("\t" + string);
	}
}
