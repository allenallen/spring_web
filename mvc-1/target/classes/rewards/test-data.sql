
insert into T_ACCOUNT (NUMBER, NAME, DATE_OF_BIRTH, EMAIL, TOTAL_POINTS) values ('8861888', 'Juan Dela Cruz', DATE '1521-03-16', 'john@ofthecross.com', 0);
insert into T_ACCOUNT (NUMBER, NAME, DATE_OF_BIRTH, EMAIL, TOTAL_POINTS) values ('123456001', 'Calen Martin D. Legaspi', DATE '1974-12-15', 'calen@orangeandbronze.com', 0);
insert into T_ACCOUNT (NUMBER, NAME, DATE_OF_BIRTH, EMAIL, TOTAL_POINTS) values ('123456002', 'Tommy Lim Jr.', DATE '1972-04-01', 'tommy@orangeandbronze.com', 0);
insert into T_ACCOUNT (NUMBER, NAME, DATE_OF_BIRTH, EMAIL, TOTAL_POINTS) values ('123456003', 'Butch Landingin', DATE '1969-02-14', 'butch@orangeandbronze.com', 0);

insert into T_ACCOUNT_CARD (ACCOUNT_ID, NUMBER) values (0, '1234567890');
insert into T_ACCOUNT_CARD (ACCOUNT_ID, NUMBER) values (1, '1234567891');
insert into T_ACCOUNT_CARD (ACCOUNT_ID, NUMBER) values (2, '1234567892');
insert into T_ACCOUNT_CARD (ACCOUNT_ID, NUMBER) values (3, '1234567893');

insert into T_MERCHANT (NUMBER, NAME, AMOUNT_PER_POINT, MINIMUM_PURCHASE_AMOUNT) 
	values ('1115558888', 'Acme Supplies', 50.0, 100.0);
