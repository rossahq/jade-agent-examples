import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.core.Runtime;
import jade.wrapper.StaleProxyException;

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

            create10SuicideAgents(myContainer);


        } catch(Exception e) {
            System.out.println("exception!" + e.toString());
        }

    }

    private static void create10SuicideAgents(ContainerController myContainer) throws StaleProxyException {
        AgentController myAgent1 = myContainer.createNewAgent("Fred", SimpleSuicideAgent.class.getCanonicalName(), null);
        AgentController myAgent2 = myContainer.createNewAgent("George", SimpleSuicideAgent.class.getCanonicalName(), null);
        AgentController myAgent3 = myContainer.createNewAgent("Paul", SimpleSuicideAgent.class.getCanonicalName(), null);
        AgentController myAgent4 = myContainer.createNewAgent("Ringo", SimpleSuicideAgent.class.getCanonicalName(), null);
        AgentController myAgent5 = myContainer.createNewAgent("Robert", SimpleSuicideAgent.class.getCanonicalName(), null);
        AgentController myAgent6 = myContainer.createNewAgent("Jon", SimpleSuicideAgent.class.getCanonicalName(), null);
        AgentController myAgent7 = myContainer.createNewAgent("JohnPaul", SimpleSuicideAgent.class.getCanonicalName(), null);
        AgentController myAgent8 = myContainer.createNewAgent("Eddie", SimpleSuicideAgent.class.getCanonicalName(), null);
        AgentController myAgent9 = myContainer.createNewAgent("John", SimpleSuicideAgent.class.getCanonicalName(), null);
        AgentController myAgent10 = myContainer.createNewAgent("Frankie", SimpleSuicideAgent.class.getCanonicalName(), null);

        myAgent1.start();
        myAgent2.start();
        myAgent3.start();
        myAgent4.start();
        myAgent5.start();
        myAgent6.start();
        myAgent7.start();
        myAgent8.start();
        myAgent9.start();
        myAgent10.start();
    }


}
