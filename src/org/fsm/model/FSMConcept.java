package org.fsm.model;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 12:16 PM
 *
 * A statemachine is associated with an instance of a concept.
 */
public interface FSMConcept {

    /**
     *
     * Unique id for concept instance
     */
    public String getId();

    public Object getProperty(String property);

    public void addProperty(String name, Object value);
}
