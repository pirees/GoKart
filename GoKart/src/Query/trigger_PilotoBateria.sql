CREATE DEFINER=`root`@`localhost` TRIGGER `pilotobateria_AFTER_INSERT` AFTER INSERT ON `pilotobateria` FOR EACH ROW BEGIN
UPDATE bateria
INNER JOIN
pilotobateria
ON bateria.id = pilotobateria.bat_id
set bateria.nrMaxPiloto =  bateria.nrMaxPiloto - new.nrEscolhaPiloto
where bateria.id < 100;
END