package in.cdac.pamr;

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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import in.cdac.pamr.activities.DashActivity;
import in.cdac.pamr.activities.EnergyReportingActivity;
import in.cdac.pamr.activities.PowerAnalysActivity;
import in.cdac.pamr.activities.PowerGraphActivity;
import in.cdac.pamr.activities.UserDetailActivity;
import in.cdac.pamr.pojos.UserDetails;
//import in.cdac.pamr.adaptersutils.HomeAdapter;

/**
 * Created by Dell1 on 21/05/2017.
 */

public class HomeActivity extends AppCompatActivity {




     RecyclerView recyclerView;
     String name;
     private int count=16;

     HomeAdapter mhomeAdapter;
    ArrayList<UserDetails>list=new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        actionBarSetup();
        Intent i=getIntent();

        recyclerView=(RecyclerView)findViewById(R.id.recycler1);



        LinearLayoutManager manager=new LinearLayoutManager(HomeActivity.this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mhomeAdapter=new HomeAdapter(this,count);
        recyclerView.setAdapter(mhomeAdapter);
            mhomeAdapter.notifyDataSetChanged();

       // mhomeAdapter.clearAdapter();

   //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     }

    public void actionBarSetup()
    {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
         name = preferences.getString("user",null);

        actionBar.setTitle("Power AMR Solutions");
        actionBar.setSubtitle(name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=new MenuInflater(HomeActivity.this);
        inflater.inflate(R.menu.menu_layout,menu);
     //   inflater.inflate(R.menu.menu_dash,menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        switch (id)
        {
            case R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    TaskStackBuilder.create(this).addNextIntentWithParentStack(upIntent).startActivities();
                } else {
                    NavUtils.navigateUpTo(this, upIntent);

                }
                break;
                //return true;


            case R.id.option_dashboard:
                Intent indash=new Intent(HomeActivity.this,DashActivity.class);

                indash.putExtra("user",name);
                startActivity(indash);
                break;

            case R.id.option_energy_reporting:
                Intent inenergy=new Intent(HomeActivity.this, EnergyReportingActivity.class);
                startActivity(inenergy);
                break;

            case R.id.option_power_analysis_report:

                Intent inanalysis=new Intent(HomeActivity.this, PowerAnalysActivity.class);
                startActivity(inanalysis);
                break;


            case R.id.option_power_graphs:
                Intent ingraph=new Intent(HomeActivity.this, PowerGraphActivity.class);
                startActivity(ingraph);
                break;


            case R.id.option_user_details:
                Intent inuser=new Intent(HomeActivity.this, UserDetailActivity.class);

                Bundle bundle=new Bundle();
                bundle.putSerializable("data",list);
                inuser.putExtras(bundle);
                inuser.putExtras(bundle);
                inuser.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(inuser);
                break;


              default:
                  Intent inhome=new Intent(HomeActivity.this,HomeActivity.class);
                  startActivity(inhome);



        }



        return super.onOptionsItemSelected(item);
    }



    public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.DisplayViewHolder> {

        Context c;
        LayoutInflater inflater;

        int itemcount;

        public HomeAdapter(){


        }

        public   HomeAdapter(Context c ,int numberOfItem)
        {

            this.c=c;
           // inflater=LayoutInflater.from(c);
            numberOfItem=itemcount;


        }


        @Override
        public DisplayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


            c=parent.getContext();
            inflater=LayoutInflater.from(c);
            View v=inflater.inflate(R.layout.dash_item_list,parent,false);
            DisplayViewHolder holder=new DisplayViewHolder(v);

            return holder;
        }

        @Override
        public void onBindViewHolder(DisplayViewHolder holder, int position) {

            holder.bind(position);

        }

        @Override
        public long getItemId(int position) {

            return super.getItemId(position);
        }

        @Override
        public int getItemCount() {

            //  itemcount=list.size();

            return itemcount;
            // /list.size();
        }


        public void clearAdapter(){
            // list.clear();
            notifyDataSetChanged();
        }

        class DisplayViewHolder extends RecyclerView.ViewHolder {


            TextView myText; //textView2,textView3,textView4,dynamicText1,dynamicText2,dynamicText3,dynamicText4;
            //ImageView img1,img2,img3,img4;

            public DisplayViewHolder(View itemView) {
                super(itemView);

                myText = (TextView) itemView.findViewById(R.id.myTextView);           // textView2=(TextView)itemView.findViewById(R.id.text12);
                // textView3=(TextView)itemView.findViewById(R.id.text3);
                // textView4=(TextView)itemView.findViewById(R.id.text4);
          /*  dynamicText1=(TextView)itemView.findViewById(R.id.textDynamic1);
            dynamicText2=(TextView)itemView.findViewById(R.id.textDynamic2);
            dynamicText3=(TextView)itemView.findViewById(R.id.textDynamic3);
            dynamicText4=(TextView)itemView.findViewById(R.id.textDynamic4);
            //img1=(ImageView)itemView.findViewById(R.id.imag1);
            //img2=(ImageView)itemView.findViewById(R.id.image2);
            //img3=(ImageView)itemView.findViewById(R.id.image3);
            //img4=(ImageView)itemView.findViewById(R.id.image4);*/



            }

            public void bind(int listIndex) {

                //  dynamicText1.setText(String.valueOf(listIndex));
                // dynamicText2.setText(String.valueOf(listIndex));
                // dynamicText3.setText(String.valueOf(listIndex));
                // dynamicText4.setText(String.valueOf(listIndex));



                myText.setText(String.valueOf(listIndex));
                // textView2.setText(String.valueOf(listIndex));
                // textView3.setText(String.valueOf(listIndex));
                // textView4.setText(String.valueOf(listIndex));




            }
        }
    }




}
