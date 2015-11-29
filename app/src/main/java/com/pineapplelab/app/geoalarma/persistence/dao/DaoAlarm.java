package com.pineapplelab.app.geoalarma.persistence.dao;

import com.pineapplelab.app.geoalarma.persistence.entity.EntityAlarm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Javier Solis @JavierTwiteando  @PineappleTic on 29/11/15.
 */
public class DaoAlarm {
    public List<EntityAlarm> getAllAlarms()
    {
        List<EntityAlarm> list = new ArrayList<EntityAlarm>();

        for(int i=0;i<20;i++)
        {
            EntityAlarm entityAlarm= new EntityAlarm();
            entityAlarm.id=i;
            entityAlarm.name="Putin";
            entityAlarm.namePlace="Punto G";

            list.add(entityAlarm);
        }
        return list;
    }
}
