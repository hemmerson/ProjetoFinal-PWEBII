INSERT INTO pessoa (id, nome, email, telefone) VALUES (1,'João Silva', 'joaosilva@email.com', '1234567890');
INSERT INTO paciente (id_pessoa, cpf, plano_saude) VALUES (1, '222.111.333-21', 'GEAP');

INSERT INTO pessoa (id, nome, email, telefone) VALUES (2,'Maria Santos', 'mariasantos@email.com', '9876543210');
INSERT INTO paciente (id_pessoa, cpf, plano_saude) VALUES (2, '111.333.444-01', 'Bradesco Saúde');

INSERT INTO pessoa (id, nome, email, telefone) VALUES (3,'Carlos Oliveira', 'carlosoliveira@email.com', '5555555555');
INSERT INTO paciente (id_pessoa, cpf, plano_saude) VALUES (3, '555.444.666-99', 'UNIMED');

INSERT INTO pessoa (id, nome, email, telefone) VALUES (4,'Ana Souza', 'anasouza@email.com', '7777777777');
INSERT INTO paciente (id_pessoa, cpf, plano_saude) VALUES (4, '888.999.000.11', 'Hapvida');

INSERT INTO pessoa (id, nome, email, telefone) VALUES (5,'Rafael Pereira', 'rafaelpereira@email.com', '9999999999');
INSERT INTO paciente (id_pessoa, cpf, plano_saude) VALUES (5, '333.222.111-00', 'GEAP');
-- ------------------------------------------------------------------------------
INSERT INTO pessoa (id, nome, email, telefone) VALUES (6,'Dr. João Santos', 'drjoaosantos@email.com', '918273645');
INSERT INTO medico (id_pessoa, crm, especialidade) VALUES (6, '12345', 'Geriatra');

INSERT INTO pessoa (id, nome, email, telefone) VALUES (7,'Dra. Maria Oliveira', 'drmariaoliveira@email.com', '654321234');
INSERT INTO medico (id_pessoa, crm, especialidade) VALUES (7, '54321', 'Clínico Geral');

INSERT INTO pessoa (id, nome, email, telefone) VALUES (8,'Dr. Carlos Silva', 'drcarlossilva@email.com', '423156788');
INSERT INTO medico (id_pessoa, crm, especialidade) VALUES (8, '98765', 'Oncologia');

INSERT INTO pessoa (id, nome, email, telefone) VALUES (9,'Dra. Ana Pereira', 'dranapereira@email.com', '876567821');
INSERT INTO medico (id_pessoa, crm, especialidade) VALUES (9, '67890', 'Pediatra');

INSERT INTO pessoa (id, nome, email, telefone) VALUES (10,'Dr. Rafael Costa', 'drrafaelcosta@email.com', '231123223');
INSERT INTO medico (id_pessoa, crm, especialidade) VALUES (10, '23456', 'Oftamologista');

-- ------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Inserindo dados para a primeira consulta
INSERT INTO consulta (valor, data, medico_id_pessoa, paciente_id_pessoa, observacao) VALUES (150.00, '2023-08-25 10:00:00', 6, 1, 'Consulta de rotina');

-- Inserindo dados para a segunda consulta
INSERT INTO consulta (valor, data, medico_id_pessoa, paciente_id_pessoa, observacao) VALUES (200.50, '2023-08-26 15:30:00', 7, 2, 'Acompanhamento pós-operatório');

-- Inserindo dados para a terceira consulta
INSERT INTO consulta (valor, data, medico_id_pessoa, paciente_id_pessoa, observacao) VALUES (120.75, '2023-08-27 11:15:00', 6, 3, 'Consulta de emergência');

-- Inserindo dados para a quarta consulta
INSERT INTO consulta (valor, data, medico_id_pessoa, paciente_id_pessoa, observacao) VALUES (180.25, '2023-08-28 14:00:00', 7, 4, 'Avaliação de sintomas');

-- Inserindo dados para a quinta consulta
INSERT INTO consulta (valor, data, medico_id_pessoa, paciente_id_pessoa, observacao) VALUES (90.00, '2023-08-29 09:30:00', 9, 5, 'Consulta de acompanhamento');

-- Inserindo dados para a sexta consulta
INSERT INTO consulta (valor, data, medico_id_pessoa, paciente_id_pessoa, observacao) VALUES (135.50, '2023-09-01 13:45:00', 7, 3, 'Acompanhamento de tratamento');

-- Inserindo dados para a sétima consulta
INSERT INTO consulta (valor, data, medico_id_pessoa, paciente_id_pessoa, observacao) VALUES (175.00, '2023-09-02 16:20:00', 8, 2, 'Consulta de rotina');

-- Inserindo dados para a oitava consulta
INSERT INTO consulta (valor, data, medico_id_pessoa, paciente_id_pessoa, observacao) VALUES (210.25, '2023-09-03 09:00:00', 6, 5, 'Exames de acompanhamento');

-- Inserindo dados para a nona consulta
INSERT INTO consulta (valor, data, medico_id_pessoa, paciente_id_pessoa, observacao) VALUES (90.50, '2023-09-04 11:30:00', 9, 4, 'Discussão de opções de tratamento');

-- Inserindo dados para a décima consulta
INSERT INTO consulta (valor, data, medico_id_pessoa, paciente_id_pessoa, observacao) VALUES (150.75, '2023-09-05 14:15:00', 10, 1, 'Consulta de acompanhamento pós-cirúrgico');

-- Inserindo dados para a décima primeira consulta
INSERT INTO consulta (valor, data, medico_id_pessoa, paciente_id_pessoa, observacao) VALUES (180.00, '2023-09-06 10:45:00', 8, 5, 'Avaliação de sintomas');

-- Inserindo dados para a décima segunda consulta
INSERT INTO consulta (valor, data, medico_id_pessoa, paciente_id_pessoa, observacao) VALUES (120.25, '2023-09-07 08:30:00', 7, 4, 'Consulta de rotina');

-- Inserindo dados para a décima terceira consulta
INSERT INTO consulta (valor, data, medico_id_pessoa, paciente_id_pessoa, observacao) VALUES (95.50, '2023-09-08 16:00:00', 9, 3, 'Acompanhamento de medicação');

-- Inserindo dados para a décima quarta consulta
INSERT INTO consulta (valor, data, medico_id_pessoa, paciente_id_pessoa, observacao) VALUES (200.00, '2023-09-09 14:30:00', 10, 2, 'Consulta de avaliação geral');

-- Inserindo dados para a décima quinta consulta
INSERT INTO consulta (valor, data, medico_id_pessoa, paciente_id_pessoa, observacao) VALUES (130.75, '2023-09-10 12:00:00', 6, 1, 'Consulta de acompanhamento');

-- ------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Criando ROLE ADMIN
INSERT INTO role (id, nome) VALUES (1, 'ROLE_ADMIN');

-- Criando ROLE USER
INSERT INTO role (id, nome) VALUES (2, 'ROLE_USER');

-- ------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Criando usuario com login = admin
INSERT INTO usuario (id, login, password) VALUES (1, 'admin', '$2a$10$tOi5F6t0yclgtf58gdsQC.76ddvKkLQzleFNWEQu9b92ik.VF0Ep.');

-- Criando usuario com login = user
INSERT INTO usuario (id, login, password) VALUES (2, 'user', '$2a$10$/mxyUb/49r/khlwfdYJW7.pB9maph6kGh8QBf5R5oVgSjjmlI6SLa');

-- ------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO usuario_roles (roles_id, usuarios_id) VALUES ( 1, 1 );
INSERT INTO usuario_roles (roles_id, usuarios_id) VALUES ( 2, 2 );