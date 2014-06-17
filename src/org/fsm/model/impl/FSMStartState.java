package org.fsm.model.impl;

import org.fsm.model.AbstractFSMState;
import org.fsm.model.FSMConcept;
import org.fsm.model.FSMEvent;
import org.fsm.model.FSMState;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 2:45 PM
 * To change this template use File | Settings | File Templates.
 */
public final class FSMStartState extends AbstractFSMState {

    public FSMStartState() {
        super("_Start_");
    }

    @Override
    public void onEntry(FSMConcept concept, FSMEvent event) {

    }

    @Override
    public void onExit(FSMConcept concept, FSMEvent event) {

    }
}
