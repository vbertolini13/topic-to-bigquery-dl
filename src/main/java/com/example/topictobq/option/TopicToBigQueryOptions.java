package com.example.topictobq.option;

import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

public interface TopicToBigQueryOptions extends PipelineOptions {
    
    @Description("Input subscriptions topic")
    @Default.String("projects/civil-medley-236513/subscriptions/prueba")
    String getInputSubscription();
    void setInputSubscription(String value);

    @Description("Output bq in gcp dataset.table")
    @Default.String("leagueoflegends.champion_bans")
    String getTableStagingFileLines();
    void setTableStagingFileLines(String value);
    
    @Description("Id project.")
    @Default.String("civil-medley-236513")
    String getProjectId();
    void setProjectId(String value);

}
