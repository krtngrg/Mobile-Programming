package com.example.lab4d;

import android.content.Context;
import android.view.*;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    Context context;
    List<Contact> contactList;

    public ContactAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPhone;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPhone = itemView.findViewById(R.id.tvPhone);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                String name = contactList.get(position).name;

                Toast.makeText(context,
                        "Calling " + name + "...",
                        Toast.LENGTH_SHORT).show();
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.contact_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.tvName.setText(contact.name);
        holder.tvPhone.setText(contact.phone);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
}

