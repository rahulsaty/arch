package test.com.helper;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import test.com.helper.databinding.ImageItemBinding;
import test.com.helper.pojo.Album;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {

    List<Album> albums;
    Context context;

    public ImageAdapter(Context context) {
        this.albums = new ArrayList<>();
        this.context = context;
    }

    public void setItem(List data){
        albums = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
             LayoutInflater inflate = LayoutInflater.from(parent.getContext());
        ImageItemBinding binding =
                DataBindingUtil.inflate(inflate, R.layout.image_item, parent, false);
        return new MyViewHolder(binding) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.MyViewHolder holder, int position) {
        holder.binding.setObj(albums.get(position));

    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final ImageItemBinding binding;


        public MyViewHolder(ImageItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


    }
}
