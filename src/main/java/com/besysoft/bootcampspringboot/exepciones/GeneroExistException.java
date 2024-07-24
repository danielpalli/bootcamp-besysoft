package com.besysoft.bootcampspringboot.exepciones;

public class GeneroExistException extends RuntimeException {
    public GeneroExistException(String message) {
        super(message);
    }

    public GeneroExistException(String message, Throwable cause){
        super(message, cause);
    }
}
