create database feyzibook
create user feyzibook with encrypted password 'password'
grant all privileges on database "feyzibook" to feyzibook
create table if not exists member()
create table if not exists meeting()
