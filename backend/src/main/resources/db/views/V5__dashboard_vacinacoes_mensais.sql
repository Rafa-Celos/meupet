CREATE OR REPLACE VIEW vw_dashboard_vacinacoes_mensais AS
SELECT
    TO_CHAR(
        data_aplicacao,
        'YYYY-MM'
    ) AS mes,

    COUNT(*) AS quantidade

FROM vacinacoes
GROUP BY mes
ORDER BY mes;