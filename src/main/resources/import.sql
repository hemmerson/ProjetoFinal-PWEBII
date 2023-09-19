INSERT INTO pessoa (id, nome) VALUES (1,'João Silva');
INSERT INTO paciente (id_pessoa, telefone) VALUES (1, '1234567890');

INSERT INTO pessoa (id, nome) VALUES (2,'Maria Santos');
INSERT INTO paciente (id_pessoa, telefone) VALUES (2, '9876543210');

INSERT INTO pessoa (id, nome) VALUES (3,'Carlos Oliveira');
INSERT INTO paciente (id_pessoa, telefone) VALUES (3, '5555555555');

INSERT INTO pessoa (id, nome) VALUES (4,'Ana Souza');
INSERT INTO paciente (id_pessoa, telefone) VALUES (4, '7777777777');

INSERT INTO pessoa (id, nome) VALUES (5,'Rafael Pereira');
INSERT INTO paciente (id_pessoa, telefone) VALUES (5, '9999999999');
-- ------------------------------------------------------------------------------
INSERT INTO pessoa (id, nome) VALUES (6,'Dr. João Santos');
INSERT INTO medico (id_pessoa, crm) VALUES (6, '12345');

INSERT INTO pessoa (id, nome) VALUES (7,'Dra. Maria Oliveira');
INSERT INTO medico (id_pessoa, crm) VALUES (7, '54321');

INSERT INTO pessoa (id, nome) VALUES (8,'Dr. Carlos Silva');
INSERT INTO medico (id_pessoa, crm) VALUES (8, '98765');

INSERT INTO pessoa (id, nome) VALUES (9,'Dra. Ana Pereira');
INSERT INTO medico (id_pessoa, crm) VALUES (9, '67890');

INSERT INTO pessoa (id, nome) VALUES (10,'Dr. Rafael Costa');
INSERT INTO medico (id_pessoa, crm) VALUES (10, '23456');

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
