# Tweetcool

The message wall application for Codecoolers

## Server
You have to create a server. You can send tweets to the server via a website.
It's purpose is to store the given tweets and send them back when requested.

### Available requests
#### / GET
testing address: `/` (method: GET)
It returns the `It works!` string.

#### /tweet GET
getting tweets: `/tweet` (method: GET)
optional parameters:

| Parameters | details                                                              | default value |
|------------|----------------------------------------------------------------------|---------------|
| limit      | Number of results to return.                                         | 10            |
| offset     | Results to skip. (2 means we start the response with the 3rd result) | 0             |
| poster     | Filter to show only one user's tweets.                               | -             |
| from       | Results posted after the given UNIX Timestamp.                       | -             |

Returns with the requested messages.


#### /tweet POST
posting tweets: `/tweet` (method: POST)
expected request:

| Parameters | details                                                              | default value |
|------------|----------------------------------------------------------------------|---------------|
| content    | The tweet message                                                    | -             |
| poster     | Who send the message                                                 | -             |

After somebody post a tweet, you need to make a Tweet object from the given data. Store the Tweet object in a list.
A Tweet object contains the poster, content(tweet message), timestamp, id. 
If the poster or tweet is empty or missing, return with an error page.

Example:
```
    "content": "Do. Or do not. There is no try.",
    "poster": "Yoda"
```

The id and timestamp is managed by the server method.
After sending a tweet redirect to /tweet to list all available tweets.


### Expected behavior

It should run on a tomcat server:

1. Query tweets from the server
1. Format and print the previous tweets. Example: `Chewbacca <1977-05-25 20:16:10>: Uuuuuuurr Ahhhhrrr Uhrrr`
1. Ask the user for message input.

Also handle all possible exceptions.

### Extra

If you managed to finish with the application to **match the excepted behaviour**, you can extend it with a javascript code to refresh
the message wall continously. And store tweets on a csv file. If the server restarts, read the tweets from the file.
Store "poster" in Cookie, and load the poster name automatically.

If you try to create this extra version, please still keep the "basic" terminal based one you created first!
