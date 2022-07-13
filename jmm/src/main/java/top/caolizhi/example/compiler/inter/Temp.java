package top.caolizhi.example.compiler.inter;

import top.caolizhi.example.compiler.lexer.Word;
import top.caolizhi.example.compiler.symbols.Type;

public class Temp extends Expr {

   static int count = 0;
   int number = 0;

   public Temp(Type p) { super(Word.temp, p); number = ++count; }

   public String toString() { return "t" + number; }
}
