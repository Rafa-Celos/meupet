CREATE OR REPLACE VIEW vw_dashboard_gastos_mensais AS
SELECT
    TO_CHAR(
        data_despesa,
        'YYYY-MM'
    ) AS mes,

    COUNT(*) AS quantidade,
    SUM(valor) AS total

FROM despesas
GROUP BY mes
ORDER BY mes;