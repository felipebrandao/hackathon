INSERT INTO public.endereco (id, cep, cidade, estado, logradouro) VALUES(1, '42840-562', 'Camaçari', 'BA', 'Av Humaita - Guarajuba');
INSERT INTO public.endereco (id, cep, cidade, estado, logradouro) VALUES(2, '48280-000', 'Mata de São João', 'BA', 'Av do Farol - Praia do Forte');

INSERT INTO public.localidade (id, id_endereco, nome) VALUES(1, 1, 'Praia Guarajuba');
INSERT INTO public.localidade (id, id_endereco, nome) VALUES(2, 2, 'Praia do Forte');

INSERT INTO public.predio (id, id_localidade, nome) VALUES(1, 1, 'Pousada em Guarajuba');
INSERT INTO public.predio (id, id_localidade, nome) VALUES(2, 2, 'Pousada em Praia do Forte');

INSERT INTO public.amenidade (quantidade, id, id_predio, descricao) VALUES(1, 1, 1, 'Piscina Adulto, aquecida e coberta');
INSERT INTO public.amenidade (quantidade, id, id_predio, descricao) VALUES(1, 2, 1, 'Piscina Adulto, não aquecida em área aberta');
INSERT INTO public.amenidade (quantidade, id, id_predio, descricao) VALUES(1, 3, 1, 'Piscina Infantil, aquecida e coberta');
INSERT INTO public.amenidade (quantidade, id, id_predio, descricao) VALUES(2, 4, 1, 'Piscina Infantil, não aquecida em área aberta');
INSERT INTO public.amenidade (quantidade, id, id_predio, descricao) VALUES(2, 5, 1, 'Restaurantes no estilo Self Service');
INSERT INTO public.amenidade (quantidade, id, id_predio, descricao) VALUES(1, 6, 1, 'Restaurante a La Carte');
INSERT INTO public.amenidade (quantidade, id, id_predio, descricao) VALUES(1, 7, 1, ' Área Kids, com brinquedoteca, vídeo games e biblioteca');
INSERT INTO public.amenidade (quantidade, id, id_predio, descricao) VALUES(1, 8, 1, 'Equipe de Entretenimento Infantil (diversas idades) e adulto');
INSERT INTO public.amenidade (quantidade, id, id_predio, descricao) VALUES(1, 9, 2, 'Piscina Adulto, aquecida e coberta');
INSERT INTO public.amenidade (quantidade, id, id_predio, descricao) VALUES(2, 10, 2, 'Piscina Adulto, não aquecida em área aberta');
INSERT INTO public.amenidade (quantidade, id, id_predio, descricao) VALUES(1, 11, 2, 'Piscina Infantil, aquecida e coberta');
INSERT INTO public.amenidade (quantidade, id, id_predio, descricao) VALUES(2, 12, 2, 'Piscina Infantil, não aquecida em área aberta');
INSERT INTO public.amenidade (quantidade, id, id_predio, descricao) VALUES(1, 13, 2, 'Restaurantes no estilo Self Service');
INSERT INTO public.amenidade (quantidade, id, id_predio, descricao) VALUES(1, 14, 2, ' Área Kids, com brinquedoteca, vídeo games e biblioteca');

INSERT INTO public.quarto (quantidade_quartos, total_pessoas, valor_diaria, id, id_predio, tipo_banheiro, tipo_quarto) VALUES(20, 4, 350.00, 1, 1, 'SIMPLES', 'STANDARD_SIMPLES');
INSERT INTO public.moveis (quantidade, id, id_quarto, descricao) VALUES(1, 1, 1, 'Sofá');
INSERT INTO public.moveis (quantidade, id, id_quarto, descricao) VALUES(2, 2, 1, 'Poltronas');
INSERT INTO public.moveis (quantidade, id, id_quarto, descricao) VALUES(1, 3, 1, 'Frigobar');
INSERT INTO public.moveis (quantidade, id, id_quarto, descricao) VALUES(1, 4, 1, 'TV Led 54 pols.');
INSERT INTO public.moveis (quantidade, id, id_quarto, descricao) VALUES(1, 5, 1, 'Mesa de Escritório');
INSERT INTO public.moveis (quantidade, id, id_quarto, descricao) VALUES(1, 6, 1, 'Cadeira de Escritório');

INSERT INTO public.cama (quantidade, id, id_quarto, descricao) VALUES(2, 1, 1, 'Queen Size');


INSERT INTO public.quarto (quantidade_quartos, total_pessoas, valor_diaria, id, id_predio, tipo_banheiro, tipo_quarto) VALUES(20, 4, 350.00, 2, 2, 'LUXO', 'LUXO_SIMPLES');
INSERT INTO public.moveis (quantidade, id, id_quarto, descricao) VALUES(2, 7, 2, 'Sofá');
INSERT INTO public.moveis (quantidade, id, id_quarto, descricao) VALUES(2, 8, 2, 'Poltronas');
INSERT INTO public.moveis (quantidade, id, id_quarto, descricao) VALUES(2, 9, 2, 'Frigobar');
INSERT INTO public.moveis (quantidade, id, id_quarto, descricao) VALUES(2, 10, 2, 'TV Led 54 pols.');
INSERT INTO public.moveis (quantidade, id, id_quarto, descricao) VALUES(2, 11, 2, 'Mesa de Escritório');
INSERT INTO public.moveis (quantidade, id, id_quarto, descricao) VALUES(2, 12, 2, 'Cadeira de Escritório');

INSERT INTO public.cama (quantidade, id, id_quarto, descricao) VALUES(2, 2, 2, 'Queen Size');

INSERT INTO public.cliente (data_nascimento, id, cpf, email, endereco_pais_origem, nome_completo, pais_origem, passaporte, telefone) VALUES('1975-03-10', 1, '69897726039', 'heloise.maite.drumond@oliveiraesouza.adv.br', 'Av Paulista', 'Heloise Maitê Bianca Drumond', 'Brasil', 'NI308270', '(11) 98751-4929');