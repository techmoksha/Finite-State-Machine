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
 * To change this template use File | Settings | File Templates.
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
     * Add a new outgoing transition to this machine.
     * @param transition : New transition to be created.
     * @return the state machine.
     */
    public <T extends FSMTransition> FSMStateMachine addOutgoingTransition(T transition);
}
