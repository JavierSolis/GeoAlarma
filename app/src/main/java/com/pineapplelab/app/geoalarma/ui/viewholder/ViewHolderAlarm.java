package com.pineapplelab.app.geoalarma.ui.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.pineapplelab.app.geoalarma.R;
import com.pineapplelab.app.geoalarma.ui.viewmodel.ViewModelAlarm;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Javier Solis @JavierTwiteando  @PineappleTic on 29/11/15.
 */
public class ViewHolderAlarm extends RecyclerView.ViewHolder
{
    @Bind(R.id.title)
    public TextView title;
    @Bind(R.id.name_place)
    public TextView namePlace;


    public ViewHolderAlarm(Context context,View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }

    public void bind(ViewModelAlarm viewModel) {
        title.setText(viewModel.title);
        namePlace.setText(viewModel.namePlace);
    }
}
