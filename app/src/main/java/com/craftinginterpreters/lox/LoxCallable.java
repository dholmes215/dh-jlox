/*
 * Copyright (c) 2021 Robert Nystrom
 * Copyright (c) 2023 David Holmes
 * Licensed under the MIT license. See LICENSE file in the project root for details.
 */
package com.craftinginterpreters.lox;

import java.util.List;

public interface LoxCallable {
    int arity();
    Object call(Interpreter interpreter, List<Object> arguments);
}
