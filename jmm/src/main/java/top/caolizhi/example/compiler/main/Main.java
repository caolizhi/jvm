package top.caolizhi.example.compiler.main;

import jdk.nashorn.internal.parser.Lexer;

public class Main {

	public static void main(String[] args) {
		Lexer lexer = new Lexer();
		Parse parse = new Parse(lexer);
		parse.program();
		System.out.println();
	}
}
