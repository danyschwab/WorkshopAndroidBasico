package br.com.danyswork.workshopandroidbasico;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HomeFragment extends BaseFragment {

    private static final String TAG = HomeFragment.class.getCanonicalName();

    public String getFragmentTag(){
        return TAG;
    }

    private Components[] mList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mList = Components.values();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.list);

        LinearLayoutManager layoutParams = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutParams);
        recyclerView.setAdapter(new RecyclerView.Adapter<ComponentsViewHolder>() {

            @Override
            public ComponentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(
                        android.R.layout.simple_list_item_1,
                        parent,
                        false);
                return new ComponentsViewHolder(v);
            }

            @Override
            public void onBindViewHolder(ComponentsViewHolder vh, final int position) {
                TextView tv = (TextView) vh.itemView;
                tv.setText(mList[position].getName());
                vh.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        BaseFragment fragment = mList[position].getKlass();
                        HomeFragment.this.getActivity().getSupportFragmentManager()
                               .beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(fragment.getFragmentTag()).commit();
                    }
                });
            }

            @Override
            public int getItemCount() {
                return mList.length;
            }
        });

        return view;
    }

    private class ComponentsViewHolder
            extends RecyclerView.ViewHolder {

        ComponentsViewHolder(View v) {
            super(v);
        }
    }
}
