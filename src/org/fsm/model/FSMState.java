package org.fsm.model;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */
public interface FSMState {

    public void onEntry();

    public void onExit();
}
