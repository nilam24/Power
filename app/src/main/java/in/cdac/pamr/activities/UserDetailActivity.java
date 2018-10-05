package in.cdac.pamr.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import in.cdac.pamr.MainActivity;
import in.cdac.pamr.R;
import in.cdac.pamr.pojos.UserDetails;

/**
 * Created by Dell1 on 21/05/2017.
 */

public class UserDetailActivity extends AppCompatActivity {


    String uname;


    RecyclerView recyclerView;
    ArrayList<UserDetails> list=new ArrayList<>();
    UserDetails userDetail=new UserDetails();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        Intent intent = getIntent();

        Bundle bundle = getIntent().getExtras();
        list = (ArrayList<UserDetails>) bundle.getSerializable("data");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new ItemAdapter(this,list));

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarSetup();

    }

    public void actionBarSetup()
    {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        uname = preferences.getString("user",null);
        actionBar.setTitle("Power AMR Solutions");
        actionBar.setSubtitle(uname);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = new MenuInflater(UserDetailActivity.this);
       // inflater.inflate(R.menu.menu_dash, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.home) {

            Intent upIntent = NavUtils.getParentActivityIntent(this);
            if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                TaskStackBuilder.create(this).addNextIntentWithParentStack(upIntent).startActivities();
            } else {
                NavUtils.navigateUpTo(this, upIntent);

            }
            return true;

        }
        return super.onOptionsItemSelected(item);
    }




    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView displayView,displayView2,displayView3,displayView4,displayView5,displayView6,displayView7,displayView8,displayView9,displayView10,displayView11,displayView12,displayView13,displayView14,displayView15;



        public ItemViewHolder(View itemView) {
            super(itemView);


            //textView under itemView
          //  displayView=(TextView)itemView.findViewById(R.id.textView1);
          //  displayView2=(TextView)itemView.findViewById(R.id.textView2);
            displayView3=(TextView)itemView.findViewById(R.id.textView3);
         //   displayView4=(TextView)itemView.findViewById(R.id.textView4);
          //  displayView5=(TextView)itemView.findViewById(R.id.textView5);
          //  displayView6=(TextView)itemView.findViewById(R.id.textView6);
          //  displayView7=(TextView)itemView.findViewById(R.id.textView7);
          //  displayView8=(TextView)itemView.findViewById(R.id.textView8);
          //  displayView9=(TextView)itemView.findViewById(R.id.textView9);
          //  displayView10=(TextView)itemView.findViewById(R.id.textView10);
          //  displayView11=(TextView)itemView.findViewById(R.id.textView11);
          //  displayView12=(TextView)itemView.findViewById(R.id.textView12);
         //   displayView13=(TextView)itemView.findViewById(R.id.textView13);
          //  displayView14=(TextView)itemView.findViewById(R.id.textView14);
          //  displayView15=(TextView)itemView.findViewById(R.id.textView15);




            return ;
        }
    }

    //ItemAdapter class is for listing data in recyclerView

    class ItemAdapter extends  RecyclerView.Adapter<ItemViewHolder> {


        ArrayList<UserDetails> list = new ArrayList<UserDetails>();
        Context context;
        ItemViewHolder holder1;

        public ItemAdapter() {

        }

        public ItemAdapter(Context context, ArrayList<UserDetails> list) {

            this.context = context;
            this.list = list;


        }


        //overriding following methods
        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(UserDetailActivity.this);

            //item_layout is the child layout of home layout file where displaying item ie textView is taken where each field value display
            View view = inflater.inflate(R.layout.item_layout, null);
            holder1 = new ItemViewHolder(view);

            return holder1;
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }


        //Bind method is use for binding the holder value to the textView

        @Override
        public void onBindViewHolder(final ItemViewHolder holder, int position) {

            final UserDetails detail = list.get(position);


            //following code is doing:--- binding data with displayView which is
            // declared in itemView and geting data from the pojo class instance getter

            //LOGIN_ID	PW   USER_LEVEL	LOGIN_NAME	EMP_ID	DEPT_ID	DESIGNATION	REMARKS	EMAIL_ID	ISACTIVE	BLOCKED	user_name	address	plant_location	plant_capacity	meterno

         //   holder.displayView.setText(detail.getLOGIN_ID());
         //   holder.displayView2.setText(detail.getUSER_LEVEL());
            holder.displayView3.setText(detail.getLOGIN_NAME());

            System.out.println("userdetailactivity"+holder);
        //    holder.displayView4.setText(detail.getEMP_ID());
        //    holder.displayView5.setText(detail.getDEPT_ID());
         //   holder.displayView6.setText(detail.getDESIGNATION());
         //   holder.displayView7.setText(detail.getREMARKS());
         //   holder.displayView8.setText(detail.getEMAIL_ID());
        //    holder.displayView9.setText(detail.getISACTIVE());
        //    holder.displayView10.setText(detail.getBLOCKED());
        //    holder.displayView11.setText(detail.getUser_name());
         //   holder.displayView12.setText(detail.getAddress());
        //    holder.displayView13.setText(detail.getPlant_location());
        //    holder.displayView14.setText(detail.getPlant_capacity());
        //    holder.displayView15.setText(detail.getMeterno());



        }
        public void clearAdapter(){
            list.clear();
            notifyDataSetChanged();
        }


    }



}

/*
RecyclerView recyclerView;
                ArrayList<UserDetail> list=new ArrayList<>();
                UserDetail userDetail=new UserDetail();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        //getIntent.getExtras is use to receive data from previous screen
        Intent intent = getIntent();

        Bundle bundle = getIntent().getExtras();
        list = (ArrayList<UserDetail>) bundle.getSerializable("data");

        System.out.println(list + "in...........main");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);


        //calling LinearLayoutmanager  to set recyclerView

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //seting adapetr itemAdapter (custom adapter defined in class ItemAdapter by extending RecyclerView.Adapter<ItemViewHolder>)
        //as argument instance of the itemAdapter class and list where data is present
        recyclerView.setAdapter(new ItemAdapter(this,list));
    }

    // this class ItemViewHolder is use to declare the textview in the View class

        class ItemViewHolder extends RecyclerView.ViewHolder {

             TextView displayView,displayView2,displayView3,displayView4,displayView5,displayView6,displayView7,displayView8,displayView9,displayView10,displayView11,displayView12,displayView13,displayView14,displayView15;



            public ItemViewHolder(View itemView) {
                super(itemView);


                //textView under itemView
                displayView=(TextView)itemView.findViewById(R.id.textView1);
                displayView2=(TextView)itemView.findViewById(R.id.textView2);
                displayView3=(TextView)itemView.findViewById(R.id.textView3);
                displayView4=(TextView)itemView.findViewById(R.id.textView4);
                displayView5=(TextView)itemView.findViewById(R.id.textView5);
                displayView6=(TextView)itemView.findViewById(R.id.textView6);
                displayView7=(TextView)itemView.findViewById(R.id.textView7);
                displayView8=(TextView)itemView.findViewById(R.id.textView8);
                displayView9=(TextView)itemView.findViewById(R.id.textView9);
                displayView10=(TextView)itemView.findViewById(R.id.textView10);
                displayView11=(TextView)itemView.findViewById(R.id.textView11);
                displayView12=(TextView)itemView.findViewById(R.id.textView12);
                displayView13=(TextView)itemView.findViewById(R.id.textView13);
                displayView14=(TextView)itemView.findViewById(R.id.textView14);
                displayView15=(TextView)itemView.findViewById(R.id.textView15);




                return ;
            }
        }

    //ItemAdapter class is for listing data in recyclerView

        class ItemAdapter extends  RecyclerView.Adapter<ItemViewHolder> {


            ArrayList<UserDetail> list = new ArrayList<UserDetail>();
            Context context;
            ItemViewHolder holder1;

            public ItemAdapter() {

            }

            public ItemAdapter(Context context, ArrayList<UserDetail> list) {

                this.context = context;
                this.list = list;


            }


            //overriding following methods
            @Override
            public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                //item_layout is the child layout of home layout file where displaying item ie textView is taken where each field value display
                View view = inflater.inflate(R.layout.item_layout, null);
                holder1 = new ItemViewHolder(view);

                return holder1;
            }

            @Override
            public long getItemId(int position) {
                return super.getItemId(position);
            }

            @Override
            public int getItemCount() {
                return list.size();
            }


        //Bind method is use for binding the holder value to the textView

            @Override
            public void onBindViewHolder(final ItemViewHolder holder, int position) {

                final UserDetail detail = list.get(position);


                 //following code is doing:--- binding data with displayView which is
                // declared in itemView and geting data from the pojo class instance getter

                //LOGIN_ID	PW   USER_LEVEL	LOGIN_NAME	EMP_ID	DEPT_ID	DESIGNATION	REMARKS	EMAIL_ID	ISACTIVE	BLOCKED	user_name	address	plant_location	plant_capacity	meterno

                holder.displayView.setText(detail.getLOGIN_ID());
                holder.displayView2.setText(detail.getUSER_LEVEL());
                holder.displayView3.setText(detail.getLOGIN_NAME());
                holder.displayView4.setText(detail.getEMP_ID());
                holder.displayView5.setText(detail.getDEPT_ID());
                holder.displayView6.setText(detail.getDESIGNATION());
                holder.displayView7.setText(detail.getREMARKS());
                holder.displayView8.setText(detail.getEMAIL_ID());
                holder.displayView9.setText(detail.getISACTIVE());
                holder.displayView10.setText(detail.getBLOCKED());
                holder.displayView11.setText(detail.getUser_name());
                holder.displayView12.setText(detail.getAddress());
                holder.displayView13.setText(detail.getPlant_location());
                holder.displayView14.setText(detail.getPlant_capacity());
                holder.displayView15.setText(detail.getMeterno());



                }
            public void clearAdapter(){
                list.clear();
                notifyDataSetChanged();
            }


        }

*/
