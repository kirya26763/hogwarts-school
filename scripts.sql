-- 1) Получить всех студентов, возраст которых между 10 и 20
SELECT * FROM student
WHERE age BETWEEN 10 AND 20;

-- 2) Получить всех студентов, но отобразить только список их имен
SELECT name FROM student;

-- 3) Получить всех студентов, у которых в имени присутствует буква 'О' (регистр может зависеть от СУБД)
SELECT * FROM student
WHERE name ILIKE '%о%';  -- ILIKE работает без учета регистра (PostgreSQL)

-- 4) Получить всех студентов, у которых возраст меньше идентификатора
SELECT * FROM student
WHERE age < id;

--5) Получить всех студентов, упорядоченных по возрасту (по возрастанию)
SELECT * FROM student
ORDER BY age ASC;