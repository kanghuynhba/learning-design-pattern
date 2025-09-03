create schema `book_market` default character set utf8 collate utf8_bin;

use book_market;

create table if not exists `Author` (
    `id` bigint not null auto_increment,
    `name` varchar(120) not null,
    primary key (`id`)
) engine=innoDB auto_increment=1 default charset=utf8mb4 collate=utf8mb4_unicode_ci;

create table if not exists `Category` (
    `id` bigint not null auto_increment,
    `name` varchar(120) not null,
    primary key (`id`)
) engine=innoDB auto_increment=1 default charset=utf8mb4 collate=utf8mb4_unicode_ci;

create table if not exists `Book` (
    `id` bigint not null auto_increment,
    `name` varchar(120) not null,
    `authorId` bigint not null,
    `categoryId` bigint not null,
    primary key (`id`)
) engine=innoDB auto_increment=1 default charset=utf8mb4 collate=utf8mb4_unicode_ci;

