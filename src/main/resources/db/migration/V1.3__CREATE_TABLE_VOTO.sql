CREATE TABLE votacao.voto (
	id_voto bigint NOT NULL AUTO_INCREMENT,
	voto varchar(3) NOT NULL,
	id_associado bigint NOT NULL,
	id_sessao bigint NOT NULL,
	PRIMARY KEY (id_voto),
	FOREIGN KEY (id_associado) REFERENCES votacao.associado(id_associado),
	FOREIGN KEY (id_sessao) REFERENCES votacao.sessao(id_sessao)
);