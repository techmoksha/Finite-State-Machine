package org.fsm;

import org.fsm.model.FSMState;
import org.fsm.model.FSMTransition;
import org.fsm.model.impl.FSMEndState;
import org.fsm.model.impl.FSMStartState;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 12:21 PM
 *
 * Abstract representation of a Finite State Machine.
 */
public interface FSMStateMachine {

    public FSMStartState getStartState();

    public FSMEndState getEndState();

    /**
     * Add a new state to this machine.
     * @param state : New state to be added.
     * @return the state machine.
     */
    public <S extends FSMState> FSMStateMachine addState(S state);

    /**
     * Bulk add new states to this machine.
     * @param states : New states to be added.
     * @return the state machine.
     */
    public <S extends FSMState> FSMStateMachine addStates(S... states);

    /**
     * Add a new outgoing transition to this machine.
     * @param transition : New transition to be created.
     * @return the state machine.
     */
    public <T extends FSMTransition> FSMStateMachine addOutgoingTransition(T transition);

    /**
     * Buld Add new outgoing transitions to this machine.
     * @param transitions : New transitions to be created.
     * @return the state machine.
     */
    public <T extends FSMTransition> FSMStateMachine addOutgoingTransitions(T... transitions);

    /**
     *
     * Denotes current state this FSM is in.
     * <p>
     *     TODO Support multiple states concurrently.
     * </p>
     */
    public FSMState getCurrentState();
}
