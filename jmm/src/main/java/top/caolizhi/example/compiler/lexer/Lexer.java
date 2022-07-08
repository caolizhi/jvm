package top.caolizhi.example.compiler.lexer;

import java.io.IOException;
import java.util.Hashtable;

import top.caolizhi.example.compiler.symbols.Type;

/**
 * 把字符串映射为字
 */
public class Lexer {

	public static int line = 1;
	char peek = ' ';
	Hashtable words = new Hashtable();

	void reserve(Word w) {
		words.put(w.lexeme, w);
	}

	public Lexer() {
		// 保留了选定的关键字
		reserve(new Word(Tag.IF, "if"));
		reserve(new Word(Tag.ELSA, "else"));
		reserve(new Word(Tag.WHILE, "while"));
		reserve(new Word(Tag.DO, "do"));
		reserve(new Word(Tag.BREAK, "break"));
		// 保留了在其他地方定义的对象的词素
		reserve(Word.True);
		reserve(Word.False);
		reserve(Type.Int);
		reserve(Type.Char);
		reserve(Type.Bool);
		reserve(Type.Float);
	}

	void readch() throws IOException {
		peek = (char)System.in.read();
	}

	boolean readch(char c) throws IOException {
		readch();
		if (peek != c) {
			return false;
		}
		peek = ' ';
		return true;
	}

	public Token scan() throws IOException {
		for( ; ; readch() ) {
			if (peek == ' ' || peek == '\t') {
				continue;
			} else if (peek == '\n') {
				line = line + 1;
			}
			else break;
		}
		switch (peek) {
			case '&':
				if (readch('&')) {
					return Word.and;
				} else
					return new Token('&');
			case '|':
				if (readch('|')) {
					return Word.or;
				} else
					return new Token('|');
			case '=':
				if (readch('=')) {
					return Word.eq;
				} else
					return new Token('=');
			case '!':
				if (readch('!')) {
					return Word.ne;
				} else
					return new Token('!');
			case '<':
				if (readch('<')) {
					return Word.le;
				} else
					return new Token('<');
			case '>':
				if (readch('>')) {
					return Word.ge;
				} else
					return new Token('>');
		}
		if (Character.isDigit(peek)) {
			int v = 0;
			do {
				v = 10 * v + Character.digit(peek, 10);
				readch();
			} while (Character.isDigit(peek));
			if(peek != '.')
				return new Num(v);
			float x = v; float d = 10;
			for (; ; ) {
				readch();
				if (!Character.isDigit(peek)) {
					break;
				}
				x = x + Character.digit(peek, 10) / d;
				d = d * 10;
			}
			return new Real(x);
		}
		if (Character.isLetter(peek)) {
			StringBuffer b = new StringBuffer();
			do {
				b.append(peek);
				readch();
			} while (Character.isLetterOrDigit(peek));
			String s = b.toString();
			Word w = (Word)words.get(s);
			if (w != null) {
			    return w;
			}
			w = new Word(Tag.ID, s);
			words.put(s, w);
			return w;
		}
		Token tok = new Token(peek);
		peek = ' ';
		return tok;
	}
}
