package org.fsm.model;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */
public interface FSMState {

    public String getName();

    /**
     *
     * A callback where any actions may be performed once the state machine
     * enters this state.
     * @param concept : The actual object on which this FSM is attached.
     * @param event : The event causing state change into this state.
     */
    public void onEntry(FSMConcept concept, FSMEvent event);

    /**
     *
     * A callback where any actions may be performed once the state machine
     * enters this state.
     * @param concept : The actual object on which this FSM is attached.
     * @param event : The event causing state change to another state.
     */
    public void onExit(FSMConcept concept, FSMEvent event);
}
