package com.dt.anh.vtamusic.screen.songonline.online.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dt.anh.vtamusic.R;
import com.dt.anh.vtamusic.data.model.Song;
import com.dt.anh.vtamusic.utils.UtilFunction;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

//Adapter for RecyclerView which includes list songs online
public class SongOnlineAdapter extends RecyclerView.Adapter<SongOnlineAdapter.ViewHolder> {
    private List<Song> mListSongs;
    private LayoutInflater mLayoutInflater;

    public SongOnlineAdapter(List<Song> listSongs) {
        mListSongs = listSongs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(parent.getContext());
        }
        View view = mLayoutInflater.inflate(R.layout.item_song, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(mListSongs.get(position));
    }

    @Override
    public int getItemCount() {
        if (mListSongs == null) {
            return 0;
        }
        return mListSongs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private CircleImageView mImageCoverSong;
        private TextView mTextTitle;
        private TextView mTextArtist;
        private TextView mTextDuration;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageCoverSong = itemView.findViewById(R.id.image_artist_cover_online_song);
            mTextTitle = itemView.findViewById(R.id.text_title_online_song);
            mTextArtist = itemView.findViewById(R.id.text_artist_online_song);
            mTextDuration = itemView.findViewById(R.id.text_duration_online_song);

            itemView.setOnClickListener(this);
        }

        public void bindData(Song song) {
            if (song == null) {
                return;
            }
            Glide.with(itemView.getContext()).load(song.getAvatarUrl())
                    .placeholder(R.drawable.ic_music)
                    .into(mImageCoverSong);
            mTextTitle.setText(song.getTitle());
            mTextArtist.setText(song.getUsername());
            mTextDuration.setText(UtilFunction.convertMilliSecondsToTimer(song.getDuration()));
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
        }
    }

    /**
     * @return List of songs
     */
    public List<Song> getListSongs() {
        return mListSongs;
    }

    /**
     * Update adapter when list songs is changed
     *
     * @param listSongs List songs after being changed
     */
    public void updateListSongs(List<Song> listSongs) {
        mListSongs = listSongs;
        notifyDataSetChanged();
    }
}
