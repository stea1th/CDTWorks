package cmruebung.entities;

import cmruebung.entities.Locations;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-21T15:28:40")
@StaticMetamodel(Countries.class)
public class Countries_ { 

    public static volatile SingularAttribute<Countries, Short> regionId;
    public static volatile SingularAttribute<Countries, String> countryName;
    public static volatile ListAttribute<Countries, Locations> locationsList;
    public static volatile SingularAttribute<Countries, String> countryId;

}