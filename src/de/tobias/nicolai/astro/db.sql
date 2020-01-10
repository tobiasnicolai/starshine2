CREATE TABLE astro_obj (id INT PRIMARY KEY, name VARCHAR(64));
CREATE TABLE moment (id INT PRIMARY KEY AUTO_INCREMENT, timestp TIMESTAMP);
CREATE TABLE position (astro_obj INT, moment INT, angel DOUBLE,
                PRIMARY KEY(astro_obj, moment),
                FOREIGN KEY (astro_obj) REFERENCES astro_obj(id),
                FOREIGN KEY (moment) REFERENCES moment(id)
                );
INSERT INTO astro_obj (id, name) values
(1, 'Sun'),
(2, 'Moon'),
(3, 'Mercury'),
(4, 'Venus'),
(5, 'Mars'),
(6, 'Jupiter'),
(7, 'Saturn'),
(8, 'Uranus'),
(9, 'Neptun'),
(10, 'Pluto');

INSERT INTO moment (id, timestp) values
(1, '1000-01-01 00:00:00');

INSERT INTO `position` (astro_obj, moment, angel) values
(1, 1, 0.0),
(2, 1, 0.0),
(3, 1, 90.0),
(4, 1, 180.0),
(5, 1, 30.0),
(6, 1, 135.0),
(7, 1, 60.0),
(8, 1, 0.0),
(9, 1, 80.0),
(10, 1, 100.0);

DROP FUNCTION IF EXISTS calc_constalation;
CREATE FUNCTION calc_constalation(o1 DOUBLE, o2 DOUBLE) RETURNS DOUBLE
RETURN IF(IF(o1>o2, o1-o2, o2-o1)>180,360-IF(o1>o2, o1-o2, o2-o1),IF(o1>o2, o1-o2, o2-o1));

DROP FUNCTION IF EXISTS calc_fade;
CREATE FUNCTION calc_fade(suspected DOUBLE, fade DOUBLE, getted DOUBLE) RETURNS DOUBLE
RETURN IF((suspected - getted) / fade > 1.0 , 0, 1 - (suspected - getted) / fade);

CREATE OR REPLACE VIEW EPH AS
SELECT
    m.timestp,
    p1.angel AS sun,
    p2.angel AS moon,
    p3.angel AS mercury,
    p4.angel AS venus,
    p5.angel AS mars,
    p6.angel AS jupiter,
    p7.angel AS saturn,
    p8.angel AS uranus,
    p9.angel AS neptun,
    p10.angel AS pluto
FROM moment m
LEFT OUTER JOIN `position` p1 ON p1.moment = m.id AND p1.astro_obj = 1
LEFT OUTER JOIN `position` p2 ON p2.moment = m.id AND p2.astro_obj = 2
LEFT OUTER JOIN `position` p3 ON p3.moment = m.id AND p3.astro_obj = 3
LEFT OUTER JOIN `position` p4 ON p4.moment = m.id AND p4.astro_obj = 4
LEFT OUTER JOIN `position` p5 ON p5.moment = m.id AND p5.astro_obj = 5
LEFT OUTER JOIN `position` p6 ON p6.moment = m.id AND p6.astro_obj = 6
LEFT OUTER JOIN `position` p7 ON p7.moment = m.id AND p7.astro_obj = 7
LEFT OUTER JOIN `position` p8 ON p8.moment = m.id AND p8.astro_obj = 8
LEFT OUTER JOIN `position` p9 ON p9.moment = m.id AND p9.astro_obj = 9
LEFT OUTER JOIN `position` p10 ON p10.moment = m.id AND p10.astro_obj = 10;

DROP FUNCTION IF EXISTS asp0;
CREATE FUNCTION asp0(o1 DOUBLE, o2 DOUBLE) RETURNS DOUBLE
RETURN calc_fade(0, 4.5, calc_constalation(o1, o2));

DROP FUNCTION IF EXISTS asp30;
CREATE FUNCTION asp30(o1 DOUBLE, o2 DOUBLE) RETURNS DOUBLE
RETURN calc_fade(30, 0.5, calc_constalation(o1, o2));

DROP FUNCTION IF EXISTS asp45;
CREATE FUNCTION asp45(o1 DOUBLE, o2 DOUBLE) RETURNS DOUBLE
RETURN calc_fade(45, 1, calc_constalation(o1, o2));

DROP FUNCTION IF EXISTS asp60;
CREATE FUNCTION asp60(o1 DOUBLE, o2 DOUBLE) RETURNS DOUBLE
RETURN calc_fade(60, 2.5, calc_constalation(o1, o2));

DROP FUNCTION IF EXISTS asp90;
CREATE FUNCTION asp90(o1 DOUBLE, o2 DOUBLE) RETURNS DOUBLE
RETURN calc_fade(90, 4, calc_constalation(o1, o2));

DROP FUNCTION IF EXISTS asp120;
CREATE FUNCTION asp120(o1 DOUBLE, o2 DOUBLE) RETURNS DOUBLE
RETURN calc_fade(120, 3.5, calc_constalation(o1, o2));

DROP FUNCTION IF EXISTS asp135;
CREATE FUNCTION asp135(o1 DOUBLE, o2 DOUBLE) RETURNS DOUBLE
RETURN calc_fade(135, 1.5, calc_constalation(o1, o2));

DROP FUNCTION IF EXISTS asp150;
CREATE FUNCTION asp150(o1 DOUBLE, o2 DOUBLE) RETURNS DOUBLE
RETURN calc_fade(150, 2, calc_constalation(o1, o2));

DROP FUNCTION IF EXISTS asp180;
CREATE FUNCTION asp180(o1 DOUBLE, o2 DOUBLE) RETURNS DOUBLE
RETURN calc_fade(180, 4.5, calc_constalation(o1, o2));

DROP FUNCTION IF EXISTS asp_sp;
CREATE FUNCTION asp_sp(o1 DOUBLE, o2 DOUBLE) RETURNS DOUBLE
RETURN IF(calc_constalation(0, o1)>calc_constalation(0, o2),
    calc_fade(calc_constalation(0, o1), 0.75, calc_constalation(0, o2)),
    calc_fade(calc_constalation(0, o2), 0.75, calc_constalation(0, o1))) +
    IF(calc_constalation(90, o1)>calc_constalation(90, o2),
    calc_fade(calc_constalation(90, o1), 0.75, calc_constalation(90, o2)),
    calc_fade(calc_constalation(90, o2), 0.75, calc_constalation(90, o1)));