# ControlePedido - Sistema de Gestão de Pedidos para E-commerce

- Descrição Geral

Este sistema é uma aplicação backend desenvolvida em Java com Spring Boot, voltada para a gestão de pedidos em um sistema de e-commerce. Ele permite o cadastro de pedidos, cálculo automático do frete com base no método de envio escolhido, controle de status conforme regras de negócio, e exposição de endpoints REST para consumo por clientes como Swagger ou Postman.

O projeto utiliza boas práticas de modelagem orientada a objetos e aplica os padrões de projeto State (para o controle de status) e Strategy (para o cálculo de frete), proporcionando um sistema coeso, extensível e de fácil manutenção.

- Funcionalidades

Criar novo pedido com nome do produto, valor e método de envio.

Cálculo automático do frete no momento da criação do pedido.

Listar todos os pedidos armazenados no banco de dados.

Consultar os detalhes de um pedido por ID.

Atualizar o status do pedido para pago, enviado ou cancelado, com base em regras específicas de transição.

Visualizar o valor do frete e status atual de cada pedido.

- Regras de Negócio do Pedido

Cada pedido é criado com o status AGUARDANDO_PAGAMENTO.

Um pedido aguardando pagamento pode ser:

Marcado como pago

Marcado como cancelado

Um pedido pago pode ser:

Marcado como enviado

Marcado como cancelado

Um pedido enviado ou cancelado não pode sofrer novas alterações.

A lógica de transição é controlada pelo enum EstadoPedido.

- Cálculo de Frete (Strategy)

O frete é calculado automaticamente com base no valor do pedido e no método de envio escolhido:

Via terrestre (caminhão): 5% do valor do pedido.

Via aérea (avião): 10% do valor do pedido.

Esse comportamento é encapsulado no enum MetodoEnvio, facilitando a extensão com novos tipos de transporte.

- Persistência

O sistema utiliza Spring Data JPA para persistência.

A entidade Pedido é mapeada com anotações JPA.

O banco de dados utilizado pode ser H2 (para testes) ou PostgreSQL/MySQL (produção).

- API REST

A API REST está totalmente documentada via Swagger/OpenAPI e pode ser testada usando Postman, Insomnia ou navegador web.

- Principais Endpoints

POST /pedidos – Criar um novo pedido.

GET /pedidos – Listar todos os pedidos.

GET /pedidos/{id} – Obter detalhes de um pedido específico.

POST /pedidos/{id}/pagar – Marcar o pedido como pago.

POST /pedidos/{id}/cancelar – Cancelar o pedido.

POST /pedidos/{id}/enviar – Enviar o pedido (caso já esteja pago).