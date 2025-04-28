-- 코드를 입력하세요
SELECT ANIMAL_ID,
    NAME,
    CASE 
        WHEN LOCATE('Neutered', SEX_UPON_INTAKE) > 0 THEN 'O'
        WHEN LOCATE('Spayed', SEX_UPON_INTAKE) > 0 THEN 'O'
        ELSE 'X'
    END 중성화
FROM ANIMAL_INS
ORDER BY ANIMAL_ID 
