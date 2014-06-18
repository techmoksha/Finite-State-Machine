package org.fsm.internal;

import org.fsm.model.FSMState;
import org.fsm.model.FSMTransition;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 7:18 PM
 * To change this template use File | Settings | File Templates.
 */
class FSMTransitionEdge {

    private FSMTransition wrappedTransition;

    FSMTransitionEdge(FSMTransition wrappedTransition) {
        this.wrappedTransition = wrappedTransition;
    }

    FSMTransition getWrappedTransition() {
        return wrappedTransition;
    }

    FSMState getFromState() {
        return wrappedTransition.getFrom();
    }

    FSMState getToState() {
        return wrappedTransition.getTo();
    }

    boolean matchesTriggerEventClass(Class<?> triggerEventClass) {
        return wrappedTransition.getTriggerEventClass().equals(triggerEventClass);
    }

    boolean matchesTriggerEventClass(FSMTransitionEdge anotherTransitionEdge) {
        return wrappedTransition.getTriggerEventClass().equals(anotherTransitionEdge.wrappedTransition.getTriggerEventClass());
    }
}
