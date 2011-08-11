package org.foi.nwtis.msimicic.eB;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.foi.nwtis.msimicic.eB.Counties;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-08-11T22:40:28")
@StaticMetamodel(States.class)
public class States_ { 

    public static volatile CollectionAttribute<States, Counties> countiesCollection;
    public static volatile SingularAttribute<States, String> name;
    public static volatile SingularAttribute<States, String> state;

}