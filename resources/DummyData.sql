USE `deviceguru`;


INSERT INTO `deviceguru`.`devicelogins` (`email`, `password`) VALUES
  ('e1@mail.com', 'password'),
  ('e2@mail.com', 'password'),
  ('e3@mail.com', 'password'),
  ('e4@mail.com', 'password'),
  ('e5@mail.com', 'password'),
  ('e6@mail.com', 'password'),
  ('e7@mail.com', 'password'),
  ('e8@mail.com', 'password'),
  ('e9@mail.com', 'password'),
  ('e10@mail.com', 'password'),
  ('e11@mail.com', 'password'),
  ('e12@mail.com', 'password'),
  ('e13@mail.com', 'password'),
  ('e14@mail.com', 'password'),
  ('e15@mail.com', 'password'),
  ('e16@mail.com', 'password'),
  ('e17@mail.com', 'password'),
  ('e18@mail.com', 'password'),
  ('admin', 'ghost123'),
  ('Fusce@etlacinia.org', 'secureLogin'),
  ('vel@vitaeerat.edu', 'MySweetHeaven'),
  ('metus.In@parturientmontesnascetur.ca', '34fdsfj45');



INSERT INTO `devices` (`serialnumber`, `type`) VALUES
  ('97268858399', 'iPad'),
  ('98712211899', 'iPad'),
  ('3242480324', 'iPad'),
  ('98345943539', 'iPad'),
  ('23465474564', 'iPad'),
  ('45633634456', 'iPad'),
  ('30987654322', 'iPad'),
  ('98765432323', 'iPad'),
  ('23435678543', 'iPad'),
  ('34546738433', 'iPad'),
  ('66598765432', 'iPad'),
  ('1234560324', 'iPad'),
  ('9872487204', 'iPad'),
  ('43254565474', 'ChromeBook'),
  ('56546543454', 'ChromeBook'),
  ('64554645455', 'ChromeBook'),
  ('95567567575', 'ChromeBook'),
  ('87654325999', 'ChromeBook'),
  ('35697234246', 'ChromeBook'),
  ('65436545553', 'ChromeBook'),
  ('98765432123', 'ChromeBook');


INSERT INTO `students` (`firstname`, `lastname`, `class`, `serialnumber`, `email`) VALUES
('Nynne', 'Hirksholm', '1a', '3242480324', 'e1@mail.com'),
('Cassandra', 'Sauersen', '1b', '98345943539', 'e2@mail.com'),
('Bjarne', 'Hirksholm', '1b', '23465474564', 'e3@mail.com'),
('Bolette', 'Lundbæk', '2a', '45633634456', 'e4@mail.com'),
('Charles', 'Hailstone', '2a', '30987654322', 'e5@mail.com'),
('Sigurd', 'Gaudi', '2b', '30987654322', 'e6@mail.com'),
('Ulrik', 'Malto', '2c', '98765432323', 'e7@mail.com'),
('Laura', 'Beton', '2c', '23435678543', 'e8@mail.com'),
('Miguel', 'Sanchez', '3a', '34546738433', 'e9@mail.com'),
('Perle', 'Bamsebratt', '3a', '66598765432', 'e10@mail.com'),
('Nynne', 'Sofiesen', '5a', '43254565474', 'e11@mail.com'),
('Casbian', 'Petter', '5b', '56546543454', 'e12@mail.com'),
('Mugtuk', 'Huggersen', '5b', '64554645455', 'e13@mail.com'),
('Morten', 'Lundbæk', '5x', '95567567575', 'e14@mail.com'),
('Christian', 'Beton', '5x', '87654325999', 'e15@mail.com'),
('Jørgen', 'Jensen', '6a', '35697234246', 'e16@mail.com'),
('Kunuk', 'Kleine', '6a', '65436545553', 'e17@mail.com'),
('Sofia', 'Belstad', '6a', '98765432123', 'e18@mail.com')
;


INSERT INTO `personel` (`firstname`, `lastname`, `device`, `email`) VALUES
  ('Catarina','Ericsson','97268858399','vel@vitaeerat.edu'),('Daniel','Svensson','98712211899','metus.In@parturientmontesnascetur.ca');

  #,('Per','Carlsson','87385748499','cursus.a.enim@interdumfeugiatSed.ca'),('Erik','Andersson','04553707299','Vivamus.nisi@idenimCurabitur.com'),('Christian','Carlsson','29411142099','placerat.orci.lacus@at.co.uk'),('Henrik','Persson','12551303299','sapien.molestie.orci@et.edu'),('Eleonor','Samuelsson','12640986999','facilisis.Suspendisse.commodo@utipsumac.com'),('Sofia','Eriksson','20757414899','Etiam.bibendum@laciniaorciconsectetuer.edu'),('Pär','Svensson','78750888699','Suspendisse.ac.metus@Phasellusdolor.net'),('Thomas','Staffansson','81593290099','Donec.porttitor@egetodio.ca'),('Märta','Staffansson','54432666699','fames@gravidamolestie.co.uk'),('Peter','Staffansson','73454279499','mus.Proin@sedpedeCum.net'),('Camilla','Persson','02213341499','gravida@arcu.ca'),('Sanna','Bodin','59607508799','dui.Fusce@hendreritneque.org'),('Christian','Carlsson','03955097499','nisi@maurisipsumporta.org'),('Per','Carlsson','26450159999','magna@vulputate.ca'),('Sofia','Ericsson','15993676299','tellus.sem.mollis@Mauris.com'),('Anna','Staffansson','24737773899','Quisque.ornare@ornare.ca'),('Anders','Carlsson','95252656899','feugiat@Donec.edu'),('Pär','Staffansson','49778856499','erat@lacusUt.net'),('Sofia','Svensson','34745190599','nulla.magna.malesuada@Duisa.net'),('Sanna','Persson','75294320799','velit@Sedeueros.co.uk'),('Catarina','Karlsson','87805545099','convallis.convallis.dolor@Maecenasliberoest.org'),('Erik','Andersson','28256062099','Mauris.magna.Duis@risusodioauctor.co.uk'),('Camilla','Carlsson','31954134099','Curabitur.massa@luctus.com'),('Per','Ericsson','95553028099','purus.Nullam@iaculisodio.ca'),('Erica','Andersson','39978973099','gravida.molestie.arcu@massa.co.uk'),('Erika','Karlsson','55958563499','enim@turpis.co.uk'),('Anders','Staffansson','28448409599','Vivamus.sit.amet@magnaPhasellusdolor.org'),('Erik','Carlsson','63871591899','Mauris.eu@enim.net'),('Stefan','Bodin','03752247599','ut.pellentesque.eget@dui.co.uk'),('Stefan','Carlsson','23739014499','Cras.convallis@vitaediamProin.net'),('Sara','Andersson','32441176799','habitant.morbi@nonduinec.ca'),('Erica','Samuelsson','25441257099','rutrum.non.hendrerit@nisl.co.uk'),('Emma','Persson','42650452099','augue.id.ante@enimnisl.ca'),('Tomas','Bodin','85327677299','Mauris@quisarcuvel.com'),('Erik','Karlsson','00426315299','vulputate.eu@nequeetnunc.edu'),('Eva','Carlsson','82426695899','consequat.lectus@nonjusto.org'),('Christian','Svensson','31698591399','Suspendisse@perconubianostra.ca'),('Daniel','Svensson','36930343499','dui.semper.et@non.ca'),('Thomas','Samuelsson','33464824199','Nullam.feugiat.placerat@ullamcorperDuiscursus.ca'),('Per','Ericsson','26871953399','Morbi.metus.Vivamus@dolornonummyac.ca'),('Lisa','Eriksson','56468987399','posuere.at.velit@eratVivamusnisi.ca'),('Erik','Persson','82700787699','Nulla.dignissim.Maecenas@Innecorci.net'),('Maria','Samuelsson','08267396999','et.magna.Praesent@mauris.co.uk'),('Fredrik','Samuelsson','52499770499','placerat@estac.edu'),('Stefan','Carlsson','30313339199','lacinia.orci@ipsum.ca'),('Märta','Samuelsson','48224841799','placerat.augue.Sed@ultricesiaculis.edu'),('Christian','Ericsson','13906857499','Quisque@orcilacus.org'),('Sara','Persson','98308381299','massa.lobortis@tempuseuligula.co.uk'),('Stefan','Carlsson','26605242499','ac@duiFuscediam.org'),('Silvia','Carlsson','55751818599','convallis.in.cursus@acfermentum.org'),('Erika','Ericsson','03755082099','velit.Sed@semsemper.edu'),('Thomas','Carlsson','75558327999','feugiat@risus.org'),('Elena','Persson','20534117299','Mauris.nulla@Duis.com'),('Fredrik','Staffansson','73491189999','Suspendisse.aliquet@Morbi.net'),('Sofia','Svensson','34427030699','Cum@Nuncmauris.ca'),('Pär','Carlsson','37901055399','ac@dignissimlacusAliquam.net'),('Thomas','Bodin','70866746099','sociis.natoque.penatibus@Curabitur.com'),('Per','Svensson','98319676999','consectetuer@ligula.ca'),('Camilla','Bodin','41277946999','Proin@gravidaAliquamtincidunt.co.uk'),('Sanna','Bodin','49665955599','Praesent@nullaDonec.ca'),('Henrik','Karlsson','16697939199','Aenean.eget.metus@rutrumjusto.net'),('Pär','Karlsson','39252049099','sodales.elit.erat@rhoncusProin.com'),('Stefan','Staffansson','48767556199','Donec.vitae@Proindolor.net'),('Märta','Staffansson','59924517699','Curabitur.egestas@arcuVivamus.co.uk'),('Sara','Bodin','12754197399','non@suscipitest.net'),('Thomas','Svensson','35541746699','euismod.urna@adipiscing.com'),('Sanna','Svensson','96300528899','consequat.enim@id.co.uk'),('Per','Andersson','43452095999','magna.Sed.eu@nonummyFuscefermentum.org'),('Erik','Carlsson','70909001599','velit.justo@Duissitamet.com'),('Anders','Ericsson','47766491799','vitae@semmagna.ca'),('Märta','Bodin','57975575999','est.mollis.non@tinciduntnibhPhasellus.edu'),('Erik','Bodin','81682960399','ligula.Nullam@risus.com'),('Emma','Svensson','60469784299','enim@enim.org'),('Erika','Persson','43450964999','Morbi.non@nequevenenatislacus.org'),('Eleonor','Karlsson','78458343099','malesuada@laciniaorci.co.uk'),('Petter','Svensson','92607550699','pede.Praesent.eu@nectellus.ca'),('Erik','Karlsson','66679785199','habitant.morbi@est.co.uk'),('Erik','Carlsson','83919707799','mollis.Duis.sit@Integereu.ca'),('Emma','Karlsson','35491225499','habitant.morbi@eget.ca'),('Daniel','Ericsson','70689869599','mi@magnaUttincidunt.org'),('Märta','Samuelsson','07711577299','amet.orci.Ut@Vestibulumante.co.uk'),('Anna','Svensson','26831765799','Aliquam@auctorvelit.edu'),('Christian','Staffansson','18808278499','at.arcu.Vestibulum@diamdictum.co.uk'),('Lisa','Eriksson','71367274299','eleifend.nec@acorci.org'),('Eva','Persson','23531728399','Nullam.nisl@convallis.co.uk'),('Pär','Andersson','70598404599','vulputate.dui.nec@portaelita.edu'),('Peter','Bodin','96325506299','In@adipiscing.edu'),('Peter','Eriksson','11399832599','et.pede@lectussitamet.edu'),('Thomas','Bodin','68651413099','Sed@massaIntegervitae.org'),('Erik','Eriksson','26575872999','Donec.feugiat@arcuVestibulumante.com'),('Eleonor','Staffansson','23863487999','augue@rutrumeuultrices.co.uk'),('Henrik','Svensson','28251366699','augue.malesuada.malesuada@nequenonquam.org'),('Eva','Andersson','70533013299','eu.sem.Pellentesque@elementum.org'),('Thomas','Carlsson','35899000699','imperdiet.erat.nonummy@VivamusnisiMauris.edu'),('Magdalena','Staffansson','97923626999','luctus.et.ultrices@interdumligula.net'),('Eva','Bodin','49525466899','et.magnis@perinceptos.com'),('Thomas','Carlsson','03332199999','Nunc.commodo@mitemporlorem.ca'),('Sara','Samuelsson','99936591999','Vivamus.euismod@scelerisque.co.uk');

INSERT INTO `repairs` (`serialnumber`, `email`, `ticketid`, `status`) VALUES
  ('3242480324', 'e1@mail.com', DEFAULT, '1');

INSERT INTO `logins`(`username`, `password`) VALUES
  ('admin','root'),('Fusce@etlacinia.org','MEO76HWQ6OS'),('mattis@ac.org','WIM96CFI8XS');

INSERT INTO `assignments`(`assignment`, `owner`, `id`) VALUES
  ('assignment text', 'admin', DEFAULT),
  ('assignment text', 'admin', DEFAULT),
  ('assignment text', 'admin', DEFAULT),
  ('assignment text', 'Fusce@etlacinia.org', DEFAULT),
  ('assignment text', 'Fusce@etlacinia.org', DEFAULT),
  ('assignment text', 'mattis@ac.org', DEFAULT),
  ('assignment text', 'mattis@ac.org', DEFAULT),
  ('assignment text', 'mattis@ac.org', DEFAULT),
  ('assignment text', 'mattis@ac.org', DEFAULT),
  ('assignment text', 'mattis@ac.org', DEFAULT);

INSERT INTO `devicehistory`(`email`, `serialnumber`, `startdate`, `enddate`) VALUES
  ('e1@mail.com', '3242480324', DATE_SUB(NOW(), INTERVAL 1 YEAR), DATE_SUB(NOW(), INTERVAL 10 MONTH)),
  ('e1@mail.com', '1234560324', DATE_SUB(NOW(), INTERVAL 6 MONTH), DATE_SUB(NOW(), INTERVAL 31 DAY)),
  ('e1@mail.com', '9872487204', DATE_SUB(NOW(), INTERVAL 30 DAY), DATE(NOW())),
  ('e2@mail.com', '98712211899', DATE_SUB(NOW(), INTERVAL 30 DAY), DATE(NOW()));

