import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;

public class TimerAgent extends Agent {

    long launchTime = System.currentTimeMillis();

    Behaviour loop;
    protected void setup() {

        loop = new TickerBehaviour(this, 300) {
            @Override
            protected void onTick() {
                long runTime = System.currentTimeMillis() - launchTime;
                System.out.println( runTime +   ": " + myAgent.getLocalName());
                if (runTime > 60000) {
                    System.out.println("One minute elapsed, bye bye");
                    myAgent.doDelete();
                }
            }
        };
        addBehaviour(loop);
    }

}
