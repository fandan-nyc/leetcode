# Write your MySQL query statement below

SELECT shortest
FROM
  (SELECT a.x - b.x AS shortest
   FROM point a
   JOIN point b) t
WHERE shortest > 0
ORDER BY shortest
LIMIT 1;
