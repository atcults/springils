--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `client_id` varchar(100) NOT NULL,
  `userid` varchar(20) DEFAULT NULL,
  `access_token` varchar(200) NOT NULL,
  `refresh_token` varchar(200) DEFAULT NULL,
  `token_type` varchar(30) DEFAULT NULL,
  `scope` varchar(100) DEFAULT NULL,
  `auth_code` varchar(200) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `client_type` varchar(20) DEFAULT NULL,
  `at_created` datetime DEFAULT NULL,
  `rt_created` datetime DEFAULT NULL,
  `at_expires_in` datetime DEFAULT NULL,
  `rt_expires_in` datetime DEFAULT NULL,
  `request_source` varchar(20) DEFAULT NULL,
  `request_detail` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`access_token`),
  UNIQUE KEY `refresh_token` (`refresh_token`),
  KEY `IX_user_id` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `client_id` varchar(100) NOT NULL,
  `client_secret` varchar(100) NOT NULL,
  `client_name` varchar(300) NOT NULL,
  `description` varchar(400) NOT NULL,
  `client_url` varchar(300) NOT NULL,
  `client_type` varchar(20) NOT NULL,
  `scope` varchar(300) DEFAULT NULL,
  `redirect_uri` varchar(400) NOT NULL,
  `regdate` date DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `token_log`
--

DROP TABLE IF EXISTS `token_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token_log` (
  `client_id` varchar(100) NOT NULL,
  `userid` varchar(20) DEFAULT NULL,
  `access_token` varchar(200) NOT NULL,
  `refresh_token` varchar(200) DEFAULT NULL,
  `token_type` varchar(30) DEFAULT NULL,
  `scope` varchar(100) DEFAULT NULL,
  `auth_code` varchar(200) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `client_type` varchar(20) DEFAULT NULL,
  `at_created` datetime DEFAULT NULL,
  `rt_created` datetime DEFAULT NULL,
  `at_expires_in` datetime DEFAULT NULL,
  `rt_expires_in` datetime DEFAULT NULL,
  `request_source` varchar(20) DEFAULT NULL,
  `request_detail` varchar(100) DEFAULT NULL,
  `token_action` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`access_token`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userid` varchar(20) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;