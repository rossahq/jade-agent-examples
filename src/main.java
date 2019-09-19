import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.core.Runtime;

public class main {

    public static void main(String[] args) {

        Profile myProfile = new ProfileImpl();
        Runtime myRuntime = Runtime.instance();
        ContainerController myContainer = myRuntime.createMainContainer(myProfile);
        try {
            AgentController rma = myContainer.createNewAgent("rma", "jade.tools.rma.rma", null);
            rma.start();

            AgentController myAgent = myContainer.createNewAgent("TimerFred", TimerAgent.class.getCanonicalName(), null);
            myAgent.start();

        } catch(Exception e) {
            System.out.println("exception!" + e.toString());
        }

    }





}
