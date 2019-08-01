package com.example.topictobq.transform;

import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;

import com.example.topictobq.dofn.PubSubToPaisDoFn;
import com.example.topictobq.domain.Pais;


public class PubSubToPaisTransform extends PTransform<PCollection<String>, PCollection<Pais>>{

    /**
     * 
     */
    private static final long serialVersionUID = 32857647873620144L;

    @Override
    public PCollection<Pais> expand(PCollection<String> input) {
        return input.apply(ParDo.of(new PubSubToPaisDoFn()));
    }
}
