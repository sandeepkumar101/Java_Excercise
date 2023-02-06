
Meter Data :
5 sec ferequency
Daily = 24*60*60/5 = 17,280
500 Meter = 500*17280 = 8,640,000
Space : 50 Bytes * 8640000 = 432,000,000 = ~400 MB Daily
Monthly = 30 * 400MB = 12,000 MB = ~12 GB
Yearly = 365 * 12GB = 4,380GB = ~4 TB


Meter Data :
5 sec ferequency
Daily = 24*60*60/5 = 17,280
500 Meter = 500*17280 = 8,640,000
Space : 50 Bytes * 8640000 = 432,000,000 = ~400 MB Daily
Monthly = 30 * 400MB = 12,000 MB = ~12 GB
Yearly = 365 * 12GB = 4,380GB = ~4 TB


Kafka
~ 5 Million message
3 Brockers
    Kubernetes Resource - 4 vCPU, 12 GB, 3 ReplicaCount, 2 ReplicatFactor, 10 Partitions (Consumer microservices application set to Max 10 Repilica)
we switched our consumers to asynchronous commits to achive higher throughput

We also utilize both the retention.bytes and retention.ms settings to remove already-processed data from the brokers. Setting these values low reduces the required storage significantly.
