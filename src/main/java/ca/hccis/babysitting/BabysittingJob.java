package ca.hccis.babysitting;

import ca.hccis.util.CisUtility;

public class BabysittingJob {

    private int yearEntered; //entered by user 2013-2025
    private int sequenceNumber;  //entered by user 0-9999
    // private String sequenceNumberString;//can hold leading 0s
    private int jobNumber;
    private int employeeCode; //1,2,3
    // private static final String BABYSITTER_1 = "Cindy";
    // private static final String BABYSITTER_2 = "Greg";
    // private static final String BABYSITTER_3 = "Marcia";
    private static final String PROMPT_BABYSITTER = "Babysitter (1-Cindy, 2-Greg, 3-Marcia)";
    private int numberOfChildrenToBeWatched;
    private int numberOfHoursInTheJob;

    private double cost;

    public BabysittingJob() {
    }

    /**
     * Process order method will calculate the cost.
     * Create a method which calculates the fee for the job.
     * Cindy is paid $7 per hour per child.
     * Greg and Marcia are paid $9 an hour for the first child, and $4 per additional hour for each additional child.
     * Examples
     * Example if Greg watches three children for two hours, he makes $17 per hour for two hours, or $34.
     * Example if Cindy watches four children for four hours, she makes $28 per hour for four hours, or $112
     *
     * @return cost
     */
    public double processJob() {

        //TODO Calculate the cost
        cost = 0;
        // if (numberOfHoursInTheJob < ) {

        // }

        return cost;
    }
        
        public void getInformation() {
        /*
        TODO 1-A four-digit year between 2013 and 2025 inclusive
        TODO 2-A job sequence number for the year between 1 and 9999 inclusive.
        Note: These two above will be used along with the year to build the job number of the object.
        job number determined by taking last two digits of the year and adding four digits of the job sequence number
        TODO 3- get last two digits of the year (modulus 100)
        - research to pad the sequence number with leading 0s
        
        TODO 4-A babysitter code of 1, 2, or 3 using PROMPT_BABYSITTER string
        TODO 5-A number of children for the job between 1 and 9 inclusive
        TODO 6-A number of hours between 1 and 12 inclusive
         */


        while (yearEntered < 2013 || yearEntered > 2025) {
            yearEntered = CisUtility.getInputInt("Enter year: ");
            if (yearEntered < 2013 || yearEntered > 2025) {
                System.out.println("Invalid year. Enter year between 2013 to 2025");
            }
        }

        while (sequenceNumber < 1 || sequenceNumber > 9999) {
            sequenceNumber = CisUtility.getInputInt("Enter sequence number: ");
            if (sequenceNumber < 1 || sequenceNumber > 9999) {
                System.out.println("Invalid sequence number. Enter sequence number between 1 and 9999");
            }
        }

        while (employeeCode < 1 || employeeCode > 3) {
            employeeCode = CisUtility.getInputInt(PROMPT_BABYSITTER);
            if (employeeCode < 1 || employeeCode > 3) {
                System.out.println("Invalid employee code. Enter employee code between 1 and 3");
            }
        }

        while(numberOfChildrenToBeWatched < 1 || numberOfChildrenToBeWatched > 9) {
            numberOfChildrenToBeWatched = CisUtility.getInputInt("Enter number of children: ");
            if (numberOfChildrenToBeWatched < 1 || numberOfChildrenToBeWatched > 9) {
                System.out.println("Invalid number of children. Enter number of children between 1 and 9");
            }
        }

        while (numberOfHoursInTheJob < 1 || numberOfHoursInTheJob > 12) {
            numberOfHoursInTheJob = CisUtility.getInputInt("Enter number of hours: ");
            if (numberOfHoursInTheJob < 1 || numberOfHoursInTheJob > 12) {
                System.out.println("Invalid number of hours. Enter number of hours between 1 and 12");
            }
        }

        constructJobNumber();
        processJob();
    }

    /**
     * to construct a job number from the last two digits of the year and the four-digit job sequential number (which might require leading zeroes).
     * For example, if the year is 2019 and the job sequence number is 35 then the job number would be 190035.
     * Example 2021 was the year and it was the 3rd job... The job number would be 210003
     *
     * @author UPDATE
     * @since 20241118
     */
    public int constructJobNumber() {
        jobNumber = ((yearEntered % 100) * 10000) + sequenceNumber;
        return jobNumber;
    }

    public double getCostOfOrder() {
        return cost;
    }


    public void display() {
        System.out.println(this.toString());
    }

    public String toString() {
        String output = ""
                + "\nCost: " + CisUtility.toCurrency(cost);
        return output;
    }


}
