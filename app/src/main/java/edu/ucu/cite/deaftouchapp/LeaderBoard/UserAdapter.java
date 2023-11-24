package edu.ucu.cite.deaftouchapp.LeaderBoard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.ucu.cite.deaftouchapp.R;
import edu.ucu.cite.deaftouchapp.userlist;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ProductViewHolder> {

    private final Context mCtx;
    private final List<userlist> productList;
    int i = 0;


    public UserAdapter(Context mCtx, List<userlist> productList) {
        this.mCtx = mCtx;
        this.productList = productList;

    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.leaderboard_layout, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

        userlist product = productList.get(position);

        i = i+1;
        String ranknumber = String.valueOf(i);
        holder.textViewUserRank.setText(ranknumber);

        holder.textViewUsername.setText(product.getUsername());
        holder.textViewUserScore.setText(product.getScore());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewUsername,textViewUserScore, textViewUserRank;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewUsername = itemView.findViewById(R.id.userleaderboardusername);
            textViewUserScore = itemView.findViewById(R.id.userleaderboardscore);
            textViewUserRank = itemView.findViewById(R.id.userleaderboardrank);

        }
    }
}
