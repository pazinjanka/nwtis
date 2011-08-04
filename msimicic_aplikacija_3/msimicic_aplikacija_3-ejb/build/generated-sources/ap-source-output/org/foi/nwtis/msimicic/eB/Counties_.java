package org.foi.nwtis.msimicic.eB;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.foi.nwtis.msimicic.eB.Cities;
import org.foi.nwtis.msimicic.eB.CountiesPK;
import org.foi.nwtis.msimicic.eB.States;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-07-06T21:38:47")
@StaticMetamodel(Counties.class)
public class Counties_ { 

    public static volatile SingularAttribute<Counties, CountiesPK> countiesPK;
    public static volatile SingularAttribute<Counties, String> name;
    public static volatile SingularAttribute<Counties, States> states;
    public static volatile CollectionAttribute<Counties, Cities> citiesCollection;

}