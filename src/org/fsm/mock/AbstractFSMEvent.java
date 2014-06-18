package org.fsm.mock;

import org.fsm.model.FSMEvent;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 9:01 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractFSMEvent<T> implements FSMEvent<T> {

    protected T source;

    protected String eventType;

    protected AbstractFSMEvent(T source, String eventType) {
        this.source = source;
        this.eventType = eventType;
    }

    @Override
    public T getSource() {
        return source;
    }

    public String getType() {
        return eventType;
    }
}
