package org.fsm.internal;

import org.fsm.model.FSMTransition;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 7:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class FSMTransitionEdge {

    private FSMTransition wrappedTransition;

    public FSMTransitionEdge(FSMTransition wrappedTransition) {
        this.wrappedTransition = wrappedTransition;
    }

    public FSMTransition getWrappedTransition() {
        return wrappedTransition;
    }
}
