-- ** 1. Tabellen erstellen
-- Erstelle eine Tabelle `Products`, wobei ein Produkt eine eindeutige ID, einen Namen, eine Kategorie (z.B. Obst, Gemüse, Getränke), einen Preis und ein Verfallsdatum hat.
-- Erstelle eine Tabelle `Categories`, wobei jede Kategorie eine eindeutige ID und einen Namen (z.B. Obst, Gemüse, Getränke) hat.

DROP TABLE IF EXISTS PRODUCTS;
DROP TABLE IF EXISTS CATEGORIES;


CREATE TABLE PRODUCTS (
    PRODUCT_ID INT PRIMARY KEY,
    NAME VARCHAR(50),
    CATEGORY VARCHAR(50),
    PREIS DECIMAL(10, 2),
    EXPIRY_DATE DATE;
);

CREATE TABLE CATEGORIES (
    ID INT PRIMARY KEY,
    NAME VARCHAR(50)
);

-- **2. Daten einfügen
-- Füge einige Produkte und Kategorien hinzu, z.B. Äpfel, Tomaten, Cola, etc.

INSERT INTO CATEGORIES (ID, NAME) VALUES
(1, 'Fruits'),
(2, 'Vegetables'),
(3, 'Dairy'),
(4, 'Bakery'),
(5, 'Beverages')
(6, 'Meat');

INSERT INTO PRODUCTS (PRODUCT_ID, NAME, CATEGORY, PREIS, EXPIRY_DATE) VALUES
(1, 'Apple', 'Fruits', 0.99, '2024-03-03'),
(2, 'Banana', 'Fruits', 0.59, '2023-07-30'),
(3, 'Orange Juice', 'Beverages', 2.49, '2024-09-30'),
(4, 'Milk', 'Dairy', 1.29, '2023-11-30'),
(5, 'Cheddar Cheese', 'Dairy', 3.49, '2024-03-24'),
(6, 'Lettuce', 'Vegetables', 1.09, '2025-07-30'),
(7, 'Tomato', 'Vegetables', 1.19, '2024-02-15'),
(8, 'Whole Wheat Bread', 'Bakery', 2.99, '2024-06-02'),
(9, 'Bagels', 'Bakery', 3.29, '2024-12-30'),
(10, 'Chicken Breast', 'Meat', 5.99, '2023-07-30'),
(11, 'Beef Steak', 'Meat', 8.49, '2025-07-30'),
(12, 'Yogurt', 'Dairy', 0.89, '2025-12-30'),
(13, 'Grapes', 'Fruits', 2.99, '2025-10-01'),
(14, 'Carrot', 'Vegetables', 0.79, '2024-09-30'),
(15, 'Orange', 'Fruits', 1.29, '2024-06-30');

-- ** 3. Daten abfragen

-- **1. Einfache Abfragen:
    -- Zeige alle Produkte an
SELECT *
FROM PRODUCTS;

    -- Zeige alle Produkte einer bestimmten Kategorie an (z.B. Obst)
SELECT *
FROM PRODUCTS
WHERE Category = 'Fruits';

    -- Zeige alle Produkte an, die teurer als 5 Euro sind
SELECT *
FROM PRODUCTS p
WHERE Preis > 5.00;

    -- Zeige alle Produkte an, deren Verfallsdatum abgelaufen ist

SELECT *
FROM PRODUCTS
WHERE EXPIRY_DATE < CURDATE();

-- **2. Erweiterte Abfragen:**
    -- Produkte gruppieren nach Kategorie**
SELECT CATEGORY, COUNT(*)
FROM PRODUCTS
GROUP BY CATEGORY;

    -- Durchschnittlicher Preis pro Kategorie**

    -- Top 3 Kategorien nach Anzahl der Produkte**
    -- Kategorie mit dem höchsten durchschnittlichen Preis**
    -- Produkte, die teurer als der Durchschnitt ihrer Kategorie sind**
    -- Kategorien mit den meisten abgelaufenen Produkten**
    -- Produkte mit der höchsten Haltbarkeit in ihrer Kategorie**
    -- Durchschnittliche Haltbarkeit (Tage) pro Kategorie**
    -- Durchschnittlicher Preis für Produkte, die nach 2023 ablaufen**
    -- Produkte mit Preis über dem Durchschnitt, sortiert nach Haltbarkeit**
    -- Teuerstes Produkt in jeder Kategorie finden**
    -- Produkte anzeigen, deren Preis über dem Durchschnittspreis aller Produkte liegt