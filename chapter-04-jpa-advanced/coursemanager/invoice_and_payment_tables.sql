create table invoice(
  invoice_id int primary key,
  amount decimal(7,2) not null,
  due_date datetime not null,
  student_name varchar(80) not null,
  email_address varchar(80) not null
);

create table payment(
  payment_id int not null,
  amount decimal(7,2) not null,
  payment_date datetime not null,
  invoice_id int not null,
  foreign key fk_invoices(invoice_id) references invoice(invoice_id),
  primary key (invoice_id, payment_id)  
);