/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.topictobq;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.gcp.pubsub.PubsubIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;

import com.example.topictobq.option.TopicToBigQueryOptions;
import com.example.topictobq.transform.PubSubToPaisTransform;
import com.example.topictobq.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StarterPipeline {

    public static void main(String[] args) {
        log.info(Constants.START_PROCESS);


        TopicToBigQueryOptions topicToBigquery = PipelineOptionsFactory.fromArgs(args).withValidation().as(TopicToBigQueryOptions.class);
        Pipeline p = Pipeline.create(topicToBigquery);

        p.apply(Constants.READ_PUBSUB, PubsubIO.readStrings().fromSubscription(topicToBigquery.getInputSubscription()))
         .apply(Constants.STRING_TO_PAIS, new PubSubToPaisTransform());

        p.run();

        log.info(Constants.FINISHED_PROCESS);
    }
}
