package com.dannextech.apps.kuzatalent;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class UploadVideoAdapter extends RecyclerView.Adapter<UploadVideoAdapter.ViewHolder> {
    Context context;
    List<UploadVideoModel> videos;
    public UploadVideoAdapter(Context context, List<UploadVideoModel> list) {
        this.context = context;
        this.videos = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_sub_details, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final UploadVideoModel uploadVideoModel = videos.get(position);

        holder.tvTitle.setText(uploadVideoModel.getTitle());
        holder.tvTalent.setText(uploadVideoModel.getTalent());
        holder.cvVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
                SharedPreferences.Editor editor= preferences.edit();

                editor.putString("vid_ref",uploadVideoModel.getUrl());

                editor.apply();

                Fragment fragment = new ViewSpecificVideoFragment();
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.flOrganizationFragment,fragment);
                fragmentTransaction.commitAllowingStateLoss();
            }
        });
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cvVideos;
        TextView tvTalent,tvTitle;
        public ViewHolder(View itemView) {
            super(itemView);

            cvVideos = (CardView) itemView.findViewById(R.id.cvVideos);
            tvTalent = (TextView) itemView.findViewById(R.id.tvVideoTalent);
            tvTitle = (TextView) itemView.findViewById(R.id.tvVideoTitle);
        }
    }
}
