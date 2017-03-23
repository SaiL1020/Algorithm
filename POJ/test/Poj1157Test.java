import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Poj1157Test {

    @Test
    // Reference: Just one line it [blog]
    // http://one-line-it.blogspot.com/2013/05/java-testing-with-stdin-and-stdout.html
    public void test0() {
        String input = "3 5\n" +
                "-7 -23 -5 -24 -16\n" +
                "-5 -21 -4 -10 -23\n" +
                "-21 -5 -4 -20 -20";
        String expected = "-31";

        // set stdin
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // set stdout
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        new Poj1157().main(null);

        Assert.assertEquals(expected, baos.toString().trim());
    }
/*
    @Test(timeout=2000)
    public void test1() {
        String s = "()()()";
        assertEquals(1, new Poj1157().getDepth(s));
    }

    @Test(timeout=2000)
    public void test2() {
        String s = "(())()";
        assertEquals(2, new Poj1157().getDepth(s));
    }

    @Test(timeout=2000)
    public void test3() {
        String s = "((())())(((())(()))())";
        assertEquals(4, new Poj1157().getDepth(s));
    }

    @Test(timeout=2000)
    public void test4() {
        String s = "()";
        assertEquals(1, new Poj1157().getDepth(s));
    }
*/
}
