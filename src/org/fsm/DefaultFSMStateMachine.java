package org.fsm;

import org.fsm.event.FSMEventListener;
import org.fsm.event.FSMEventRegistry;
import org.fsm.internal.FSMStateGraph;
import org.fsm.model.FSMConcept;
import org.fsm.model.FSMEvent;
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
public class DefaultFSMStateMachine implements FSMStateMachine, FSMEventListener {

    /**
     * The concept for which this state machine runs.
     */
    private FSMConcept concept;

    private FSMStateGraph stateGraph;

    /**
     * This keeps track of current state this machine is in.
     */
    private FSMState currentState;

    public DefaultFSMStateMachine(FSMConcept concept) {
        this.concept = concept;
        initialize();
    }

    /**
     * Subclasses are not expected to override this since
     * it may change the way the FSM is constructed.
     */
    void initialize() {
        //Initialize start and end state
        FSMStartState startState = new FSMStartState();
        FSMEndState endState = new FSMEndState();
        stateGraph = new FSMStateGraph();
        stateGraph.addState(startState);
        stateGraph.addState(endState);
        //Current state to start
        currentState = startState;

        FSMEventRegistry.INSTANCE.addEventListener(this);
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

    @Override
    @SuppressWarnings("unchecked")
    public <S extends FSMState> FSMStateMachine addStates(S... states) {
        for (S state : states) {
            addState(state);
        }
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends FSMTransition> FSMStateMachine addOutgoingTransitions(T... transitions) {
        for (T transition : transitions) {
            addOutgoingTransition(transition);
        }
        return this;
    }

    @Override
    public FSMState getCurrentState() {
        return currentState;
    }

    @Override
    public <E extends FSMEvent<?>> void onAssert(E fsmEvent) {
        FSMState nextState = stateGraph.getNextState(currentState, fsmEvent);
        if (nextState != null) {
            FSMState previousState = currentState;
            //Make this next state current
            currentState = nextState;
            //Execute exit action of previous state and entry of next state
            previousState.onExit(concept, fsmEvent);
            currentState.onEntry(concept, fsmEvent);
        }
    }
}
