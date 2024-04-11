insert into produto (descricao, valor) values ('ZAPP 1L', 2500);
insert into produto (descricao, valor) values ('CLETODIM NORTOX CX 250 G', 1800);

INSERT INTO pessoa (nome, tipo, cnpj) VALUES ('Empresa A', 'J', '12345678000100'),('Empresa B', 'J', '23456789000111');

INSERT INTO pessoa (nome, tipo, cpf) VALUES ('João Silva', 'F', '12345678901'),('Maria Souza', 'F', '23456789012');




insert into venda (pessoa_id, data) values (1, '2024-03-05 10:00:00')
insert into venda (pessoa_id, data) values (3, '2024-03-06 10:00:00')
insert into venda (pessoa_id, data) values (3, '2024-03-07 10:00:00')
insert into venda (pessoa_id, data) values (2, '2024-03-08 10:00:00')




insert into item_venda (quantidade, venda_id, produto_id) values (10, 1, 1)
insert into item_venda (quantidade, venda_id, produto_id) values (20, 1, 2)

insert into item_venda (quantidade, venda_id, produto_id) values (1, 2, 1)
insert into item_venda (quantidade, venda_id, produto_id) values (4, 2, 2)


insert into item_venda (quantidade, venda_id, produto_id) values (1, 3, 1)
insert into item_venda (quantidade, venda_id, produto_id) values (2, 3, 2)


insert into item_venda (quantidade, venda_id, produto_id) values (11, 4, 1)
insert into item_venda (quantidade, venda_id, produto_id) values (12, 4, 2)

