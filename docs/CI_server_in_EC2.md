# Setting up CI server in amazon ec2

# To extend storage size you need to follow below link

Follow this [link](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-using-volumes.html).

### How to install MySQL on an Amazon EC2 Server Instance? 

Being a newbie to server administration especially with Linux, I found
myself looking all over the internet on how to install a mysql server
instance! Here is what worked for me on the Amazon EC2 instance:

### To install a MySQL Server

	$ sudo yum install mysql-server

When you are prompted, type 'y'.

**To start the installed MySQL Server**

	 $ sudo chkconfig mysqld on
     $ sudo service mysqld start

Response: Starting mysqld

**Configuring newly installed MySQL Server**

	 $ mysqladmin –u root password \[your\_new\_password\]
	 $ mysqladmin –u root –p create \[your\_new\_db\]

When you are prompted for a password, type \[your\_new\_pwd\]. You can set password blank by not providing any password.

**Using MySQL Externally**

If you need to access MySQL from another server, then you need to
execute these following additional steps.

	$ mysql –u root -p
	Mysq>GRANT ALL PRIVILEGES ON *.* TO USER@IP IDENTIFIED BY PASSWORD WITH GRANT OPTION;

Or you can replace IP with ‘%’ to allow from any remote source. Next,
from the AWS Management Console find the Security Group that you
assigned to your instance during set-up and add 'MySQL' to the group.
You can also manually add port 3306. Save and whoala ready to go! - See
more at
[here](http://www.text-analytics101.com/2013/11/how-to-install-mysql-on-amazon-ec2.html#sthash.G4R5uYoq.dpuf)

# Install and Use PostgreSQL

Introduction
------------

Relational database management systems are a key component of many web
sites and applications. They provide a structured way to store,
organize, and access information.

**PostgreSQL**, or Postgres, is a relational database management system
that provides an implementation of the SQL querying language. It is a
popular choice for many small and large projects and has the advantage
of being standards-compliant and having many advanced features like
reliable transactions and concurrency without read locks.

In this guide, we will demonstrate how to install Postgres on CentOS 7
and go over some basic ways to use it.

Installation
------------

CentOS's default repositories contain Postgres packages, so we can
install them without a hassle using the yum package system.

Install the postgresql-server package and the "contrib" package, that
adds some additional utilities and functionality:

**Give default priviledge**

	$ sudo su

**To install a Postgresql Server**

	$ yum install postgresql-server postgresql-contrib

When you are prompted, type 'y'.

**Post-installation**

Due to policies for Red Hat family distributions, the PostgreSQL
installation will not be enabled for automatic start or have the
database initialized automatically. To make your database installation
complete, you need to perform these two steps:

	$ service postgresql initdb
	$ chkconfig postgresql on

By default, PostgreSQL does not allow password authentication. We will
change that by editing its host-based authentication (HBA)
configuration.

**Open the HBA configuration**

	$ vi /var/lib/pgsql9/data/pg\_hba.conf

pg\_hba.conf excerpt (updated)

    host    all     all                     trust
	host	all     all     127.0.0.1/32	trust
	host	all	    all		::1/128			trust
	host    all     all     0.0.0.0/0       trust

Save and exit. PostgreSQL is now configured to allow connection without password.

    $ vi /var/lib/pgsql/data/postgresql.conf 
    
Set listen_address = '*' and and port = 5432

Save and exit. PostgreSQL is not listen all incoming connection at 5432 port.

**Start and check postgresql service status**

	$ service postgresql start
	$ service –-status-all | grep postgres*


### Replacing OpenJDK with Oracle JDK 

EC2 instance is a RedHat distribution, that uses OpenJDK by default. To
the cloud integration on TeamCity to work properly we need to replace
OpenJDK with Oracle JDK. - See more at
[here](http://pedroreys.com/2011/05/23/running-teamcity-on-ec2/)

**Check the current OpenJDK:**

	$ java -version

    java version "1.7.0\_85"'
    OpenJDK Runtime Environment (IcedTea6 1.13.3) 	(rhel-5.1.13.3.el6\_5-x86\_64)
	OpenJDK 64-Bit Server VM (build 23.25-b01, mixed mode)

**Check the current RPM package name:**

	$ rpm -qa | grep openjdk

response:

	java-1.7.0-openjdk-1.7.0.85-2.6.1.3.61.amzn1.x86\_64

**Remove the installed OpenJDK package:**

	$ yum remove -y java-1.7.0-openjdk

**Check your version**

	$ uname –a

**Copy rpm Package to home directory via ftp and run package**

	$ rpm -ivh jdk-8u25-linux-x64.rpm
	$ java –version

**Setup Global Environment Variables**

	$ export JAVA\_HOME=/usr/java/jdk1.8.0\_66/
	$ eport PATH=\$PATH:\$JAVA\_HOME
	$ echo \$JAVA\_HOME
	$ echo \$PATH

Setup PATH permanent: create a file called java.sh under /etc/profile.d/
directory.

	$ vi /etc/profile.d/java.sh

Add the following lines:

	#!/bin/bash
	JAVA\_HOME=/usr/java/jdk1.8.0\_25/
	export PATH=\$JAVA\_HOME/bin:\$PATH
	export CLASSPATH=.

Then save and close file. Make it executable and run it.

	$ chmod +x /etc/profile.d/java.sh
	$ source /etc/profile.d/java.sh


**TODO
Update document for setting up java (Multiple version)
Install GIT
Install Gradle
Install Maven
Install nodejs
Install bower (General default package manager - Required)



**Some useful commands**

    uptime: Uptime of server
	w: User list
	top: Process explorer

# Download and run TeamCity embedded 

**Downloading TeamCity and extract**

	$ wget team-city-url
	$ gtar xfz team-city-tar-file

**Changing Server Port:**

To change the server's port, in the &lt;[TeamCity
Home](https://confluence.jetbrains.com/display/TCD6/TeamCity+Specific+Directories#TeamCitySpecificDirectories-tcHomeDir)&gt;/conf/server.xml
file, change the port number in the HTTP/1.1 connector (here the port
number is 8111):
```
  <Connector port="8111" protocol="HTTP/1.1"
  connectionTimeout="20000"
  redirectPort="8443"
  enableLookup="false"
  useBodyEncodingForURI="true"
  />
  ```

It is recommended to use mysql user other than root but in my case I
have used root user.
