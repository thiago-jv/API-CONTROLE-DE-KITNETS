DELETE FROM usuario_permissao;
DELETE FROM usuario;
DELETE FROM permissao;

INSERT INTO usuario (id, email, nome, senha) values (1, 'thiago', 'Thiago Henrique', '$2a$10$.b0TDo0au2KeGOFRXGTuJOZ8Zr0QGJMyaH4HQ2/LfpwB5aQ6Z85l.');--  angular
INSERT INTO usuario (id, email, nome, senha) values (2, 'carlos', 'Carlos Henrique', '$2a$10$.b0TDo0au2KeGOFRXGTuJOZ8Zr0QGJMyaH4HQ2/LfpwB5aQ6Z85l.');--  angular

INSERT INTO permissao (id, descricao) values (1, 'ROLE_APARTAMENTO');

INSERT INTO permissao (id, descricao) values (2, 'ROLE_LANCAMENTO');

INSERT INTO permissao (id, descricao) values (3, 'ROLE_INQUILINO');

INSERT INTO permissao (id, descricao) values (4, 'ROLE_PREDIO');

INSERT INTO permissao (id, descricao) values (5, 'ROLE_VALOR');

INSERT INTO permissao (id, descricao) values (6, 'ROLE_DIARIO');

-- admin
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 1);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 3);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 4);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 6);

INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 6);

