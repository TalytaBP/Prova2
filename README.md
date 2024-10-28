# Projeto Loja de Brinquedos 

# Integrantes
Robson Apparecido dos Santos e Talyta Botelho Perrotti

# Funcionalidades
Criar (POST): Permite o cadastro de brinquedos no sistema;
Ler (GET): Realiza consultas de brinquedos já cadastrados;
Atualizar (PUT): Realizar uma atualização no sistema;
Deletar (DELETE): Deletar um brinquedo do sistema;

# Configuração do Banco de Dados
O projeto utiliza um banco de dados Oracle, e a conexão é feita por meio do arquivo application.properties do Spring Boot. As seguintes informações são armazenadas na tabela de brinquedos (TDS_TB_BRINQUEDOS):

[X] Id: Identificação única do brinquedo.
[X] Nome: Nome do brinquedo.
[X] Tipo: Tipo do brinquedo (Ex: Eletrônico, Educativo).
[X] Classificação: Faixa etária recomendada.
[X] Tamanho: Dimensões do brinquedo em centimetros.
[X] Preço: Preço do brinquedo.

# Exemplo de JSON para cadastro de brinquedos no sistema:

# Prints do POSTMAN
