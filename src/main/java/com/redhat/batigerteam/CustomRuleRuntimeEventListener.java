package com.redhat.batigerteam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.kie.api.event.rule.*;

public class CustomRuleRuntimeEventListener implements RuleRuntimeEventListener {
    private static final Logger LOG = LoggerFactory.getLogger(CustomRuleRuntimeEventListener.class);
    /**
     */
    public CustomRuleRuntimeEventListener() {
        LOG.info("Registered CustomRuleRuntimeEventListener.");
    }


    /**
     * @param event
     */
    public void objectInserted(ObjectInsertedEvent event) {
        if (event.getRule() == null) {
            LOG.info("Rule is null.");
        } else if (event.getRule().getName() == null) {
            LOG.info("Rule name is null.");
        }
        if (event.getObject() == null) {
            LOG.info("Object is null.");
        }
        LOG.info(
                "Rule <<" +
                        //event.getRule().getName()+
                        ">> has caused Object (" +
                        event.getObject().toString()+
                        ") of class <<" +
                        event.getObject().getClass().getName()+
                        ">> to be inserted."
        );
    }


    /**
     * @param event
     */
    public void objectUpdated(ObjectUpdatedEvent event) {
        LOG.info(
                "Rule <<" +
                        //event.getRule().getName()+
                        ">> has caused Object (" +
                        event.getObject().toString()+
                        ") of class <<" +
                        //event.getObject().getClass().getName()+
                        ">> to be updated."
        );
    }


    /**
     * @param event
     */
    public void objectDeleted(ObjectDeletedEvent event) {
        LOG.info(
                "Rule <<" +
                        //event.getRule().getName() +
                        ">> has caused Object (" +
                        event.getOldObject().toString()+
                        ") of class <<" +
                        //event.getOldObject().getClass().getName()+
                        ">> to be deleted."
        );
    }
}
