CREATE TABLE `produto` (
	`id` bigint(20) NOT NULL,
	`nome_produto` varchar(255) NOT NULL,
	`descricao` varchar(255) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `produto` ADD PRIMARY KEY(`id`);
ALTER TABLE `produto` MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;