CREATE OR REPLACE VIEW public.vw_dashboard_adocoes AS
SELECT
    adotados AS total_adocoes,
    ROUND(
        adotados::numeric / total_animais::numeric,
        4
    ) AS percentual_adocao
FROM public.vw_dashboard_animais;