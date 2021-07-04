package pkt;

import java.io.File;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.FIS;



public class Batarya {
    private FIS fis;
    private double voltaj;
    private double sicaklik;
    
    public Batarya(double voltaj, double sicaklik) throws URISyntaxException
    {
        this.voltaj = voltaj;
        this.sicaklik = sicaklik;
        
        File dosya = new File(getClass().getResource("Model.fcl").toURI());
        fis = FIS.load(dosya.getPath(),true);
        
        fis.setVariable("voltaj", voltaj);
        fis.setVariable("sicaklik", sicaklik);
        fis.evaluate();        
    }
    
    public Batarya() throws URISyntaxException
    {
        File dosya = new File(getClass().getResource("Model.fcl").toURI());
        fis = FIS.load(dosya.getPath(),true);
    }
    
    public FIS getModel() {
        return fis;
    }
    
    @Override
    public String toString() {
        String cikti = "voltaj: "+voltaj + "\nsicaklik: "+sicaklik + "\nDoluluk: "+fis.getVariable("doluluk").getValue();
        return cikti;
    }
    
}