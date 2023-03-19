/*
 * Copyright (c) 2021 Robert Nystrom
 * Copyright (c) 2023 David Holmes
 * Licensed under the MIT license. See LICENSE file in the project root for details.
 */
package com.craftinginterpreters.lox;

public class Return extends RuntimeException {
    final Object value;

    public Return(Object value) {
        super(null, null, false, false);
        this.value = value;
    }
}
