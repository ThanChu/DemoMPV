package vn.com.demo.three.team.demompv.movie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.datarepository.model.Movie;
import com.datarepository.utils.Constant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import vn.com.demo.three.team.demompv.R;
import vn.com.demo.three.team.demompv.baze.OnItemRecyclerClickListener;

/**
 * Created by ThanCV on 12/21/2016.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private int mWidthPoster;
    private int mHeightPoster;
    private Context mContext;
    private List<Movie> mMoviesList;
    private OnItemRecyclerClickListener<Movie> mMovieOnItemRecyclerClickListener;

    //setter for event item click

    public void setmMovieOnItemRecyclerClickListener(OnItemRecyclerClickListener<Movie> mMovieOnItemRecyclerClickListener) {
        this.mMovieOnItemRecyclerClickListener = mMovieOnItemRecyclerClickListener;
    }

    //My constructor
    public MoviesAdapter(Context mContext) {
        this.mContext = mContext;
        mMoviesList = new ArrayList<>();
        mWidthPoster = (int) mContext.getResources().getDimension(R.dimen.width_logo_movie);
        mHeightPoster = (int) mContext.getResources().getDimension(R.dimen.height_logo_movie);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Movie movie = mMoviesList.get(position);

        Picasso.with(mContext)
                .load(Constant.BASE_IMAGE_POSTER.concat(Constant.SIZE_POSTER).concat(movie.getPosterUrl()))
                .resize(mWidthPoster, mHeightPoster)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.mLogoImg);

        holder.mTitleTv.setText(movie.getTitle());
        holder.mDesTv.setText(movie.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mMovieOnItemRecyclerClickListener != null) {
                    mMovieOnItemRecyclerClickListener.onItemClickListener(movie);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMoviesList.size();
    }

    //update data list
    public void updateData(List<Movie> movieList) {
        if (movieList != null) {
            mMoviesList = movieList;
            notifyDataSetChanged();
        }
    }

    //My view holder
    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mLogoImg;
        TextView mTitleTv;
        TextView mDesTv;

        public ViewHolder(View itemView) {
            super(itemView);
            mLogoImg = (ImageView) itemView.findViewById(R.id.item_movie_logo_img);
            mTitleTv = (TextView) itemView.findViewById(R.id.item_movie_title_tv);
            mDesTv = (TextView) itemView.findViewById(R.id.item_movie_des_tv);
        }
    }
}
