package com.example.topictobq.option;

import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

public interface TopicToBigQueryOptions extends PipelineOptions {
    
    @Description("Input subscriptions topic")
    @Default.String("projects/civil-medley-236513/subscriptions/sub-one")
    String getInputSubscription();
    void setInputSubscription(String value);

    @Description("Name dataset of bigquery.")
    @Default.String("poc_dataset")
    String getDataset();
    void setDataset(String value);
    
    @Description("Name table of bigquery.")
    @Default.String("subscription")
    String getTable();
    void setTable(String value);
    
    @Description("Id project.")
    @Default.String("civil-medley-236513")
    String getProjectId();
    void setProjectId(String value);

}
