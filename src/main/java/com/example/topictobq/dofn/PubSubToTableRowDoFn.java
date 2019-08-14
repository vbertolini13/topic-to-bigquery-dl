package com.example.topictobq.dofn;

import java.io.IOException;

import org.apache.beam.sdk.transforms.DoFn;

import com.example.topictobq.persistence.ChampBanSchema;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.bigquery.model.TableRow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PubSubToTableRowDoFn extends DoFn<String, TableRow> {

    private static final long serialVersionUID = 78471626844184217L;

    @ProcessElement
    public void processElement(ProcessContext c) throws IOException {
        if(c.element() != null) {
            log.info("**************************element =>"+c.element());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(c.element());
            
        	TableRow row = new TableRow();
            row.set(ChampBanSchema.getTableSchema().getFields().get(0).getName(), node.get("attribute").get("id_champion").asText());
            row.set(ChampBanSchema.getTableSchema().getFields().get(1).getName(), node.get("attribute").get("champion").asText());
            row.set(ChampBanSchema.getTableSchema().getFields().get(2).getName(), node.get("attribute").get("turn").asText());
            row.set(ChampBanSchema.getTableSchema().getFields().get(3).getName(), node.get("attribute").get("id_match").asText());

    		log.info("**************************row =>"+row.toString());
            c.output(row);
        }

    }

}
