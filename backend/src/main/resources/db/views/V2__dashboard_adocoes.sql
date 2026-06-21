CREATE OR REPLACE VIEW vw_dashboard_adocoes AS
SELECT
    COUNT(*) AS total_adocoes,

    ROUND(
        (
            COUNT(*)::numeric
            /
            NULLIF(
                (
                    SELECT COUNT(*)
                    FROM animals
                ),
                0
            )
        ) * 100,
        2
    ) AS percentual_adocao

FROM adocoes;