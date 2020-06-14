CREATE TABLE `perfil` (
	`id` bigint(20) NOT NULL,
	`nome` varchar(255) NOT NULL,
	`email` varchar(255) NOT NULL,
	`password` varchar(255) NOT NULL,
	`perfil` varchar(255) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `perfil` ADD PRIMARY KEY(`id`);
ALTER TABLE `perfil` MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;