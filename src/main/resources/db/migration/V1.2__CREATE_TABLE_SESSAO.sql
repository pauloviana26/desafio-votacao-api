CREATE TABLE votacao.sessao (
	id_sessao bigint NOT NULL AUTO_INCREMENT,
	data_inicio datetime NOT NULL,
	data_fim datetime NOT NULL,
	id_pauta bigint NOT NULL,
	PRIMARY KEY (id_sessao),
	UNIQUE (id_pauta),
	FOREIGN KEY (id_pauta) REFERENCES votacao.pauta(id_pauta)
);