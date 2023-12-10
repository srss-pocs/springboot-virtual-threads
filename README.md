# springboot-virtual-threads
Spring Boot 3.2.0





Start Both Server and run client api

![image](https://github.com/srss-pocs/springboot-virtual-threads/assets/145287517/6feb956e-27ed-4797-b892-d4e0004836de)



Download Apache Benchmark https://www.apachelounge.com/download/  (Apache 2.4.58 Win64)

UnZip and Set the Path

Open Command Prompt

Run Cleint API as shown below

ab -n 2 -c 1 http://localhost:8080/api/block/2

![image](https://github.com/srss-pocs/springboot-virtual-threads/assets/145287517/4627038f-4098-4e64-8227-21ec7e4c9c2d)

 
For Reference POST API
ab -p content.json -T application/json -H 'Authorization: Bearer xxxx' -c 10 -n 2000 -l http://myserver/myapi



# content.json contains the json you want to post
# -p means to POST it
# -H adds an Auth header (could be Basic or Token)
# -T sets the Content-Type
# -c is concurrent clients
# -n is the number of requests to run in the test
# -l Accept variable document length (use this for dynamic pages)

