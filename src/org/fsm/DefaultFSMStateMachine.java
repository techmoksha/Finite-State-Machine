package org.fsm;

import org.fsm.model.impl.FSMEndState;
import org.fsm.model.impl.FSMStartState;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 2:43 PM
 *
 * Default implementation of a state machine.
 */
public class DefaultFSMStateMachine implements FSMStateMachine {

    private FSMStartState startState;

    private FSMEndState endState;

    protected DefaultFSMStateMachine() {
        //Initialize start and end state

    }

    @Override
    public FSMStartState getStartState() {
        return startState;
    }

    @Override
    public FSMEndState getEndState() {
        return endState;
    }
}
