package com.example.instagram;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FavoriteRecycleViewAdapter extends RecyclerView.Adapter<FavoriteRecycleViewAdapter.ViewHolder>{
    private static final String TAG = "RecycleViewAdapter";

    private ArrayList<String> avatars = new ArrayList<String>();
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<String> images  = new ArrayList<String>();
    private ArrayList<String> descriptions  = new ArrayList<String>();
    private ArrayList<String> views  = new ArrayList<String>();
    private ArrayList<Boolean> liked  = new ArrayList<Boolean>();
    private Context context;

    public FavoriteRecycleViewAdapter(Context context) {
        this.context = context;
    }

    {
        for (int i = 0; i < MainActivity.liked.size(); i++){
            if(MainActivity.liked.get(i) == true){
                avatars.add(MainActivity.avatars.get(i));
                names.add(MainActivity.names.get(i));
                images.add(MainActivity.images.get(i));
                descriptions.add(MainActivity.descriptions.get(i));
                views.add(MainActivity.views.get(i));
                liked.add(MainActivity.liked.get(i));
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: ");

        Glide.with(context)
                .asBitmap()
                .load(avatars.get(position))
                .into(holder.avatar);

        holder.name.setText(names.get(position));

        Glide.with(context)
                .asBitmap()
                .load(images.get(position))
                .into(holder.image);

        holder.like.setImageResource(R.drawable.heart);

        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: like");

                if(liked.get(position) == false){
                    holder.like.setImageResource(R.drawable.heart);
                    Toast.makeText(v.getContext(), "Liked!", Toast.LENGTH_SHORT).show();
                    MainActivity.liked.set(MainActivity.names.indexOf(names.get(position)), true);
                }else{
                    holder.like.setImageResource(R.drawable.passion);
                    Toast.makeText(v.getContext(), "Unliked!", Toast.LENGTH_SHORT).show();
                    MainActivity.liked.set(MainActivity.names.indexOf(names.get(position)), false);
                }
            }
        });

        holder.view.setText(views.get(position));
        holder.view.append(" просмотров");
        holder.name2.setText(names.get(position));
        holder.description.setText(descriptions.get(position));

        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: layout");

                Intent intent = new Intent(v.getContext(), DescriptionActivity.class);
                intent.putExtra("avatar", avatars.get(position));
                intent.putExtra("name", names.get(position));
                intent.putExtra("image", images.get(position));
                intent.putExtra("view", views.get(position));
                intent.putExtra("description", descriptions.get(position));
                intent.putExtra("liked", liked.get(position));
                intent.putExtra("position", position);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView avatar;
        TextView name;
        ImageView image;
        ImageView like;
        TextView view;
        TextView description;
        TextView name2;
        LinearLayout parent_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            avatar = itemView.findViewById(R.id.avatar);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
            like = itemView.findViewById(R.id.like);
            view = itemView.findViewById(R.id.view);
            description = itemView.findViewById(R.id.description);
            name2 = itemView.findViewById(R.id.name2);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
