package org.fsm.internal;

import org.fsm.model.FSMEvent;
import org.fsm.model.FSMState;
import org.fsm.model.FSMTransition;
import org.fsm.model.impl.FSMEndState;
import org.fsm.model.impl.FSMStartState;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 7:18 PM
 *
 * Internally our FSM is represented as a graphical network
 */
public class FSMStateGraph implements Iterable<FSMState> {

    /**
     * We need frequent lookup during execution so better to use map for O(1) lookup.
     */
    private Map<String, FSMStateNode> stateNodes = new HashMap<String, FSMStateNode>();

    public <S extends FSMState> boolean addState(S state) {
        if (stateNodes.containsKey(state.getName())) {
            return false;
        }
        //Check if it already contains this state node
        FSMStateNode stateNode = new FSMStateNode(state);
        stateNodes.put(state.getName(), stateNode);
        return true;
    }

    public <T extends FSMTransition> boolean addOutgoingTransition(T transition) {
        //Get its from and to
        FSMState fromState = transition.getFrom();
        FSMState toState = transition.getTo();

        if (fromState instanceof FSMEndState || toState instanceof FSMStartState) {
            //No transitions can go out from end and no transitions can come into start
            return false;
        }

        FSMStateNode matchingFromStateNode = stateNodes.get(fromState.getName());
        FSMTransitionEdge transitionEdge = new FSMTransitionEdge(transition);

        return (matchingFromStateNode != null) &&
                matchingFromStateNode.addOutgoingEdge(transitionEdge);
    }

    public FSMState getState(String name) {
        return stateNodes.get(name).getWrappedState();
    }

    public Iterator<FSMState> iterator() {
        Collection<FSMStateNode> values = stateNodes.values();
        Collection<FSMState> states = new ArrayList<FSMState>(values.size());

        for (FSMStateNode stateNode : values) {
            states.add(stateNode.getWrappedState());
        }
        return states.iterator();
    }

    public FSMState getNextState(FSMState state, FSMEvent<?> fsmEvent) {
        FSMStateNode matchingFromStateNode = stateNodes.get(state.getName());
        FSMState nextState = null;

        if (matchingFromStateNode != null) {
            //Evaluate outgoing transitions
            for (FSMTransitionEdge outgoingEdge : matchingFromStateNode.getOutgoingEdges()) {
                if (outgoingEdge.matchesTriggerEventClass(fsmEvent.getClass())) {
                    nextState = outgoingEdge.getToState();
                    break;
                }
            }
        }
        return nextState;
    }

    public int size() {
        return stateNodes.size();
    }
}
