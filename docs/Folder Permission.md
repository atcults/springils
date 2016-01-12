# Folder permission


In order to set permissions on the folder and all sub folders/files you
need to use the recursive option in your command:

	chmod 777 -R /path/to/directory

Your permissions are set using three numbers.

the 100's are for the owner of the file

    400 read
    200 write
    100 execute

10's are for the group of the file

	40 read
    20 write
    10 execute

1's are for everyone else

    4 read
    2 write
    1 execute
