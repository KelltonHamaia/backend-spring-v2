create database spring_v2;

create table user (
                      id bigint primary key not null auto_increment,
                      name text not null,
                      email text not null UNIQUE,
                      password text not null,
                      birthday date,
                      created_at timestamp default CURRENT_TIMESTAMP,
                      updated_at timestamp default CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP
);


create table category (
                          id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
                          name text
);

create table product (
                         id bigint primary key not null auto_increment,
                         name text not null,
                         description text,
                         stock int,
                         id_category bigint,
                         FOREIGN KEY (id_category) references category(id),
                         created_at timestamp default CURRENT_TIMESTAMP,
                         updated_at timestamp default CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP
);

create table transaction (
                             id bigint primary key not null auto_increment,
                             user_id bigint not null,
                             product_id bigint not null,
                             action text,
                             quantity int,
                             created_at timestamp default current_timestamp,
                             updated_at timestamp default current_timestamp on update current_timestamp,
                             constraint action_check CHECK (action IN ('REFILL', 'SALE')),
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (product_id) REFERENCES product(id)
);