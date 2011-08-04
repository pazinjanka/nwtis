use nwtis_msimicic_bp_1;
INSERT INTO grupe (gr_ime,naziv) VALUES
		 ('admin','Administratori'),
		 ('manager','Manageri'),
		 ('korisnik', 'Korisnici'),
		 ('nwtis','NWTiS');

INSERT INTO korisnici_grupe (kor_ime,gr_ime) VALUES
		 ('admin','admin'),
		 ('pero','admin'),
		 ('mato','manager'),
		 ('pero','nwtis'),
		 ('ivo', 'korisnik');