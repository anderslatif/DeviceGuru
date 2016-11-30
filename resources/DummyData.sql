

INSERT INTO `sql7145733`.`devicelogins` (`email`, `password`) VALUES
#   ('two line', example),
  ('e@mail.com', 'password');


INSERT INTO `sql7145733`.`devices` (`serialnumber`, `type`) VALUES
  ('3242480324', 'iPad');

INSERT INTO `sql7145733`.`classes` (`class`) VALUES
  ('3A');

INSERT INTO `sql7145733`.`students` (`firstname`, `lastname`, `class`, `device`, `email`) VALUES
  ('Nynne', 'Hirksholm', '3A', '3242480324', 'e@mail.com');

/*INSERT INTO `sql7145733`.`personel` (`firstname`, `lastname`, `device`, `email`) VALUES
  ('Teach', 'Laresen', '6575643534', 'lar@edu.dk');*/

/*INSERT INTO `sql7145733`.`repairs` (`device`, `owner`, `ticketid`, `status`) VALUES
  ();*/

/*INSERT INTO `sql7145733`.`logins`(`username`, `password`) VALUES
  ();*/

/*INSERT INTO `sql7145733`.`assignments`(`assignment`, `owner`, `id`) VALUES
  ();*/

INSERT INTO `sql7145733`.`devicehistory`(`email`, `device`, `startdate`, `enddate`) VALUES
  ('e@mail.com', '3242480324', DATE(NOW()), null);

