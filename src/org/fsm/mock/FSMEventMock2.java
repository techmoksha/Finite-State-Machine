package org.fsm.mock;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 9:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class FSMEventMock2 extends AbstractFSMEvent<Object> {

    public FSMEventMock2(Object source) {
        super(source, "MOCK2");
    }
}
