# Depth_Chart API

To run the depth_carth API in your local machine the following pre-requests needs to be installed

- Java 8
- Eclipse / Spring STS IDE
- Maven
- postman

Steps to Run/Execute the project in local
Step 1: Import the maven project in the eclipse IDE and wait for the dependencies to download locally.
Step 2: If the dependencies are not downloaded from the pom.xml file, right-click the project -> maven -> download sources 
Step 3: Right-click on the project -> Run as -> Maven Build
Step 4: A new dialog box will open, In goals mention clean install and check the Skip Test option and click on the Run button.
Step 5: Once the build is successful, right-click on the SportsbetprojectApplication.java file -> Run as -> Java Application.

In Depth_Chart API there are 4 endpoints to create, remove, and list the player details with position and position depth

1. POST -> /addPlayerToDepthChart
Firstly, in order to add the players to the depth chart, we need to store the player details objects in H2 DB. The below is the request body used to store the player information.
URL: http://localhost:8080/addPlayerToDepthChart
{
"playerId":1,
"playerName": "Bob",
"position": "WR",
"positionDepth":"0"
}

2. GET -> /player-list
URL: http://localhost:8080/player-list
To get all player details present in the DB, the 
sample response:
{
    "KR": [
        {
            "playerId": 3,
            "playerName": "alice",
            "position": "KR",
            "positionDepth": "0"
        }
    ],
    "WR": [
        {
            "playerId": 2,
            "playerName": "charlie",
            "position": "WR",
            "positionDepth": "0"
        },
        {
            "playerId": 1,
            "playerName": "bob",
            "position": "WR",
            "positionDepth": "0"
        }
    ]
}

3. GET -> /PlayerInDepthChart
URL:http://localhost:8080/PlayerInDepthChart?playerId=2&playerPosition=WR
To get the particular player and position depth details, the user need to pass the playerId and playerPosition to requestURL

Sample response: 
[
    {
        "playerId": 1,
        "playerName": "bob",
        "position": "WR",
        "positionDepth": "0"
    }
]

4. PUT -> /removePlayerFromDepthChart/{playername}/{position}
To delete the existing player from the DB, the user needs to pass the palnerName and his/her position to delete the player from the depth chart
URL: http://localhost:8080/removePlayerFromDepthChart/bob/WR
