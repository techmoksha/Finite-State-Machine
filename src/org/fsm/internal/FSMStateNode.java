package org.fsm.internal;

import org.fsm.model.FSMState;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 7:18 PM
 * To change this template use File | Settings | File Templates.
 */
class FSMStateNode {

    private FSMState wrappedState;

    /**
     * Transition edges which have this state node as "from" state.
     */
    private Set<FSMTransitionEdge> outgoingTransitionEdges;

    FSMStateNode(FSMState wrappedState) {
        this.wrappedState = wrappedState;
        this.outgoingTransitionEdges = new HashSet<>();
    }

    boolean addOutgoingEdge(FSMTransitionEdge fsmTransitionEdge) {
        //Same type of transition (triggering event class is same) is not allowed since it creates
        //conflicting situation.
        for (FSMTransitionEdge outgoingTransitionEdge : outgoingTransitionEdges) {
            if (outgoingTransitionEdge.matchesTriggerEventClass(fsmTransitionEdge)) {
                throw new IllegalArgumentException("Transition with this event type already exists");
            }
        }
        return outgoingTransitionEdges.add(fsmTransitionEdge);
    }

    FSMState getWrappedState() {
        return wrappedState;
    }

    Collection<FSMTransitionEdge> getOutgoingEdges() {
        return Collections.unmodifiableCollection(outgoingTransitionEdges);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FSMStateNode that = (FSMStateNode) o;

        return !wrappedState.equals(that.wrappedState);
    }

    @Override
    public int hashCode() {
        return wrappedState.hashCode();
    }
}
