![ecosystem](https://user-images.githubusercontent.com/22338759/58522958-83d51680-81fd-11e9-9957-4c7a7d40bd07.png)


<b>Handle large write volume: Billions write events per day.</b>
- At first, collecting big-data with a single or unit system might cause slow down.
So We need to use something helps big-data transfer based on distributed processing.

<b>Handle large read/query volume: Millions merchants want to get insight about their business. Read/Query patterns are time-series related metrics.</b>

<b>Provide metrics to customers with at most one hour delay.</b>

<b>Run with minimum downtime.</b>

<b>Have the ability to reprocess historical data in case of bugs in the processing logic.</b>
- Introduce a logger and logging api system logs, and these logs also expected has a large volume.
We need to make a storage for collect API log. 
Hadoop helps trnasfer logs fast with hour or minute partitions and using Hive makes improvement of operability (DBMS likes).
Collecting logs could be worked on batch system, digdag helps to schedule easy and improve visibility with it's GUI system.
