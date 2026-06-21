CREATE OR REPLACE VIEW vw_dashboard_top_animais AS
SELECT
    a.id,
    a.nome,
    a.especie,
    SUM(d.valor) AS gasto_total

FROM animals a
JOIN despesas d
    ON d.animal_id = a.id

GROUP BY
    a.id,
    a.nome,
    a.especie

ORDER BY gasto_total DESC;