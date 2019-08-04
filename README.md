# Update Streaming Dataflow

## Run
java -jar topic-to-bigquery-dl.jar --project=[id de proyecto] --zone=us-central1-a --streaming=true --runner=DataflowRunner --numWorkers=1 --workerMachineType=n1-standard-1

## Update
java -jar topic-to-bigquery-dl.jar --project=[id de proyecto] --zone=us-central1-a --streaming=true --runner=DataflowRunner --numWorkers=1 --workerMachineType=n1-standard-1 --jobName=[nombre de la ejecucion anterior] --update
