package org.fsm;

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
}
