package org.foi.nwtis.msimicic.eB;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.foi.nwtis.msimicic.eB.CitiesPK;
import org.foi.nwtis.msimicic.eB.Counties;
import org.foi.nwtis.msimicic.eB.ZipCodes;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-08-09T23:58:28")
@StaticMetamodel(Cities.class)
public class Cities_ { 

    public static volatile SingularAttribute<Cities, CitiesPK> citiesPK;
    public static volatile CollectionAttribute<Cities, ZipCodes> zipCodesCollection;
    public static volatile SingularAttribute<Cities, String> name;
    public static volatile SingularAttribute<Cities, Counties> counties;

}