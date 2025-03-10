use dvdprime_example;

create table Category
(
	id int not null
		primary key,
	name varchar(20) not null
);

create table Board
(
	id int not null
		primary key,
	category_id int not null,
	name varchar(20) not null,
	is_thumbnail_required tinyint(1) not null,
	constraint board_ibfk_1
		foreign key (category_id) references  Category (id)
);

create index category_id
	on  Board (category_id);

create table TagType
(
	id int not null
		primary key,
	name varchar(20) not null
);

create table BoardTagTypes
(
	id int not null
		primary key,
	tag_type_id int not null,
	board_id int not null,
	constraint boardtagtypes_ibfk_1
		foreign key (tag_type_id) references  TagType (id),
	constraint boardtagtypes_ibfk_2
		foreign key (board_id) references  Board (id)
);

create index board_id
	on  BoardTagTypes (board_id);

create index tag_type_id
	on  BoardTagTypes (tag_type_id);

create table  Tag
(
	id int not null
		primary key,
	type_id int not null,
	name varchar(20) not null,
	constraint tag_ibfk_1
		foreign key (type_id) references  TagType (id)
);

create table  Brand
(
	id int not null
		primary key,
	tag_id int not null,
	name varchar(255) not null,
	logo_url text null,
	constraint brand_ibfk_1
		foreign key (tag_id) references  Tag (id)
);

create index tag_id
	on  Brand (tag_id);

create table  Platform
(
	id int not null
		primary key,
	tag_id int not null,
	name varchar(20) not null,
	logo_url text null,
	constraint platform_ibfk_1
		foreign key (tag_id) references  Tag (id)
);

create table  Movie
(
	id int not null
		primary key,
	platform_id int not null,
	tag_id int not null,
	title varchar(255) not null,
	director varchar(255) not null,
	genre varchar(20) null,
	release_date date not null,
	poster_url text null,
	constraint movie_ibfk_1
		foreign key (platform_id) references  Platform (id),
	constraint movie_ibfk_2
		foreign key (tag_id) references  Tag (id)
);

create index platform_id
	on  Movie (platform_id);

create index tag_id
	on  Movie (tag_id);

create index tag_id
	on  Platform (tag_id);

create index type_id
	on  Tag (type_id);

create table  User
(
	id int not null
		primary key,
	email varchar(255) not null,
	password varchar(255) not null,
	nickname varchar(20) not null,
	created_at datetime not null,
	deleted_at datetime null
);

create table  Message
(
	id int not null
		primary key,
	receiver_id int not null,
	sender_id int not null,
	title varchar(255) not null,
	content text not null,
	created_at datetime not null,
	constraint message_ibfk_1
		foreign key (receiver_id) references  User (id),
	constraint message_ibfk_2
		foreign key (sender_id) references  User (id)
);

create index receiver_id
	on  Message (receiver_id);

create index sender_id
	on  Message (sender_id);

create table  Post
(
	id int not null
		primary key,
	author_id int not null,
	board_id int not null,
	title varchar(255) not null,
	content text not null,
	hit int not null,
	likes int not null,
	thumbnail_url text null,
	created_at datetime not null,
	deleted_at datetime null,
	constraint post_ibfk_1
		foreign key (author_id) references  User (id),
	constraint post_ibfk_2
		foreign key (board_id) references  Board (id)
);

create table  Comment
(
	id int not null
		primary key,
	author_id int not null,
	post_id int not null,
	content text not null,
	likes int not null,
	is_hidden tinyint(1) not null,
	created_at datetime not null,
	deleted_at datetime null,
	parent_comment_id int null,
	constraint comment_ibfk_1
		foreign key (author_id) references  User (id),
	constraint comment_ibfk_2
		foreign key (post_id) references  Post (id),
	constraint comment_ibfk_3
		foreign key (parent_comment_id) references  Comment (id)
);

create index author_id
	on  Comment (author_id);

create index parent_comment_id
	on  Comment (parent_comment_id);

create index post_id
	on  Comment (post_id);

create index author_id
	on  Post (author_id);

create index board_id
	on  Post (board_id);

create table  PostTags
(
	id int not null
		primary key,
	tag_id int not null,
	post_id int not null,
	constraint posttags_ibfk_1
		foreign key (tag_id) references  Tag (id),
	constraint posttags_ibfk_2
		foreign key (post_id) references  Post (id)
);

create index post_id
	on  PostTags (post_id);

create index tag_id
	on  PostTags (tag_id);

create table  Scrap
(
	id int not null
		primary key,
	user_id int not null,
	post_id int not null,
	constraint scrap_ibfk_1
		foreign key (user_id) references  User (id),
	constraint scrap_ibfk_2
		foreign key (post_id) references  Post (id)
);

create index post_id
	on  Scrap (post_id);

create index user_id
	on  Scrap (user_id);

create table  Subscribe
(
	id int not null
		primary key,
	subscriber_id int not null,
	subscribed_to_id int not null,
	constraint subscribe_ibfk_1
		foreign key (subscriber_id) references  User (id),
	constraint subscribe_ibfk_2
		foreign key (subscribed_to_id) references  User (id)
);

create index subscribed_to_id
	on  Subscribe (subscribed_to_id);

create index subscriber_id
	on  Subscribe (subscriber_id);

create table  TempPost
(
	id int not null
		primary key,
	board_id int not null,
	author_id int not null,
	title varchar(255) not null,
	content text not null,
	constraint temppost_ibfk_1
		foreign key (board_id) references  Board (id),
	constraint temppost_ibfk_2
		foreign key (author_id) references  User (id)
);

create index author_id
	on  TempPost (author_id);

create index board_id
	on  TempPost (board_id);