package org.fsm.model;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 12:01 PM
 *
 * The {@link org.fsm.FSMStateMachine} is an event driven Finite State Machine.
 * Events trigger state changes, so events also depict a named state transition.
 *
 */
public interface FSMEvent<T> {

    /**
     * Any source which resulted in this event creation.
     *
     */
    public T getSource();

    /**
     * A unique String to denote event type.
     */
    public String getType();
}
