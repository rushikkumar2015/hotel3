create table hotel(
    id int primary key auto_increment,
    name varchar(255),
    location varchar(255),
    rating int
);
create table room(
    id int primary key auto_increment,
    roomNumber varchar(255),
    type varchar(255),
    price double,
    hotelId int,
    foreign key (hotelId) references hotel(id);
);