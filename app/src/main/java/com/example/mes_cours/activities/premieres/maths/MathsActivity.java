package com.example.mes_cours.activities.premieres.maths;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mes_cours.R;
import com.example.mes_cours.activities.premieres.ListesMatieresActivity;
import com.example.mes_cours.activities.premieres.maths.num.ListesMathsNumActivity;
import com.example.mes_cours.ui.premiere.ListesMatieresPremiereFragment;

public class MathsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maths_premiere_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ListesMatieresPremiereFragment.newInstance())
                    .commitNow();
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        GridView listesMathsPremiereGridview = (GridView) findViewById(R.id.listes_maths_premiere_gridview);
        listesMathsPremiereGridview.setAdapter(new ImageAdapter(this));

        // Click sur Nume ou Géom
        listesMathsPremiereGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Intent intent = new Intent(MathsActivity.this, ListesMathsNumActivity.class);
                        intent.putExtra("Maths", "Math data Num");
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(MathsActivity.this, "Geom", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        String[] fruitNames = {"Numériques","Géometries"};
        // Keep all Images in array
        public Integer[] mThumbIds = {
                R.drawable.ic_folder, R.drawable.ic_folder,
        };

        // Constructor
        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            Context context;

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            View view1 = inflater.inflate(R.layout.maths_premiere_fragment,null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.folder_cours_p_title);
            ImageView image = view1.findViewById(R.id.folder_cours_p_item);

            name.setText(fruitNames[position]);
            image.setImageResource(mThumbIds[position]);
            return view1;
        }


    }

}