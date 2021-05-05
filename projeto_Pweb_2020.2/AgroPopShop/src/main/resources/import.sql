/*Primeira linha em branco - Spring não tava adicionado os valores*/
INSERT INTO clientes (nome_Completo, email, telefone, cep, uf, cidade, bairro, rua, numero, complemento, genero) VALUES ('Letícia Amaral', 'leticia@mail.com', '84923234321', '59510-030', 'RN', 'Natal', 'Centro', 'Rua flores', '23', 'casa', 'Feminino');
INSERT INTO clientes (nome_Completo, email, telefone, cep, uf, cidade, bairro, rua, numero, complemento, genero) VALUES ('José camara', 'josecamara@gov.br', '1174343212', '59520-000', 'SP', 'São Paulo', 'Centro', 'Rua Rosas', '234', 'Apartamento 3', 'Masculino');
INSERT INTO clientes (nome_Completo, email, telefone, cep, uf, cidade, bairro, rua, numero, complemento, genero) VALUES ('Jarbas Alcantara Nobre', 'jarbas@mail.com', '11234326543', '23510-012', 'SP', 'São Paulo', 'Centro', 'Avenida Brasil', '1345', 'Centro', 'Não Informado');
INSERT INTO produtos (nome_Produto, marca, preco, altura, largura, profundidade, peso) VALUES ('Fertilizante', 'Fertipus', 23.50, 12, 5, 2, 1.5);
INSERT INTO dependentes (nome_Completo, data_nascimento, genero, id_principal) VALUES ('Jorge Amaral', parseDateTime('21/06/1839','dd/MM/yyyy'), 'Masculino', 1);
INSERT INTO dependentes (nome_Completo, data_nascimento, genero, id_principal) VALUES ('Leandra Amaral', parseDateTime('15/01/1994','dd/MM/yyyy'), 'Feminino', 1);
INSERT INTO dependentes (nome_Completo, data_nascimento, genero, id_principal) VALUES ('Lizandra Amaral', parseDateTime('15/01/1994','dd/MM/yyyy'), 'Feminino', 1);
INSERT INTO dependentes (nome_Completo, data_nascimento, genero, id_principal) VALUES ('Sirius Black', parseDateTime('15/02/1842','dd/MM/yyyy'), 'Masculino', 2);
INSERT INTO dependentes (nome_Completo, data_nascimento, genero, id_principal) VALUES ('Sandra Moreira', parseDateTime('24/06/1992','dd/MM/yyyy'), 'Feminino', 2);
INSERT INTO dependentes (nome_Completo, data_nascimento, genero, id_principal) VALUES ('Francisco Alcantara Nobre', parseDateTime('28/02/1983','dd/MM/yyyy'), 'Masculino', 3);
INSERT INTO dependentes (nome_Completo, data_nascimento, genero, id_principal) VALUES ('Geralda Alcantara Nobre Barros', parseDateTime('17/08/1982','dd/MM/yyyy'), 'Feminino', 3);