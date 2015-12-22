package itomer.edu.recyclerviewdemo;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


//The adapters View Holder
public class MovieViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.description)
    TextView description;
    @Bind(R.id.li_btn_delete)
    ImageButton liBtnDelete;
    @Bind(R.id.closeCard)
    CardView closeCard;
    @Bind(R.id.cardView)
    CardView cardView;

    public interface OnDeleteListener {
        void onDeleteClicked(int position);
    }

    private OnDeleteListener onDeleteListener;

    MovieViewHolder(View itemView, OnDeleteListener onDeleteListener) {
        super(itemView);
        this.onDeleteListener = onDeleteListener;
        ButterKnife.bind(this, itemView);
    }

    @OnClick(R.id.li_btn_delete)
    void delete(View v) {
        int position = this.getAdapterPosition();
        if (onDeleteListener != null)
            onDeleteListener.onDeleteClicked(position);
    }
}
