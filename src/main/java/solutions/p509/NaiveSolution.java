package solutions.p509;

import markdown.MarkdownUtils;

public class NaiveSolution {

    public int fib(int n) {

        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);

    }

    public static void main(String [] args){
        MarkdownUtils.printMarkdownToConsole("int fib(int n) {\n" +
                "    if (n <= 1) return n;\n" +
                "    return fib(n - 1) + fib(n - 2);\n" +
                "}\n");
    }
}
