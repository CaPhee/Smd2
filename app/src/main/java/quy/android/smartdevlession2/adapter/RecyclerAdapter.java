package quy.android.smartdevlession2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import quy.android.smartdevlession2.Data;
import quy.android.smartdevlession2.R;

/**
 * Created by iamme on 17/05/28.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private List<Data> listData = new ArrayList<>();
    public RecyclerAdapter(List<Data> listData) {
        this.listData = listData;
    }

    public void updateList(List<Data> data) {
        listData = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup,
                                                 int position) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.item_recycler, viewGroup, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder viewHolder, int position) {
        viewHolder.tvName.setText(listData.get(position).getName());
    }

    public void addItem(int position, Data data) {
        listData.add(position, data);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {

        public TextView tvName;
        public ImageButton btnDelete;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            btnDelete = (ImageButton) itemView.findViewById(R.id.btn_delete);

            // set listener for button delete
            btnDelete.setOnClickListener(this);
        }

        // remove item when click button delete
        @Override
        public void onClick(View v) {
            removeItem(getAdapterPosition());
        }
    }
}
