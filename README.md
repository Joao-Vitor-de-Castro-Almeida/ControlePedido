# ControlePedido - Sistema de Gestão de Pedidos para E-commerce

## Descrição Geral
ControlePedido é um sistema backend desenvolvido em **Java com Spring Boot** para gerenciar pedidos de um sistema de e-commerce. Ele oferece funcionalidades como:

- Cadastro de pedidos
- Cálculo de frete com base no método de envio
- Gerenciamento de status do pedido conforme regras de negócio
- Exposição de API REST documentada com Swagger

O projeto aplica os padrões de projeto:
- **State**: controla os estados do pedido
- **Strategy**: calcula o frete de forma flexível

---

## Funcionalidades
- Criar novo pedido com nome do produto, valor e método de envio.
- Cálculo automático do frete ao criar o pedido.
- Listar todos os pedidos cadastrados.
- Consultar detalhes de um pedido por ID.
- Atualizar o status do pedido: pagar, enviar ou cancelar.
- Visualizar o valor do frete e o status atual do pedido.

---

## Regras de Negócio do Pedido
- Todo pedido é criado com o status **AGUARDANDO_PAGAMENTO**.
- Um pedido **aguardando pagamento** pode ser:
    - Marcado como **pago**
    - Marcado como **cancelado**
- Um pedido **pago** pode ser:
    - Marcado como **enviado**
    - Marcado como **cancelado**
- Um pedido **enviado** ou **cancelado** **não pode mais ser alterado**.
- A lógica de transição é encapsulada no `enum EstadoPedido`, seguindo o padrão State.

---

## Cálculo de Frete (Strategy)
O frete é calculado automaticamente com base no valor do pedido e no método de envio selecionado:

- **Via terrestre (caminhão)**: 5% do valor do pedido.
- **Via aérea (avião)**: 10% do valor do pedido.

Essas estratégias estão implementadas no `enum MetodoEnvio`, permitindo adicionar facilmente novos tipos de envio no futuro.

---

## Persistência de Dados
- Persistência feita com **Spring Data JPA**.
- Entidade `Pedido` mapeada com anotações JPA.
- Suporte a bancos como **H2 (para testes)** e **PostgreSQL/MySQL (produção)**.

---

## API REST
A API está totalmente documentada com **Swagger/OpenAPI** e pode ser testada com ferramentas como **Postman** e **Insomnia**.

### Principais Endpoints
| Método | Rota                      | Ação                         |
|--------|---------------------------|------------------------------|
| POST   | `/pedidos`                | Criar um novo pedido         |
| GET    | `/pedidos`                | Listar todos os pedidos      |
| GET    | `/pedidos/{id}`           | Buscar pedido por ID         |
| POST   | `/pedidos/{id}/pagar`     | Marcar pedido como pago      |
| POST   | `/pedidos/{id}/cancelar`  | Cancelar um pedido           |
| POST   | `/pedidos/{id}/enviar`    | Enviar um pedido (se pago)   |
