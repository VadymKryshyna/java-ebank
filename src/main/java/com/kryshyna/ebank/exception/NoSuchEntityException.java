package com.kryshyna.ebank.exception;

/**
 * @author Vadym Kryshyna
 */
public class NoSuchEntityException extends DaoBusinessException {

    public NoSuchEntityException(String message) {
        super(message);
    }
}
