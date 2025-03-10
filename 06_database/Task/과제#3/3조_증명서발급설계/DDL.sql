CREATE TABLE BirthRegistration (
	BirthRegistrationID	INT	NOT NULL,
	BIrthDate	DATETIME	NULL,
	BirthLocation	VARCHAR(255)	NULL,
	Qualification	VARCHAR(255)	NULL,
	RegistrationID2	INT	NOT NULL
);

CREATE TABLE Relation (
	PersonID	INT	NOT NULL,
	TargetID	INT	NOT NULL,
	RelationshipTypeID	INT	NOT NULL,
	IsCurrent	BOOLEAN	NULL
);

CREATE TABLE Residence (
	ResidenceID	INT	NOT NULL,
	ReportDate	DATETIME	NULL,
	isCurrent	BOOLEAN	NULL,
	AddressID	INT	NOT NULL,
    PersonID INT NOT NULL
);
CREATE TABLE HouseHoldRelation (
	HouseHoldRelationID	INT	NOT NULL,
	Name	VARCHAR(255)	NULL
);

CREATE TABLE Person (
	PersonID	INT	NOT NULL,
	RegistrationNumber	VARCHAR(255)	NULL,
	Name	VARCHAR(255)	NULL,
	Gender	VARCHAR(255)	NULL
);

CREATE TABLE RelationType (
	RelationshipTypeID	INT	NOT NULL,
	TypeName	VARCHAR(255)	NULL
);

CREATE TABLE HouseHoldMember (
	HouseHoldID	INT	NOT NULL,
	HouseHoldRelationID	INT	NOT NULL,
	ReportDate	DATE	NULL,
	ChangeResonID	INT	NOT NULL
);

CREATE TABLE ResidentRegistration (
	ResidentRegistrationID	INT	NOT NULL,
	CertificateNumber	VARCHAR(255)	NULL,
	IssueDate	DATE	NULL
);

CREATE TABLE FamilyRegistrration (
	FamilyRegistrrationID	INT	NOT NULL,
	IssueDate	DATETIME	NULL,
	CertificateNumber	VARCHAR(255)	NULL
);

CREATE TABLE Address (
	AddressID	INT	NOT NULL,
	RoadAddress	VARCHAR(255)	NULL
);

CREATE TABLE DeathRegistration (
	DeathRegistrationID	INT	NOT NULL,
	DeathLocation	VARCHAR(255)	NULL,
	DeathLocationType	VARCHAR(255)	NULL,
	DeathTime	DATETIME	NULL,
	Qualification	VARCHAR(255)	NULL,
	RegistrationID2	INT	NOT NULL
);

CREATE TABLE HouseHold (
	HouseHoldID	INT	NOT NULL,
	HouseHoldDate	DATE	NULL,
	ResidenceID	INT	NOT NULL,
	ResidentRegistrationID	INT	NOT NULL
);

CREATE TABLE Registration (
	RegistrationID	INT	NOT NULL,
	ReporterRegistrationNumber	VARCHAR(255)	NULL,
	RegistrationDate	VARCHAR(255)	NULL,
	Email	VARCHAR(255)	NULL,
	PhoneNo	VARCHAR(255)	NULL,
	PersonID	INT	NOT NULL,
	RegistrationTypeID	INT	NOT NULL
);

CREATE TABLE FamailyRelation (
	PersonID	INT	NOT NULL,
	TargetID	INT	NOT NULL,
	RelationshipTypeID	INT	NOT NULL,
	FamilyRegistrrationID	INT	NOT NULL
);

CREATE TABLE ChangeReason (
	ChangeResonID	INT	NOT NULL,
	Reason	VARCHAR(255)	NULL
);

CREATE TABLE RegistrationType (
	RegistrationTypeID	INT	NOT NULL,
	TypeName	VARCHAR(255)	NULL
);

ALTER TABLE BirthRegistration ADD CONSTRAINT PK_BIRTHREGISTRATION PRIMARY KEY (
	BirthRegistrationID
);

ALTER TABLE Relation ADD CONSTRAINT PK_RELATION PRIMARY KEY (
	PersonID,
	TargetID,
	RelationshipTypeID
);

ALTER TABLE Residence ADD CONSTRAINT PK_RESIDENCE PRIMARY KEY (
	ResidenceID
);

ALTER TABLE HouseHoldRelation ADD CONSTRAINT PK_HOUSEHOLDRELATION PRIMARY KEY (
	HouseHoldRelationID
);

ALTER TABLE Person ADD CONSTRAINT PK_PERSON PRIMARY KEY (
	PersonID
);

ALTER TABLE RelationType ADD CONSTRAINT PK_RELATIONTYPE PRIMARY KEY (
	RelationshipTypeID
);

ALTER TABLE HouseHoldMember ADD CONSTRAINT PK_HOUSEHOLDMEMBER PRIMARY KEY (
	HouseHoldID,
	HouseHoldRelationID
);

ALTER TABLE ResidentRegistration ADD CONSTRAINT PK_RESIDENTREGISTRATION PRIMARY KEY (
	ResidentRegistrationID
);

ALTER TABLE FamilyRegistrration ADD CONSTRAINT PK_FAMILYREGISTRRATION PRIMARY KEY (
	FamilyRegistrrationID
);

ALTER TABLE Address ADD CONSTRAINT PK_ADDRESS PRIMARY KEY (
	AddressID
);

ALTER TABLE DeathRegistration ADD CONSTRAINT PK_DEATHREGISTRATION PRIMARY KEY (
	DeathRegistrationID
);

ALTER TABLE HouseHold ADD CONSTRAINT PK_HOUSEHOLD PRIMARY KEY (
	HouseHoldID
);

ALTER TABLE Registration ADD CONSTRAINT PK_REGISTRATION PRIMARY KEY (
	RegistrationID
);

ALTER TABLE FamailyRelation ADD CONSTRAINT PK_FAMAILYRELATION PRIMARY KEY (
	PersonID,
	TargetID,
	RelationshipTypeID,
	FamilyRegistrrationID
);

ALTER TABLE ChangeReason ADD CONSTRAINT PK_CHANGEREASON PRIMARY KEY (
	ChangeResonID
);

ALTER TABLE RegistrationType ADD CONSTRAINT PK_REGISTRATIONTYPE PRIMARY KEY (
	RegistrationTypeID
);

ALTER TABLE Relation ADD CONSTRAINT FK_Person_TO_Relation_1 FOREIGN KEY (
	TargetID
)
REFERENCES Person (
	PersonID
);

ALTER TABLE Relation ADD CONSTRAINT FK_RelationType_TO_Relation_1 FOREIGN KEY (
	RelationshipTypeID
)
REFERENCES RelationType (
	RelationshipTypeID
);

ALTER TABLE HouseHoldMember ADD CONSTRAINT FK_HouseHold_TO_HouseHoldMember_1 FOREIGN KEY (
	HouseHoldID
)
REFERENCES HouseHold (
	HouseHoldID
);

ALTER TABLE HouseHoldMember ADD CONSTRAINT FK_HouseHoldRelation_TO_HouseHoldMember_1 FOREIGN KEY (
	HouseHoldRelationID
)
REFERENCES HouseHoldRelation (
	HouseHoldRelationID
);

ALTER TABLE FamailyRelation ADD CONSTRAINT FK_Relation_TO_FamailyRelation_1 FOREIGN KEY (
	PersonID
)
REFERENCES Relation (
	PersonID
);

ALTER TABLE FamailyRelation ADD CONSTRAINT FK_Relation_TO_FamailyRelation_2 FOREIGN KEY (
	TargetID
)
REFERENCES Relation (
	TargetID
);

ALTER TABLE FamailyRelation ADD CONSTRAINT FK_Relation_TO_FamailyRelation_3 FOREIGN KEY (
	RelationshipTypeID
)
REFERENCES Relation (
	RelationshipTypeID
);

ALTER TABLE FamailyRelation ADD CONSTRAINT FK_FamilyRegistrration_TO_FamailyRelation_1 FOREIGN KEY (
	FamilyRegistrrationID
)
REFERENCES FamilyRegistrration (
	FamilyRegistrrationID
);

ALTER TABLE Residence ADD CONSTRAINT FK_Person_TO_Residence FOREIGN KEY (
	PersonID
)
REFERENCES Person (
	PersonID
);



-- 주소 데이터 삽입
INSERT INTO Address (AddressID, RoadAddress) VALUES
(1, '경기도 성남시 분당구 대왕판교로645번길'),
(2, '경기도 성남시 분당구 불정로 90번길'),
(3, '서울시 동작구 상도로 940번길'),
(4, '강원도 고성군 금강산로 290번길');


-- 주민(Person) 데이터 삽입 - 가족 구성원
INSERT INTO Person (PersonID, RegistrationNumber, Name, Gender) VALUES
(1, '790510-*******', '남기준', '남'),  -- 본인(세대주)
(2, '540514-*******', '남석환', '남'),  -- 부
(3, '551022-*******', '박한나', '여'),  -- 모
(4, '820821-*******', '이주은', '여'),  -- 배우자
(5, '120315-*******', '남기석', '남'),  -- 자녀
(6, '851205-*******', '이선미', '여'),  -- 동거인
(7, '130914-*******', '남길동', '남');  -- 사망자(할아버지)

-- 주거지 데이터 삽입
INSERT INTO Residence (ResidenceID, ReportDate, isCurrent, AddressID, PersonID) VALUES
(1, '2013-03-05', 1, 1, 1),
(2, '2013-03-05', 1, 1, 4),
(3, '2013-03-05', 1, 1, 5),
(4, '2013-03-05', 1, 1, 6),
(5, '2009-10-31', 0, 2, 2),
(6, '2009-10-31', 0, 2, 3),
(7, '2007-10-31', 0, 3, 7);

-- 가족관계 유형 데이터 삽입
INSERT INTO RelationType (RelationshipTypeID, TypeName) VALUES
(1, '본인'),
(2, '부'),
(3, '모'),
(4, '배우자'),
(5, '자녀');

-- 세대 구성원 관계 유형 삽입
INSERT INTO HouseHoldRelation (HouseHoldRelationID, Name) VALUES
(1, '본인'),
(2, '배우자'),
(3, '자녀'),
(4, '동거인');

-- 신고 데이터 삽입
INSERT INTO Registration (RegistrationID, ReporterRegistrationNumber, RegistrationDate, Email, PhoneNo, PersonID, RegistrationTypeID) VALUES
(1, '790510-*******', '2012-03-17', 'nam@nhnad.co.kr', '010-1234-5678', 1, 1),
(2, '130914-*******', '2020-05-02', NULL, '010-2345-6789', 2, 2),
(3, '120315-*******', '2012-03-17', 'nam@nhnad.co.kr ', '010-1234-5678', 5, 1);

-- 출생신고서 데이터 삽입
INSERT INTO BirthRegistration (BirthRegistrationID, BirthDate, BirthLocation, Qualification, RegistrationID2) VALUES 
(1, '2012-03-15', '병원', '부', 1),
(2, '2012-03-15 14:59:00', '병원', '부', 3);

-- 사망신고서 데이터 삽입
INSERT INTO DeathRegistration (DeathRegistrationID, DeathLocation, DeathLocationType, DeathTime, Qualification, RegistrationID2) VALUES 
(1, '강원도 고성군 금강산로 290번길', '주택', '2021-04-29 09:03:00', '비동거친족', 2);

-- 가족관계증명서 발급 데이터 삽입
INSERT INTO FamilyRegistrration (FamilyRegistrrationID, IssueDate, CertificateNumber) VALUES
(1, '2021-10-25', '12345678-91011121');

-- 주민등록등본 발급 데이터 삽입
INSERT INTO ResidentRegistration (ResidentRegistrationID, CertificateNumber, IssueDate) VALUES
(1, '98765432-10987654', '2021-10-25');

-- 세대 데이터 삽입
INSERT INTO HouseHold (HouseHoldID, HouseHoldDate, ResidenceID, ResidentRegistrationID) VALUES 
(1, '2009-10-02', 1, 1);


-- Relation 데이터 삽입
INSERT INTO Relation (PersonID, TargetID, RelationshipTypeID, IsCurrent) VALUES
(1, 1, 1, 1), -- 남기준(본인)
(1, 2, 2, 1), -- 남기준의 부: 남석환
(1, 3, 3, 1), -- 남기준의 모: 박한나
(1, 4, 4, 1), -- 남기준의 배우자: 이주은
(1, 5, 5, 1), -- 남기준의 자녀: 남기석
(5, 5, 1, 1), -- 남기석(본인)
(5, 1, 2, 1), -- 남기석의 부: 남기준
(5, 4, 3, 1); -- 남기석의 모: 이주은

-- 가족관계 데이터 삽입
INSERT INTO FamailyRelation (PersonID, RelationshipTypeID, FamilyRegistrrationID, TargetID) VALUES
(1, 1, 1, 1), -- 남기준(본인)
(1, 2, 1, 2), -- 남기준의 부: 남석환
(1, 3, 1, 3), -- 남기준의 모: 박한나
(1, 4, 1, 4), -- 남기준의 배우자: 이주은
(1, 5, 1, 5); -- 남기준의 자녀: 남기석


-- 세대구성원 데이터 삽입
INSERT INTO HouseHoldMember (HouseHoldID, HouseHoldRelationID, ReportDate, ChangeResonID) VALUES
(1, 1, '2009-10-02', 1),  -- 남기준(세대주)
(1, 2, '2010-02-15', 2),  -- 이주은(배우자)
(1, 3, '2012-03-17', 3),  -- 남기석(자녀)
(1, 4, '2015-11-29', 2);  -- 이선미(동거인)

INSERT INTO ChangeReason(ChangeResonID, Reason) VALUES 
(1, '세대분리'),
(2, '전입'),
(3, '출생등록');

INSERT INTO RegistrationType VALUES 
(1, '출생신고'), 
(2, '사망신고');