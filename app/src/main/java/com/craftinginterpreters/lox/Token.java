/*
 * Copyright (c) 2021 Robert Nystrom
 * Copyright (c) 2022 David Holmes
 * Licensed under the MIT license. See LICENSE file in the project root for details.
 */
package com.craftinginterpreters.lox;

public class Token {
    final TokenType type;
    final String lexeme;
    final Object literal;
    final int line;

    Token(TokenType type, String lexeme, Object literal, int line) {
        this.type = type;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
    }

    public String toString() {
        return type + " " + lexeme + " " + literal;
    }
}
