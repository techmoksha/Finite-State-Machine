package org.fsm.internal;

import org.fsm.model.FSMState;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 7:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class FSMStateNode {

    private FSMState wrappedState;

    /**
     * Transition edges which have this state node as "from" state.
     */
    private Set<FSMTransitionEdge> outgoingTransitionEdges;

    public FSMStateNode(FSMState wrappedState) {
        this.wrappedState = wrappedState;
        this.outgoingTransitionEdges = new HashSet<FSMTransitionEdge>();
    }

    public boolean addOutgoingEdge(FSMTransitionEdge fsmTransitionEdge) {
        return outgoingTransitionEdges.add(fsmTransitionEdge);
    }

    public FSMState getWrappedState() {
        return wrappedState;
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
