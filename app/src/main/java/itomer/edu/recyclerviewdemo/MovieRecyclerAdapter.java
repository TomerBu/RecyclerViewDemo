package itomer.edu.recyclerviewdemo;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;

import java.util.Collections;
import java.util.List;

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieViewHolder> implements MovieViewHolder.OnDeleteListener {

    private List<Data> list = Collections.emptyList();
    private Interpolator overshoot = new OvershootInterpolator(3);

    public MovieRecyclerAdapter(List<Data> list) {
        this.list = list;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout, parent, false);
        return new MovieViewHolder(v, this);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Data item = list.get(position);
        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        holder.imageView.setImageResource(item.getImageId());
        if (position != 0)
            animate(holder.itemView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    // Insert a new item to the RecyclerView
    public void insert(int position, Data data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing the Data object
    public void remove(Data data) {
        int position = list.indexOf(data);
        if (position == -1) return;
        list.remove(position);
        notifyItemRemoved(position);
    }

    public void animate(View itemView) {
        int sign = ((int) (Math.random() * 100)) % 2 == 0 ? 1 : -1;
        ViewCompat.setTranslationY(itemView, -100);
        ViewCompat.setTranslationX(itemView, sign * 30);
        ViewCompat.animate(itemView).setStartDelay(100).
                setInterpolator(overshoot)
                .setDuration(300).translationY(0).translationX(0);
    }


    @Override
    public void onDeleteClicked(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }
}
