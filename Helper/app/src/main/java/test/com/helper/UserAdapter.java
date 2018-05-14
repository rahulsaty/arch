package test.com.helper;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.com.helper.pojo.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    List<User> user ;

    public UserAdapter() {
        this.user = new ArrayList<>();
    }

    public void setItem(List data){
        user = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
             View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);
        return new MyViewHolder(itemView) ;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position) {
        holder.bind((User) user.get(position));

    }

    @Override
    public int getItemCount() {
        return user.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textView1)
        public TextView userId;
        @BindView(R.id.textView2)
        public TextView title;
        @BindView(R.id.textView3)
        public TextView body;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }

        public void bind(User o) {
            title.setText(o.title);
            body.setText(o.body);
            userId.setText(String.valueOf(o.userId));
        }
    }
}
