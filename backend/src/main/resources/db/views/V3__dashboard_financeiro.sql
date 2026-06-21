CREATE OR REPLACE VIEW vw_dashboard_financeiro AS
SELECT
    categoria,
    COUNT(*) AS quantidade,
    SUM(valor) AS total,
    AVG(valor) AS media
FROM despesas
GROUP BY categoria
ORDER BY total DESC;