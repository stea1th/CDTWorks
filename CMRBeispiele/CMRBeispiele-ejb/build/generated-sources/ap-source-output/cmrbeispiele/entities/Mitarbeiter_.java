package cmrbeispiele.entities;

import cmrbeispiele.entities.Abteilung;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-21T13:17:16")
@StaticMetamodel(Mitarbeiter.class)
public class Mitarbeiter_ { 

    public static volatile SingularAttribute<Mitarbeiter, Integer> mNr;
    public static volatile SingularAttribute<Mitarbeiter, Abteilung> abteilung;
    public static volatile SingularAttribute<Mitarbeiter, String> mName;
    public static volatile SingularAttribute<Mitarbeiter, String> mVorname;
    public static volatile SingularAttribute<Mitarbeiter, String> wohnort;

}