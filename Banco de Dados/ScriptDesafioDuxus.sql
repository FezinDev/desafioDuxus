 create database if not exists desafioduxus;
 
 use desafioduxus;

INSERT INTO integrante (franquia, nome, funcao) VALUES
('Los Angeles Lakers', 'LeBron James', 'Ala'),
('Los Angeles Lakers', 'Anthony Davis', 'Pivô'),
('Los Angeles Lakers', 'D Angelo Russell', 'Armador'),
('Los Angeles Lakers', 'Austin Reaves', 'Ala'),
('Los Angeles Lakers', 'Rui Hachimura', 'Ala'),
('Golden State Warriors', 'Stephen Curry', 'Armador'),
('Golden State Warriors', 'Klay Thompson', 'Ala'),
('Golden State Warriors', 'Draymond Green', 'Pivô'),
('Golden State Warriors', 'Andrew Wiggins', 'Ala'),
('Golden State Warriors', 'Kevon Looney', 'Pivô'),
('Boston Celtics', 'Jayson Tatum', 'Ala'),
('Boston Celtics', 'Jaylen Brown', 'Ala'),
('Boston Celtics', 'Marcus Smart', 'Armador'),
('Boston Celtics', 'Al Horford', 'Pivô'),
('Boston Celtics', 'Derrick White', 'Armador'),
('Miami Heat', 'Jimmy Butler', 'Ala'),
('Miami Heat', 'Bam Adebayo', 'Pivô'),
('Miami Heat', 'Tyler Herro', 'Armador'),
('Miami Heat', 'Kyle Lowry', 'Armador'),
('Miami Heat', 'Caleb Martin', 'Ala'),
('Chicago Bulls', 'Zach LaVine', 'Ala'),
('Chicago Bulls', 'DeMar DeRozan', 'Ala'),
('Chicago Bulls', 'Nikola Vucevic', 'Pivô'),
('Chicago Bulls', 'Patrick Williams', 'Ala'),
('Chicago Bulls', 'Ayo Dosunmu', 'Armador');

INSERT INTO time (data) VALUES
('2024-11-01'),
('2024-11-08'),
('2024-11-15'),
('2024-11-22'),
('2024-11-29');


INSERT INTO composicao_time (time_id, integrante_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 6),
(1, 8),
(2, 4),
(2, 7),
(2, 9),
(2, 11),
(2, 15),
(3, 13),
(3, 14),
(3, 16),
(3, 18),
(3, 19),
(4, 17),
(4, 20),
(4, 21),
(4, 23),
(4, 1),
(5, 5),
(5, 22),
(5, 25),
(5, 1),
(5, 2);

INSERT INTO time (data) VALUES
('2024-12-06');


INSERT INTO composicao_time (time_id, integrante_id) VALUES
(6, 1),
(6, 2),
(6, 3),
(6, 6),
(6, 8);

SELECT 
    t.data AS data_do_time,
    ti.franquia AS franquia_do_time,
    ti.nome AS nome_integrante,
    ti.funcao AS funcao_integrante,
    t.id AS id_time
FROM 
    composicao_time ct
JOIN 
    time t ON ct.time_id = t.id
JOIN 
    integrante ti ON ct.integrante_id = ti.id
ORDER BY 
    t.data, t.id, ti.nome;