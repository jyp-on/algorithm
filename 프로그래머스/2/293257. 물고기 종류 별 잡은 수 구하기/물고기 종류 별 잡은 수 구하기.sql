SELECT COUNT(fi.ID) AS FISH_COUNT, fni.FISH_NAME
FROM FISH_INFO fi 
JOIN 
    FISH_NAME_INFO fni 
ON 
    fi.FISH_TYPE = fni.FISH_TYPE
GROUP BY 
    fni.FISH_NAME
ORDER BY 
    FISH_COUNT DESC;