Tech Stack :

        H2 Embed DB          
        Spring Boot           (localhost:9025)
        SpringFox - Swagger   (http://localhost:9025/swagger-ui.html#/)
        Lombok
        Junit

General Information :

        -Project have 2 controller.Player/Search (At first I did in single controller but later ı thought ı should separated)
        -As a start, I thought it appropriate to create 3 tables.These are GAME,REGION,PLAYER.Also try to create relation between them.
        -I created unique indexes on some of these tables, so I wanted to avoid false records.
        -Created uUnique exception codes for each Exception Types.
        -End Points are designed to be suitable for Rest and Http.
        -I added as much control as ı can on Request Models. I used validator(anotations) where I took Enums as parameter.

How To Run :

        -Inside the 'com.bestseller.gaming' folder. You will see 'GamingServiceApplication.class' you should run this class.
        -Inside the 'resources' folder.You will see 'application.yml' you can edit your port or db configs.
        -Also there is 'data-h2'.sql scripts for creating initial datas for DB.You can add or delete Scripts.
        
        ** NOTE:Please note that,when you try to add new INSERT here you might face INDEX exception.
            To prevent this please look up on entities and try to 'uniqueConstraints' logic. **

Unit Tests :

        - Basiclly I try to cover all Bussiness Logic on my Services. :) (With exception and without exception)

General Thoughts and Decisions :

           -At first I went with a simpler and more precise approach rather than a complex approach.
            The data types that caught my attention here were Game and Region, and when defining them, 
            I followed certain rules by understanding that I had to connect them to the Player Table.
            At the beginning of these rules, I considered the uniqueness of some of the fields to be inserted and the connections between the Tables.
            Then I added control for some 'must' cases while coding my business logic. 
            I also set up a simple ErrorHandling mechanism to get a meaningful message and redirect the user.
            Ultimately, I aimed to establish a structure that could be developed and easily changed as relational and management for the future.

