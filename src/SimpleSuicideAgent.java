import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;

import java.util.Random;

public class SimpleSuicideAgent extends Agent {

    long launchTime = System.currentTimeMillis();

    protected void setup() {

        System.out.println("Hello! Agent " + getAID().getName() + " is ready.");
        long time = System.currentTimeMillis();
        System.out.println("and it is: " + time);

        Behaviour loop = new TickerBehaviour(this, 10000) {
            @Override
            protected void onTick() {
                long elapsedTime = System.currentTimeMillis() - launchTime;
                System.out.println("I am " + getAID().getName());

                //when elapsed time since launch is between 1 and 2 mins
                if (elapsedTime > 60000 & elapsedTime < 120000)
                    // 25% chance of committing suicide
                    if (Math.random() < 0.25) {
                    System.out.println("Goodbye cruel world!");
                    myAgent.doDelete();
                } else {
                        //cheat death
                        System.out.println("Not this time!");
                    }
            }
        };
        addBehaviour(loop);



    }
}
