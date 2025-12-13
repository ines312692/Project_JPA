-- INIT DES TABLES DE SÉQUENCE
INSERT INTO commune_seq(next_val) VALUES (1);
INSERT INTO departement_seq(next_val) VALUES (1);
INSERT INTO maire_seq(next_val) VALUES (1);
-- Departements
INSERT INTO departement(id, nom) VALUES (1, 'Grand Tunis');
INSERT INTO departement(id, nom) VALUES (2, 'Nord-Est');
-- Communes
INSERT INTO commune(id, nom, population, departement_id) VALUES (1, 'Tunis', 1200000, 1);
INSERT INTO commune(id, nom, population, departement_id) VALUES (2, 'Ariana', 700000, 1);
INSERT INTO commune(id, nom, population, departement_id) VALUES (3, 'Manouba', 400000, 1);
INSERT INTO commune(id, nom, population, departement_id) VALUES (4, 'Ben Arous', 700000, 1);
INSERT INTO commune(id, nom, population, departement_id) VALUES (5, 'Bizerte', 300000, 2);

-- Maires
INSERT INTO maire(id, nom, adresse, commune_id) VALUES (1, 'Ramzi', 'Rue de la République', 1);

INSERT INTO maire(id, nom, adresse, commune_id) VALUES (2, 'Farhat', 'Avenue Bourguiba', 2);

INSERT INTO maire(id, nom, adresse, commune_id) VALUES (3, 'Sana', 'Rue 14 Janvier', 4);

INSERT INTO maire(id, nom, adresse, commune_id) VALUES (4, 'Imen', 'Cité des Roses', 5);

-- Mails
INSERT INTO maire_emails(maire_id, emails) VALUES (1, 'ramzi@gmail.com');
INSERT INTO maire_emails(maire_id, emails) VALUES (1, 'contact@ramzi.tn');
INSERT INTO maire_emails(maire_id, emails) VALUES (1, 'mairie.tunis@tn.gov');

INSERT INTO maire_emails(maire_id, emails) VALUES (2, 'farhat@yahoo.fr');
INSERT INTO maire_emails(maire_id, emails) VALUES (2, 'mairie.ariana@tn.gov');

INSERT INTO maire_emails(maire_id, emails) VALUES (3, 'sana.mairie@gmail.com');

INSERT INTO maire_emails(maire_id, emails) VALUES (4, 'imen.mairie@biz.tn');
INSERT INTO maire_emails(maire_id, emails) VALUES (4, 'info@mairiebizerte.tn');

-- Correction des séquences
UPDATE commune_seq SET next_val = 6;
UPDATE departement_seq SET next_val = 3;
UPDATE maire_seq SET next_val = 5;

