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

- [X] Id: Identificação única do brinquedo.
- [X] Nome: Nome do brinquedo.
- [X] Tipo: Tipo do brinquedo (Ex: Eletrônico, Educativo).
- [X] Classificação: Faixa etária recomendada.
- [X] Tamanho: Dimensões do brinquedo em centimetros.
- [X] Preço: Preço do brinquedo.

# Exemplo de JSON para cadastro de brinquedos no sistema:

...

{
  "nome": "Casa da Barbie",
  "tipo": "Casa de boneca",
  "classificacao": 10,
  "tamanho": 100.0,
  "preco": 3000.0
}
...

# Prints do POSTMAN

### Post
![Post](https://github.com/user-attachments/assets/2f43e345-5d90-4e38-af4b-c33f867ba7ce)

### Get
![Get](https://github.com/user-attachments/assets/5ee8aaa0-5ad8-4a76-b70e-d286ad48c5fc)

### Put
![PUT](https://github.com/user-attachments/assets/0f087268-1c8d-45d2-92f8-45de2d1c92de)


