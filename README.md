# HealthPlan API

A HealthPlan API é uma aplicação REST desenvolvida com Spring Boot para gerenciar planos de saúde. Esta API oferece recursos para realizar operações CRUD (Create, Read, Update, Delete) em planos de saúde, beneficiários e outras funcionalidades relacionadas.

## Características Principais
- Cadastrar um beneficiário junto com seus documentos;
- Listar todos os beneficiários cadastrados;
- Listar todos os documentos de um beneficiário a partir de seu id;
- Atualizar os dados cadastrais de um beneficiário;
- Remover um beneficiário.

## Tecnologias Utilizadas
- Java 8
- Spring Boot
- H2 Database
- Maven
- Swagger

## Configuração do Ambiente de Desenvolvimento
1. Baixe o repositório.

## Informações importantes
Documentação dos endpoints: http://localhost:8080/swagger-ui/index.html

Login e senha para autorização da API:
Login: admin
Senha: admin

Console do banco de dados H2: localhost:8080/h2-console/
Login: admin
Senha: admin

## Utilização do Postman
Para facilitar a manipulação e teste da API, recomenda-se o uso do [Postman](https://www.postman.com/).

Exemplo:
Post
http://localhost:8080/api/beneficiarios/cadastrar
{
  "nome": "novo nome",
  "telefone": "123456789",
  "dataNascimento": "1997-04-08",
  "documentos": [
    {
      "tipoDocumento": "RG",
      "descricao": "4567891",
      "dataInclusao": "2024-01-20",
      "dataAtualizacao": "2024-01-20"
    },
    {
      "tipoDocumento": "CPF",
      "descricao": "987654321",
      "dataInclusao": "2024-01-20",
      "dataAtualizacao": "2024-01-20"
    }]}

## Executando o Build e Iniciando a Aplicação
Certifique-se de ter o Java 8 instalado.
Certifique-se de ter o Maven instalado.

Abra o CMD - Navegue até o diretório do projeto
Execute os comandos:
```
mvn clean install
java -jar target/HealthPlan-1.0.jar
