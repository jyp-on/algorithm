select name from employee e1
join (select managerId, count(managerId) c from employee
group by managerId 
having c >= 5) e2 on e1.id = e2.managerId