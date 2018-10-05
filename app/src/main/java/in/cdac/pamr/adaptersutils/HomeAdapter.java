package in.cdac.pamr.adaptersutils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import in.cdac.pamr.R;

/**
 * Created by Dell1 on 21/05/2017.
 */

//    public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.DisplayViewHolder> {
//
//    Context c;
//    LayoutInflater inflater;
//
//    int itemcount;
//
//        public HomeAdapter(){
//
//
//    }
//
//    public   HomeAdapter(Context c ,int numberOfItem)
//    {
//
//        inflater=LayoutInflater.from(c);
//        numberOfItem=itemcount;
//
//
//    }
//
//
//        @Override
//    public DisplayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//
//        c=parent.getContext();
//         inflater=LayoutInflater.from(c);
//        View v=inflater.inflate(R.layout.dash_item_list,parent,false);
//        DisplayViewHolder holder=new DisplayViewHolder(v);
//
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(DisplayViewHolder holder, int position) {
//
//         holder.bind(position);
//
//    }
//
//    @Override
//    public long getItemId(int position) {
//
//        return super.getItemId(position);
//    }
//
//    @Override
//    public int getItemCount() {
//
//      //  itemcount=list.size();
//
//        return itemcount;
//        // /list.size();
//    }
//
//
//    public void clearAdapter(){
//       // list.clear();
//        notifyDataSetChanged();
//    }
//
//    class DisplayViewHolder extends RecyclerView.ViewHolder {
//
//
//        TextView myText; //textView2,textView3,textView4,dynamicText1,dynamicText2,dynamicText3,dynamicText4;
//        //ImageView img1,img2,img3,img4;
//
//        public DisplayViewHolder(View itemView) {
//            super(itemView);
//
//            myText = (TextView) itemView.findViewById(R.id.myTextView);           // textView2=(TextView)itemView.findViewById(R.id.text12);
//           // textView3=(TextView)itemView.findViewById(R.id.text3);
//           // textView4=(TextView)itemView.findViewById(R.id.text4);
//          /*  dynamicText1=(TextView)itemView.findViewById(R.id.textDynamic1);
//            dynamicText2=(TextView)itemView.findViewById(R.id.textDynamic2);
//            dynamicText3=(TextView)itemView.findViewById(R.id.textDynamic3);
//            dynamicText4=(TextView)itemView.findViewById(R.id.textDynamic4);
//            //img1=(ImageView)itemView.findViewById(R.id.imag1);
//            //img2=(ImageView)itemView.findViewById(R.id.image2);
//            //img3=(ImageView)itemView.findViewById(R.id.image3);
//            //img4=(ImageView)itemView.findViewById(R.id.image4);*/
//
//
//
//        }
//
//        public void bind(int listIndex) {
//
//           //  dynamicText1.setText(String.valueOf(listIndex));
//           // dynamicText2.setText(String.valueOf(listIndex));
//           // dynamicText3.setText(String.valueOf(listIndex));
//           // dynamicText4.setText(String.valueOf(listIndex));
//
//
//
//            myText.setText(String.valueOf(listIndex));
//           // textView2.setText(String.valueOf(listIndex));
//           // textView3.setText(String.valueOf(listIndex));
//           // textView4.setText(String.valueOf(listIndex));
//
//
//
//
//        }
//    }
//}
