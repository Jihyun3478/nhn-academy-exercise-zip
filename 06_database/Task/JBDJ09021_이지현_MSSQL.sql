-- Problem 1
SELECT ReleaseYear, Title, RunningTime, Plot FROM Movie WHERE KoreanTitle = '퍼스트 맨';

-- Problem 2
SELECT KoreanTitle, Title FROM Movie WHERE ReleaseYear = 2003;

-- Problem 3
SELECT p.KoreanName 
FROM Person p
JOIN Appear a ON p.PersonID = a.PersonID
JOIN Role r ON a.RoleID = r.RoleID AND r.RoleName = 'Composer'
JOIN Movie m ON a.MovieID = m.MovieID AND m.KoreanTitle = '글래디에이터';

-- Problem 4
SELECT COUNT(*) FROM Appear a
INNER JOIN Role r ON a.RoleID = r.RoleID
INNER JOIN Movie m ON a.MovieID = m.MovieID
WHERE m.KoreanTitle = '매트릭스' AND r.RoleKorName = '감독';

-- Problem 5
SELECT m.KoreanTitle + ' (' + m.Title + ') - ' + CAST(m.ReleaseYear AS VARCHAR)
FROM Movie m
JOIN Appear a ON m.MovieID = a.MovieID
JOIN Role r ON a.RoleID = r.RoleID AND r.RoleKorName = '감독'
GROUP BY m.MovieID
HAVING COUNT(a.PersonID) >= 2;

-- Problem 6
SELECT DISTINCT m.KoreanTitle FROM Movie m
INNER JOIN Appear a ON m.MovieID = a.MovieID
INNER JOIN Person p ON a.PersonID = p.PersonID
INNER JOIN AwardInvolve ai ON ai.AppearID = a.AppearID
WHERE p.KoreanName = '한스 짐머';

-- Problem 7
SELECT m.KoreanTitle + ' (' + m.Title + ') - ' + CAST(m.ReleaseYear AS VARCHAR)
FROM Movie m
JOIN Appear a ON m.MovieID = a.MovieID
JOIN Person p ON a.PersonID = p.PersonID
JOIN Role r ON a.RoleID = r.RoleID
WHERE (r.RoleKorName = '감독' AND p.KoreanName = '제임스 카메론')
   OR (r.RoleKorName = '배우' AND p.KoreanName = '아놀드 슈워제네거')
GROUP BY m.MovieID
HAVING COUNT(DISTINCT p.PersonID) = 2;

-- Problem 8
SELECT m.KoreanTitle, m.ReleaseYear FROM Movie m
INNER JOIN Appear a ON m.MovieID = a.MovieID
INNER JOIN Person p ON a.PersonID = p.PersonID
WHERE m.RunningTime >= 100 AND p.KoreanName = '레오나르도 디카프리오'
ORDER BY m.ReleaseYear DESC;

-- Problem 9
SELECT KoreanTitle, Title, ReleaseYear, BoxOfficeWWGross FROM Movie WHERE GradeID = 1 ORDER BY Budget DESC OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY;

-- Problem 10
SELECT '$' + FORMAT(AVG(BoxOfficeWWGross), 'N2') FROM movie WHERE ReleaseYear < 1999;

-- Problem 11
SELECT TOP 1 KoreanTitle + ' (' + Title + ') - ' + CAST(ReleaseYear AS VARCHAR) FROM Movie ORDER BY Budget DESC;

-- Problem 12
SELECT p.KoreanName + ' (' + p.Name + ') - ' + CAST(DATEDIFF(YEAR, p.BirthDate, GETDATE()) AS VARCHAR)
FROM Person p
JOIN Appear a ON p.PersonID = a.PersonID
JOIN Movie m ON a.MovieID = m.MovieID
JOIN Role r ON a.RoleID = r.RoleID AND r.RoleKorName = '감독'
GROUP BY p.PersonID
ORDER BY SUM(m.Budget) DESC OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY;

-- Problem 13
SELECT p.Name, p.BirthDate FROM Person p
INNER JOIN Appear a ON p.PersonID = a.PersonID
INNER JOIN Role r ON a.RoleID = r.RoleID
INNER JOIN Movie m ON a.MovieID = m.MovieID
WHERE r.RoleKorName = '배우'
GROUP BY p.PersonID
ORDER BY SUM(m.BoxOfficeWWGross) DESC OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY;

-- Problem 14
SELECT KoreanTitle, BoxOfficeWWGross FROM Movie WHERE BoxOfficeWWGross > 0 ORDER BY Budget ASC OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY;

-- Problem 15
SELECT '$' + FORMAT(AVG(BoxOfficeUSGross), 'N2') FROM Movie WHERE Budget <= 50000000;

-- Problem 16
SELECT '$' + FORMAT(AVG(BoxOfficeUSGross), 'N2') FROM Movie WHERE Budget <= 50000000;

-- Problem 17
SELECT KoreanTitle + ' (' + Title + ') - ' + CAST(ReleaseYear AS VARCHAR) FROM Movie m
INNER JOIN MovieGenre mg ON mg.MovieID = m.MovieID
INNER JOIN Genre g ON mg.GenreID = g.GenreID
WHERE g.GenreKorName IN ('드라마', '전쟁');

-- Problem 18
SELECT Title, KoreanTitle, ReleaseYear FROM Movie m
INNER JOIN Appear a ON m.MovieID = a.MovieID
INNER JOIN Person p ON a.PersonID = p.PersonID
WHERE p.KoreanName = '톰 행크스'
ORDER BY m.RunningTime DESC OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY;

-- Problem 19
SELECT p.KoreanName, p.Name
FROM Person p
JOIN Appear a ON p.PersonID = a.PersonID
JOIN AwardInvolve ai ON a.AppearID = ai.AppearID
JOIN Sector s ON ai.SectorID = s.SectorID AND s.SectorKorName = '남우주연상'
JOIN Role r ON a.RoleID = r.RoleID AND r.RoleKorName = '배우'
GROUP BY p.PersonID
ORDER BY COUNT(ai.InvolveID) DESC OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY;

-- Problem 20
SELECT p.KoreanName, p.Name FROM Person p
INNER JOIN Appear a ON p.PersonID = a.PersonID
INNER JOIN AwardInvolve ai ON a.AppearID = ai.AppearID
INNER JOIN Role r ON a.RoleID = r.RoleID
WHERE r.RoleKorName = '배우'
GROUP BY p.PersonID
ORDER BY COUNT(ai.InvolveID) DESC OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY;

-- Problem 21
SELECT p.KoreanName, p.Name FROM Person p
INNER JOIN Appear a ON p.PersonID = a.PersonID
INNER JOIN AwardInvolve ai ON a.AppearID = ai.AppearID
INNER JOIN Sector s ON ai.SectorID = s.SectorID
INNER JOIN Role r ON a.RoleID = r.RoleID
WHERE s.SectorKorName = '남우주연상' AND r.RoleKorName = '배우'
GROUP BY p.PersonID
ORDER BY COUNT(ai.InvolveID) DESC;

-- Problem 22
SELECT p.KoreanName, p.Name FROM Person p
INNER JOIN Appear a ON p.PersonID = a.PersonID
INNER JOIN AwardInvolve ai ON a.AppearID = ai.AppearID
GROUP BY p.PersonID
ORDER BY COUNT(ai.InvolveID) DESC OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY;

-- Problem 23
SELECT KoreanTitle, Title, ReleaseYear FROM Movie m
INNER JOIN Appear a ON m.MovieID = a.MovieID
INNER JOIN AwardInvolve ai ON a.AppearID = ai.AppearID
INNER JOIN Winning w ON ai.WinningID = w.WinningID
WHERE w.WinOrNot = 'Nominated'
GROUP BY m.MovieID
ORDER BY COUNT(ai.InvolveID) DESC OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY;

-- Problem 24
SELECT p.KoreanName, p.Name FROM Person p
JOIN Appear a ON p.PersonID = a.PersonID
JOIN Role r ON a.RoleID = r.RoleID
WHERE r.RoleKorName = '여배우'
GROUP BY p.PersonID
ORDER BY COUNT(a.MovieID) DESC OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY;

-- Problem 25
SELECT m.KoreanTitle + ' (' + m.Title + ') - ' + CAST(m.ReleaseYear AS VARCHAR)
FROM Movie m
INNER JOIN Appear a ON m.MovieID = a.MovieID
INNER JOIN AwardInvolve ai ON a.AppearID = ai.AppearID
GROUP BY m.MovieID
ORDER BY COUNT(ai.InvolveID) DESC OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY;

-- Problem 26
SELECT TOP 10 m.KoreanTitle + ' (' + m.Title + ') - ' + CAST(m.ReleaseYear AS VARCHAR)
FROM Movie m
ORDER BY BoxOfficeWWGross DESC;

-- Problem 27
SELECT m.KoreanTitle + ' (' + m.Title + ') - ' + CAST(m.ReleaseYear AS VARCHAR)
FROM Movie m
WHERE m.BoxOfficeWWGross >= 1000000000 AND m.Budget <= 100000000
ORDER BY m.Budget ASC;

-- Problem 28
SELECT p.KoreanName, p.Name FROM Person p
INNER JOIN Appear a ON p.PersonID = a.PersonID
INNER JOIN Role r ON a.RoleID = r.RoleID
INNER JOIN Movie m ON a.MovieID = m.MovieID
INNER JOIN MovieGenre mg ON m.MovieID = mg.MovieID
INNER JOIN Genre g ON mg.GenreID = g.GenreID
WHERE r.RoleKorName = '감독' AND g.GenreKorName = '전쟁'
GROUP BY p.PersonID
ORDER BY COUNT(m.MovieID) DESC OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY;

-- Problem 29
SELECT KoreanTitle, Title, ReleaseYear FROM Movie m
WHERE m.BoxOfficeUSGross >= 10000000 AND m.RunningTime >= 100
ORDER BY m.BoxOfficeWWGross DESC;

-- Problem 30
SELECT m.KoreanTitle + ' (' + m.Title + ') - ' + CAST(m.ReleaseYear AS VARCHAR)
FROM Movie m
WHERE m.Budget >= 100000000
ORDER BY m.Budget DESC OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY;

-- Problem 31
SELECT KoreanTitle, Title FROM Movie WHERE KoreanTitle LIKE '플%' ORDER BY ReleaseYear DESC;

-- Problem 32
SELECT m.KoreanTitle + ' (' + m.Title + ') - ' + CAST(m.ReleaseYear AS VARCHAR)
FROM Movie m
INNER JOIN Appear a ON m.MovieID = a.MovieID
WHERE a.RoleID = 2 AND a.PersonID = 1;

-- Problem 35
SELECT p.Name + ' (' + p.KoreanName + ') FROM Person p
WHERE p.BirthDate < '1970-01-01' ORDER BY p.Name;