package com.iuea.bottomsheetapp;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MyBottomSheetFragment extends BottomSheetDialogFragment {

    private EditText editTextInput;
    private RecyclerView recyclerView;
    private Button buttonSubmit, buttonCancel;
    private MyAdapter myAdapter;
    private List<String> itemList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_sheet, container, false);

        // Initialize UI components
        editTextInput = view.findViewById(R.id.editText_input);
        recyclerView = view.findViewById(R.id.recyclerView_items);
        buttonSubmit = view.findViewById(R.id.button_submit);
        buttonCancel = view.findViewById(R.id.button_cancel);

        // Set LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize Adapter with sample data
        itemList.add("Sample Item 1");

        myAdapter = new MyAdapter(itemList);
        recyclerView.setAdapter(myAdapter);

        // Handle Submit Button Click
        buttonSubmit.setOnClickListener(v -> {
            String input = editTextInput.getText().toString().trim();
            if (input.isEmpty()) {
                Toast.makeText(getContext(), "Please enter some text", Toast.LENGTH_SHORT).show();
            } else {
                // Add input to the list and notify adapter
                itemList.add(input);
                myAdapter.notifyItemInserted(itemList.size() - 1);
                editTextInput.setText("");
                Toast.makeText(getContext(), "Submitted: " + input, Toast.LENGTH_SHORT).show();
            }
        });

        // Handle Cancel Button Click
        buttonCancel.setOnClickListener(v -> dismiss());

        return view;
    }
}
