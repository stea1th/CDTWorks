package demoserver;

import exceptions.KeinNameException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(mappedName = "HalloBean")
public class Hallo implements HalloRemote {

    @EJB(name = "dA")
    private DatumAuswertenLocal dA;

    @Override
    public String sagWas(String name) throws KeinNameException  {
        
        if(name==null || name.length()==0)
            throw new KeinNameException("Kein sinnvoller Name: "+ (name==null? name : "\"\""));
        
        return getBegruessung() + " " + name + ", heute ist " + dA.getWochenTag();
    }
    
    private String getBegruessung() {
        
        int hour = new GregorianCalendar().get(Calendar.HOUR_OF_DAY);
        if (hour < 11) 
            return "Guten Morgen";
        if (hour < 13) 
            return "Mahlzeit";
        if (hour < 18) 
            return "Servus";
        return "Hallo";
        
    }
}
