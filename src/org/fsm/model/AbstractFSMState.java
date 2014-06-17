package org.fsm.model;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractFSMState implements FSMState {

    protected String name;

    protected AbstractFSMState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractFSMState that = (AbstractFSMState) o;

        return !name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("name='").append(name);
        return sb.toString();
    }
}
