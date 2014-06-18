package org.fsm.model.impl;

import org.fsm.model.FSMEvent;
import org.fsm.model.FSMState;
import org.fsm.model.FSMTransition;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class FSMTransitionImpl implements FSMTransition {

    private FSMState fromState;

    private FSMState toState;

    private Class<?> triggerEventClass;

    public FSMTransitionImpl(FSMState fromState, FSMState toState, Class<?> triggerEventClass) {
        this.fromState = fromState;
        this.toState = toState;
        this.triggerEventClass = triggerEventClass;
    }

    @Override
    public FSMState getFrom() {
        return fromState;
    }

    @Override
    public FSMState getTo() {
        return toState;
    }

    public Class<?> getTriggerEventClass() {
        return triggerEventClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FSMTransitionImpl that = (FSMTransitionImpl) o;

        return fromState.equals(that.fromState) && toState.equals(that.toState) && triggerEventClass.equals(that.triggerEventClass);
    }

    @Override
    public int hashCode() {
        int result = fromState.hashCode();
        result = 31 * result + toState.hashCode();
        result = 31 * result + triggerEventClass.hashCode();
        return result;
    }
}
