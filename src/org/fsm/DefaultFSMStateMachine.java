package org.fsm;

import org.fsm.internal.FSMStateGraph;
import org.fsm.model.FSMState;
import org.fsm.model.FSMTransition;
import org.fsm.model.impl.FSMEndState;
import org.fsm.model.impl.FSMStartState;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 2:43 PM
 * <p/>
 * Default implementation of a state machine.
 */
public class DefaultFSMStateMachine implements FSMStateMachine {

    private FSMStateGraph stateGraph;

    protected DefaultFSMStateMachine() {
        //Initialize start and end state
        FSMStartState startState = new FSMStartState();
        FSMEndState endState = new FSMEndState();
        stateGraph = new FSMStateGraph();
        stateGraph.addState(startState);
        stateGraph.addState(endState);
    }

    @Override
    public FSMStartState getStartState() {
        return (FSMStartState) stateGraph.getState("_Start_");
    }

    @Override
    public FSMEndState getEndState() {
        return (FSMEndState) stateGraph.getState("_End_");
    }

    @Override
    public <S extends FSMState> FSMStateMachine addState(S state) {
        if (state == null) {
            throw new IllegalArgumentException("State cannot be null");
        }
        if (state.getName() == null) {
            throw new IllegalArgumentException("State name cannot be null");
        }
        stateGraph.addState(state);
        return this;
    }

    @Override
    public <T extends FSMTransition> FSMStateMachine addOutgoingTransition(T transition) {
        if (transition == null) {
            throw new IllegalArgumentException("Transition cannot be null");
        }
        if (transition.getFrom() == null) {
            throw new IllegalArgumentException("Transition cannot be from null From state");
        }
        if (transition.getTo() == null) {
            throw new IllegalArgumentException("Transition cannot be to null To state");
        }
        stateGraph.addOutgoingTransition(transition);
        return this;
    }
}
