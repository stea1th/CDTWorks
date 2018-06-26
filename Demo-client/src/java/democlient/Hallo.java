package democlient;

import demoserver.DatumAuswertenRemote;
import demoserver.HalloRemote;
import demoserver.WochentagUndMonatDTO;
import exceptions.KeinNameException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Hallo {

    public static void main(String[] args) throws NamingException {
        InitialContext context = new InitialContext();
        HalloRemote remote = (HalloRemote) context.lookup("HalloBean");
        try {
            System.out.println(remote.sagWas(""));
        } catch (KeinNameException e) {
            System.out.println(e.getMessage());
        }
        DatumAuswertenRemote dRemote = (DatumAuswertenRemote) context.lookup("DatumAuswertenBean");
        WochentagUndMonatDTO erg = dRemote.getWochentagUndMonatDTO();
        System.out.println(erg.getMonat() + " " + erg.getWochenTag());
    }

}
