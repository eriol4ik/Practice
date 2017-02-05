CREATE TABLE `first_db`.`tableContacts` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NULL,
  `age` INT NULL,
  `email` VARCHAR(60) NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `first_db`.`tableContacts`
ADD COLUMN `mobile` INT NULL AFTER `email`;

CREATE TABLE `first_db`.`users` (
	`id` INT(16) NOT NULL,
    `login` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`id`, `login`)
    );

ALTER TABLE `first_db`.`users`
  ADD COLUMN `password` VARCHAR(20) NULL AFTER `login`;

/* Добавление записей в таблицу */
INSERT INTO `first_db`.`users` (`id`, `login`, `password`)
    VALUES (1, 'admin', 'admin');

INSERT INTO `first_db`.`users` (`id`, `login`, `password`)
VALUES (2, 'user', 'user');

INSERT INTO `first_db`.`users` (`id`, `login`, `password`)
VALUES (3, 'test', 'test');

/* Получение записей из таблицы */
SELECT login, password FROM users;