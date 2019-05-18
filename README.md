# MyRetail-Product-Management

## For Developers

Please refer to the README.md in each subsequent folder for development instructions

## Running the entire application on local machine

### Prerequisites

- Git ([OSX](https://git-scm.com/download/mac)) ([Windows](https://git-scm.com/download/win))
  ([Linux](https://git-scm.com/download/linux))
- Docker installed and running ([OSX](https://www.docker.com/products/docker#/mac))
  ([Windows](https://www.docker.com/products/docker#/windows))
  ([Linux](https://www.docker.com/products/docker#/linux))
- Java 8 installed (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
    - If you have previously had Java 9 installed, change the JAVA_HOME path to where Java 1.8 is
        - e.g. for a Mac, you can run the following after install
        ```
            $ export JAVA_HOME=`/usr/libexec/java_home -v 1.8`
        ```
- Maven 3.3.9+ installed (https://maven.apache.org/install.html)

### Clone the repository

```
    $ git clone https://github.com/mahar89/MyRetail-Product-Management.git
```

### Build the application
1.Build MyRetail-Product-Management

```
    $ cd /path/to/MyRetail-Product-Management
    $ mvn clean install
```
