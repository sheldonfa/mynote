-- auto Generated on 2017-11-05 16:32:29 
-- DROP TABLE IF EXISTS `earning`; 
CREATE TABLE earning(
    `id` INTEGER(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `company` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'company',
    `text` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'text',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'earning';