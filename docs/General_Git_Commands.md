# General Commands for Git

***Clone Repository:***

-   git clone https://github.com/nbparmar/ForTestingRepository.git

***Configure User Name & Password:***

-   **git config user.name**: Display current user name

-   **git config user.password**: Display current password

-   **git config user.name "username"**: Store "username" as current
    user

-   **git config user.password "password"**: Store "password" for
    current user

***Make New Branch:***

-   **git branch &lt;branchName&gt;**

***Checkout branch:***

-   **git branch**: Display all branch with current branch as
    highlighted

-   **git checkout &lt;branchName&gt;**

***Pull Changes:***

-   **git pull**

-   *(Always ensure branch before pull)*

***Push Changes:***

-   **git push**: Push changes to the Local Server

-   **git push origin &lt;branchName&gt;:** Push change to the Remote
    Server

-   *(Always ensure branch before push)*

***Delete Branch:***

-   **git branch -D &lt;branchName&gt;:** Delete branch from the Local
    Server

-   **git push origin --delete &lt;branchName&gt;**: Delete branch from
    the Remote Server\\

***Merge Branch:***

-   **git merge master**: Merge current branch into master

***Housekeeping:***

-   **git remote update origin --prune**: Update remote branches

-   **git gc --prune**: Clear local
