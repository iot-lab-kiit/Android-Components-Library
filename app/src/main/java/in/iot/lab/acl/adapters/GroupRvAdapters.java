package in.iot.lab.acl.adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.iot.lab.acl.R;

public class GroupRvAdapters extends RecyclerView.Adapter<GroupRvAdapters.GroupViewHolder> {

    ArrayList<String> group = new ArrayList<>();
    ArrayList<String> logo = new ArrayList<>();

    public GroupRvAdapters(ArrayList<String> group, ArrayList<String> logo) {
        this.group = group;
        this.logo = logo;
    }

    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_group_card, parent, false);
        return (new GroupViewHolder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {
        String title = group.get(position);
        String imgLoc = logo.get(position);

        holder.mTextView.setText(title);
        holder.mImageView.setImageResource(R.drawable.text);
    }

    @Override
    public int getItemCount() {
        return group.size();
    }

    public class GroupViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;
        private ImageView mImageView;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.group_image);
            mTextView = itemView.findViewById(R.id.group_title);
        }
    }
}
