package com.example.recyclerview;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.net.URI;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecylcerViewAdapter extends RecyclerView.Adapter<RecylcerViewAdapter.ViewHolder> {
    private static final String TAG = "RecylcerViewAdapter";
    private ArrayList<String> mImagesNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mobileNumber = new ArrayList<>();
    private Context mcontext;

    public RecylcerViewAdapter(Context mcontext, ArrayList<String> mImagesNames, ArrayList<String> mImages, ArrayList<String> mobileNumber) {
        this.mImagesNames = mImagesNames;
        this.mImages = mImages;
        this.mcontext = mcontext;
        this.mobileNumber = mobileNumber;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBinfViewHolder: called.");

        Glide.with(mcontext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);
        holder.imageName.setText(mImagesNames.get(position));
        holder.phonenumber.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_DIAL); // Action for what intent called for
                    intent.setData(Uri.parse("tel: " + mobileNumber.get(position))); // Data with intent respective action on intent
                    mcontext.startActivity(intent);
                }
        });
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext, mImagesNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImagesNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView imageName,phonenumber;
        RelativeLayout parentLayout;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.images);
            imageName = itemView.findViewById(R.id.imagename);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            phonenumber = itemView.findViewById(R.id.phnnumber);
        }
    }
}
