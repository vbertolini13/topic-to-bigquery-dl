package com.example.topictobq.dofn;

import org.apache.beam.sdk.transforms.DoFn;

import com.example.topictobq.domain.Pais;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PubSubToPaisDoFn extends DoFn<String, Pais> {

    private static final long serialVersionUID = 78471626844184217L;

    @ProcessElement
    public void processElement(ProcessContext c) {
        log.info(c.element());
        Pais p = new Pais();
        p.setMensaje(c.element());

    }

}
