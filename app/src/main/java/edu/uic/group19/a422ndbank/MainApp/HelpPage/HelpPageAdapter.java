package edu.uic.group19.a422ndbank.MainApp.HelpPage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import edu.uic.group19.a422ndbank.Models.FAQ;
import edu.uic.group19.a422ndbank.R;


public class HelpPageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    ArrayList<FAQ> questions;
    OnCellClickedListener cellClickedListener;

    public HelpPageAdapter(Context context,  ArrayList<FAQ> faqs, OnCellClickedListener onCellClickedListener){
        this.context = context;
        this.questions = faqs;
        this.cellClickedListener = onCellClickedListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.faq_row, viewGroup, false);
        Item item = new Item(row, cellClickedListener);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((Item) viewHolder).questionText.setText(questions.get(i).getQuestion());
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class Item extends  RecyclerView.ViewHolder implements View.OnClickListener{

        TextView questionText;
        OnCellClickedListener onItemClickedListener;

        public Item(@NonNull View itemView, OnCellClickedListener onItemClickedListener) {
            super(itemView);
            questionText = (TextView) itemView.findViewById(R.id.questionText);
            this.onItemClickedListener = onItemClickedListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickedListener.onCellClicked(getAdapterPosition());
        }
    }

    public interface OnCellClickedListener{
        void onCellClicked(int pos);
    }
}