package org.fsm.model.impl;

import org.fsm.model.FSMState;
import org.fsm.model.FSMTransition;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class FSMTransitionImpl implements FSMTransition {

    private FSMState fromState;

    private FSMState toState;

    @Override
    public FSMState getFrom() {
        return fromState;
    }

    @Override
    public FSMState getTo() {
        return toState;
    }


}
