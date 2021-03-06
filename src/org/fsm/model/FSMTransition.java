package org.fsm.model;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */
public interface FSMTransition {

    /**
     *
     * The transition From state. Will be null for start state
     *
     */
    public FSMState getFrom();

    /**
     *
     * Transition To State. Will be null for end state
     * and will be same as from state for self transition.
     */
    public FSMState getTo();

    /**
     * Every transition depicts a relation which is
     * captured by the event that triggered it.
     * <p>
     *     Here the class of that event is used to
     *     depict the named relation.
     * </p>
     * @see org.fsm.model.FSMEvent
     */
    public Class<?> getTriggerEventClass();
}
