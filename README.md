## API Pedido de compras

API RESTful para receber pedidos de compras.

Entidades:
- Usuário
- Endereço
- Produto
- Pedido
- ItemPedido

Funcionalidades:
- Cadastrar o usuário
- Validar nome, cpf, email e endereço
- Recuperar e salvar os produtos de uma API externa: https://dummyjson.com/products/search?q=phone
- Listar os produtos disponíveis

- Finalizar o pedido de compras: 
  - O usuário (cliente) precisa realizar login (JWT)
  - Salvar o pedido
  - Validar o estoque
  - Dar baixa no estoque
  - Enviar um email de confirmação para o cliente
  - Enviar um email para o responsável do departamento de vendas