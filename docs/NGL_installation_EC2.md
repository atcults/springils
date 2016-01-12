# How To Install and Use PostgreSQL on CentOS 7

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
install them without a hassle using the yum package system.

Install the postgresql-server package and the "contrib" package, that
adds some additional utilities and functionality:

**Give default priviledge**

	$ sudo su

**To install a MySQL Server**

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

	host	 all 	all		127.0.0.1/32	 md5
	host	 all	all		::1/128			 md5

Save and exit. PostgreSQL is now configured to allow password
authentication.

**Start and check postgresql service status**

	$ service postgresql start
	$ service –-status-all | grep postgres*

**Download latest version from source forge**

$ wget
http://nchc.dl.sourceforge.net/project/newgenlib/NewGenLib/version3.1.2/InstallNGL3.1.zip
