package com.shemuchemi.burningbushent.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shemuchemi.burningbushent.R;
import com.shemuchemi.burningbushent.model.Movie;
import com.squareup.picasso.Picasso;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;
    public static final String IMAGE_URL_BASE_PATH= "http://image.tmdb.org/t/p/w342//";

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    //A view holder inner class where we get reference to the views in the layout using their ID
    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView movieDescription;
        TextView rating;
        ImageView movieImage;

        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = v.findViewById(R.id.movies_layout);
            movieImage =  v.findViewById(R.id.movie_image);
            movieTitle =  v.findViewById(R.id.title);
            movieDescription =  v.findViewById(R.id.description);
            rating =  v.findViewById(R.id.rating);
        }
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        String image_url = IMAGE_URL_BASE_PATH + movies.get(position).getPosterPath();
        Picasso.get()
                .load(image_url)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(holder.movieImage);
        holder.movieTitle.setText(movies.get(position).getTitle());
//        holder.data.setText(movies.get(position).getReleaseDate());
        holder.movieDescription.setText(movies.get(position).getOverview());
        holder.rating.setText(movies.get(position).getVoteAverage().toString());

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}


