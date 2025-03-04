select sum(g.score) score, e.emp_no, e.emp_name, e.position, e.email from HR_GRADE g
join HR_EMPLOYEES e on e.EMP_NO = g.EMP_NO
group by e.emp_no
order by sum(g.score) desc
limit 1