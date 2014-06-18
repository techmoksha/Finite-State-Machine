package org.fsm.event;

import org.fsm.model.FSMEvent;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 18/6/14
 * Time: 5:27 AM
 *
 * Interface to be implemented by listeners to get event notifications.
 */
public interface FSMEventListener {

    public <E extends FSMEvent<?>> void onAssert(E fsmEvent);
}
