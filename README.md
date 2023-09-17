## Starwars API challenge
This idea was provided by @AmeDigital backend challenge.

This rest api works with starwars planets that contains the following fields:
- Name
- Climate
- Terrain

Also, the challenge demands that the programmer must relate each planet with its movies appearances quantity. To do that, we must use this external [api](https://swapi.co/) to gather this information.

It is important to notice that, although it wasn't needed, I populated the database with requests to the same api, that said, there are two profiles for use:

    1. dev -> uses postgres as database
    2. test -> just the usual h2 in memory database

So everytime you run the application, either on dev or test profile, 6 requests will be made to the external api to populate the database. 

This was not part of the challenge but I really thought that would be a good exercise to overcome as I was obligated to read about json trees and stuff like that.

## References
https://github.com/AmeDigital/challenge-back-end-hit

https://github.com/google/gson

https://github.com/CollabCodeTech/backend-challenges