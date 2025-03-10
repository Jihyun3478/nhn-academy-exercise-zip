-- 항공사 테이블
INSERT INTO Airline (AirlineID, AirlineName, Country) VALUES
(1, '대한항공', '대한민국'),
(2, '아시아나항공', '대한민국'),
(3, '에미레이트 항공', '아랍에미리트'),
(4, '싱가포르 항공', '싱가포르'),
(5, '카타르 항공', '카타르');

-- 공항 테이블
INSERT INTO Airport (AirportID, AirportName, City, Country, IATACode) VALUES
(1, '인천국제공항', '인천', '대한민국', 'ICN'),
(2, '김포국제공항', '서울', '대한민국', 'GMP'),
(3, '나리타 국제공항', '도쿄', '일본', 'NRT'),
(4, '하마드 국제공항', '도하', '카타르', 'DOH'),
(5, '창이 국제공항', '싱가포르', '싱가포르', 'SIN');

-- 운항 경로 테이블
INSERT INTO FlightRoute (FlightRouteID, ArrivalAirportID, DepartureAirportID, Distance) VALUES
(1, 1, 3, 1250),
(2, 2, 5, 4700),
(3, 3, 4, 8000),
(4, 4, 1, 7200),
(5, 5, 2, 4600);

-- 운항 계획 테이블
INSERT INTO FlightSchedule (FlightScheduleID, FlightRouteID, AirlineID, DepartureDate, ArrivalDate, SeasonCode) VALUES
(1, 1, 1, '2025-03-10 08:00:00', '2025-03-10 12:00:00', 'S1'),
(2, 2, 2, '2025-03-11 09:30:00', '2025-03-11 16:00:00', 'S2'),
(3, 3, 3, '2025-03-12 22:00:00', '2025-03-13 06:30:00', 'P1'),
(4, 4, 4, '2025-03-13 14:00:00', '2025-03-13 22:00:00', 'P2'),
(5, 5, 5, '2025-03-14 07:00:00', '2025-03-14 13:30:00', 'P3');

-- 출발/도착 정보 테이블
INSERT INTO DepartureArrival (DepartureArrivalID, FlightRouteID, RouteMilage) VALUES
(1, 1, 10000),
(2, 2, 20000),
(3, 3, 45000),
(4, 4, 50000),
(5, 5, 30000);

-- 승무원 테이블
INSERT INTO FlightAttendant (FlightAttendantID, FlightAttendantName, Ranks) VALUES
(1, '김민수', '수석 승무원'),
(2, '이영희', '일반 승무원'),
(3, '박지훈', '일반 승무원'),
(4, '최수진', '수석 승무원'),
(5, '정하늘', '일반 승무원');

-- 승무원 편조 테이블
INSERT INTO FlightAttendantCrew (CrewID, FlightAttendantID) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- 승무원 비행계획 테이블
INSERT INTO FlightAttendantSchedule (FlightAttendantScheduleID, CrewID, FlightScheduleID) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5);

-- 항공 교통 관리 테이블
INSERT INTO ATCAdvisory (ATCAdvisoryID, AdvisoryAirportID, FlightScheduleID, DelayTime, DelayReason) VALUES
(1, 1, 1, SEC_TO_TIME(3000), '기상 악화로 인한 착륙 지연 가능성'),
(2, 2, 2, SEC_TO_TIME(2400), '이륙 전 추가 점검 필요'),
(3, 3, 3, SEC_TO_TIME(1800), '강한 난기류 주의'),
(4, 4, 4, SEC_TO_TIME(1200), '비행 경로 변경 승인'),
(5, 5, 5, SEC_TO_TIME(600), '착륙 후 지연 예상');

-- CustomerIdentify 테이블 데이터
INSERT INTO CustomerIdentify (CustomerIdentifyID, IdentificationType) VALUES 
(1, '주민등록증'),
(2, '여권'),
(3, '사업자등록증');

-- Customer 테이블 데이터
INSERT INTO Customer (CustomerID, CustomerIdentifyID, Name, Email, PhoneNumber, BirthDate) VALUES 
(1, 1, '김동현', 'kim@example.com', '010-1234-5678', '1985-03-15 00:00:00'),
(2, 1, '이동현', 'lee@example.com', '010-2345-6789', '1990-05-20 00:00:00'),
(3, 2, '박동현', 'park@example.com', '010-3456-7890', '1978-11-30 00:00:00'),
(4, 2, '정동현', 'jung@example.com', '010-4567-8901', '1982-07-12 00:00:00'),
(5, 3, '제주항공', 'jejuair@example.com', '02-1234-5678', NULL);

-- PrivateCustomer 테이블 데이터
INSERT INTO PrivateCustomer (PrivateCustomerID, CustomerID2, CustomerIdentifyID, Gender, Address) VALUES 
(1, 1, 1, '남', '서울시 강남구 테헤란로 123'),
(2, 2, 1, '여', '서울시 서초구 서초대로 456'),
(3, 3, 2, '남', '경기도 성남시 분당구 판교로 789'),
(4, 4, 3, '여', '인천시 연수구 송도대로 101');

-- CorporateCustomer 테이블 데이터
INSERT INTO CorporateCustomer (CorporateCustomerID, CustomerID2, CustomerIdentifyID, CorporateType, CompanyName, CompanyAddress) VALUES 
(1, 5, 3, '항공운송', '제주항공', '서울시 강서구 하늘길 260');

-- FullMember 테이블 데이터
INSERT INTO FullMember (FullMemberID, PrivateCustomerID, StartDate) VALUES 
(1, 1, '2020-01-01 00:00:00'),
(2, 2, '2019-01-02 00:00:00');

-- SimpleMember 테이블 데이터
INSERT INTO SimpleMember (SimpleMemberID, PrivateCustomerID, StartDate) VALUES 
(1, 3, '2021-02-20 00:00:00'),
(2, 4, '2022-01-05 00:00:00');

-- CorporateCustomerEmployee 테이블 데이터
INSERT INTO CorporateCustomerEmployee (CorporateCustomerEmployeeID, CorporateCustomerID, Department, CorporateEmail) VALUES 
(1, 1, '영업부', 'sales@jejuair.com'),
(2, 1, '마케팅부', 'marketing@jejuair.com'),
(3, 1, '인사부', 'hr@jejuair.com');

-- CorporateBenefit 테이블 데이터
INSERT INTO CorporateBenefit (CorporateBenefitID, CorporateCustomerID, BenefitStartDate, BenefitEndDate, Benefit) VALUES 
(1, 1, '2025-01-01 00:00:00', '2025-12-31 00:00:00', '비즈니스석 10% 할인'),
(2, 1, '2025-01-01 00:00:00', '2025-12-31 00:00:00', '무료 수하물 추가 30kg'),
(3, 1, '2025-01-01 00:00:00', '2025-12-31 00:00:00', '라운지 무료 이용');

-- PreferFlyingInfo 테이블 데이터
INSERT INTO PreferFlyingInfo (ArrivalAirportID, CustomerID) VALUES 
(1, 1),  -- 예: 인천 
(2, 2),  -- 예: 뉴욕 
(3, 3),  -- 예: 파리
(4, 4);  -- 예: 시드니

-- Product 테이블 더미 데이터
INSERT INTO Product (ProductID, ProductName, Price) VALUES
(1, 'Economy Class Ticket', 500),
(2, 'Business Class Ticket', 1200),
(3, 'First Class Ticket', 2500);

-- Service 테이블 더미 데이터
INSERT INTO Service (ServiceID, ServiceName, Price) VALUES
(1, 'Extra Legroom Seat', 50),
(2, 'Priority Boarding', 30),
(3, 'In-Flight Meal', 20);

-- PartnerProduct 테이블 더미 데이터
INSERT INTO PartnerProduct (PartnerProduct, Name, Price) VALUES
(1, 'Hotel Discount', 100),
(2, 'Car Rental Discount', 80),
(3, 'Airport Lounge Access', 150);

-- Accessory 테이블 더미 데이터
INSERT INTO Accessory (AccessoryID, AccessoryName, Price) VALUES
(1, 'Neck Pillow', 25),
(2, 'Headphones', 50),
(3, 'Blanket', 40);

-- FlightTicket 테이블 더미 데이터
INSERT INTO FlightTicket (FlightTicketID, FlightScheduleID, Price) VALUES
(1, 1, 500),
(2, 2, 1200),
(3, 3, 2500);

-- PackageProduct 테이블 더미 데이터
INSERT INTO PackageProduct (PackageProductID, PackageName) VALUES
(1, 'Basic Travel Package'),
(2, 'Business Travel Package'),
(3, 'Luxury Travel Package');

-- PackageProductDetail 테이블 더미 데이터
INSERT INTO PackageProductDetail (PackageProductDetail, PackageProductID, FlightTicketID, ServiceID, PartnerProduct, AccessoryID) VALUES
(1, 1, 1, 1, 1, 1),
(2, 2, 2, 2, 2, 2),
(3, 3, 3, 3, 3, 3);

-- ProductDetail 테이블 더미 데이터
INSERT INTO ProductDetail (ProductDetailID, ProductID, FlightTicketID, ServiceID, PartnerProduct, AccessoryID, PackageProductID) VALUES
(1, 1, 1, 1, 1, 1, 1),
(2, 2, 2, 2, 2, 2, 2),
(3, 3, 3, 3, 3, 3, 3);

INSERT INTO Ticket (TicketID, PassengerID, PNRID, TotalAmount, SeatClass, SeatNumber, SegmentID)
VALUES 
(1, 101, 1000, 500, 'Economy', 15, 123),
(2, 102, 1002, 700, 'Business', 5, 124);

INSERT INTO Fare (FareID, TicketID, FareAmount)
VALUES 
(501, 1, 100000),
(502, 2, 200000);

INSERT INTO Tax (TaxID, TicketID, TaxType, TaxAmount)
VALUES 
(601, 1, 'Airport Service Charge', 10000),
(602, 2, 'Fuel Charge', 20000) ;


INSERT INTO PaymentMethod (PaymentMethodID, TicketID)
VALUES 
(701, 1),
(702, 2);

INSERT INTO Coupon (CouponID, SegmentID, CouponValue)
VALUES 
('CPN001', 123, 10000),
('CPN002', 124, 20000);

INSERT INTO ServiceDetail (ServiceDetailID, TicketID)
VALUES 
(801, 1),
(802, 2);

INSERT INTO Refund (RefundID, TicketID, RefundAmount, RefundDate)
VALUES 
(901, 1, 100, '2023-10-03 12:00:00'),
(902, 2, 150, '2023-10-04 13:00:00');

INSERT INTO RefundPaymentMethod (RefundPaymentMethodID, RefundID)
VALUES 
(1001, 901),
(1002, 902);

INSERT INTO RefundTax (RefundTaxID, RefundID)
VALUES 
(1101, 901),
(1102, 902);

INSERT INTO RefundFare (RefundFareID, RefundID)
VALUES 
(1201, 901),
(1202, 902);

-- 예약정보 테이블 데이터
INSERT INTO PNR (PNRID, CustomerID) 
VALUES
	(1000, 1),	-- 김동현 가는편 예약
    (1002, 2);	-- 이동현 편도 예약

-- 부가서비스예약내역 테이블 데이터
INSERT INTO ReservationInfo(ReservationInfoID, ProductID, PassengerID, PNRID2, SegmentID)
VALUES 
	(800, 1, 101, 1000, 123),
    (801, 3, 102, 1002, 124);

-- 탑승객 테이블 데이터
INSERT INTO Passenger(PassengerID, PNRID)
VALUES 
	(101, 1000),	-- 김동현 탑승객 정보
    (102, 1002);	-- 이동현 탑승객 정보
	
-- 특별서비스예약내역 테이블 데이터
INSERT INTO SSR(SSRID, PassengerID, PNRID, SegmentID)
VALUES 
	(4000, 101, 1000, 123),
    (5000, 102, 1002, 124);

-- 비행구간 테이블 데이터
INSERT INTO Segment (SegmentID, PNRID)
VALUES 
	(123, 1000),
	(124, 1002);

-- 이동현 승객 예약 정보 열람    
SELECT DISTINCT
	Customer.Name AS 탑승객,
    FlightSchedule.DepartureDate AS 출발일자,
    FlightSchedule.ArrivalDate AS 도착일자,
    Airline.AirlineName AS 항공사명,
    A1.AirportName AS 출발공항이름,
	A1.City AS 출발공항국가,
	A1.Country AS 출발공항도시,
	A1.IATACode AS 출발공항IATA코드,
	A2.AirportName AS 도착공항이름,
	A2.City AS 도착공항국가,
    A2.Country AS 도착공항도시,
	A2.IATACode AS 도착공항IATA코드,
	Ticket.SeatNumber AS 좌석번호,
	Ticket.SeatClass AS 좌석등급,
	Ticket.SeatClass AS 좌석등급
FROM PNR
JOIN Customer ON PNR.CustomerID = Customer.CustomerID
JOIN Passenger ON PNR.PNRID = Passenger.PNRID
JOIN ReservationInfo ON (Passenger.PNRID = ReservationInfo.PNRID2 AND Passenger.PassengerID = ReservationInfo.PassengerID)
JOIN SSR ON (Passenger.PNRID = ReservationInfo.PNRID2 AND Passenger.PassengerID = ReservationInfo.PassengerID)
JOIN Segment ON PNR.PNRID = Segment.PNRID
JOIN Ticket ON (Passenger.PNRID = Ticket.PNRID AND Passenger.PassengerID = Ticket.PassengerID)
JOIN Product ON ReservationInfo.ProductID = Product.ProductID
JOIN ProductDetail ON Product.ProductID = ProductDetail.ProductID
JOIN FlightTicket ON ProductDetail.FlightTicketID = FlightTicket.FlightTicketID
JOIN FlightSchedule ON FlightSchedule.FlightScheduleID = FlightTicket.FlightScheduleID
JOIN Airline ON FlightSchedule.AirlineID = Airline.AirlineID
JOIN FlightRoute ON FlightSchedule.FlightRouteID = FlightRoute.FlightRouteID
JOIN Airport A1 ON FlightRoute.DepartureAirportID = A1.AirportID
JOIN Airport A2 ON FlightRoute.ArrivalAirportID = A2.AirportID
WHERE Customer.Name = '이동현';

-- 김동현 예약정보 열람
SELECT DISTINCT
	Customer.Name AS 탑승객,
    FlightSchedule.DepartureDate AS 출발일자,
    FlightSchedule.ArrivalDate AS 도착일자,
    Airline.AirlineName AS 항공사명,
    A1.AirportName AS 출발공항이름,
	A1.City AS 출발공항국가,
	A1.Country AS 출발공항도시,
	A1.IATACode AS 출발공항IATA코드,
	A2.AirportName AS 도착공항이름,
	A2.City AS 도착공항국가,
    A2.Country AS 도착공항도시,
	A2.IATACode AS 도착공항IATA코드,
	Ticket.SeatNumber AS 좌석번호,
	Ticket.SeatClass AS 좌석등급,
	Ticket.SeatClass AS 좌석등급
FROM PNR
JOIN Customer ON PNR.CustomerID = Customer.CustomerID
JOIN Passenger ON PNR.PNRID = Passenger.PNRID
JOIN ReservationInfo ON (Passenger.PNRID = ReservationInfo.PNRID2 AND Passenger.PassengerID = ReservationInfo.PassengerID)
JOIN SSR ON (Passenger.PNRID = ReservationInfo.PNRID2 AND Passenger.PassengerID = ReservationInfo.PassengerID)
JOIN Segment ON PNR.PNRID = Segment.PNRID
JOIN Ticket ON (Passenger.PNRID = Ticket.PNRID AND Passenger.PassengerID = Ticket.PassengerID)
JOIN Product ON ReservationInfo.ProductID = Product.ProductID
JOIN ProductDetail ON Product.ProductID = ProductDetail.ProductID
JOIN FlightTicket ON ProductDetail.FlightTicketID = FlightTicket.FlightTicketID
JOIN FlightSchedule ON FlightSchedule.FlightScheduleID = FlightTicket.FlightScheduleID
JOIN Airline ON FlightSchedule.AirlineID = Airline.AirlineID
JOIN FlightRoute ON FlightSchedule.FlightRouteID = FlightRoute.FlightRouteID
JOIN Airport A1 ON FlightRoute.DepartureAirportID = A1.AirportID
JOIN Airport A2 ON FlightRoute.ArrivalAirportID = A2.AirportID
WHERE Customer.Name = '김동현';