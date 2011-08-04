package org.foi.nwtis.msimicic.eB;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.foi.nwtis.msimicic.eB.Putovanje;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-07-06T21:38:47")
@StaticMetamodel(Korisnici.class)
public class Korisnici_ { 

    public static volatile SingularAttribute<Korisnici, Date> datumPromjene;
    public static volatile CollectionAttribute<Korisnici, Putovanje> putovanjeCollection;
    public static volatile SingularAttribute<Korisnici, String> emailAdresa;
    public static volatile SingularAttribute<Korisnici, String> prezime;
    public static volatile SingularAttribute<Korisnici, String> korIme;
    public static volatile SingularAttribute<Korisnici, Integer> vrsta;
    public static volatile SingularAttribute<Korisnici, String> ime;
    public static volatile SingularAttribute<Korisnici, String> lozinka;
    public static volatile SingularAttribute<Korisnici, Date> datumKreiranja;

}