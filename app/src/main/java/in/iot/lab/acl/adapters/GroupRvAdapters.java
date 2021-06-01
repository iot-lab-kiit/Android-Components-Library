package in.iot.lab.acl.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import in.iot.lab.acl.R;
import in.iot.lab.acl.utils.RvClickHandler;

public class GroupRvAdapters extends RecyclerView.Adapter<GroupRvAdapters.GroupViewHolder> {

    List<String> group = new ArrayList<>();
    ArrayList<String> logo = new ArrayList<>();
    Context context;
    RvClickHandler mRvClickHandler;



    public GroupRvAdapters(List<String> group, ArrayList<String> logo, Context context, RvClickHandler rvClickHandler) {
        this.group = group;
        this.logo = logo;
        this.context=context;
        mRvClickHandler=rvClickHandler;
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
        String imgLoc = "@drawable/acl_logo";
        int imageResource= context.getResources().getIdentifier(imgLoc,null, context.getPackageName());
        Drawable res=context.getResources().getDrawable(imageResource);


        holder.mTextView.setText(title);
        holder.mImageView.setImageDrawable(res);
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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRvClickHandler.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
