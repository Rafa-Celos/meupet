CREATE OR REPLACE VIEW vw_dashboard_animais AS
SELECT
    COUNT(*) AS total_animais,

    COUNT(*) FILTER (
        WHERE status = 'DISPONIVEL'
    ) AS disponiveis,

    COUNT(*) FILTER (
        WHERE status = 'ADOTADO'
    ) AS adotados,

    COUNT(*) FILTER (
        WHERE ativo = true
    ) AS ativos,

    COUNT(*) FILTER (
        WHERE ativo = false
    ) AS inativos

FROM animals;