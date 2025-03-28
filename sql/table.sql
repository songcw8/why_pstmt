CREATE TABLE test_user
(
    test_user_id int unsigned auto_increment primary key,
    username     varchar(255) unique not null,
    password     varchar(255)        not null,
    create_at    timestamp default CURRENT_TIMESTAMP
)