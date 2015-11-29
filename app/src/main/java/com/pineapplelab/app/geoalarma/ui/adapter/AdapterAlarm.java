package com.pineapplelab.app.geoalarma.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pineapplelab.app.geoalarma.R;
import com.pineapplelab.app.geoalarma.ui.viewholder.ViewHolderAlarm;
import com.pineapplelab.app.geoalarma.ui.viewmodel.ViewModelAlarm;

import java.util.List;

/**
 * Created by Javier Solis @JavierTwiteando  @PineappleTic on 29/11/15.
 */
public class AdapterAlarm extends RecyclerView.Adapter<ViewHolderAlarm>
{
    private List<ViewModelAlarm> listViewModels;
    private Context context;

    public AdapterAlarm(Context context,List<ViewModelAlarm> listViewModels)
    {
        this.context=context;
        this.listViewModels=listViewModels;
    }

    @Override
    public ViewHolderAlarm onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alarm, parent, false);

        //itemView.setOnClickListener(this);

        ViewHolderAlarm viewHolderAlarm = new ViewHolderAlarm(this.context,itemView);
        return viewHolderAlarm;
    }

    @Override
    public void onBindViewHolder(ViewHolderAlarm holder, int position) {
        ViewModelAlarm viewModel = this.listViewModels.get(position);
        holder.bind(viewModel);
    }

    @Override
    public int getItemCount() {
        return this.listViewModels.size();
    }
}
