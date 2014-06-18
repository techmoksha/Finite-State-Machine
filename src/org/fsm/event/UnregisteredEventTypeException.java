package org.fsm.event;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 18/6/14
 * Time: 6:06 AM
 *
 * Thrown when event whose type is unregistered is used.
 */
public class UnregisteredEventTypeException extends Exception {

    public UnregisteredEventTypeException(String message) {
        super(message);
    }
}
