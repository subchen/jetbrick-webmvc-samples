create table order_info (
	id integer not null,
	serialno varchar(20) not null,
	price double not null,
	purchase_date datetime not null,
	primary key (id)
);

create table order_item (
	id int not null,
	order_id int not null,
	goods varchar(50) not null,
	price double not null,
	primary key (id)
);

insert into order_info values (101, 'A-0458-1726', 82.91, '2013-05-16 12:00:09');
insert into order_info values (102, 'A-9478-3456', 48.81, '2013-05-17 13:00:08');
insert into order_info values (103, 'A-0384-0958', 18.83, '2013-05-18 14:00:07');
insert into order_info values (104, 'A-8472-8092', 30.47, '2013-05-17 15:00:06');
insert into order_info values (105, 'A-1267-6932', 19.98, '2013-05-16 16:00:05');

insert into order_item values (9101, 101, 'Despicable Me 2 ', 19.98);
insert into order_item values (9102, 101, 'The Hunger Games: Catching Fire', 29.95);
insert into order_item values (9103, 101, 'Saving Mr. Banks', 17.99);
insert into order_item values (9104, 101, 'The Hobbit: The Desolation of Smaug', 14.99);
insert into order_item values (9105, 102, 'Thor: The Dark World', 18.83);
insert into order_item values (9106, 102, 'Despicable Me 2 ', 19.98);
insert into order_item values (9107, 102, 'The Veronica Mars Movie ', 10.00);
insert into order_item values (9108, 103, 'Thor: The Dark World', 18.83);
insert into order_item values (9109, 104, 'Despicable Me (Single-Disc Edition) ', 10.49);
insert into order_item values (9110, 104, 'Despicable Me 2 ', 19.98);
insert into order_item values (9111, 105, 'Despicable Me 2 ', 19.98);

