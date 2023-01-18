INSERT INTO usuario (id, email, nome, senha) values (1, 'thiago@hotmail.com', 'Thiago Henrique', '$2a$10$.b0TDo0au2KeGOFRXGTuJOZ8Zr0QGJMyaH4HQ2/LfpwB5aQ6Z85l.');
INSERT INTO usuario (id, email, nome, senha) values (2, 'carlos@hotmail.com', 'Carlos Henrique', '$2a$10$.b0TDo0au2KeGOFRXGTuJOZ8Zr0QGJMyaH4HQ2/LfpwB5aQ6Z85l.');

INSERT INTO permissao (id, descricao) values (1, 'ROLE_CADASTRAR_APARTAMENTO');
INSERT INTO permissao (id, descricao) values (2, 'ROLE_PESQUISAR_APARTAMENTO');
INSERT INTO permissao (id, descricao) values (3, 'ROLE_REMOVER_APARTAMENTO');

INSERT INTO permissao (id, descricao) values (4, 'ROLE_CADASTRAR_LANCAMENTO');
INSERT INTO permissao (id, descricao) values (5, 'ROLE_REMOVER_LANCAMENTO');
INSERT INTO permissao (id, descricao) values (6, 'ROLE_PESQUISAR_LANCAMENTO');

INSERT INTO permissao (id, descricao) values (7, 'ROLE_CADASTRAR_INQUILINO');
INSERT INTO permissao (id, descricao) values (8, 'ROLE_REMOVER_INQUILINO');
INSERT INTO permissao (id, descricao) values (9, 'ROLE_PESQUISAR_INQUILINO');

INSERT INTO permissao (id, descricao) values (10, 'ROLE_CADASTRAR_PREDIO');
INSERT INTO permissao (id, descricao) values (11, 'ROLE_REMOVER_PREDIO');
INSERT INTO permissao (id, descricao) values (12, 'ROLE_PESQUISAR_PREDIO');

INSERT INTO permissao (id, descricao) values (13, 'ROLE_CADASTRAR_VALOR');
INSERT INTO permissao (id, descricao) values (14, 'ROLE_REMOVER_VALOR');
INSERT INTO permissao (id, descricao) values (15, 'ROLE_PESQUISAR_VALOR');

-- admin
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 1);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 3);

INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 4);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 6);

INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 7);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 8);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 9);

INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 10);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 11);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 12);

INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 13);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 14);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 15);

INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 13);

