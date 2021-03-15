
#   Setup
    Assuming your zeekeper is all configured.
    open cmd and Run
    
`zkserver`

    Now start your kafka 
    Go to your kafka Directory open cmd here 
    and run
    
`.\bin\windows\kafka-server.bat  .\config\server.properties`

    Now you need to create a topic so that the producer can publish data into that topic
    open another cmd terminal her
    Run
`.\bin\windows kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topics users`

    You are all set up now just open the assignment on ide and run it. 
    You should see on the terminal that producer and consumer are connected
    
    Now to actually see the flow of data 
    Use postman and make some post requests on 
    localhost:8090/kafka/movie and send movie data along with it 
    and now you should on the console see the trending actor of the year.