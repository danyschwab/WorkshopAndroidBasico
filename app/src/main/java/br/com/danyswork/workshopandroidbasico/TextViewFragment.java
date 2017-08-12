package br.com.danyswork.workshopandroidbasico;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TextViewFragment extends BaseFragment {

    private static final String TAG = TextViewFragment.class.getCanonicalName();

    public static BaseFragment getInstance() {
        return new TextViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text_view, container, false);
        TextView textView = view.findViewById(R.id.text_view);
        return view;
    }

    @Override
    public String getFragmentTag() {
        return TAG;
    }
}
