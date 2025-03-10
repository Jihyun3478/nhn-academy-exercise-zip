CREATE TABLE SSR (
	SSRID	INT	NOT NULL,
	PassengerID	INT	NOT NULL,
	PNRID	INT	NOT NULL,
	SegmentID	INT	NOT NULL
);

CREATE TABLE Customer (
	CustomerID	INT	NOT NULL,
	CustomerIdentifyID	INT	NOT NULL,
	Name	VARCHAR(255)	NULL,
	Email	VARCHAR(255)	NULL,
	PhoneNumber	VARCHAR(255)	NULL,
	BirthDate	DATETIME	NULL
);

CREATE TABLE PreferFlyingInfo (
	ArrivalAirportID	INT	NOT NULL,
	CustomerID	INT	NOT NULL
);

CREATE TABLE Service (
	ServiceID	INT	NOT NULL,
	ServiceName	VARCHAR(255)	NULL,
	Price	INT	NULL
);

CREATE TABLE Product (
	ProductID	INT	NOT NULL,
	ProductName	VARCHAR(255)	NULL,
	Price	INT	NULL
);

CREATE TABLE PackageProduct (
	PackageProductID	INT	NOT NULL,
	PackageName	VARCHAR(255)	NULL
);

CREATE TABLE CrossOver (
	CrossOverID	INT	NOT NULL,
	AirportID	INT	NOT NULL,
	FlightScheduleID	INT	NOT NULL
);

CREATE TABLE FlightAttendantCrew (
	CrewID	INT	NOT NULL,
	FlightAttendantID	INT	NOT NULL
);

CREATE TABLE RefundPaymentMethod (
	RefundPaymentMethodID	INT	NOT NULL,
	RefundID	INT	NOT NULL
);

CREATE TABLE RefundFare (
	RefundFareID	INT	NOT NULL,
	RefundID	INT	NOT NULL
);

CREATE TABLE RefundTax (
	RefundTaxID	INT	NOT NULL,
	RefundID	INT	NOT NULL
);

CREATE TABLE Tax (
	TaxID	INT	NOT NULL,
	TicketID	INT	NOT NULL,
	TaxType	VARCHAR(255)	NULL,
	TaxAmount	INT	NULL
);

CREATE TABLE PackageProductDetail (
	PackageProductDetail	INT	NOT NULL,
	PackageProductID	INT	NOT NULL,
	FlightTicketID	INT	NOT NULL,
	ServiceID	INT	NOT NULL,
	PartnerProduct	INT	NOT NULL,
	AccessoryID	INT	NOT NULL
);

CREATE TABLE Airport (
	AirportID	INT	NOT NULL,
	AirportName	VARCHAR(255)	NULL,
	City	VARCHAR(255)	NULL,
	Country	VARCHAR(255)	NULL,
	IATACode	VARCHAR(255)	NULL
);

CREATE TABLE FlightTicket (
	FlightTicketID	INT	NOT NULL,
	FlightScheduleID	INT	NOT NULL,
	Price	INT	NULL
);

CREATE TABLE DepartureArrival (
	DepartureArrivalID	INT	NOT NULL,
	FlightRouteID	INT	NOT NULL,
	RouteMilage	INT	NULL
);

CREATE TABLE FullMember (
	FullMemberID	INT	NOT NULL,
	PrivateCustomerID	INT	NOT NULL,
	StartDate	DATETIME	NULL
);

CREATE TABLE ServiceDetail (
	ServiceDetailID	INT	NOT NULL,
	TicketID	INT	NOT NULL
);

CREATE TABLE FlightAttendantSchedule (
	FlightAttendantScheduleID	INT	NOT NULL,
	CrewID	INT	NOT NULL,
	FlightScheduleID	INT	NOT NULL
);

CREATE TABLE FlightAttendant (
	FlightAttendantID	INT	NOT NULL,
	FlightAttendantName	VARCHAR(255)	NULL,
	Ranks	VARCHAR(255)	NULL
);

CREATE TABLE ATCAdvisory (
	ATCAdvisoryID	INT	NOT NULL,
	AdvisoryAirportID	INT	NOT NULL,
	FlightScheduleID	INT	NOT NULL,
	DelayTime	TIME	NULL,
	DelayReason	VARCHAR(255)	NULL
);

CREATE TABLE Ticket (
	TicketID	INT	NOT NULL,
	PassengerID	INT	NOT NULL,
	PNRID	INT	NOT NULL,
	TotalAmount	INT	NOT NULL,
	SeatClass	VARCHAR(255)	NOT NULL,
	SeatNumber	INT	NOT NULL,
	SegmentID	INT	NOT NULL
);

CREATE TABLE Accessory (
	AccessoryID	INT	NOT NULL,
	AccessoryName	VARCHAR(255)	NULL,
	Price	INT	NULL
);

CREATE TABLE CorporateBenefit (
	CorporateBenefitID	INT	NOT NULL,
	CorporateCustomerID	INT	NOT NULL,
	BenefitStartDate	DATETIME	NULL,
	BenefitEndDate	DATETIME	NULL,
	Benefit	VARCHAR(255)	NULL
);

CREATE TABLE Passenger (
	PassengerID	INT	NOT NULL,
	PNRID	INT	NOT NULL
);

CREATE TABLE Coupon (
	CouponID	VARCHAR(255)	NOT NULL,
	CouponValue	INT	NULL,
	SegmentID	INT	NOT NULL
);

CREATE TABLE FlightSchedule (
	FlightScheduleID	INT	NOT NULL,
	FlightRouteID	INT	NOT NULL,
	AirlineID	VARCHAR(255)	NOT NULL,
	DepartureDate	DATETIME	NULL,
	ArrivalDate	DATETIME	NULL,
	SeasonCode	VARCHAR(255)	NULL
);

CREATE TABLE PrivateCustomer (
	PrivateCustomerID	INT	NOT NULL,
	CustomerID2	INT	NOT NULL,
	CustomerIdentifyID	INT	NOT NULL,
	Gender	VARCHAR(255)	NULL,
	Address	VARCHAR(255)	NULL
);

CREATE TABLE CorporateCustomer (
	CorporateCustomerID	INT	NOT NULL,
	CustomerID2	INT	NOT NULL,
	CustomerIdentifyID	INT	NOT NULL,
	CorporateType	VARCHAR(255)	NULL,
	CompanyName	VARCHAR(255)	NULL,
	CompanyAddress	VARCHAR(255)	NULL
);

CREATE TABLE PNR (
	PNRID	INT	NOT NULL,
	CustomerID	INT	NOT NULL
);

CREATE TABLE PartnerProduct (
	PartnerProduct	INT	NOT NULL,
	Name	VARCHAR(255)	NULL,
	Price	INT	NULL
);

CREATE TABLE CorporateCustomerEmployee (
	CorporateCustomerEmployeeID	INT	NOT NULL,
	CorporateCustomerID	INT	NOT NULL,
	Department	VARCHAR(255)	NULL,
	CorporateEmail	VARCHAR(255)	NULL
);

CREATE TABLE ProductDetail (
	ProductDetailID	INT	NOT NULL,
	ProductID	INT	NOT NULL,
	FlightTicketID	INT	NOT NULL,
	ServiceID	INT	NOT NULL,
	PartnerProduct	INT	NOT NULL,
	AccessoryID	INT	NOT NULL,
	PackageProductID	INT	NOT NULL
);

CREATE TABLE CustomerIdentify (
	CustomerIdentifyID	INT	NOT NULL,
	IdentificationType	VARCHAR(255)	NULL
);

CREATE TABLE FlightRoute (
	FlightRouteID	INT	NOT NULL,
	DepartureAirportID	INT	NOT NULL,
	ArrivalAirportID	INT	NOT NULL,
	Distance	BIGINT	NULL
);

CREATE TABLE Airline (
	AirlineID	VARCHAR(255)	NOT NULL,
	AirlineName	VARCHAR(255)	NULL,
	Country	VARCHAR(255)	NULL
);

CREATE TABLE Fare (
	FareID	INT	NOT NULL,
	TicketID	INT	NOT NULL,
	FareAmount	INT	NULL
);

CREATE TABLE Segment (
	SegmentID	INT	NOT NULL,
	PNRID	INT	NOT NULL
);

CREATE TABLE PaymentMethod (
	PaymentMethodID	INT	NOT NULL,
	TicketID	INT	NOT NULL
);

CREATE TABLE ReservationInfo (
	ReservationInfoID	INT	NOT NULL,
	ProductID	INT	NOT NULL,
	PassengerID	INT	NOT NULL,
	PNRID2	INT	NOT NULL,
	SegmentID	INT	NOT NULL
);

CREATE TABLE SimpleMember (
	SimpleMemberID	INT	NOT NULL,
	PrivateCustomerID	INT	NOT NULL,
	StartDate	DATETIME	NULL
);

CREATE TABLE Refund (
	RefundID	INT	NOT NULL,
	TicketID	INT	NOT NULL,
	RefundAmount	INT	NULL,
	RefundDate	DATETIME	NULL
);

ALTER TABLE SSR ADD CONSTRAINT PK_SSR PRIMARY KEY (
	SSRID
);

ALTER TABLE Customer ADD CONSTRAINT PK_CUSTOMER PRIMARY KEY (
	CustomerID,
	CustomerIdentifyID
);

ALTER TABLE PreferFlyingInfo ADD CONSTRAINT PK_PREFERFLYINGINFO PRIMARY KEY (
	ArrivalAirportID
);

ALTER TABLE Service ADD CONSTRAINT PK_SERVICE PRIMARY KEY (
	ServiceID
);

ALTER TABLE Product ADD CONSTRAINT PK_PRODUCT PRIMARY KEY (
	ProductID
);

ALTER TABLE PackageProduct ADD CONSTRAINT PK_PACKAGEPRODUCT PRIMARY KEY (
	PackageProductID
);

ALTER TABLE CrossOver ADD CONSTRAINT PK_CROSSOVER PRIMARY KEY (
	CrossOverID
);

ALTER TABLE FlightAttendantCrew ADD CONSTRAINT PK_FLIGHTATTENDANTCREW PRIMARY KEY (
	CrewID
);

ALTER TABLE RefundPaymentMethod ADD CONSTRAINT PK_REFUNDPAYMENTMETHOD PRIMARY KEY (
	RefundPaymentMethodID,
	RefundID
);

ALTER TABLE RefundFare ADD CONSTRAINT PK_REFUNDFARE PRIMARY KEY (
	RefundFareID,
	RefundID
);

ALTER TABLE RefundTax ADD CONSTRAINT PK_REFUNDTAX PRIMARY KEY (
	RefundTaxID,
	RefundID
);

ALTER TABLE Tax ADD CONSTRAINT PK_TAX PRIMARY KEY (
	TaxID,
	TicketID
);

ALTER TABLE PackageProductDetail ADD CONSTRAINT PK_PACKAGEPRODUCTDETAIL PRIMARY KEY (
	PackageProductDetail,
	PackageProductID
);

ALTER TABLE Airport ADD CONSTRAINT PK_AIRPORT PRIMARY KEY (
	AirportID
);

ALTER TABLE FlightTicket ADD CONSTRAINT PK_FLIGHTTICKET PRIMARY KEY (
	FlightTicketID
);

ALTER TABLE DepartureArrival ADD CONSTRAINT PK_DEPARTUREARRIVAL PRIMARY KEY (
	DepartureArrivalID
);

ALTER TABLE FullMember ADD CONSTRAINT PK_FULLMEMBER PRIMARY KEY (
	FullMemberID
);

ALTER TABLE ServiceDetail ADD CONSTRAINT PK_SERVICEDETAIL PRIMARY KEY (
	ServiceDetailID
);

ALTER TABLE FlightAttendantSchedule ADD CONSTRAINT PK_FLIGHTATTENDANTSCHEDULE PRIMARY KEY (
	FlightAttendantScheduleID
);

ALTER TABLE FlightAttendant ADD CONSTRAINT PK_FLIGHTATTENDANT PRIMARY KEY (
	FlightAttendantID
);

ALTER TABLE ATCAdvisory ADD CONSTRAINT PK_ATCADVISORY PRIMARY KEY (
	ATCAdvisoryID
);

ALTER TABLE Ticket ADD CONSTRAINT PK_TICKET PRIMARY KEY (
	TicketID
);

ALTER TABLE Accessory ADD CONSTRAINT PK_ACCESSORY PRIMARY KEY (
	AccessoryID
);

ALTER TABLE CorporateBenefit ADD CONSTRAINT PK_CORPORATEBENEFIT PRIMARY KEY (
	CorporateBenefitID
);

ALTER TABLE Passenger ADD CONSTRAINT PK_PASSENGER PRIMARY KEY (
	PassengerID,
	PNRID
);

ALTER TABLE Coupon ADD CONSTRAINT PK_COUPON PRIMARY KEY (
	CouponID
);

ALTER TABLE FlightSchedule ADD CONSTRAINT PK_FLIGHTSCHEDULE PRIMARY KEY (
	FlightScheduleID
);

ALTER TABLE PrivateCustomer ADD CONSTRAINT PK_PRIVATECUSTOMER PRIMARY KEY (
	PrivateCustomerID,
	CustomerID2,
	CustomerIdentifyID
);

ALTER TABLE CorporateCustomer ADD CONSTRAINT PK_CORPORATECUSTOMER PRIMARY KEY (
	CorporateCustomerID,
	CustomerID2,
	CustomerIdentifyID
);

ALTER TABLE PNR ADD CONSTRAINT PK_PNR PRIMARY KEY (
	PNRID
);

ALTER TABLE PartnerProduct ADD CONSTRAINT PK_PARTNERPRODUCT PRIMARY KEY (
	PartnerProduct
);

ALTER TABLE CorporateCustomerEmployee ADD CONSTRAINT PK_CORPORATECUSTOMEREMPLOYEE PRIMARY KEY (
	CorporateCustomerEmployeeID
);

ALTER TABLE ProductDetail ADD CONSTRAINT PK_PRODUCTDETAIL PRIMARY KEY (
	ProductDetailID,
	ProductID,
	FlightTicketID,
	ServiceID,
	PartnerProduct,
	AccessoryID,
	PackageProductID
);

ALTER TABLE CustomerIdentify ADD CONSTRAINT PK_CUSTOMERIDENTIFY PRIMARY KEY (
	CustomerIdentifyID
);

ALTER TABLE FlightRoute ADD CONSTRAINT PK_FLIGHTROUTE PRIMARY KEY (
	FlightRouteID
);

ALTER TABLE Airline ADD CONSTRAINT PK_AIRLINE PRIMARY KEY (
	AirlineID
);

ALTER TABLE Fare ADD CONSTRAINT PK_FARE PRIMARY KEY (
	FareID,
	TicketID
);

ALTER TABLE Segment ADD CONSTRAINT PK_SEGMENT PRIMARY KEY (
	SegmentID
);

ALTER TABLE PaymentMethod ADD CONSTRAINT PK_PAYMENTMETHOD PRIMARY KEY (
	PaymentMethodID
);

ALTER TABLE ReservationInfo ADD CONSTRAINT PK_RESERVATIONINFO PRIMARY KEY (
	ReservationInfoID
);

ALTER TABLE SimpleMember ADD CONSTRAINT PK_SIMPLEMEMBER PRIMARY KEY (
	SimpleMemberID
);

ALTER TABLE Refund ADD CONSTRAINT PK_REFUND PRIMARY KEY (
	RefundID
);

ALTER TABLE Customer ADD CONSTRAINT FK_CustomerIdentify_TO_Customer_1 FOREIGN KEY (
	CustomerIdentifyID
)
REFERENCES CustomerIdentify (
	CustomerIdentifyID
);

ALTER TABLE PreferFlyingInfo ADD CONSTRAINT FK_FlightRoute_TO_PreferFlyingInfo_1 FOREIGN KEY (
	ArrivalAirportID
)
REFERENCES FlightRoute (
	FlightRouteID
);

ALTER TABLE RefundPaymentMethod ADD CONSTRAINT FK_Refund_TO_RefundPaymentMethod_1 FOREIGN KEY (
	RefundID
)
REFERENCES Refund (
	RefundID
);

ALTER TABLE RefundFare ADD CONSTRAINT FK_Refund_TO_RefundFare_1 FOREIGN KEY (
	RefundID
)
REFERENCES Refund (
	RefundID
);

ALTER TABLE RefundTax ADD CONSTRAINT FK_Refund_TO_RefundTax_1 FOREIGN KEY (
	RefundID
)
REFERENCES Refund (
	RefundID
);

ALTER TABLE Tax ADD CONSTRAINT FK_Ticket_TO_Tax_1 FOREIGN KEY (
	TicketID
)
REFERENCES Ticket (
	TicketID
);

ALTER TABLE PackageProductDetail ADD CONSTRAINT FK_PackageProduct_TO_PackageProductDetail_1 FOREIGN KEY (
	PackageProductID
)
REFERENCES PackageProduct (
	PackageProductID
);

ALTER TABLE Passenger ADD CONSTRAINT FK_PNR_TO_Passenger_1 FOREIGN KEY (
	PNRID
)
REFERENCES PNR (
	PNRID
);

ALTER TABLE PrivateCustomer ADD CONSTRAINT FK_Customer_TO_PrivateCustomer_1 FOREIGN KEY (
	CustomerID2
)
REFERENCES Customer (
	CustomerID
);

ALTER TABLE PrivateCustomer ADD CONSTRAINT FK_Customer_TO_PrivateCustomer_2 FOREIGN KEY (
	CustomerIdentifyID
)
REFERENCES Customer (
	CustomerIdentifyID
);

ALTER TABLE CorporateCustomer ADD CONSTRAINT FK_Customer_TO_CorporateCustomer_1 FOREIGN KEY (
	CustomerID2
)
REFERENCES Customer (
	CustomerID
);

ALTER TABLE CorporateCustomer ADD CONSTRAINT FK_Customer_TO_CorporateCustomer_2 FOREIGN KEY (
	CustomerIdentifyID
)
REFERENCES Customer (
	CustomerIdentifyID
);

ALTER TABLE ProductDetail ADD CONSTRAINT FK_Product_TO_ProductDetail_1 FOREIGN KEY (
	ProductID
)
REFERENCES Product (
	ProductID
);

ALTER TABLE ProductDetail ADD CONSTRAINT FK_FlightTicket_TO_ProductDetail_1 FOREIGN KEY (
	FlightTicketID
)
REFERENCES FlightTicket (
	FlightTicketID
);

ALTER TABLE ProductDetail ADD CONSTRAINT FK_Service_TO_ProductDetail_1 FOREIGN KEY (
	ServiceID
)
REFERENCES Service (
	ServiceID
);

ALTER TABLE ProductDetail ADD CONSTRAINT FK_PartnerProduct_TO_ProductDetail_1 FOREIGN KEY (
	PartnerProduct
)
REFERENCES PartnerProduct (
	PartnerProduct
);

ALTER TABLE ProductDetail ADD CONSTRAINT FK_Accessory_TO_ProductDetail_1 FOREIGN KEY (
	AccessoryID
)
REFERENCES Accessory (
	AccessoryID
);

ALTER TABLE ProductDetail ADD CONSTRAINT FK_PackageProduct_TO_ProductDetail_1 FOREIGN KEY (
	PackageProductID
)
REFERENCES PackageProduct (
	PackageProductID
);

ALTER TABLE Fare ADD CONSTRAINT FK_Ticket_TO_Fare_1 FOREIGN KEY (
	TicketID
)
REFERENCES Ticket (
	TicketID
);