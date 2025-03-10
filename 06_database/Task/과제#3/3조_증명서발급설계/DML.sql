-- 남기준의 가족관계증명서
SELECT 
    fr.CertificateNumber AS '증명서확인번호',
    DATE_FORMAT(fr.IssueDate, '%Y-%m-%d') AS '발급일',
    a.RoadAddress AS '등록기준지(본적)',
    p2.Name AS '성명',
    rt.TypeName AS '구분',
	substring(p2.RegistrationNumber,1,6) AS '생년월일',
    p2.RegistrationNumber AS '주민등록번호',
    p2.Gender AS '성별'
FROM Person p1
JOIN FamailyRelation fr1 ON p1.PersonID = fr1.PersonID
JOIN RelationType rt ON fr1.RelationshipTypeID = rt.RelationshipTypeID
JOIN Person p2 ON fr1.TargetID = p2.PersonID
JOIN FamilyRegistrration fr ON fr1.FamilyRegistrrationID = fr.FamilyRegistrrationID
JOIN Residence r ON p1.PersonID = r.PersonID
JOIN Address a ON r.AddressID = a.AddressID
WHERE p1.Name = '남기준'
ORDER BY 
    CASE 
        WHEN rt.TypeName = '본인' THEN 1
        WHEN rt.TypeName = '부' THEN 2
        WHEN rt.TypeName = '모' THEN 3
        WHEN rt.TypeName = '배우자' THEN 4
        WHEN rt.TypeName = '자녀' THEN 5
        ELSE 6
    END;
    
    
-- 등본 주소,신고일
SELECT DISTINCT
    '현주소' AS '구분',
    a.RoadAddress AS '주소',
    r.ReportDate AS '신고일'
FROM Address a
JOIN Residence r ON a.AddressID = r.AddressID
WHERE r.AddressID = 1 AND r.isCurrent = 1
UNION ALL
SELECT DISTINCT
    '주소' AS '구분',
    a.RoadAddress AS '주소',
    r.ReportDate AS '신고일'
FROM Address a  
JOIN Residence r ON a.AddressID = r.AddressID
WHERE r.isCurrent != 1

-- 남기준의 주민등록등본
SELECT 
    rr.CertificateNumber AS '증명서확인번호',
    rr.IssueDate AS '발급일',
    h.HouseHoldDate AS '세대구성일',
    c.Reason AS '변동사유',
    r.ReportDate AS '신고일',
    p.Name AS '성명',
    hhr.Name AS '세대주관계',
    p.RegistrationNumber AS '주민등록번호'
FROM HouseHold h
JOIN Residence r ON h.ResidenceID = r.ResidenceID
JOIN Address a ON r.AddressID = a.AddressID
JOIN HouseHoldMember hm ON h.HouseHoldID = hm.HouseHoldID
JOIN ChangeReason c ON hm.ChangeResonID = c.ChangeResonID 
JOIN HouseHoldRelation hhr ON hm.HouseHoldRelationID = hhr.HouseHoldRelationID
JOIN Person p ON (
    (hhr.HouseHoldRelationID = 1 AND p.Name = '남기준') OR
    (hhr.HouseHoldRelationID = 2 AND p.Name = '이주은') OR
    (hhr.HouseHoldRelationID = 3 AND p.Name = '남기석') OR
    (hhr.HouseHoldRelationID = 4 AND p.Name = '이선미')
)
JOIN ResidentRegistration rr ON r.ResidenceID = 1  -- 현재 주소에 대한 등본
WHERE r.isCurrent = 1
ORDER BY
    CASE 
        WHEN hhr.Name = '본인' THEN 1
        WHEN hhr.Name = '배우자' THEN 2
        WHEN hhr.Name = '자녀' THEN 3
        ELSE 4
    END;
    
    
SELECT 
    reg.RegistrationDate AS '신고일',
    p.Name AS '성명',
    p.Gender AS '성별',
    br.BirthDate AS '출생일시',
    br.BirthLocation AS '출생장소',
    a.RoadAddress AS '등록기준지(본적)',
    
    father.Name AS '부 성명',
    father.RegistrationNumber AS '부 주민등록번호',
    mother.Name AS '모 성명',
    mother.RegistrationNumber AS '모 주민등록번호',

	father.Name AS '신고인 성명',
    reg.ReporterRegistrationNumber AS '신고인 주민등록번호',
    br.Qualification AS '신고인 자격',
    reg.Email AS '신고인 이메일',
    reg.PhoneNo AS '신고인 전화번호'
    
FROM BirthRegistration br
JOIN Registration reg ON br.RegistrationID2 = reg.RegistrationID
JOIN Person p ON reg.PersonID = p.PersonID
JOIN Residence res ON p.ResidenceID = res.ResidenceID
JOIN Address a ON res.AddressID = a.AddressID

LEFT JOIN Relation father_rel ON p.PersonID = father_rel.PersonID 
    AND father_rel.RelationshipTypeID = (SELECT RelationshipTypeID FROM RelationType WHERE TypeName = '부')
LEFT JOIN Person father ON father_rel.TargetID = father.PersonID

LEFT JOIN Relation mother_rel ON p.PersonID = mother_rel.PersonID 
    AND mother_rel.RelationshipTypeID = (SELECT RelationshipTypeID FROM RelationType WHERE TypeName = '모')
LEFT JOIN Person mother ON mother_rel.TargetID = mother.PersonID

WHERE p.Name = '남기석';

-- 사망신고서
SELECT 
	rgt.RegistrationDate AS '신고일',
    p.Name AS '사망자 성명',
    rgt.ReporterRegistrationNumber AS '사망자 주민등록번호',
    dr.DeathLocationType AS '사망장소 구분',
    dr.DeathLocation AS '사망장소 주소',
    p2.Name AS '신고인 성명',
    p2.RegistrationNumber AS '신고인 주민등록번호',
    dr.Qualification AS '신고인 자격',
    rgt.Email AS '신고인 이메일',
    rgt.PhoneNo AS '신고인 전화번호'
FROM deathregistration dr
JOIN registration rgt ON dr.RegistrationID2 = rgt.RegistrationID
JOIN person p ON rgt.ReporterRegistrationNumber = p.RegistrationNumber
JOIN person p2 ON rgt.PersonID = p2.PersonID
JOIN registrationtype rt ON rt.RegistrationTypeID = rgt.RegistrationTypeID
WHERE rgt.ReporterRegistrationNumber = '130914-*******' AND rt.TypeName = '사망신고';