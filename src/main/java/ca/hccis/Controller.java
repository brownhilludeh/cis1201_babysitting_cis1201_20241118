package ca.hccis;

import ca.hccis.babysitting.BabysittingJob;
import ca.hccis.util.CisUtility;

/**
 * Controls the overall flow of the program.
 *
 * @author cis1201
 * @since 20241113
 */
public class Controller {

    private static double totalCostOfAll = 0;
    private static String allDetails = "\nJobs Details\n";

    private static String MENU = "\nA-add babysitting job\nB-show total\nC-Show all order details\nX-eXit";

    public static void main(String[] args) {

        System.out.println("Welcome to the babysitting project ("+ CisUtility.getTodayString("yyyy-MM-dd")+")");
        String option = "";
        do{
            option = CisUtility.getInputString(MENU);
            switch(option.toUpperCase()){
                case "X":
                    System.out.println("Goodbye");
                    break;
                    //Add case to add
                case "A":
                    addBabysittingJob();
                    break;
                case "B":
                    showTotal(); //Add case to show total cost
                    break;
                case "C": //Add case to show details
                    showAllJobs();

            }
        }while(!option.equalsIgnoreCase("X"));

    }

    /**
     * Add a babysitting job
     * @since 20241118
     * @author CIS1201
     */
    public static void addBabysittingJob(){
        BabysittingJob babysittingJob = new BabysittingJob();
        babysittingJob.getInformation();
        babysittingJob.display();
        allDetails += "\n"+babysittingJob.toString();
        totalCostOfAll += babysittingJob.getCostOfOrder();
    }

    /**
     * show total
     * @since 20241118
     * @author CIS1201
     */
    public static void showTotal(){
        System.out.println("The total cost of all jobs: "+ totalCostOfAll);
    }

    /**
     * show all of the details
     * @since 20241118
     * @author CIS1201
     */
    public static void showAllJobs(){
        System.out.println(allDetails);
    }

}
