-- **Filme gruppieren nach Genre**
    -- Zeige die Anzahl der Filme pro Genre an


SELECT GENRE, COUNT(*) as `anzahl`
FROM MOVIES
GROUP BY GENRE;

-- **Durchschnittliches Erscheinungsjahr pro Genre:**
    -- Berechne das durchschnittliche Erscheinungsjahr für Filme in jedem Genre

SELECT GENRE, AVG(RELEASE_YEAR) as `average year`
FROM MOVIES
GROUP BY GENRE;

-- **Top 5 Genres nach Anzahl der Filme:**
    -- Zeige die Top 5 Genres mit den meisten Filmen an

SELECT GENRE as `top 5 genre nach Anzahl`, COUNT(*) as `Anzahl`
FROM MOVIES
GROUP BY GENRE
ORDER BY COUNT(*) DESC
LIMIT 5;

-- **Jahr mit den meisten Filmen:**
    -- Finde das Erscheinungsjahr mit den meisten veröffentlichten Filmen

SELECT RELEASE_YEAR as `year`, COUNT(*)
FROM MOVIES
GROUP BY RELEASE_YEAR
ORDER BY COUNT(*) DESC
LIMIT 1;

-- **Genres mit den meisten Filmen nach 2000:**
    -- Zeige die Genres mit den meisten Filmen, die nach dem Jahr 2000 veröffentlicht wurden

SELECT GENRE, COUNT(*) as `Anzahl nach 2000`
FROM MOVIES
WHERE RELEASE_YEAR >= 2000
GROUP BY GENRE
ORDER BY COUNT(*) DESC
LIMIT 1;

-- **Genres nach der Anzahl der Filme sortiert:**
    -- Sortiere die Genres nach der Anzahl der darin enthaltenen Filme, absteigend

SELECT GENRE, COUNT(*) as `Anzahl`
FROM MOVIES
GROUP BY GENRE
ORDER BY COUNT(*) DESC

-- **Genre mit den ältesten durchschnittlichen Erscheinungsjahren:**
    -- Finde das Genre, dessen Filme im Durchschnitt am ältesten sind

SELECT GENRE, AVG(RELEASE_YEAR) as `average year` 
FROM MOVIES
GROUP BY GENRE
ORDER BY AVG(RELEASE_YEAR)
LIMIT 1;
