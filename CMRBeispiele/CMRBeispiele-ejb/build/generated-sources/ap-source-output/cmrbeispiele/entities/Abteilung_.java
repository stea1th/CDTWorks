package cmrbeispiele.entities;

import cmrbeispiele.entities.Mitarbeiter;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-21T13:17:15")
@StaticMetamodel(Abteilung.class)
public class Abteilung_ { 

    public static volatile SingularAttribute<Abteilung, String> abtName;
    public static volatile SingularAttribute<Abteilung, String> abtNr;
    public static volatile SingularAttribute<Abteilung, String> stadt;
    public static volatile ListAttribute<Abteilung, Mitarbeiter> mitarbeiterList;

}