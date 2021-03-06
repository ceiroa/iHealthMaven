--The database engine that supports transactions
--and foreign key constraints is InnoDB.

use ihealth;

--Create table clients
create table IF NOT EXISTS clients
(
    id int(24) NOT NULL AUTO_INCREMENT,
    firstName varchar(30),
    middleInitial varchar(12),
    lastName varchar(40),
    gender varchar(12),
    address varchar(40),
    city varchar(20),
    usState varchar(20),
    zipcode varchar(8),
    email varchar(30),
    referrer varchar(50),
    homePhone varchar(16),
    cellPhone varchar(16),
    workPhone varchar(16),
    dob varchar(10),
    ssn varchar(12),
    driverLicense varchar(20),
    employer varchar(30),
    occupation varchar(30),
    employerAddress varchar(40),
    employerPhoneNum varchar(16),
    contactName varchar(60),
    contactRelation varchar(20),
    contactPhone varchar(16),
    insurance varchar(30),
    insuranceAddress varchar(40),
    policyHolderName varchar(40),
    policyHolderAddress varchar(60),
    policyHolderDob varchar(10),
    policyHolderSsn varchar(12),
    policyNumber varchar(30),
    groupNumber varchar(30),
    policyHolderRelation varchar(30),
    insurance2 varchar(30),
    insuranceAddress2 varchar(40),
    policyHolderName2 varchar(40),
    policyHolderAddress2 varchar(60),
    policyHolderDob2 varchar(10),
    policyHolderSsn2 varchar(12),
    policyNumber2 varchar(30),
    groupNumber2 varchar(30),
    policyHolderRelation2 varchar(30),
    accidentInfo varchar(800),
    compInfo varchar(800),
    UNIQUE (id),
    PRIMARY KEY(id)
) type=innodb;

--Create table users
create table IF NOT EXISTS users
(
    id int(24) NOT NULL AUTO_INCREMENT,
    firstName varchar(30),
    lastName varchar(40),
    username varchar(20) NOT NULL,
    password varchar(60) NOT NULL,
    userType enum('admin', 'nonadmin') NOT NULL,
    email varchar(30),
    status enum('active', 'inactive') NOT NULL,
    dateCreated timestamp default '0000-00-00 00:00:00',
    dateUpdated timestamp default now() on update now(),
    UNIQUE (username),
    PRIMARY KEY(id)
) type=innodb;

--Create table cervicalSpineVisits
create table IF NOT EXISTS cervicalSpineVisits
(
    --Common fields for all visit tables
    id int(24) NOT NULL AUTO_INCREMENT,
    clientId int(24) NOT NULL,
    dateCreated timestamp default NULL,
    dateUpdated timestamp default now() on update now(),
    sameComplaint enum('yes', 'no'),
    painChange enum('same', 'better', 'worse'),
    achingDullSore enum('yes', 'no') DEFAULT 'no',
    burning enum('yes', 'no') DEFAULT 'no',
    numbnessTingling enum('yes', 'no') DEFAULT 'no',
    sharpShooting enum('yes', 'no') DEFAULT 'no',
    sharpStabbing enum('yes', 'no') DEFAULT 'no',
    stiffnessTightness enum('yes', 'no') DEFAULT 'no',
    swelling enum('yes', 'no') DEFAULT 'no',
    throbbing enum('yes', 'no') DEFAULT 'no',
    snapPopGrind enum('yes', 'no') DEFAULT 'no',
    painLevel int(2),
    complaint varchar(800),
    frequency varchar(400),
    --Until here
    flex int(6),
    llf int(6),
    llr int(6),
    ext int(6),
    rlf int(6),
    rlr int(6),
    jacksonComp varchar(12),
    maxComp varchar(12),
    shoulderDep varchar(12),
    sotoHall varchar(12),
    spurlings varchar(12),
    csDistraction varchar(12),
    valsavas varchar(12),
    baccody varchar(12),
    latArm varchar(12),
    latForearm varchar(12),
    middleFinger varchar(12),
    medForearm varchar(12),
    medArm varchar(12),
    biceps varchar(12),
    brachiorad varchar(12),
    triceps varchar(12),
    shoulderAbd varchar(12),
    wristExt varchar(12),
    wristFlex varchar(12),
    fingerExt varchar(12),
    fingerFlex varchar(12),
    fingerAbd varchar(12),
    --These fields are also common for all visit tables
    inspection varchar(1200),
    palpation varchar(1600),
    dxAction varchar(1600),
    FOREIGN KEY (clientId) REFERENCES clients(id),
    PRIMARY KEY(id)
) type=innodb;


--Create table lumbarSpineVisits
create table IF NOT EXISTS lumbarSpineVisits
(
    --Common fields for all visit tables
    id int(24) NOT NULL AUTO_INCREMENT,
    clientId int(24) NOT NULL,
    dateCreated timestamp default NULL,
    dateUpdated timestamp default now() on update now(),
    sameComplaint enum('yes', 'no'),
    painChange enum('same', 'better', 'worse'),
    achingDullSore enum('yes', 'no') DEFAULT 'no',
    burning enum('yes', 'no') DEFAULT 'no',
    numbnessTingling enum('yes', 'no') DEFAULT 'no',
    sharpShooting enum('yes', 'no') DEFAULT 'no',
    sharpStabbing enum('yes', 'no') DEFAULT 'no',
    stiffnessTightness enum('yes', 'no') DEFAULT 'no',
    swelling enum('yes', 'no') DEFAULT 'no',
    throbbing enum('yes', 'no') DEFAULT 'no',
    snapPopGrind enum('yes', 'no') DEFAULT 'no',
    painLevel int(2),
    complaint varchar(800),
    frequency varchar(400),
    --Until here
    flex int(6),
    ext int(6),
    llf int(6),
    rlf int(6),
    llr int(6),
    rlr int(6),
    valsavas varchar(12),
    straightLeg varchar(12),
    browstringTest varchar(12),
    lasegueTest varchar(12),
    elyTest varchar(12),
    thomasTest varchar(12),
    springTest varchar(12),
    trenderlenburgTest varchar(12),
    bilateralLegRaise varchar(12),
    pelvicRock varchar(12),
    patrickFabere varchar(12),
    milgram varchar(12),
    medLegFoot varchar(12),
    latLeg varchar(12),
    latFoot varchar(12),
    patellar varchar(12),
    hamstring varchar(12),
    achilles varchar(12),
    antTibialis varchar(12),
    extHallucis varchar(12),
    peroneus varchar(12),
    --These fields are also common for all visit tables
    inspection varchar(1200),
    palpation varchar(1600),
    dxAction varchar(1600),
    FOREIGN KEY (clientId) REFERENCES clients(id),
    PRIMARY KEY(id)
) type=innodb;


--Create table upperExtremitiesVisits
create table IF NOT EXISTS upperExtremitiesVisits
(
    --Common fields for all visit tables
    id int(24) NOT NULL AUTO_INCREMENT,
    clientId int(24) NOT NULL,
    dateCreated timestamp default NULL,
    dateUpdated timestamp default now() on update now(),
    sameComplaint enum('yes', 'no'),
    painChange enum('same', 'better', 'worse'),
    achingDullSore enum('yes', 'no') DEFAULT 'no',
    burning enum('yes', 'no') DEFAULT 'no',
    numbnessTingling enum('yes', 'no') DEFAULT 'no',
    sharpShooting enum('yes', 'no') DEFAULT 'no',
    sharpStabbing enum('yes', 'no') DEFAULT 'no',
    stiffnessTightness enum('yes', 'no') DEFAULT 'no',
    swelling enum('yes', 'no') DEFAULT 'no',
    throbbing enum('yes', 'no') DEFAULT 'no',
    snapPopGrind enum('yes', 'no') DEFAULT 'no',
    painLevel int(2),
    complaint varchar(800),
    frequency varchar(400),
    --Until here
    shoulderFlex int(6),
    shoulderLr int(6),
    shoulderAbd int(6),
    shoulderExt int(6),
    shoulderMr int(6),
    shoulderAdd int(6),
    elbowFlex int(6),
    elbowPro int(6),
    elbowExt int(6),
    elbowSup int(6),
    wristFlex int(6),
    wristAbd int(6),
    wristExt int(6),
    wristAdd int(6),
    dropArmTest varchar(12),
    drawbarnTest varchar(12),
    supraspinatusTest varchar(12),
    apleyScratchTest varchar(12),
    postImpingSign varchar(12),
    speedTest varchar(12),
    crossOverImpTest varchar(12),
    yergasonTest varchar(12),
    apprehensionTest varchar(12),
    drawerTest varchar(12),
    varusStressTest varchar(12),
    cozensTest varchar(12),
    valgusStressTest varchar(12),
    golferElbow varchar(12),
    tinelSign varchar(12),
    pinchGripTest varchar(12),
    fromentTest varchar(12),
    phalenTest varchar(12),
    fingerTapTest varchar(12),
    finkelsteninTest varchar(12),
    bunnelLitter varchar(12),
    --These fields are also common for all visit tables
    inspection varchar(1200),
    palpation varchar(1600),
    dxAction varchar(1600),
    FOREIGN KEY (clientId) REFERENCES clients(id),
    PRIMARY KEY(id)
) type=innodb;


--Create table lowerExtremitiesVisits
create table IF NOT EXISTS lowerExtremitiesVisits
(
    --Common fields for all visit tables
    id int(24) NOT NULL AUTO_INCREMENT,
    clientId int(24) NOT NULL,
    dateCreated timestamp default NULL,
    dateUpdated timestamp default now() on update now(),
    sameComplaint enum('yes', 'no'),
    painChange enum('same', 'better', 'worse'),
    achingDullSore enum('yes', 'no') DEFAULT 'no',
    burning enum('yes', 'no') DEFAULT 'no',
    numbnessTingling enum('yes', 'no') DEFAULT 'no',
    sharpShooting enum('yes', 'no') DEFAULT 'no',
    sharpStabbing enum('yes', 'no') DEFAULT 'no',
    stiffnessTightness enum('yes', 'no') DEFAULT 'no',
    swelling enum('yes', 'no') DEFAULT 'no',
    throbbing enum('yes', 'no') DEFAULT 'no',
    snapPopGrind enum('yes', 'no') DEFAULT 'no',
    painLevel int(2),
    complaint varchar(800),
    frequency varchar(400),
    --Until here
    kneeFlex int(6),
    kneeExt int(6),
    pf int(6),
    df int(6),
    inv int(6),
    ev int(6),
    hipFlex int(6),
    hipExt int(6),
    hipAbd int(6),
    hipAdd int(6),
    hipLr int(6),
    hipMr int(6),
    hipHyp int(6),
    trendelenbarg varchar(12),
    legLength varchar(12),
    thomasTest varchar(12),
    oberTest varchar(12),
    mcMurray varchar(12),
    apleyTest varchar(12),
    bounceHome varchar(12),
    patellaGrinding varchar(12),
    apprehensionPatella varchar(12),
    tinelSign varchar(12),
    effusionTest varchar(12),
    rigidFlatFeet varchar(12),
    tibialTorsion varchar(12),
    homansSign varchar(12),
    forefootTest varchar(12),
    ankleDorsiflexion varchar(12),
    --These fields are also common for all visit tables
    inspection varchar(1200),
    palpation varchar(1600),
    dxAction varchar(1600),
    FOREIGN KEY (clientId) REFERENCES clients(id),
    PRIMARY KEY(id)
) type=innodb;

--Create table uploads
create table IF NOT EXISTS uploads
(
    id int(24) NOT NULL AUTO_INCREMENT,
    clientId int(24) NOT NULL,
    dateCreated timestamp default now(),
    dateUpdated timestamp default now() on update now(),
    filename varchar(40) NOT NULL,
    filePath varchar(200) NOT NULL,
    FOREIGN KEY (clientId) REFERENCES clients(id),
    PRIMARY KEY(id)
) type=innodb;