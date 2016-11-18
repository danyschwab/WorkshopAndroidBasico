package br.com.danyswork.workshopandroidbasico;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class HomeFragment extends Fragment {

    private static final String TAG = HomeFragment.class.getCanonicalName();

    public HomeFragment() {
        // Required empty public constructor

    }

    private final String[] mList = new String[] {
            "Layouts",
            "TextView",
            "EditText",
            "ImageView",
            "Button",
            "Listas",
            "Dialogs"
    };

    public String getFragmentTag(){
        return TAG;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);

        LinearLayoutManager layoutParams = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutParams);
        recyclerView.setAdapter(new RecyclerView.Adapter<PlanetViewHolder>() {

            @Override
            public PlanetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(
                        android.R.layout.simple_list_item_1,
                        parent,
                        false);
                return new PlanetViewHolder(v);
            }

            @Override
            public void onBindViewHolder(PlanetViewHolder vh, int position) {
                TextView tv = (TextView) vh.itemView;
                tv.setText(mList[position]);
            }

            @Override
            public int getItemCount() {
                return mList.length;
            }
        });

        return view;
    }

    private class PlanetViewHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        PlanetViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(HomeFragment.this.getContext(),
                    "You have clicked " + ((TextView) v).getText(),
                    Toast.LENGTH_LONG).show();
        }
    }
}
