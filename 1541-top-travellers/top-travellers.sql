# Write your MySQL query statement below
SELECT u.name,SUM(coalesce(r.distance,0)) as travelled_distance
FROM users u
LEFT JOIN Rides r ON r.user_id= u.id
GROUP BY user_id
ORDER BY travelled_distance DESC, u.name ASC
