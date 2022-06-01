1- Time Management -> 35
2- Contents coverage in order
3- Questions coverage -> specially to scope down not up
4- For seniors and above: "Why" and pushing back is very critical
5- Final design -> Needs to happen level by level



Tactical group. Answers the “why” question.
Why this is being done? History behind this. How did it happen. Etc.

Strategic group (on project level), answers “what” questions like: should I build mvp? Should I target extendability? Etc
*Business requirements: business goals.
*Logistical requirements: team size, timing, etc.

Operational group: answers “how” questions like scaling, data center locations, etc
*Product requirements: features?
*Technical Requirements: infrastructure?


Questions (Requirements/Scale) -> 5m
Personas -> 2m
UX Experience flow -> 3m
Functional requirements -> 2m
Non-functional requirements -> 2m
Problem Specific Challenges/Core Problem -> 3m
Entities -> 1m
  APIs -> 2m
  Data Models -> 3m
Trade-offs -> 2m
Low Level Calculations/Requirements/Estimates -> 2m
System Flow -> 3m
System Diagram -> 5m


Non-functional
1) High availability
2) Persistency - only leaderboard
3) Consistency - eventual consistency
4) Latency - as low as possible


1. Several Logging Sources
    - Application Logs
    - System Log (Linux VM) logs
    - VPC/Networks logs
    - Kubernetes pod logs
    - Cloud Watch - Default AWS logs
    - Cloud Trail - Default AWS Service (Access and Changes)
    - No custom logs in AWS services

2. Log are unstructured
    -



Task : Create a centralized logging Platform

Common Requirments:
1. Audit Trail - Access log  
    - Easy Access
    - TTL (Accessible for 3-6 Months) 
    - Director of Information Security
    - Store
2. Access all log one place
    - Store in one place
    - Have visualization ability (Metrics, Application log, Audit Logs, Tracing, Network etc)
    - Searh by any tag (Application name, Server Name, Time Range, Message)
    - Find by Application
    - Find by Error
    - Find by 
3. Kubernetes Log 
    - 

4. Account change log
    - What type of changes?
    - DB or Tenet 

Relevant Data:
# of Logs:
Logs per application/service: 1
Webserver logs: 2
Mail server logs: 1
Suggested relevant system logs: 3 (syslog, auth.log)
# of Hosts:
Approximate number of webservers: 60
Approximate number of hosts running the main application: 800 Services in Kubernetes: 3
Approximate pods per Kubernetes service: 10
Additional Data:
Approximate number of emails sent by the application per day: 60 million Approximate number of requests per second to all webservers: 8000

Data ingress -> 
    1. Log Fan out service
        - Log emittion 
        - Register with the Config Service
        - Push/Pull
        - Push
        - get Kafka Config

    2.  Message Brocker
        - Topic (Application log)
        - Topic Metics
            - Push to DB
            - Aggregation - Event process service - 

1. How we know if something fail
    Sidecar can fail
    Network 

2. How we address failure
3. 
    
Data Store:
    Time Serise data
    1. Application log
    2. Access log
    3. Metric 
    4. ets
Data Base
    1. Hot
        1. AWS Cassandra
    2. Cold
        2. S3









1. Realtime notification 
    - Sliding window 


Pre aggregates - Average of CPU or Disk usage

Create the Monitor on the Pre Aggregates

Top Frequency

System Metric ( )
Application Metrics (SLA ets)

Ingession system


 -> Queue -> Fanout 
 Capacitors - Realtime /Batch Process
 Push the data to the Capacitors 

Fan out 

Time serices data
    - Storage

Keep log in file system
Log aggregator
    Log appender



DB Sharding/ Partitioning


LSM Tree
In memory --> Tree in Flush --> Young File --> Old Data -- > Consolidated File


SSTable - Sort String Table

