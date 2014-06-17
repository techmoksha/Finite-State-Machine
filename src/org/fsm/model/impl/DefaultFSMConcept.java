package org.fsm.model.impl;

import org.fsm.FSMStateMachine;
import org.fsm.model.FSMConcept;

import java.util.Properties;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 2:16 PM
 * <p/>
 * Abstract representation of {@link org.fsm.model.FSMConcept} which
 * implementations can extend
 */
public class DefaultFSMConcept implements FSMConcept {

    protected String id;

    protected Properties properties;

    protected FSMStateMachine stateMachine;

    public DefaultFSMConcept() {
        this(UUID.randomUUID().toString());
    }

    public DefaultFSMConcept(String id) {
        this.id = id;
        properties = new Properties();
    }

    public DefaultFSMConcept(String id, FSMStateMachine stateMachine) {
        this.id = id;
        this.stateMachine = stateMachine;
    }

    public String getId() {
        return id;
    }

    @Override
    public Object getProperty(String property) {
        if (property == null) {
            throw new IllegalArgumentException("Property name cannot be null");
        }
        return properties.get(property);
    }

    @Override
    public void addProperty(String name, Object value) {
        if (name == null) {
            throw new IllegalArgumentException("Property name cannot be null");
        }
        properties.put(name, value);
    }
}
