# Setting up CI server in amazon ec2


**How to install MySQL on an Amazon EC2 Server Instance?**

Being a newbie to server administration especially with Linux, I found
myself looking all over the internet on how to install a mysql server
instance! Here is what worked for me on the Amazon EC2 instance:

**To install a MySQL Server**

1.  First step is to of course ssh into the EC2 instance

2.  Then, at a command prompt, use the following command to install
    MySQL Server:

3.  sudo yum install mysql-server

	When you are prompted, type 'y'.

**To start the installed MySQL Server**

1.  Start mysql, and configure it to start up automatically on reboot.
2.  sudo chkconfig mysqld on
3.  sudo service mysqld start

	You would see a response like the following.
	> Starting mysqld

**Configuring newly installed MySQL Server **

1.  To update the password of root user, do the following:

> mysqladmin -u root password \[your\_new\_pwd\]

1.  To create a data base, do the following:

> mysqladmin -u root -p create \[your\_new\_db\]
>
> When you are prompted for a password, type \[your\_new\_pwd\]. Well
> that's it. There rest of the MySQL functionality is as usual. For more
> details on other functionalities please use the MySQL website.

**Using MySQL Externally**

If you need to access MySQL from another server, then you need to
execute these following additional steps.

*  First off, create a MySQL user who can connect from any type of host
    using the following SQL:

*  GRANT ALL PRIVILEGES ON \*.\* TO 'theuser'@'localhost'

*  GRANT ALL PRIVILEGES ON \*.\* TO 'theuser'@'localhost'

*  CREATE USER 'theuser'@'%' IDENTIFIED BY '\[your\_pwd\]'

*  GRANT ALL PRIVILEGES ON *.* TO 'theuser'@'%' WITH GRANT OPTION

*  Next, from the AWS Management Console find the Security Group that
    you assigned to your instance during set-up and add 'MySQL' to
    the group. You can also manually add port 3306. Save and whoala
    ready to go!

- See more at [here](http://www.text-analytics101.com/2013/11/how-to-install-mysql-on-amazon-ec2.html\#sthash.G4R5uYoq.dpuf)

#### So here what you should do when you want to replace OpenJDK with Java SE JDK:
**Check the current OpenJDK version.**
I am going to retain the same version if possible:

		$ java -version
    
response:
	
     java version "1.7.0\_85"
	 OpenJDK Runtime Environment (IcedTea6 1.13.3) (rhel-5.1.13.3.el6\_5-x86\_64)
	 OpenJDK 64-Bit Server VM (build 23.25-b01, mixed mode)
  
**Check the current RPM package name:**

  	$ rpm -qa | grep openjdk
response: 

	java-1.7.0-openjdk-1.7.0.85-2.6.1.3.61.amzn1.x86\_64

**Remove the installed OpenJDK package:**

  	$ yum remove -y java-1.7.0-openjdk
  
