package com.example.cscb07_2023_fall;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.fragment.NavHostFragment;
import com.example.cscb07_2023_fall.databinding.FragmentStudentLoginPageBinding;

public class StudentLoginPage extends Fragment {

    private FragmentStudentLoginPageBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment with View Binding
        binding = FragmentStudentLoginPageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set the click listener for the login button
        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Perform navigation when the button is clicked
                NavHostFragment.findNavController(StudentLoginPage.this)
                        .navigate(R.id.action_studentLoginPage_to_studentHomePage);
            }
        });

        // Set the click listener for the new account button
        binding.buttonNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Perform navigation when the button is clicked
                NavHostFragment.findNavController(StudentLoginPage.this)
                        .navigate(R.id.action_studentLoginPage_to_studentHomePage);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Avoid memory leak
        binding = null;
    }
}
