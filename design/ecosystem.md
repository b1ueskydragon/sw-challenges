![ecosystem](https://user-images.githubusercontent.com/22338759/58522958-83d51680-81fd-11e9-9957-4c7a7d40bd07.png)


<b>Handle large write volume: Billions write events per day.</b><br>
- At first, collecting big-data with a single or unit system might cause slow down.
So We need to use something helps big-data transfer based on distributed processing.

<b>Handle large read/query volume: Millions merchants want to get insight about their business.</b><br>
<b>Provide metrics to customers with at most one hour delay.</b><br>
<b>Run with minimum downtime.</b><br>

Using Kafka
- Kafka supports stream processing and large volumn of activity data aggregated into Kafka
- If there was system failure or change implementation on data receiver (Storage) It is not matter for data sender (API), since Kafka supports messege queue, it helps seperate to API side and log-collection side. 

Background of Using Stream processing
- We need to transfer realtime as much as possible, cause there are huge volume of datum and prevent process delay.
-  Batch saves lot of datum at once and work when scheduled time comes, so it might induce dealy or stop if there are some error or capacity exceed. Instead, Stream is dynamic, flexible since it's a data flow. If there are something wrong while transfer, stream processing could notice and take some action.

<b>Have the ability to reprocess historical data in case of bugs in the processing logic.</b><br>
- We need to make a storage for collect API log like server access, tracking information, error or warn logs. 
- Introduce a logger and logging api system logs, and we can expect outputs have more than large volume than activity data.
- Collecting historic log with specific partition is required than realtime transfer.

Hadoop with Hive
- Hadoop is based by MapReduce process, it helps trnasfer huge data fast with hour or minute partitions
- Using Hive makes improvement of operability (DBMS likes).
- Logs could be convert to the other format if needed (e.g. compression) with Hive queries.

Using digdag
- Collecting logs could be worked on batch system, digdag helps to schedule easy and improve visibility with it's GUI system.
- Retry process is simple when transfer was failed

<b>Read/Query patterns are time-series related metrics.</b><br>
- It is hard to transfer with ordering since stream is an asynchronous event from servers.
- Each part of stream should be sorted by time ordered manually while streaming

Or
- Sort after transfer to Elasticsearch. Elasticsearch supports search queries and Time series use cases.

Improves get insight with visualization
- Kibana helps make a graph based on data from elasticsearch.

<b>Notes</b><br>
- Stream processing works constantly, it requires adjust flexibly if there needs to expand transfer flow
- Batch system should be estimated as accurate as possible since we could notice something wrong only after batch failed (not real time)
