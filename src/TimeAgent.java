import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;

public class TimeAgent extends Agent {

    protected void setup() {
        System.out.println("Agent "+getLocalName()+" started.");

        // Add the TickerBehaviour (period 1 sec)
        addBehaviour(new TickerBehaviour(this, 480) {
            protected void onTick() {

                System.out.println("Agent "+myAgent.getLocalName()+": tick="+getTickCount());
            }
        });

        // Add the WakerBehaviour (wakeup-time 10 secs)
        addBehaviour(createWaker(10000));
    }

    private Behaviour createWaker(int timeout) {
        return new WakerBehaviour(this, timeout) {
                protected void handleElapsedTimeout() {
                    System.out.println("Agent " + myAgent.getLocalName() + ": It's wakeup-time.");
                    if (Math.random() > 0.8) {
                        System.out.println("Deleting...");
                        myAgent.doDelete();
                    } else {
                        System.out.println("Creating a new waker");
                        addBehaviour(createWaker(10000));
                    }
                }
            };
    }
}
