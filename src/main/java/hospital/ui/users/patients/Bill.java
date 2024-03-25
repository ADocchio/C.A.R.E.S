package hospital.ui.users.patients;

import hospital.ui.labs.Lab;

public class Bill {
    private final int formatSpaces = 40;

    private String labCosts (Lab[] labs){
        StringBuilder result = new StringBuilder();

        for (Lab lab : labs) {
            String s1 = lab.getName() + "(" +  lab.getTimesRun() + "x)";
            String s2 = lab.getTotalCost() +  "$\n";
            result.append(formatBill(s1, s2, formatSpaces));
        }

        return result.toString();
    }

    private String formatBill(String s1, String s2, int totalSpaces){
        StringBuilder result = new StringBuilder(s1);
        int usedSpaces = s1.length() + s2.length();

        for(int i = 0; i < totalSpaces - usedSpaces;i++){
            result.append(" ");
        }

        result.append(s2);
        return result.toString();
    }


    public String toBill(Patient patient) {
        String bill ="";
        double flateRate = 100.0;
        double dayRate = 10.0;
        double stayCost = patient.getStay().getDays() * dayRate + flateRate;
        double labsCost = 0;

        for (Lab lab : patient.getLabPanel().getLabs()) {
            labsCost += lab.getTotalCost();
        }

        bill += "Patient: " + patient.getLastName() + ", " + patient.getFirstName() + "\n";

        bill += "#################COSTS:#################\n";
        bill += formatBill("Stay: " + patient.getStay().getDays(), stayCost + "$\n", formatSpaces);

        bill += "\n-----------------LABS:------------------\n";
        bill += labCosts(patient.getLabPanel().getLabs());

        bill += "########################################\n\n";
        bill += formatBill("Insurance:", patient.getInsurancePlan(), formatSpaces);
        bill += "\n\n########################################";

        bill += "\n\n\n";
        bill += formatBill("Total:", Double.toString(labsCost + stayCost) + "$\n", formatSpaces);

        return bill;
    }
}




