package com.example.calcEngine;

import java.util.IllegalFormatCodePointException;

/**
 * Created by premkum3 on 12/28/2017.
 */
public class IllegalStatementException extends Exception {
    public IllegalStatementException(String reason, String statement) {
        super(reason + ": " + statement);
    }

    public IllegalStatementException(String reason, String statement, Throwable cause) {
        super(reason + ": " + statement, cause);
    }
}
