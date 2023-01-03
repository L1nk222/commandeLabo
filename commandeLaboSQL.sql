-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: commandelabo
-- ------------------------------------------------------
-- Server version	5.5.5-10.11.0-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commande` (
  `idCommande` int(11) NOT NULL,
  `matriculeProd` varchar(100) DEFAULT NULL,
  `quantiteProd` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idCommande`),
  KEY `matriculeProd` (`matriculeProd`),
  CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`matriculeProd`) REFERENCES `produit` (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande`
--

LOCK TABLES `commande` WRITE;
/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
INSERT INTO `commande` VALUES (1,'PR19','100'),(2,'PR3','26'),(3,'PR29','22'),(4,'PR29','85'),(5,'PR6','91'),(6,'PR28','20'),(7,'PR28','50'),(8,'PR29','78'),(9,'PR8','4'),(10,'PR3','94'),(11,'PR21','94'),(12,'PR16','60'),(13,'PR21','87'),(14,'PR1','71'),(15,'PR19','14'),(16,'PR12','71'),(17,'PR28','43'),(18,'PR15','39'),(19,'PR18','89'),(20,'PR27','4'),(21,'PR25','36'),(22,'PR8','10'),(23,'PR14','67'),(24,'PR11','10'),(25,'PR9','96'),(26,'PR12','58'),(27,'PR2','9'),(28,'PR5','92'),(29,'PR17','15'),(30,'PR24','49');
/*!40000 ALTER TABLE `commande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fournisseurs`
--

DROP TABLE IF EXISTS `fournisseurs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fournisseurs` (
  `idFournisseur` int(11) NOT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `mail` varchar(100) DEFAULT NULL,
  `adresse` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idFournisseur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fournisseurs`
--

LOCK TABLES `fournisseurs` WRITE;
/*!40000 ALTER TABLE `fournisseurs` DISABLE KEYS */;
INSERT INTO `fournisseurs` VALUES (1,'Kwinu','ajoiris0@ehow.com','3 Hooker Terrace'),(2,'Babblestorm','lflorez1@icq.com','21183 Union Avenue'),(3,'Bluejam','cfratson2@artisteer.com','84 Green Road'),(4,'Yodel','vpesticcio3@pcworld.com','17705 Mitchell Hill'),(5,'Gabcube','tgowers4@ucla.edu','783 Basil Plaza'),(6,'Lazz','dbramham5@rakuten.co.jp','18 Sachtjen Park'),(7,'Twimm','ttrodd6@arstechnica.com','52 Anderson Pass'),(8,'Camido','lfrayling7@google.ru','86 1st Crossing'),(9,'Topdrive','nroby8@wikipedia.org','72092 East Parkway'),(10,'Wordware','qnorvel9@ibm.com','30223 Onsgard Terrace'),(11,'Mybuzz','abillsberrya@altervista.org','833 Shopko Way'),(12,'Rhyloo','csweetlandb@bluehost.com','4586 Superior Circle'),(13,'Zoomdog','cbloschkec@nhs.uk','606 Morrow Center'),(14,'Browsedrive','nhalld@techcrunch.com','06780 Blue Bill Park Park'),(15,'Voonyx','lpennie@flavors.me','9 Londonderry Drive'),(16,'Wikizz','akeenef@sphinn.com','55887 Green Ridge Way'),(17,'Katz','jbratcherg@desdev.cn','57 Sunfield Pass'),(18,'Quamba','othaxterh@ibm.com','98220 Maple Place'),(19,'Rhynyx','mcavei@squidoo.com','9849 Mcguire Place'),(20,'Zoozzy','nbrownsworthj@twitter.com','3 5th Avenue'),(21,'Layo','bchinneryk@yelp.com','4 Meadow Valley Avenue'),(22,'Skilith','dmcgloughlinl@wp.com','406 Lillian Place'),(23,'Eire','achidlerm@pbs.org','471 Springview Court'),(24,'Blogspan','hwisdenn@dailymotion.com','116 Beilfuss Drive'),(25,'Kwimbee','sorbineo@mail.ru','6352 Cordelia Junction'),(26,'Trilia','hferneyp@illinois.edu','2373 Starling Point'),(27,'Browseblab','cmorleyq@google.nl','439 Lawn Avenue'),(28,'Fivechat','esearsbyr@wired.com','92110 Sommers Trail'),(29,'Rhynyx','akarlowiczs@salon.com','59292 Dennis Junction'),(30,'Livepath','ahuggont@springer.com','4 Quincy Terrace');
/*!40000 ALTER TABLE `fournisseurs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laboratoire`
--

DROP TABLE IF EXISTS `laboratoire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laboratoire` (
  `idLabo` int(11) NOT NULL,
  `ville` varchar(100) DEFAULT NULL,
  `idStock` int(11) DEFAULT NULL,
  PRIMARY KEY (`idLabo`),
  KEY `idStock` (`idStock`),
  CONSTRAINT `laboratoire_ibfk_1` FOREIGN KEY (`idStock`) REFERENCES `stock` (`idStock`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laboratoire`
--

LOCK TABLES `laboratoire` WRITE;
/*!40000 ALTER TABLE `laboratoire` DISABLE KEYS */;
INSERT INTO `laboratoire` VALUES (1,'Cilegong',9),(2,'Baranoa',17),(3,'Luna',8),(4,'Cibeureum',23),(5,'Cincinnati',25),(6,'Saga-shi',30),(7,'Meitang',30),(8,'Anyuan',3),(9,'Liaoyang',29),(10,'Laleng',25),(11,'Chornyanka',17),(12,'Pushkin',8),(13,'Tehetu',25),(14,'Meicheng',22),(15,'Mamali',11),(16,'Sancha',15),(17,'Sumqay?t',6),(18,'Shahb?',9),(19,'União',13),(20,'Tsuma',26),(21,'Pyhäselkä',12),(22,'Shemona?kha',19),(23,'Zgornje Gorje',13),(24,'Bordeaux',10),(25,'Maroúsi',17),(26,'Malko T?rnovo',27),(27,'Queniquea',11),(28,'Xinji',29),(29,'Guachetá',14),(30,'Tsushima',12);
/*!40000 ALTER TABLE `laboratoire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produit` (
  `matricule` varchar(100) NOT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `poids` float DEFAULT NULL,
  `idFournisseur` int(11) DEFAULT NULL,
  PRIMARY KEY (`matricule`),
  KEY `idFournisseur` (`idFournisseur`),
  CONSTRAINT `produit_ibfk_1` FOREIGN KEY (`idFournisseur`) REFERENCES `fournisseurs` (`idFournisseur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit`
--

LOCK TABLES `produit` WRITE;
/*!40000 ALTER TABLE `produit` DISABLE KEYS */;
INSERT INTO `produit` VALUES ('PR1','Jetwire','mauris sit amet eros suspendisse accumsan tortor quis turpis sed ante vivamus tortor duis mattis egestas metus aenean fermentum donec',11,15),('PR10','Brightdog','faucibus orci luctus et ultrices posuere cubilia curae duis faucibus',2,5),('PR11','Twimbo','odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut',38,1),('PR12','Dynava','pede malesuada in imperdiet et commodo vulputate justo in blandit',56,17),('PR13','Livetube','cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer',94,12),('PR14','Jabberstorm','etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus',62,22),('PR15','Jabberbean','mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit',60,5),('PR16','Jatri','eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum',33,17),('PR17','Teklist','nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo',33,20),('PR18','Eayo','nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus',3,18),('PR19','Realfire','ante vivamus tortor duis mattis egestas metus aenean fermentum donec ut mauris eget massa tempor',6,10),('PR2','Roombo','pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi',81,6),('PR20','Cogilith','sapien varius ut blandit non interdum in ante vestibulum ante ipsum primis',24,1),('PR21','Flipopia','libero nam dui proin leo odio porttitor id consequat in consequat',75,11),('PR22','Dabshots','posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien',21,17),('PR23','Wordtune','eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus',51,14),('PR24','Zoonder','at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci',44,22),('PR25','Lajo','turpis eget elit sodales scelerisque mauris sit amet eros suspendisse accumsan tortor quis turpis sed ante vivamus tortor',38,6),('PR26','Oloo','commodo vulputate justo in blandit ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing elit proin interdum mauris',17,25),('PR27','Jabbersphere','phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat',7,25),('PR28','Livetube','cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien',68,30),('PR29','Quaxo','duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio',89,14),('PR3','Dabshots','sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec',92,8),('PR30','Midel','ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et',24,27),('PR4','Jabberbean','pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo',57,8),('PR5','Realcube','elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi',4,26),('PR6','Yata','aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien',34,12),('PR7','Divavu','dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices',67,29),('PR8','Zoomzone','convallis eget eleifend luctus ultricies eu nibh quisque id justo sit',10,19),('PR9','Gigashots','lorem ipsum dolor sit amet consectetuer adipiscing elit proin risus praesent lectus vestibulum quam sapien varius ut blandit non interdum',69,23);
/*!40000 ALTER TABLE `produit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recap`
--

DROP TABLE IF EXISTS `recap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recap` (
  `idRecap` int(11) NOT NULL,
  `dateCommande` varchar(100) DEFAULT NULL,
  `descriptionCommande` varchar(1000) DEFAULT NULL,
  `idCommande` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRecap`),
  KEY `idCommande` (`idCommande`),
  CONSTRAINT `recap_ibfk_1` FOREIGN KEY (`idCommande`) REFERENCES `commande` (`idCommande`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recap`
--

LOCK TABLES `recap` WRITE;
/*!40000 ALTER TABLE `recap` DISABLE KEYS */;
INSERT INTO `recap` VALUES (1,'13/11/2022','augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia',3),(2,'17/05/2022','potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi',2),(3,'12/10/2022','est quam pharetra magna ac consequat metus sapien ut nunc',1),(4,'06/10/2022','vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula',5),(5,'24/11/2022','erat id mauris vulputate elementum nullam varius nulla facilisi cras',6),(6,'05/03/2022','mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit',7),(7,'09/03/2022','urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam',9),(8,'31/08/2022','tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam',4),(9,'07/02/2022','platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum',10),(10,'25/04/2022','lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum',11),(11,'28/08/2022','sapien a libero nam dui proin leo odio porttitor id',8),(12,'05/01/2022','at turpis a pede posuere nonummy integer non velit donec diam',12),(13,'03/12/2022','volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna',13),(14,'21/05/2022','magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum',16),(15,'24/03/2022','gravida sem praesent id massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio cras mi pede malesuada',14),(16,'05/03/2022','maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis',15),(17,'31/05/2022','interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa',17),(18,'03/01/2022','id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit',18),(19,'17/06/2022','quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac',19),(20,'27/03/2022','ante vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio',20),(21,'18/12/2022','rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie',21),(22,'16/10/2022','sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc',22),(23,'06/08/2022','nibh ligula nec sem duis aliquam convallis nunc proin at turpis',23),(24,'08/05/2022','aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in',24),(25,'17/05/2022','congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat',29),(26,'29/12/2022','at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt',28),(27,'03/06/2022','nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc',25),(28,'07/05/2022','mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim sit amet',26),(29,'19/02/2022','aliquam quis turpis eget elit sodales scelerisque mauris sit amet eros suspendisse accumsan tortor quis turpis sed',27),(30,'10/01/2022','in porttitor pede justo eu massa donec dapibus duis at',30);
/*!40000 ALTER TABLE `recap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `idStock` int(11) NOT NULL,
  `matricule` varchar(100) NOT NULL,
  `quantiteProd` int(11) DEFAULT NULL,
  PRIMARY KEY (`idStock`,`matricule`),
  KEY `matricule` (`matricule`),
  CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`matricule`) REFERENCES `produit` (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,'PR1',611),(2,'PR2',2373),(3,'PR3',776),(4,'PR4',576),(5,'PR5',2982),(6,'PR6',2657),(7,'PR7',820),(8,'PR8',1409),(9,'PR9',1980),(10,'PR10',2969),(11,'PR11',531),(12,'PR12',130),(13,'PR13',2237),(14,'PR14',360),(15,'PR15',1636),(16,'PR16',762),(17,'PR17',1619),(18,'PR18',2743),(19,'PR19',1303),(20,'PR20',2988),(21,'PR21',637),(22,'PR22',1297),(23,'PR23',1977),(24,'PR24',1515),(25,'PR25',1289),(26,'PR26',2719),(27,'PR27',2770),(28,'PR28',1125),(29,'PR29',1990),(30,'PR30',2882);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'commandelabo'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-03 14:10:12
