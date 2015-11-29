package com.pineapplelab.app.geoalarma.mapper;

import com.pineapplelab.app.geoalarma.persistence.entity.EntityAlarm;
import com.pineapplelab.app.geoalarma.ui.viewmodel.ViewModelAlarm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Javier Solis @JavierTwiteando  @PineappleTic on 29/11/15.
 */
public class MapperViewModel {
    public static class  Alarm
    {
        public static List<ViewModelAlarm> map(List<EntityAlarm> listEntity)
        {
            List<ViewModelAlarm> listViewModel = new ArrayList<ViewModelAlarm>();
            for (EntityAlarm item:listEntity) {
                ViewModelAlarm viewModel = map(item);
                listViewModel.add(viewModel);
            }

            return listViewModel;
        }

        public static ViewModelAlarm map(EntityAlarm entity)
        {
            ViewModelAlarm viewModel = new ViewModelAlarm();
            viewModel.namePlace=entity.namePlace;
            viewModel.title=entity.name;
            return viewModel;
        }
    }
}
