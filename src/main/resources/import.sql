INSERT INTO paciente (nome, telefone) VALUES ('João Silva', '1234567890');
INSERT INTO paciente (nome, telefone) VALUES ('Maria Santos', '9876543210');
INSERT INTO paciente (nome, telefone) VALUES ('Carlos Oliveira', '5555555555');
INSERT INTO paciente (nome, telefone) VALUES ('Ana Souza', '7777777777');
INSERT INTO paciente (nome, telefone) VALUES ('Rafael Pereira', '9999999999');

INSERT INTO medico (nome, crm) VALUES ('Dr. João Santos', '12345');
INSERT INTO medico (nome, crm) VALUES ('Dra. Maria Oliveira', '54321');
INSERT INTO medico (nome, crm) VALUES ('Dr. Carlos Silva', '98765');
INSERT INTO medico (nome, crm) VALUES ('Dra. Ana Pereira', '67890');
INSERT INTO medico (nome, crm) VALUES ('Dr. Rafael Costa', '23456');

-- Inserindo dados para a primeira consulta
INSERT INTO consulta (valor, data, medico_id, paciente_id, observacao) VALUES (150.00, '2023-08-25 10:00:00', 1, 1, 'Consulta de rotina');

-- Inserindo dados para a segunda consulta
INSERT INTO consulta (valor, data, medico_id, paciente_id, observacao) VALUES (200.50, '2023-08-26 15:30:00', 2, 2, 'Acompanhamento pós-operatório');

-- Inserindo dados para a terceira consulta
INSERT INTO consulta (valor, data, medico_id, paciente_id, observacao) VALUES (120.75, '2023-08-27 11:15:00', 1, 3, 'Consulta de emergência');

-- Inserindo dados para a quarta consulta
INSERT INTO consulta (valor, data, medico_id, paciente_id, observacao) VALUES (180.25, '2023-08-28 14:00:00', 3, 4, 'Avaliação de sintomas');

-- Inserindo dados para a quinta consulta
INSERT INTO consulta (valor, data, medico_id, paciente_id, observacao) VALUES (90.00, '2023-08-29 09:30:00', 4, 5, 'Consulta de acompanhamento');

-- Inserindo dados para a sexta consulta
INSERT INTO consulta (valor, data, medico_id, paciente_id, observacao) VALUES (135.50, '2023-09-01 13:45:00', 2, 3, 'Acompanhamento de tratamento');

-- Inserindo dados para a sétima consulta
INSERT INTO consulta (valor, data, medico_id, paciente_id, observacao) VALUES (175.00, '2023-09-02 16:20:00', 3, 2, 'Consulta de rotina');

-- Inserindo dados para a oitava consulta
INSERT INTO consulta (valor, data, medico_id, paciente_id, observacao) VALUES (210.25, '2023-09-03 09:00:00', 1, 5, 'Exames de acompanhamento');

-- Inserindo dados para a nona consulta
INSERT INTO consulta (valor, data, medico_id, paciente_id, observacao) VALUES (90.50, '2023-09-04 11:30:00', 4, 4, 'Discussão de opções de tratamento');

-- Inserindo dados para a décima consulta
INSERT INTO consulta (valor, data, medico_id, paciente_id, observacao) VALUES (150.75, '2023-09-05 14:15:00', 5, 1, 'Consulta de acompanhamento pós-cirúrgico');

-- Inserindo dados para a décima primeira consulta
INSERT INTO consulta (valor, data, medico_id, paciente_id, observacao) VALUES (180.00, '2023-09-06 10:45:00', 3, 5, 'Avaliação de sintomas');

-- Inserindo dados para a décima segunda consulta
INSERT INTO consulta (valor, data, medico_id, paciente_id, observacao) VALUES (120.25, '2023-09-07 08:30:00', 2, 4, 'Consulta de rotina');

-- Inserindo dados para a décima terceira consulta
INSERT INTO consulta (valor, data, medico_id, paciente_id, observacao) VALUES (95.50, '2023-09-08 16:00:00', 4, 3, 'Acompanhamento de medicação');

-- Inserindo dados para a décima quarta consulta
INSERT INTO consulta (valor, data, medico_id, paciente_id, observacao) VALUES (200.00, '2023-09-09 14:30:00', 5, 2, 'Consulta de avaliação geral');

-- Inserindo dados para a décima quinta consulta
INSERT INTO consulta (valor, data, medico_id, paciente_id, observacao) VALUES (130.75, '2023-09-10 12:00:00', 1, 1, 'Consulta de acompanhamento');
