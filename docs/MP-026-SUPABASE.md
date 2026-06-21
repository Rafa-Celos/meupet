\# MP-026 - Publicação do Banco PostgreSQL no Supabase



\## Objetivo



Disponibilizar o banco de dados do projeto MeuPet em ambiente de nuvem para consumo externo e integração com ferramentas de BI.



\## Implementações



\* Criação de projeto no Supabase.

\* Configuração de acesso externo via PostgreSQL.

\* Migração do banco local Docker (meupet\_db).

\* Importação das tabelas:



&#x20; \* animals

&#x20; \* adotantes

&#x20; \* adocoes

&#x20; \* vacinacoes

&#x20; \* castracoes

&#x20; \* despesas

\* Importação das views analíticas:



&#x20; \* vw\_dashboard\_animais

&#x20; \* vw\_dashboard\_adocoes

&#x20; \* vw\_dashboard\_financeiro

&#x20; \* vw\_dashboard\_gastos\_mensais

&#x20; \* vw\_dashboard\_top\_animais

&#x20; \* vw\_dashboard\_vacinacoes\_mensais



\## Resultado



Banco de dados disponível em ambiente de nuvem, permitindo consultas externas e integração com ferramentas de Business Intelligence, especialmente o Looker Studio.



