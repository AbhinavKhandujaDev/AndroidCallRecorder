package com.example.dialer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dialer.models.DialerItem;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class DialerFragment extends Fragment {
    RecyclerView recyclerView;
    TextView textView;
    ImageButton deleteButton;

    String[] arr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#", "", "call", ""};
    ArrayList<DialerItem> dialerItems;
    ArrayAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerView = getView().findViewById(R.id.dialer_recycler_view);
        textView = getView().findViewById(R.id.dialer_textView);
        deleteButton = getView().findViewById(R.id.dialer_delete);

        DialerItem item = new DialerItem();
        for (String s : arr) {
            item.text = s;
            item.id = s;
            dialerItems.add(item);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialer, container, false);
    }
}