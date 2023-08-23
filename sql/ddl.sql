CREATE TABLE `member` (
    `Id` int NOT NULL,
    `Name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
)

INSERT INTO `member`.`member`
(`Id`,
`Name`)
VALUES
(1, "test1"),
(2, "test2"),
(3, "test3"),
(4, "test4"),
(5, "test5");