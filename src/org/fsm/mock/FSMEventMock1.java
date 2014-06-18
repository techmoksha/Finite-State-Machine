package org.fsm.mock;

import org.fsm.model.FSMEvent;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 9:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class FSMEventMock1 extends AbstractFSMEvent<Object> {

    public FSMEventMock1(Object source) {
        super(source, "MOCK1");
    }
}
