alter table tb_order MODIFY code varchar(40) not null;
update tb_order set code = uuid();
alter table tb_order add constraint uk_order_code_unique unique(code);