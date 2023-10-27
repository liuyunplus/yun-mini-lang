package com.liuyun.lang;

import com.liuyun.lang.antlr.YunLangLexer;
import com.liuyun.lang.antlr.YunLangParser;
import com.liuyun.lang.ast.Program;
import com.liuyun.lang.entity.Environment;
import com.liuyun.lang.tools.CommonTools;
import com.liuyun.lang.visitor.ASTVisitor;
import com.liuyun.lang.visitor.ParseTreeVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

	public static void main(String[] args) throws Exception {
		String context = CommonTools.readFileToString("classpath:Example.yun");
		CharStream charStream = CharStreams.fromString(context);
		YunLangLexer lexer = new YunLangLexer(charStream);
		CommonTokenStream stream = new CommonTokenStream(lexer);
		YunLangParser parser = new YunLangParser(stream);

		YunLangParser.ProgramContext tree = parser.program();
		ParseTreeVisitor parseTreeVisitor = new ParseTreeVisitor();
		Program ast = (Program) parseTreeVisitor.visit(tree);

		ASTVisitor astVisitor = new ASTVisitor();
		Environment global = Environment.createGlobal();
		astVisitor.interpret(ast, global);
	}

}
