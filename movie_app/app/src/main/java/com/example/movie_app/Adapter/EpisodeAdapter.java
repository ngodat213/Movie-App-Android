package com.example.movie_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie_app.Model.Episode;
import com.example.movie_app.Model.Movie;
import com.example.movie_app.R;
import java.util.List;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>{
    private Context context;
    private List<Episode> episodeList;

    public EpisodeAdapter(Context context, List<Episode> episodeList) {
        this.context = context;
        this.episodeList = episodeList;
    }

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_episode,parent,false);
        return new EpisodeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {
        final Episode episode = episodeList.get(position);
        if(episode == null) return;
        Glide.with(holder.imageMovie).load(episode.getImageEpisode()).into(holder.imageMovie);
        holder.nameMovie.setText(episode.getNameMovie());
        holder.episodeName.setText(episode.getEpisodeTitle());
        if(episode.isCheck() == true){
            holder.subtitled.setText("Subscribed");
        }else{
            holder.subtitled.setText("Subscribe");
        }
    }

    @Override
    public int getItemCount() {
        return episodeList.size();
    }

    public class EpisodeViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageMovie;
        private TextView nameMovie, subtitled, episodeName;
        public EpisodeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageMovie = (ImageView) itemView.findViewById(R.id.episodeImage);
            nameMovie = (TextView) itemView.findViewById(R.id.episode_name_episode);
            episodeName = (TextView) itemView.findViewById(R.id.episode_name_episode);
            subtitled = (TextView) itemView.findViewById(R.id.is_sub);
        }
    }
}
