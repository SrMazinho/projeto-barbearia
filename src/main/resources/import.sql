insert into cliente(id, nome, cpf) values (1,'João da Silveira', '201.576.231-19');
insert into cliente(id, nome, cpf) values (2,'Pedro Cruz', '202.476.231-29');
insert into cliente(id, nome, cpf) values (3,'Raphael Bernardo', '203.376.231-39');
insert into cliente(id, nome, cpf) values (4,'Vinicius Francisco', '204.276.231-49');
insert into cliente(id, nome, cpf) values (5,'João Paulo', '205.176.231-59');

insert into funcionario(id, nome, telefone, salario, funcao, cpf) values (1, 'João Gomes', '952147895', 2500, 'Barbeiro','211.171.231-99');
insert into funcionario(id, nome, telefone, salario, funcao, cpf) values (2, 'Lucas Santana', '942147895', 2000, 'Recepcionista','221.172.231-99');
insert into funcionario(id, nome, telefone, salario, funcao, cpf) values (3, 'Tulio Arruda', '932147895', 2500, 'Barbeiro','231.173.231-99');
insert into funcionario(id, nome, telefone, salario, funcao, cpf) values (4, 'Pedro Nascimento', '922147895', 2500, 'Barbeiro','241.174.231-99');
insert into funcionario(id, nome, telefone, salario, funcao, cpf) values (5, 'Francisco Flor', '912147895', 5000, 'Gerente','251.175.231-99');

insert into servico(id, descricao, cliente_id, funcionario_id) values (1, 'Corte', 1, 5);
insert into servico(id, descricao, cliente_id, funcionario_id) values (2, 'Corte e barba', 2, 4);
insert into servico(id, descricao, cliente_id, funcionario_id) values (3, 'Barba', 3, 3);
insert into servico(id, descricao, cliente_id, funcionario_id) values (4, 'Corte e barba', 4, 2);
insert into servico(id, descricao, cliente_id, funcionario_id) values (5, 'barba', 5, 1);