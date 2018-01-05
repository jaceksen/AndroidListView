package pl.jaceksen.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<AdapterItems>    listnewsData = new ArrayList<AdapterItems>();
    MyCustomAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvlist = (ListView) findViewById(R.id.lvlist);

        //add data and view it
        listnewsData.add(new AdapterItems(1,"developer"," develop apps"));
        listnewsData.add(new AdapterItems(2,"programmer"," programm apps"));
        listnewsData.add(new AdapterItems(3,"sprzątaczka"," sprząta"));
        myadapter=new MyCustomAdapter(listnewsData);

        lvlist.setAdapter(myadapter);

        lvlist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final AdapterItems s = listnewsData.get(position);
//                TextView tvID = (TextView)view.findViewById(R.id.tvID);
//                tvID.setText("aaa");
                Toast.makeText(getApplicationContext(),s.Description,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private class MyCustomAdapter extends BaseAdapter {
        public ArrayList<AdapterItems> listnewsDataAdpater ;

        public MyCustomAdapter(ArrayList<AdapterItems>  listnewsDataAdpater) {
            this.listnewsDataAdpater=listnewsDataAdpater;
        }


        @Override
        public int getCount() {
            return listnewsDataAdpater.size();
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.layout_ticket, null);

            final   AdapterItems s = listnewsDataAdpater.get(position);

            TextView tvID = ( TextView) myView.findViewById(R.id.tvID);
            tvID.setText("ID: " + s.ID);

            TextView tvTitle = ( TextView) myView.findViewById(R.id.tvTitle);
            tvTitle.setText(s.JobTitle);
            tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),s.JobTitle,Toast.LENGTH_SHORT).show();
                }
            });

            TextView tvDesc = ( TextView) myView.findViewById(R.id.tvDesc);
            tvDesc.setText(s.Description);

            return myView;
        }

    }
}
