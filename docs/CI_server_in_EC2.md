# Setting up CI server in amazon ec2

### How to install MySQL on an Amazon EC2 Server Instance? 

Being a newbie to server administration especially with Linux, I found
myself looking all over the internet on how to install a mysql server
instance! Here is what worked for me on the Amazon EC2 instance:

### To install a MySQL Server

	$ yum install mysql-server

When you are prompted, type 'y'.

**To start the installed MySQL Server**

	 $ chkconfig mysqld on
     $ service mysqld start

Response: Starting mysqld

**Configuring newly installed MySQL Server**

	 $ mysqladmin –u root password \[your\_new\_password\]
	 $ mysqladmin –u root –p create \[your\_new\_db\]

When you are prompted for a password, type \[your\_new\_pwd\]. Well
that's it. There rest of the MySQL functionality is as usual. For more
details on other functionalities please use the MySQL website.

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

### Replacing OpenJDK with Oracle JDK 


EC2 instance is a RedHat distribution, that uses OpenJDK by default. To
the cloud integration on TeamCity to work properly we need to replace
OpenJDK with Oracle JDK. - See more at
[here](http://pedroreys.com/2011/05/23/running-teamcity-on-ec2/)

**Check the current OpenJDK:**

	$ java -version
response:

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
