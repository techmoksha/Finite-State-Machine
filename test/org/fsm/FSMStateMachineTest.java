package org.fsm;

import org.fsm.event.FSMEventRegistry;
import org.fsm.event.UnregisteredEventTypeException;
import org.fsm.mock.FSMEventMock1;
import org.fsm.mock.FSMEventMock2;
import org.fsm.mock.MockFSMState;
import org.fsm.model.FSMConcept;
import org.fsm.model.FSMState;
import org.fsm.model.FSMTransition;
import org.fsm.model.impl.DefaultFSMConcept;
import org.fsm.model.impl.FSMTransitionImpl;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/6/14
 * Time: 8:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class FSMStateMachineTest {

    @BeforeClass
    public static void setupBasicFSM() {
        FSMConcept concept = new DefaultFSMConcept();
        FSMStateMachine finiteStateMachine = new DefaultFSMStateMachine(concept);
        //Start adding states
        FSMState firstState = new MockFSMState("FirstState", new FSMEventMock1("E1"));
        FSMState secondState = new MockFSMState("SecondState", new FSMEventMock1("E2"));
        FSMState thirdState = new MockFSMState("ThirdState", new FSMEventMock2("E2"));
        FSMState fourthState = new MockFSMState("FourthState", new FSMEventMock1("E4"));
        FSMState fifthState = new MockFSMState("FifthState", new FSMEventMock1("E5"));

        finiteStateMachine.addStates(firstState, secondState, thirdState, fourthState, fifthState);

        //Start adding transitions
        FSMTransition startToFirstState =
                new FSMTransitionImpl(finiteStateMachine.getStartState(), firstState, FSMEventMock1.class);
        FSMTransition startToSecondState =
                new FSMTransitionImpl(finiteStateMachine.getStartState(), secondState, FSMEventMock2.class);

        FSMTransition firstToThirdState =
                new FSMTransitionImpl(firstState, thirdState, FSMEventMock1.class);
        FSMTransition secondToThirdState =
                new FSMTransitionImpl(secondState, thirdState, FSMEventMock1.class);

        FSMTransition thirdToFourthState =
                new FSMTransitionImpl(thirdState, fourthState, FSMEventMock1.class);
        FSMTransition thirdToFifthState =
                new FSMTransitionImpl(thirdState, fifthState, FSMEventMock2.class);

        FSMTransition fourthToFifthState =
                new FSMTransitionImpl(fourthState, fifthState, FSMEventMock2.class);
        FSMTransition fifthToFourthState =
                new FSMTransitionImpl(fifthState, fourthState, FSMEventMock1.class);

        FSMTransition fourthToEndState =
                new FSMTransitionImpl(fourthState, finiteStateMachine.getEndState(), FSMEventMock1.class);
        FSMTransition fifthToEndState =
                new FSMTransitionImpl(fifthState, finiteStateMachine.getEndState(), FSMEventMock2.class);

        finiteStateMachine.addOutgoingTransitions(startToFirstState, startToSecondState, firstToThirdState,
                secondToThirdState, thirdToFourthState, thirdToFifthState, fourthToFifthState,
                fifthToFourthState, fourthToEndState, fifthToEndState);

        concept.attachStateMachine(finiteStateMachine);
    }

    @Test
    public void executeBasicFSM() {
        FSMEventRegistry.INSTANCE.registerEventType("MOCK1");
        FSMEventRegistry.INSTANCE.registerEventType("MOCK2");
        //Start
        try {
            FSMEventRegistry.INSTANCE.assertEvent(new FSMEventMock1("StartEvent"));
        } catch (UnregisteredEventTypeException e) {
            e.printStackTrace();
        }
    }
}
