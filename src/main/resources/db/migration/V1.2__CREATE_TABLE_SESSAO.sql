CREATE TABLE votacao.sessao (
	id_sessao bigint PRIMARY KEY NOT NULL,
	data_inicio datetime NOT NULL,
	data_fim datetime NOT NULL,
	id_pauta bigint NOT NULL,
	UNIQUE (id_pauta),
	FOREIGN KEY (id_pauta) REFERENCES votacao.pauta(id_pauta)
);