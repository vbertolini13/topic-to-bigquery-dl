package com.example.topictobq.transform;

import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;

import com.example.topictobq.dofn.PubSubToTableRowDoFn;
import com.google.api.services.bigquery.model.TableRow;


public class PubSubToTableRowTransform extends PTransform<PCollection<String>, PCollection<TableRow>>{

    /**
     * 
     */
    private static final long serialVersionUID = 32857647873620144L;

    @Override
    public PCollection<TableRow> expand(PCollection<String> input) {
        return input.apply(ParDo.of(new PubSubToTableRowDoFn()));
    }
}
