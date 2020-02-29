create database bootcamp;

create table PERSON (
    CODE VARCHAR(12) PRIMARY KEY,
    FIRST_NAME VARCHAR(255),
    LAST_NAME VARCHAR(255),
    BIRTH_DATE DATE,
    EMPLOYED BOOLEAN,
    HEIGHT INT
)

insert into PERSON(CODE, FIRST_NAME, LAST_NAME, BIRTH_DATE, EMPLOYED, HEIGHT)
    values ('010175-25345', 'Vasya', 'Pupkin', '1975-01-01', true, 185)

insert into PERSON(CODE, FIRST_NAME, LAST_NAME, BIRTH_DATE, EMPLOYED, HEIGHT)
    values ('041181-94856', 'Masha', 'Pupkina', '1981-11-04', false, 171)

insert into PERSON(CODE, FIRST_NAME, LAST_NAME, BIRTH_DATE, EMPLOYED, HEIGHT)
    values ('190295-38475', 'Janis', 'Berzinsh', '1995-02-19', false, 204)

insert into PERSON(CODE, FIRST_NAME, LAST_NAME, BIRTH_DATE, EMPLOYED, HEIGHT)
    values ('220783-45679', 'Peteris', 'Berzinsh', '1983-07-22', true, 182)

update PERSON set EMPLOYED = true where CODE = '041181-94856'

create table DOMESTIC_ANIMAL (
    CHIP_ID INT AUTO_INCREMENT,
    NICKNAME VARCHAR(255) NOT NULL,
    MASTER_FK VARCHAR(12),
    PRIMARY KEY (CHIP_ID),
    FOREIGN KEY (MASTER_FK) REFERENCES PERSON(CODE)
) ENGINE=INNODB;


insert into domestic_animal (nickname, master_fk) values ('Prince', '041181-94856')
insert into domestic_animal (nickname, master_fk) values ('Murinsh', '041181-94856')
insert into domestic_animal (nickname, master_fk) values ('Reksis', '220783-45679')
insert into domestic_animal (nickname, master_fk) values ('Killer', NULL)

create table COMPANY (
    REG_NR BIGINT PRIMARY KEY,
    TYPE VARCHAR(25) NOT NULL,
    NAME VARCHAR(255) NOT NULL
)

insert into company(REG_NR, TYPE, NAME) values (40003584748, 'SIA', 'Accenture')
insert into company(REG_NR, TYPE, NAME) values (40203075442, 'IK', 'Riga Coding School')

create table COMPANY_EMPLOYEE (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    REG_NR BIGINT NOT NULL,
    PERSON_CODE VARCHAR(12),
    FOREIGN KEY (REG_NR) REFERENCES COMPANY(REG_NR),
    FOREIGN KEY (PERSON_CODE) REFERENCES PERSON(CODE)
)

insert into company_employee(REG_NR, PERSON_CODE) values (40003584748, '030874-34534')
insert into company_employee(REG_NR, PERSON_CODE) values (40203075442, '030874-34534')
insert into company_employee(REG_NR, PERSON_CODE) values (40203075442, '041181-94856')
insert into company_employee(REG_NR, PERSON_CODE) values (40003584748, '220783-45679')


alter table person
    add column address_fk int,
    add foreign key (address_fk) references address(id)


select person.* from person
    join address on person.address_fk = address.id
    where address.country = 'Latvia'

select * from person where address_fk in (
    select id from address where country = 'Latvia'
)


select * from person where code in (
   select master_fk from domestic_animal
)

#select person.first_name, domestic_animal.nickname
#    from person join domestic_animal
#        on person.code = domestic_animal.master_fk


select distinct person.*
    from person join domestic_animal
        on person.code = domestic_animal.master_fk
