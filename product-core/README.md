# product-core

## Prerequisites

- Git ([OSX](https://git-scm.com/download/mac)) ([Windows](https://git-scm.com/download/win))
  ([Linux](https://git-scm.com/download/linux))
- Docker ([OSX](https://www.docker.com/products/docker#/mac))
  ([Windows](https://www.docker.com/products/docker#/windows))
  ([Linux](https://www.docker.com/products/docker#/linux))

## Install, build and run as follows:

1. Clone the repo

    ```
    $ git clone https://github.com/mahar89/MyRetail-Product-Management.git
    ```

2. Build the project:

    ```
    $ cd /path/to/MyRetail-Product_Management
    $ mvn clean install
    ```

3. Run the app:

    #### Through Docker

    ```
    $ cd /path/to/MyRetail-Product_Management/product-core
    $ docker-compose up
    ```

    #### Through IntelliJ / Eclipse

    i. Ensure that Mongo DB user `product-management` exists. If not run following:

     ```
     $ mongo admin --eval "db.getSiblingDB('product-management').createUser({user:'product-management',pwd:'product-management',roles:[{role:'readWrite', db:'product-management'}]});"
     ```

     ii. You can open up the project in IntelliJ / eclipse, and run the application with the
     following parameters:

    Main class: `ProductManagementApp`