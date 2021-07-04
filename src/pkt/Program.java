package pkt;

import java.net.URISyntaxException;
import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class Program {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.print("Voltaj (11.5 - 13.5): ");
        double voltaj = in.nextDouble();
        System.out.print("Sicaklik (26 - 36): ");
        double sicaklik = in.nextDouble();
        
        try {
            Batarya b = new Batarya(voltaj,sicaklik);
            JFuzzyChart.get().chart(b.getModel());
            System.out.println(b + " %");
            
            var rules = b.getModel().getFunctionBlock("Batarya").getFuzzyRuleBlock("KuralBlok1").getRules();
            for(Rule r : rules) {
            	if(r.getDegreeOfSupport() > 0)   System.out.println(r);
            }
            
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}