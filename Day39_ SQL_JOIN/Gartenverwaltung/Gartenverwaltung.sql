-- **Tabelle: Garten**
    -- GartenID** (Primary Key)
    -- Name** (Name des Gartens)
    -- Größe** (Fläche des Gartens in Quadratmetern)

DROP TABLE IF EXISTS Garten;

CREATE TABLE Garten (
    GartenID INT PRIMARY KEY,
    Name VARCHAR(50),
    Größe INT -- IN QUADRATMETERN
);

-- **Tabelle: Pflanze**
    -- PflanzenID** (Primary Key)
    -- Name** (Name der Pflanze)
    -- Essbar** (Boolescher Wert, ob die Pflanze essbar ist)
    -- WasserbedarfProPflanze** (Wasserbedarf in Litern pro Pflanze)

DROP TABLE IF EXISTS Pflanze;

CREATE TABLE Pflanze (
    PflanzenID INT PRIMARY KEY,
    Name VARCHAR(50),
    Essbar BOOLEAN,
    WasserbedarfProPflanze int -- in Liter
);
    
-- **Tabelle: GartenPflanzen**
    -- GartenID** (Foreign Key zu Garten)
    -- PflanzenID** (Foreign Key zu Pflanze)
    -- Anzahl** (Anzahl der Pflanzen im Garten)

DROP TABLE IF EXISTS GartenPflanzen;

CREATE TABLE GartenPflanzen (
    GartenID int,
    PflanzenID int,
    Anzahl int,
    FOREIGN KEY (GartenID) REFERENCES Garten(GartenID)
);

-- **Insert Into

INSERT INTO Garten (GartenID, Name, Größe)
VALUES
(1, 'Blumenparadies', 500),
(2, 'GemüseObstGarten', 300),
(3, 'Kräutergarten', 150);

INSERT INTO Pflanze (PflanzenID, Name, Essbar, WasserbedarfProPflanze)
VALUES
(1, 'Rose', FALSE, 2),
(2, 'Tomate', TRUE, 3),
(3, 'Basilikum', TRUE, 1),
(4, 'Sonnenblume', FALSE, 5),
(5, 'Karotte', TRUE, 2),
(6, 'Apfelbaum', TRUE, 10),
(7, 'Lavendel', FALSE, 1),
(8, 'Erdbeere', TRUE, 2),
(9, 'Kartoffel', TRUE, 4),
(10, 'Kürbis', TRUE, 3),
(11, 'Dill', TRUE, 1);

INSERT INTO GartenPflanzen (GartenID, PflanzenID, Anzahl)
VALUES
(1, 1, 50),    -- 50 Rosen im Blumenparadies
(1, 4, 20),    -- 20 Sonnenblumen im Blumenparadies
(1, 7, 100),   -- 100 Lavendelpflanzen im Blumenparadies

(2, 2,  30),    -- 30 Tomaten 
(2, 5,  40),    -- 40 Karotten
(2, 9,  20),    -- 20 Karoffelpflanzen
(2, 10, 10),    -- 10 Kürbispflanzen 
(2, 6,  5),     -- 5 Apfelbäume
(2, 8,  25),    -- 25 Erdbeerpflanzen

(3, 3, 100),   -- 100 Basilikumpflanzen
(3, 2, 15),    -- 15 Tomaten
(3, 7, 50),    -- 50 Lavendelpflanzen
(3, 11, 100);  -- 100 Dill

-- 1. **Berechne die gesamte Anzahl von Pflanzen in jedem Garten**
SELECT GartenID, SUM(Anzahl) as AnzahlVonPflanzen
FROM GartenPflanzen
GROUP BY GartenID;

/* SELECT GartenID, SUM(Anzahl) as AnzahlVonPflanzen
FROM Garten
LEFT JOIN GartenPflanzen
ON Garten.GARTENID = GartenPflanzen.GartenID
GROUP BY GartenID; */

-- 2. **Finde die Namen der Pflanzen und die Anzahl der Pflanzen im „Blumenparadies“**
SELECT Pflanze.NAME, GartenPflanzen.Anzahl
FROM Pflanze
INNER JOIN GartenPflanzen ON Pflanze.PflanzenID = GartenPflanzen.PflanzenID
INNER JOIN GARTEN ON GARTEN.GartenID = GartenPflanzen.GartenID
WHERE GARTEN.NAME = 'Blumenparadies'

-- 3. **Liste Gärten mit weniger als 200 Pflanzen auf**
SELECT GARTEN.NAME, SUM(GartenPflanzen.Anzahl) AS NUM_PFLANZEN
FROM GartenPflanzen
INNER JOIN GARTEN ON GARTEN.GartenID = GartenPflanzen.GartenID
GROUP BY GARTEN.NAME
WHERE SUM(GartenPflanzen.Anzahl) < 200;

-- 4. **Finde den Namen der Pflanze und den Wasserbedarf für alle essbaren Pflanzen im „Kräutergarten“**
SELECT Pflanze.NAME, Pflanze.WasserbedarfProPflanze
FROM GartenPflanzen
INNER JOIN GARTEN ON GARTEN.GARTENID = GartenPflanzen.GartenID
INNER JOIN Pflanze ON GartenPflanzen.PflanzenID = Pflanze. PflanzenID
WHERE Pflanze.Essbar = TRUE AND GARTEN.NAME = 'Kräutergarten';

-- 5. **Berechne die durchschnittliche Anzahl an Pflanzen pro Garten**
SELECT GARTEN.NAME, AVG(GartenPflanzen.Anzahl)
FROM GartenPflanzen
INNER JOIN GARTEN ON GARTEN.GARTENID = GartenPflanzen.GartenID
GROUP BY GARTEN.NAME

-- 6. **Finde alle essbaren Pflanzen im Kräutergarten**
SELECT Pflanze.NAME
FROM GartenPflanzen
INNER JOIN Pflanze ON GartenPflanzen.PflanzenID = Pflanze.PflanzenID
INNER JOIN GARTEN ON GARTEN.GARTENID = GartenPflanzen.GartenID
WHERE Pflanze.Essbar = TRUE AND GARTEN.NAME = 'Kräutergarten';

-- **2 JOINS notwendig
-- 1. **Liste alle Gärten auf, die mindestens eine essbare Pflanze enthalten**
SELECT GARTEN.NAME, COUNT(Pflanze.Essbar)
FROM GartenPflanzen
INNER JOIN Pflanze ON GartenPflanzen.PflanzenID = Pflanze.PflanzenID
INNER JOIN GARTEN ON GARTEN.GARTENID = GartenPflanzen.GartenID
GROUP BY GARTEN.NAME
WHERE COUNT(Pflanze.Essbar)>=1;

-- 2. **Finde die Gärten, in denen mindestens eine Pflanze mehr als 10 Liter Wasser pro Tag benötigt**
SELECT GARTEN.NAME, SUM(CASE WHEN Pflanze.WasserbedarfProPflanze >= 10 THEN 1 ELSE 0 END) as `COUNT Pflanze dass mehr als 10 Liter Wasser pro Tag benötigt`
FROM GartenPflanzen
INNER JOIN Pflanze ON GartenPflanzen.PflanzenID = Pflanze.PflanzenID
INNER JOIN GARTEN ON GARTEN.GARTENID = GartenPflanzen.GartenID
GROUP BY GARTEN.NAME
HAVING SUM(CASE WHEN Pflanze.WasserbedarfProPflanze >= 10 THEN 1 ELSE 0 END) >=1;

-- 3. **Berechne den gesamten Wasserbedarf für einen bestimmten Garten** 
-- 4. **Berechne den Garten mit dem höchsten Wasserbedarf** 
-- 5. **Finde den Garten mit der größten Anzahl an essbaren Pflanzen**
-- 6. **Finde die Gärten, die keine essbaren Pflanzen enthalten**