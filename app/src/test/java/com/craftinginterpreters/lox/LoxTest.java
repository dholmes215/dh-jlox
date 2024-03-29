/*
 * Copyright (c) 2021 Robert Nystrom
 * Copyright (c) 2023 David Holmes
 * Licensed under the MIT license. See LICENSE file in the project root for details.
 */
package com.craftinginterpreters.lox;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LoxTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(originalOut);
    }

    @AfterEach
    public void resetOutput() {
        outContent.reset();
    }

    @Test
    void printHelloWorld() {
        Lox.run("print \"Hello, world!\";");
        assertEquals("Hello, world!\n", outContent.toString().replaceAll("\r\n", "\n"));
    }

    private static final String scopeTestProgram = """
            var a = "global a";
            var b = "global b";
            var c = "global c";
            {
              var a = "outer a";
              var b = "outer b";
              {
                var a = "inner a";
                print a;
                print b;
                print c;
              }
              print a;
              print b;
              print c;
            }
            print a;
            print b;
            print c;""";

    private static final String scopeTestProgramExpectedOutput = """
            inner a
            outer b
            global c
            outer a
            outer b
            global c
            global a
            global b
            global c
            """;

    /**
     * Unit test running <a href="https://craftinginterpreters.com/statements-and-state.html">the test program at the
     * end of chapter 6</a>.
     */
    @Test
    void runScopeTestProgram() {
        Lox.run(scopeTestProgram);
        assertEquals(scopeTestProgramExpectedOutput, outContent.toString().replaceAll("\r\n", "\n"));
    }
}
