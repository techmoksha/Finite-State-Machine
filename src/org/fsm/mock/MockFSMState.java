package org.fsm.mock;

import org.fsm.event.FSMEventRegistry;
import org.fsm.event.UnregisteredEventTypeException;
import org.fsm.model.AbstractFSMState;
import org.fsm.model.FSMConcept;
import org.fsm.model.FSMEvent;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 8:53 PM
 *
 * A do nothing dummy implementation.
 */
public class MockFSMState extends AbstractFSMState {

    private FSMEvent eventToTrigger;

    public MockFSMState(String name,FSMEvent eventToTrigger) {
        super(name);
        this.eventToTrigger = eventToTrigger;
    }

    @Override
    public void onEntry(FSMConcept concept, FSMEvent event) {
        System.out.printf("Entry state executed for state [%s] caused by event [%s]", name, event.getSource());
        System.out.println();
        //Assert new event to get SM going
        try {
            FSMEventRegistry.INSTANCE.assertEvent(eventToTrigger);
        } catch (UnregisteredEventTypeException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onExit(FSMConcept concept, FSMEvent event) {
        System.out.printf("Exit state executed for state [%s] caused by event [%s]", name, event.getSource());
        System.out.println();
    }
}
