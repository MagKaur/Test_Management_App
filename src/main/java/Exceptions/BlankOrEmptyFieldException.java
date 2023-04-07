package Exceptions;

public class BlankOrEmptyFieldException extends Exception{
        public BlankOrEmptyFieldException (String errorMessage) {
            super(errorMessage);
        }
    }
